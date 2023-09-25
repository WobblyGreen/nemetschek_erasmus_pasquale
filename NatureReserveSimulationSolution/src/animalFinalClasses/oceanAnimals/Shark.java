package animalFinalClasses.oceanAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Carnivore;

public class Shark extends Carnivore{

	public Shark(int x, int y) {
		super("shark", 1, 45, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("dolphin", "fish", "tuna"));
	}
}
