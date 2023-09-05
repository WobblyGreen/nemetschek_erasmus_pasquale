package Food;

public abstract class Food {
	protected FoodName foodName;
	protected int energy;
	
	public Food(FoodName foodName, int energy) {
		this.foodName=foodName;
		this.energy=energy;
	}

	public int getEnergy() {
		return energy;
	}
	
	public FoodName getFoodName() {
		return this.foodName;
	}
	
	@Override
	public String toString() {
		return foodName+" "+energy;
	}
	
}
