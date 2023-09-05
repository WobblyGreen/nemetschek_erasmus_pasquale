package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Common.Eatable;
import Food.Food;
import Food.FoodName;

public class Zebra extends Animal {

	public Zebra(int maxEnergy, ArrayList<Eatable> zebraFood) {
		super(AnimalSpecies.ZEBRA, maxEnergy, zebraFood);
	}

	public Zebra(int maxEnergy) {
		super(AnimalSpecies.ZEBRA, maxEnergy);
	}

}

