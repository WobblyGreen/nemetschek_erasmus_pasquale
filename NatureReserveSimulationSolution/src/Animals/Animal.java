package Animals;

import java.util.ArrayList;
import Food.Food;

public abstract class Animal {
	protected final String animalName;
	protected boolean alive;
	
	protected final int maxEnergy;
	protected int currentEnergy;

	protected ArrayList<Food> diet;

	public Animal(String animalName, int maxEnergy, ArrayList<Food> diet) {
		this.animalName = animalName;
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
		
		if(!this.diet.contains(food)) {
			this.currentEnergy--;
			
			if(this.currentEnergy<=0)
				this.alive=false;
		}
		
		else if(this.currentEnergy<this.maxEnergy)
			this.currentEnergy++;	
	};
	
	public boolean isAlive() {
		return alive;
	}

	@Override
	public String toString() {
		String animalInfo = "\n"+this.alive + " " + this.animalName + " " + this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
		return animalInfo;
	}
}
