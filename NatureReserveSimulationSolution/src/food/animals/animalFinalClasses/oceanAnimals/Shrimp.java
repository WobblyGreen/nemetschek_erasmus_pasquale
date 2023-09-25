package food.animals.animalFinalClasses.oceanAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Omnivore;

public class Shrimp extends Omnivore{

	public Shrimp(int x, int y) {
		super("shrimp", 0.3, 3, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("algae"));
	}

}
