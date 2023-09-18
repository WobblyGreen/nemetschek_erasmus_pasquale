package nonAnimal;

import food.Food;

public class Plant extends Food{

	public Plant(String name, double size, int maxEnergy) {
		super(name, size, maxEnergy);
	}
	
	@Override
	public String toString() {
		return name+" "+currentEnergy+"/"+maxEnergy;
	}
}
