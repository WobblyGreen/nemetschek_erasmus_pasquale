package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Interfaces.DietItem;
import Interfaces.Eatable;

public class Carnivore extends Animal {

	public Carnivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<DietItem> animalsToEat) {
		super(as, maxEnergy, size, animalsToEat);
	}
	
	public Carnivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}

}
