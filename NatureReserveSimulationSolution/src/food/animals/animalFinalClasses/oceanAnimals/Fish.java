package food.animals.animalFinalClasses.oceanAnimals;

import java.util.ArrayList;

import java.util.Arrays;

import food.animals.Omnivore;

public class Fish extends Omnivore{
	public Fish(int x, int y) {
		super("fish", 1, 5, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("algae","insect"));
	}
}
