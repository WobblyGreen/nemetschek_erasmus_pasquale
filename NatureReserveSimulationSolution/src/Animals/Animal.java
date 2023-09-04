package Animals;

import java.util.ArrayList;
import Food.Food;

public class Animal {
	protected final String animalName;
	protected boolean alive;
	
	protected final int maxEnergy;
	protected int currentEnergy;

	protected ArrayList<Food> diet;

	public Animal(String animalName, int maxEnergy, ArrayList<Food> diet) {
		super();
		this.animalName = animalName;
		this.maxEnergy = maxEnergy;
		this.diet = diet;
		
		this.currentEnergy = maxEnergy;
		this.alive = (currentEnergy > 0 ? true : false);
	}
	
	public void feed(Food food) {
		if(!this.alive) return;
		if(!this.diet.contains(food)) {
			this.currentEnergy--;
			return;
		}
		if(this.currentEnergy==this.maxEnergy) return;
		
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
