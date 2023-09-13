package Animals;

import java.util.ArrayList;

import Interfaces.DietItem;
import Interfaces.Eatable;
import events.Emitter;
import events.Event;
import food.Food;
import food.FoodName;

public abstract class Animal extends Food{
	protected int starvingValue;
	protected ArrayList<FoodName> diet;
	
	public Animal(FoodName name, double size, int maxEnergy, ArrayList<FoodName> diet) {
		super(name, size, maxEnergy);
		this.starvingValue=maxEnergy/3;
		this.diet=diet;
	}
	
	/**
	 * Feeds the animal with the  passed food
	 * @param food
	 * @return 
	 */
	public Event feed(Food food) {
		if(!alive || food==null) return Event.CANT_EAT;
		
		Event event=null;
		if(!dietContainsFood(food.getName())) {
			starve();
			event=Event.EAT_BAD_FOOD;
		}
		
		else{
			food.changeEnergy(this.changeEnergy(food.getCurrentEnergy()));
			event=Event.EAT;
		}
		
		if(food instanceof Animal) {
			((Animal)food).die();
		}
		
		return event;
	};
	
	public Event addFoodToDiet(FoodName item) {
		if(diet.contains(item)) return null;
		
		diet.add(item);
		return Event.EXPANDING_DIET;
	}
	
	public Event grow() {
		size+=(size*Math.random()*((double)currentEnergy/maxEnergy));
		return Event.GROW;
		
	}
	
	public void starve() {
		this.changeEnergy(-1);
	}
	
	public boolean dietContainsFood(FoodName item) {
		for(FoodName fn:diet) {
			if(fn.equals(item)) return true;
		}
		return false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public Event isStarving() {
		return (currentEnergy<=starvingValue ? Event.STARVE : null);
	}
	
	public ArrayList<FoodName> getDiet(){
		return diet;
	}
	
	@Override
	public String toString() {
		String animalInfo = this.name+ " " + (int)size +" "+ this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
		return animalInfo;
	}
}
