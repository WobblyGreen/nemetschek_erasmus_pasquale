package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Food.Food;

public class Lion extends Animal {

	public Lion(int maxEnergy, ArrayList<Food> diet) {
		super(AnimalSpecies.LION, maxEnergy, diet);
	}

}
