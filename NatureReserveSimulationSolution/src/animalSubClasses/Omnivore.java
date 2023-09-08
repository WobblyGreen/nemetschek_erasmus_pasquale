package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Interfaces.DietItem;
import Interfaces.Eatable;

public class Omnivore extends Animal {

	public Omnivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<DietItem> animalsAndVeggiesToEat) {
		super(as, maxEnergy, size, animalsAndVeggiesToEat);
	}
	
	public Omnivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}

}
