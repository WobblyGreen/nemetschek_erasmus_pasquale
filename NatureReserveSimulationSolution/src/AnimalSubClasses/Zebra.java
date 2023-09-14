package AnimalSubClasses;

import java.util.ArrayList;
import java.util.Arrays;

import Animals.Herbivore;
import food.FoodName;

public final class Zebra extends Herbivore{

	public Zebra() {
		super(FoodName.ZEBRA, 1, 9, null);
		this.diet=new ArrayList<FoodName>(Arrays.asList(FoodName.BANANA, FoodName.CAULIFLOWER));
	}

}
