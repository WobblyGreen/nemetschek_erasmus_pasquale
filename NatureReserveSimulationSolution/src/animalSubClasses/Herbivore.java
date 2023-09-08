package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Common.Eatable;
import Common.Food;
import Food.Food;
import Food.FoodName;

public class Herbivore extends Animal {

	public Herbivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<Food> veggieToEat) {
		super(as, maxEnergy, size, veggieToEat);
	}

	public Herbivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}

}

