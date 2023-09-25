package animalFinalClasses.jungleAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Herbivore;

public class Bongo extends Herbivore{

	public Bongo(int x, int y) {
		super("bongo", 1, 9, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("grass", "leaf", "seed"));
	}
	

}
