package food.animals.animalFinalClasses.oceanAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Carnivore;

public class Whale extends Carnivore{
	public Whale(int x, int y) {
		super("whale", 1, 45, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("fish", "shrimp", "shark", "sea lion"));
	}
}
