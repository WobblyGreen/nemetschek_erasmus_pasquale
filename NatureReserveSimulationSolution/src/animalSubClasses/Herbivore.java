package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Interfaces.DietItem;

public class Herbivore extends Animal {

	public Herbivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<DietItem> veggieToEat) {
		super(as, maxEnergy, size, veggieToEat);
	}

	public Herbivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}

}

