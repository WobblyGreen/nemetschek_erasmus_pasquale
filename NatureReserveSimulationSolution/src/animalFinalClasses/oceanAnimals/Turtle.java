package animalFinalClasses.oceanAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Omnivore;

public class Turtle extends Omnivore{

	public Turtle(int x, int y) {
		super("turtle", 1, 12, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("algae", "shrimp", "jellyfish"));
	}

}
