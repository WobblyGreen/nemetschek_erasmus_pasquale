package Animals;

import java.util.ArrayList;

import Interfaces.DietItem;
import Interfaces.Eatable;
import events.Emitter;

public abstract class Animal implements Eatable, Emitter{
	protected final AnimalSpecies animal;
	protected boolean alive;
	
	protected final int maxEnergy;
	protected int currentEnergy;
	protected int starvingValue;

	protected ArrayList<DietItem> diet;
	protected double size;

	public Animal(AnimalSpecies as, int maxEnergy, double size, ArrayList<DietItem> diet) {
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
	 * @return 
	 */
	public Eatable feed(Eatable toEat) {
		if(!alive || toEat==null) return null;
		
		if(!dietContainsFood(toEat.getDietItem())) {
			starve();
			toEat.setEnergy(toEat.getEnergy()-1);
		}
		
		else if(toEat.getEnergy()<=0)
			starve();
		
		else{
			this.currentEnergy+=toEat.getEnergy();
			toEat.setEnergy(0);
			
			if(this.currentEnergy>this.maxEnergy) {
				toEat.setEnergy(currentEnergy-maxEnergy);
				currentEnergy=maxEnergy;
			}
		}
		
		if(toEat instanceof Animal) 
			((Animal)toEat).die();
		
		return toEat;
	};
	
	//Eatable methods
	public double getSize() {
		return this.size;
	}
	
	public DietItem getDietItem() {
		return animal;
	}
	
	public int getEnergy() {
		return currentEnergy;
	}
	
	public void setEnergy(int energy) {
		this.currentEnergy=energy;
	}
	
	public String getName() {
		return animal+"";
	}
	
	@Override
	public void setSize(double size) {
		this.size=size;
	}
	//end
	
	public boolean addFoodToDiet(DietItem foodName) {
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
	
	public void starve() {
		this.currentEnergy--;
		if(currentEnergy<=0) die();
	}
	
	public boolean dietContainsFood(DietItem item) {
		for(DietItem di:diet) {
			if(di.equals(item)) return true;
		}
		return false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public boolean isStarving() {
		return alive && currentEnergy<=starvingValue;
	}
	
	public ArrayList<DietItem> getDiet(){
		return diet;
	}
	
	public int getMaxEnergy() {
		return maxEnergy;
	}

	@Override
	public String toString() {
		String animalInfo = this.animal+ " " + (int)size +" "+ this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
		return animalInfo;
	}
}
