package food;

public abstract class Food {
	protected double size;
	protected int currentEnergy;
	protected int maxEnergy;
	protected FoodName name;
	
	
	public Food(FoodName name, double size, int currentEnergy, int maxEnergy) {
		this.currentEnergy = currentEnergy;
		this.maxEnergy = maxEnergy;
		this.name = name;
	}


	public double getSize() {
		return size;
	}


	public int getCurrentEnergy() {
		return currentEnergy;
	}


	public int getMaxEnergy() {
		return maxEnergy;
	}


	public FoodName getName() {
		return name;
	}


	public void setCurrentEnergy(int currentEnergy) {
		this.currentEnergy=currentEnergy;
		
	}
}
