package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Common.Eatable;

public class Carnivore extends Animal {

	public Carnivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<Eatable> animalsToEat) {
		super(as, maxEnergy, size, animalsToEat);
	}
	
	public Carnivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}

}
