package animalFinalClasses.desertAnimals;

import java.util.ArrayList;
import java.util.Arrays;
import animals.Herbivore;

public final class BactrianCamel extends Herbivore {

	public BactrianCamel(int x, int y) {
		super("bactrian camel", 1, 9, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("grass", "leaf", "shrub"));
	}

}
