package nonAnimal;

import food.Food;
import food.FoodName;

public class Plants extends Food{

	public Plants(FoodName name, double size, int maxEnergy) {
		super(name, size, maxEnergy);
	}
	
	@Override
	public String toString() {
		return name+" "+currentEnergy+"/"+maxEnergy;
	}
}
