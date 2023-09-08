package Animals;

import java.util.ArrayList;

import Common.Eatable;
import Common.Food;

public abstract class Animal implements Eatable{
	protected final AnimalSpecies animal;
	protected boolean alive;
	
	protected final int maxEnergy;
	protected int currentEnergy;
	protected int starvingValue;

	protected ArrayList<Food> diet;
	protected double size;

	public Animal(AnimalSpecies as, int maxEnergy, double size, ArrayList<Food> diet) {
		this.animal = as;
		this.maxEnergy = maxEnergy;
		
		this.currentEnergy = maxEnergy;
		this.alive = true;
		
		this.starvingValue=maxEnergy/4;
		this.size=size;
		
		this.diet=diet;
	}
	
	/**
	 * Feeds the animal with the  passed food
	 * @param food
	 */
	public void feed(Eatable toEat) {
		if(!this.alive) return;

		if(!dietContainsFood(AnimalSpecies.valueOf(getName()))) {
			this.currentEnergy-=toEat.getEnergy();
			
			if(this.currentEnergy<=0) die();
		}
		
		else{
			this.currentEnergy+=toEat.getEnergy();
			if(this.currentEnergy>this.maxEnergy)
				currentEnergy=maxEnergy;
		}
		
		if(toEat instanceof Animal) 
			((Animal)toEat).die();
			
	};
	
	//Eatable methods
	public double getSize() {
		return this.size;
	}
	
	public String getName() {
		return animal+"";
	}
	
	public int getEnergy() {
		return currentEnergy;
	}
	
	public void setEnergy(int energy) {
		this.currentEnergy=energy;
	}
	
	@Override
	public void setSize(double size) {
		this.size=size;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Eatable)) return false;
		Eatable e = (Eatable)obj;
		
		return this.getName()==e.getName();
	}
	//end
	
	public void addFoodToDiet(Food foodName) {
		this.diet.add(foodName);
	}
	
	private void die() {
		this.alive=false;
		this.currentEnergy=0;
	}
	
	public void grow() {
		this.size+=(size*Math.random()*((double)currentEnergy/maxEnergy));
	}
	
	public void starve() {
		this.currentEnergy--;
		if(currentEnergy<=0) die();
	}
	
	public boolean dietContainsFood(Food toEat) {
		for(Food e:diet) {
			if(e.equals(toEat)) return true;
		}
		return false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public boolean isStarving() {
		return alive && currentEnergy<=starvingValue;
	}
	
	

	@Override
	public String toString() {
		String animalInfo = this.animal+ " " + (int)size +" "+ this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
		return animalInfo;
	}
}
