package Animals;

import java.util.ArrayList;

import Common.Eatable;

public class Animal implements Eatable{
	protected final AnimalSpecies animal;
	protected boolean alive;
	
	protected final int maxEnergy;
	protected int currentEnergy;
	protected int starvingValue;

	protected ArrayList<Eatable> diet;
	protected double size;

	public Animal(AnimalSpecies as, int maxEnergy, double size) {
		this.animal = as;
		this.maxEnergy = maxEnergy;
		this.diet = null;
		
		this.currentEnergy = maxEnergy;
		this.alive = true;
		
		this.starvingValue=maxEnergy/4;
		this.size=size;
	}
	
	public Animal(AnimalSpecies as, int maxEnergy, double size, ArrayList<Eatable> diet) {
		this(as, maxEnergy, 1);
		this.diet=diet;
	}
	
	/**
	 * Feeds the animal with the  passed food
	 * @param food
	 */
	public void feed(Eatable toEat) {
		if(!this.alive) return;
		
		int energyOfAnimalToEat=0;
		if(toEat instanceof Animal) {
			Animal eaten = (Animal)toEat;
			energyOfAnimalToEat=eaten.currentEnergy;
			eaten.die();
		}

		if(!dietContainsFood(toEat)) {
			this.currentEnergy=-toEat.getEnergy()-energyOfAnimalToEat;
			
			if(this.currentEnergy<=0) die();
		}
		
		else{
			this.currentEnergy+=toEat.getEnergy()+energyOfAnimalToEat;
			if(this.currentEnergy>this.maxEnergy)
				currentEnergy=maxEnergy;
		}
			
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
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Eatable)) return false;
		Eatable e = (Eatable)obj;
		
		return this.getName()==e.getName();
	}
	//end
	
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
	
	private boolean dietContainsFood(Eatable toEat) {
		for(Eatable e:diet) {
			if(e.getName()==toEat.getName()) return true;
		}
		return false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public boolean isStarving() {
		return currentEnergy<=starvingValue && alive;
	}
	
	public void setEnergy(int energy) {
		this.currentEnergy=energy;
	}

	@Override
	public String toString() {
		String animalInfo = this.animal+ " " + size +" "+ this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
		return animalInfo;
	}
}
