package Food;

import Common.Eatable;

public abstract class EatableButNotAnimal implements Eatable{
	protected NonAnimal foodName;
	protected int energy;
	protected double size;
	
	public EatableButNotAnimal(NonAnimal foodName, int energy) {
		this.foodName=foodName;
		this.energy=energy;
		this.size=1;
	}

	public EatableButNotAnimal(NonAnimal foodName, int energy, double size) {
		this(foodName, energy);
		this.size=size;
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

	@Override
	public void setEnergy(int energy) {
		this.energy=energy;
	}

	@Override
	public void setSize(double size) {
		// TODO Auto-generated method stub
		
	}
	
}
