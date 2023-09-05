package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Food.Food;
import Food.FoodName;

public class Lion extends Animal {

	public Lion(int maxEnergy, ArrayList<FoodName> lionFood) {
		super(AnimalSpecies.LION, maxEnergy, lionFood);
	}

}
