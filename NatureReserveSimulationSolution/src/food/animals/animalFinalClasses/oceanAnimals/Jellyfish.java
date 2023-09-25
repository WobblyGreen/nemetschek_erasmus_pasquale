package food.animals.animalFinalClasses.oceanAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Carnivore;

public class Jellyfish extends Carnivore {

	public Jellyfish(int x, int y) {
		super("jellyfish", 1.3, 5, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("plankton"));
	}

}
