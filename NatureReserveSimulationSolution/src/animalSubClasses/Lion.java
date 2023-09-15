package animalSubClasses;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Carnivore;
import food.FoodName;

public final class Lion extends Carnivore {

	public Lion() {
		super(FoodName.LION, 1, 7, null);
		this.diet=new ArrayList<FoodName>(Arrays.asList(FoodName.ZEBRA));
	}

}
