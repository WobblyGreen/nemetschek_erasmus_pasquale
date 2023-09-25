package animalFinalClasses.savannaAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Herbivore;

public class Elephant extends Herbivore{
	public Elephant(int x, int y) {
		super("elephant", 1, 22, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("banana", "grass", "root", "leaf", "bark"));
	}

}
