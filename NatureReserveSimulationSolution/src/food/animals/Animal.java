package food.animals;

import java.util.ArrayList;


import biomes.Biome;
import events.EmitMessage;
import events.Emitter;
import events.Event;
import food.Food;
import simulation.Generator;

public abstract class Animal extends Food implements Emitter{
	protected ArrayList<String> diet;
	protected int starvingValue;

	public Animal(String name, double size, int maxEnergy, ArrayList<String> diet, int x, int y) {
		super(name, size, maxEnergy, x, y);
		this.starvingValue=maxEnergy/3;
		this.diet=diet;
	}
	
	public ArrayList<EmitMessage> onEachTurn(Biome[][] world, Generator gen) {
		ArrayList<EmitMessage> events = new ArrayList<>();
		
		int random_col = x + (Math.random()>0.5? 1 : -1);
		int random_row = y + (Math.random()>0.5? 1 : -1);
		
		try {
			Biome target = world[random_row][random_col];
			if(canMoveTo(target)) {
				events.add(new EmitMessage(Event.MOVED, "from "+world[y][x].displayNameAndCoordinate()+" to "+target.displayNameAndCoordinate()));
				move(world[this.y][this.x], target);
			}
		} catch(Exception e) {};
		
		Food food = world[y][x].getAllEatableItems().get((int)(Math.random()*world[y][x].getAllEatableItems().size()));
		Event feedEvent = this.feed(food);
		events.add(new EmitMessage(feedEvent, food+""));
		
		return events;
	}
	
	private boolean canMoveTo(Biome biome) {
		return biome.getSupportedAnimals().contains(this.name) && biome.getCurrentCapacity()<biome.getMaxCapacity();
	}
	
	private void move(Biome fromBiome, Biome toMoveBiome) {
		fromBiome.removeAnimal(this);
		toMoveBiome.addAnimal(this);
		this.x=toMoveBiome.getX();
		this.y=toMoveBiome.getY();
	}
	
	public boolean dietContainsFood(String food) {
		for(String foodName:diet) {
			if(foodName.equals(food)) return true;
		}
		return false;
	}
	
	protected Event feed(Food food) {
		if(!alive || food==null) {
			starve();
			return Event.CANT_EAT;
		}
		
		if(food==this) {
			starve();
			return Event.EAT_ITSELF;
		}
		
		Event event=null;
		if(!dietContainsFood(food)) {
			starve();
			event=Event.EAT_BAD_FOOD;
		}
		
		else{
			int leftOverEnergyFromEating=changeEnergy(food.getCurrentEnergy());
			food.setCurrentEnergy(leftOverEnergyFromEating);
			event=Event.EAT;
		}
		
		return event;
	};
	
	public Event addFoodToDiet(Food food) {
		if(this.dietContainsFood(food)) return null;
		
		diet.add(food.getName());
		return Event.EXPANDING_DIET;
	}
	
	public Event grow() {
		size+=(size*Math.random()*((double)currentEnergy/maxEnergy));
		return Event.GROW;
	}
	
	public void starve() {
		this.changeEnergy(-1);
	}
	
	public boolean dietContainsFood(Food food) {
		for(String f:diet) {
			if(f.equals(food.getName())) return true;
		}
		return false;
	}
	
	public Event isStarving() {
		return (currentEnergy<=starvingValue ? Event.STARVE : null);
	}
	
	public ArrayList<String> getDiet(){
		return diet;
	}

	@Override
	public String toString() {
		return (isAlive()?"\u001B[32m" : "\u001B[31m") + this.name+" "+ this.currentEnergy + "/" + this.maxEnergy + "\u001B[0m";
	}
	
	public String getAllInfos() {
		return this.name+ " " + (int)size +" "+ this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
	}
}
