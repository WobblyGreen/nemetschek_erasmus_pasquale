package animals;

import java.util.ArrayList;


import events.Emitter;
import events.Event;
import food.Food;

public abstract class Animal extends Food implements Emitter{
	protected ArrayList<String> diet;
	protected int starvingValue;

	public Animal(String name, double size, int maxEnergy, ArrayList<String> diet) {
		super(name, size, maxEnergy);
		this.starvingValue=maxEnergy/3;
		this.diet=diet;
	}
	
	public boolean dietContainsFood(String food) {
		for(String foodName:diet) {
			if(foodName.equals(food)) return true;
		}
		return false;
	}
	
	public Event feed(Food food) {
		if(!alive || food==null) {
			starve();
			return Event.CANT_EAT;
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
		return this.name+" "+ this.currentEnergy + "/" + this.maxEnergy;
	}
	
	public String getAllInfos() {
		return this.name+ " " + (int)size +" "+ this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
	}
}
