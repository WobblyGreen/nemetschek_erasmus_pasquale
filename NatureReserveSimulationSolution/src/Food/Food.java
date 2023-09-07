package Food;

import Common.Eatable;

public class Food implements Eatable{
	protected FoodName foodName;
	protected int energy;
	protected double size;
	
	public Food(FoodName foodName, int energy) {
		this.foodName=foodName;
		this.energy=energy;
	}

	public int getEnergy() {
		return energy;
	}
	
	public String getName() {
		return this.foodName+"";
	}
	
	@Override
	public String toString() {
		return foodName+" "+energy;
	}

	@Override
	public double getSize() {
		return size;
	}
	
}
