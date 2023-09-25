package food.animals.animalFinalClasses.everywhereAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Omnivore;

public class Insect extends Omnivore{

	public Insect(int x, int y) {
		super("insect", 0.2, 1, new ArrayList<String>(Arrays.asList("dung")), x, y);
	}

}
