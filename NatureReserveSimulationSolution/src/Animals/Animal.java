package Animals;

import java.util.ArrayList;

import events.Event;
import food.Food;
import food.FoodName;

public abstract class Animal extends Food{
	protected ArrayList<FoodName> diet;
	protected boolean alive;
	private int starvingValue;
	
	public Animal(FoodName name, double size, int currentEnergy, int maxEnergy, boolean alive, ArrayList<FoodName> diet) {
		super(name, size, currentEnergy, maxEnergy);
		this.alive=alive;
		this.diet=diet;
	}

	/**
	 * Feeds the animal with the  passed food
	 * @param food
	 * @return 
	 */
	public Event feed(Food food) {
		if(!alive || food==null) return null;
		
		if(!dietContainsFood(food.getName())) {
			changeEnergy(-1);
		}
		
		else{
			int leftOverEnergy = changeEnergy(food.getCurrentEnergy());
			food.setCurrentEnergy(leftOverEnergy);
		}
		
		if(food instanceof Animal) 
			((Animal)food).die();
		
		return null;
	};
	
	private int changeEnergy(int value) {
		int leftOverEnergy=0;
		this.currentEnergy+=value;
		
		if(currentEnergy<0) {
			leftOverEnergy=currentEnergy;
			currentEnergy=0;
			die();
		}
		
		else if(currentEnergy>maxEnergy) {
			leftOverEnergy=currentEnergy-maxEnergy;
			currentEnergy=maxEnergy;
		}
		
		return leftOverEnergy;
	}
	
	public boolean dietContainsFood(FoodName food) {
		for(FoodName foodName:diet) {
			if(foodName.equals(food)) return true;
		}
		return false;
	}
	
	public boolean addFoodToDiet(FoodName foodName) {
		if(diet.contains(foodName)) return false;
		
		this.diet.add(foodName);
		return true;
	}
	
	private void die() {
		this.alive=false;
	}
	
	public void grow() {
		this.size+=(size*Math.random()*((double)currentEnergy/maxEnergy));
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public boolean isStarving() {
		return currentEnergy<=starvingValue;
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
