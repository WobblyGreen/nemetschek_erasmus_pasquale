package food.animals.animalFinalClasses.jungleAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Herbivore;

public class Gorilla extends Herbivore{

	public Gorilla(int x, int y) {
		super("gorilla", 1, 14, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("banana", "root", "leaf", "bark"));
	}

}
