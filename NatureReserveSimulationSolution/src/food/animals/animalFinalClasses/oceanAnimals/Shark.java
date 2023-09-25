package food.animals.animalFinalClasses.oceanAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Carnivore;

public class Shark extends Carnivore{

	public Shark(int x, int y) {
		super("shark", 1, 12, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("dolphin", "fish", "tuna"));
	}
}
