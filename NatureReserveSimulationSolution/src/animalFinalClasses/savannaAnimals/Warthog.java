package animalFinalClasses.savannaAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Omnivore;

public class Warthog extends Omnivore {

	public Warthog(int x, int y) {
		super("warthog", 1, 13, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("grass", "berry", "egg", "root", "insect"));
	}

}
