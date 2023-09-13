package Animals;

import java.util.ArrayList;
import food.FoodName;

public abstract class Omnivore extends Animal {

	public Omnivore(FoodName name, double size, int maxEnergy, ArrayList<FoodName> diet) {
		super(name, size, maxEnergy, diet);
	}

	

}
