package food.animals.animalFinalClasses.jungleAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import food.animals.Carnivore;

public class Anaconda extends Carnivore{
	public Anaconda(int x, int y) {
		super("anaconda", 1, 8, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("fish", "deer", "bird", "turtle"));
	}

}
