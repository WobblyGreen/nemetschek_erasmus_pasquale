package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Common.Eatable;

public class Lion extends Animal {

	public Lion(int maxEnergy, double size, ArrayList<Eatable> lionFood) {
		super(AnimalSpecies.LION, maxEnergy, size, lionFood);
	}
	
	public Lion(int maxEnergy) {
		super(AnimalSpecies.LION, maxEnergy, 1);
	}

}
