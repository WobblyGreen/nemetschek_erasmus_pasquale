package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Common.Eatable;

public class Omnivore extends Animal {

	public Omnivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<Eatable> animalsAndVeggiesToEat) {
		super(as, maxEnergy, size, animalsAndVeggiesToEat);
	}
	
	public Omnivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}

}
