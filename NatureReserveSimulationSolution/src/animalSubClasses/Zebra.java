package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Food.Food;
import Food.FoodName;

public class Zebra extends Animal {

	public Zebra(int maxEnergy, ArrayList<FoodName> zebraFood) {
		super(AnimalSpecies.ZEBRA, maxEnergy, zebraFood);
	}

}

