package food.nonAnimals;

import food.Food;

public class Plant extends Food{

	public Plant(String name, double size, int maxEnergy, int x, int y) {
		super(name, size, maxEnergy, x, y);
	}
	
	@Override
	public String toString() {
		return name+" "+currentEnergy+"/"+maxEnergy;
	}
}
