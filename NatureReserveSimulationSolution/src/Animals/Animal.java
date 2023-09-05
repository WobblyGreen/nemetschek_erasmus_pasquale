package Animals;

import java.util.ArrayList;
import Food.Food;
import Food.FoodName;

public abstract class Animal {
	protected final AnimalSpecies animal;
	protected boolean alive;
	
	protected final int maxEnergy;
	protected int currentEnergy;

	protected ArrayList<FoodName> diet;

	public Animal(AnimalSpecies as, int maxEnergy, ArrayList<FoodName> diet) {
		this.animal = as;
		this.maxEnergy = maxEnergy;
		this.diet = diet;
		
		this.currentEnergy = maxEnergy;
		this.alive = true;
	}
	
	/**
	 * Feeds the animal with the passed food
	 * @param food
	 */
	public void feed(Food food) {
		if(!this.alive) return;
		
		if(!this.diet.contains(food.getFoodName())) {
			this.currentEnergy-=food.getEnergy();
			
			if(this.currentEnergy<=0) {
				this.alive=false;
				this.currentEnergy=0;
			}
		}
		
		else{
			this.currentEnergy+=food.getEnergy();
			if(this.currentEnergy>this.maxEnergy)
				currentEnergy=maxEnergy;
		}
			
	};
	
	public boolean isAlive() {
		return alive;
	}

	@Override
	public String toString() {
		String animalInfo = "\n"+this.alive + " " + this.animal+ " " + this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
		return animalInfo;
	}
}
