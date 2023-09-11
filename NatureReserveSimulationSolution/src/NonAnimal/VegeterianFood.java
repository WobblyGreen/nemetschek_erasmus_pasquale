package NonAnimal;

import Interfaces.DietItem;
import Interfaces.Eatable;

public class VegeterianFood implements Eatable{
	protected VegeterianSpecies foodName;
	protected int currentEnergy;
	protected int maxEnergy;
	protected double size;
	
	public VegeterianFood(VegeterianSpecies foodName, int energy) {
		this.foodName=foodName;
		this.maxEnergy=energy;
		this.currentEnergy=energy;
		this.size=1;
	}

	public VegeterianFood(VegeterianSpecies foodName, int energy, double size) {
		this(foodName, energy);
		this.size=size;
	}

	public int getEnergy() {
		return currentEnergy;
	}
	
	public DietItem getDietItem() {
		return foodName;
	}
	
	@Override
	public String toString() {
		return foodName+" "+currentEnergy;
	}

	@Override
	public double getSize() {
		return size;
	}

	@Override
	public void setEnergy(int energy) {
		this.currentEnergy=energy;
	}

	@Override
	public int getMaxEnergy() {
		return maxEnergy;
	}
	
	public String getName() {
		return foodName+"";
	}

	@Override
	public void setSize(double size) {
		// TODO Auto-generated method stub
		
	}
	
}
