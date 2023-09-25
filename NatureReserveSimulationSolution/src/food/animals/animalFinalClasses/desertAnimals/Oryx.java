package food.animals.animalFinalClasses.desertAnimals;

import java.util.ArrayList;


import java.util.Arrays;

import food.animals.Herbivore;

public final class Oryx extends Herbivore {

	public Oryx(int x, int y) {
		super("oryx", 1, 8, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("leaf", "grass", "potato"));
	}

}
