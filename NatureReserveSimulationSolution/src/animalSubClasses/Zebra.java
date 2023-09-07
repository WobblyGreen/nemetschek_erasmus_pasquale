package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Common.Eatable;
import Food.Food;
import Food.FoodName;

public class Zebra extends Animal {

	public Zebra(int maxEnergy, double size, ArrayList<Eatable> zebraFood) {
		super(AnimalSpecies.ZEBRA, maxEnergy, size, zebraFood);
	}

	public Zebra(int maxEnergy) {
		super(AnimalSpecies.ZEBRA, maxEnergy, 1);
	}

}

