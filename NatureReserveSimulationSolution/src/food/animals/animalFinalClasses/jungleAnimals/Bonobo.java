package food.animals.animalFinalClasses.jungleAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Omnivore;

public class Bonobo extends Omnivore{

	public Bonobo(int x, int y) {
		super("bonobo", 1, 7, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("banana", "insect", "seed"));
	}

}
