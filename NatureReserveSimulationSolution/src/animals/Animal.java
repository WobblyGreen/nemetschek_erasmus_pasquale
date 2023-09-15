package animals;

import java.util.ArrayList;

import events.Emitter;
import events.Event;
import food.Food;
import food.FoodName;

public abstract class Animal extends Food implements Emitter{
	protected ArrayList<FoodName> diet;
	protected int starvingValue;

	public Animal(FoodName name, double size, int maxEnergy, ArrayList<FoodName> diet) {
		super(name, size, maxEnergy);
		this.starvingValue=maxEnergy/3;
		this.diet=diet;
	}
	
	public boolean dietContainsFood(FoodName food) {
		for(FoodName foodName:diet) {
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
		for(FoodName fn:diet) {
			if(fn.equals(food.getName())) return true;
		}
		return false;
	}
	
	public Event isStarving() {
		return (currentEnergy<=starvingValue ? Event.STARVE : null);
	}
	
	public ArrayList<FoodName> getDiet(){
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
