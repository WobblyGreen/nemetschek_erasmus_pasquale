package NonAnimal;

import Interfaces.Eatable;

public class VegeterianFood implements Eatable{
	protected VegeterianSpecies foodName;
	protected int energy;
	protected double size;
	
	public VegeterianFood(VegeterianSpecies foodName, int energy) {
		this.foodName=foodName;
		this.energy=energy;
		this.size=1;
	}

	public VegeterianFood(VegeterianSpecies foodName, int energy, double size) {
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
