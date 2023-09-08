package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Common.Eatable;
import Common.Food;

public class Carnivore extends Animal {

	public Carnivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<Food> animalsToEat) {
		super(as, maxEnergy, size, animalsToEat);
	}
	
	public Carnivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}

}
