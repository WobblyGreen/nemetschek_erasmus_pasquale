package animalSubClasses;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Herbivore;
import food.FoodName;

public final class Zebra extends Herbivore{

	public Zebra() {
		super(FoodName.ZEBRA, 1, 9, null);
		this.diet=new ArrayList<FoodName>(Arrays.asList(FoodName.BANANA, FoodName.CAULIFLOWER));
	}

}
