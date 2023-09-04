package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Food.Food;

public class Zebra extends Animal {

	public Zebra(int maxEnergy, ArrayList<Food> diet) {
		super(AnimalSpecies.ZEBRA, maxEnergy, diet);
	}

}

