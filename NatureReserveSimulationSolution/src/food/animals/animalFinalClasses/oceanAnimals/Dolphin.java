package food.animals.animalFinalClasses.oceanAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Carnivore;

public class Dolphin extends Carnivore {

	public Dolphin(int x, int y) {
		super("dolphin", 1, 10, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("fish", "shrimp", "jellyfish"));
	}
}
