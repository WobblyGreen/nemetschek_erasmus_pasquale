package Animals;

import java.util.ArrayList;

import Interfaces.DietItem;
import Interfaces.Eatable;

public abstract class Animal implements Eatable{
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
	public boolean feed(Eatable toEat) {
		if(!alive || toEat==null) return false;
		
		if(!dietContainsFood(toEat.getDietItem())) {
			this.currentEnergy--;
			
			if(this.currentEnergy<=0) die();
		}
		
		else{
			this.currentEnergy+=toEat.getEnergy();
			if(this.currentEnergy>this.maxEnergy)
				currentEnergy=maxEnergy;
		}
		
		if(toEat instanceof Animal) 
			((Animal)toEat).die();
		
		return true;
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
		this.diet.add(foodName);
		return true;
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

	@Override
	public String toString() {
		String animalInfo = this.animal+ " " + (int)size +" "+ this.currentEnergy + "/" + this.maxEnergy + "\n" + this.diet;
		return animalInfo;
	}
}
