package Animals;

import java.util.ArrayList;

import events.Event;
import food.Food;
import food.FoodName;

public abstract class Animal extends Food{
<<<<<<< HEAD
	protected ArrayList<FoodName> diet;
	protected boolean alive;
	private int starvingValue;
	
	public Animal(FoodName name, double size, int currentEnergy, int maxEnergy, boolean alive, ArrayList<FoodName> diet) {
		super(name, size, currentEnergy, maxEnergy);
		this.alive=alive;
=======
	protected int starvingValue;
	protected ArrayList<FoodName> diet;
	
	public Animal(FoodName name, double size, int maxEnergy, ArrayList<FoodName> diet) {
		super(name, size, maxEnergy);
		this.starvingValue=maxEnergy/3;
>>>>>>> 6b9ad2c (Fixed inheritance between Animal, Plants and Food)
		this.diet=diet;
	}

	/**
	 * Feeds the animal with the  passed food
	 * @param food
	 * @return 
	 */
	public Event feed(Food food) {
<<<<<<< HEAD
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
=======
		if(!alive || food==null) return Event.CANT_EAT;
		
		Event event=null;
		if(!dietContainsFood(food)) {
			starve();
			event=Event.EAT_BAD_FOOD;
		}
		
		else{
			food.changeEnergy(this.changeEnergy(food.getCurrentEnergy()));
			event=Event.EAT;
		}
		
		return event;
	};
	
	public Event addFoodToDiet(Food food) {
		if(this.dietContainsFood(food)) return null;
>>>>>>> 6b9ad2c (Fixed inheritance between Animal, Plants and Food)
		
		diet.add(food.getName());
		return Event.EXPANDING_DIET;
	}
	
	public Event grow() {
		size+=(size*Math.random()*((double)currentEnergy/maxEnergy));
		return Event.GROW;
		
	}
	
<<<<<<< HEAD
	public boolean isAlive() {
		return alive;
	}
	
	public boolean isStarving() {
		return currentEnergy<=starvingValue;
	}
	
	public ArrayList<FoodName> getDiet(){
		return diet;
	}

=======
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
	
>>>>>>> 6b9ad2c (Fixed inheritance between Animal, Plants and Food)
	@Override
	public String toString() {
		String animalInfo = this.name+ " " + (int)size +" "+ this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
		return animalInfo;
	}
}
