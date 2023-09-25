package food.animals.animalFinalClasses.everywhereAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Omnivore;

public class Bird extends Omnivore{

	public Bird(int x, int y) {
		super("bird", 1, 4,
				new ArrayList<String>(Arrays.asList("insect", "seed", "egg"))
				, x, y);
		// TODO Auto-generated constructor stub
	}

}
