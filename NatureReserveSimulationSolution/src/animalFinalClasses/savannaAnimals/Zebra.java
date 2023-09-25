package animalFinalClasses.savannaAnimals;

import java.util.ArrayList;
import java.util.Arrays;
import animals.Herbivore;

public final class Zebra extends Herbivore{

	public Zebra(int x, int y) {
		super("zebra", 1, 9, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("banana", "cauliflower"));
	}

}
