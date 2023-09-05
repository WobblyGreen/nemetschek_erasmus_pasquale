package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Common.Eatable;

public class Lion extends Animal {

	public Lion(int maxEnergy, ArrayList<Eatable> lionFood) {
		super(AnimalSpecies.LION, maxEnergy, lionFood);
	}
	
	public Lion(int maxEnergy) {
		super(AnimalSpecies.LION, maxEnergy);
	}

}
