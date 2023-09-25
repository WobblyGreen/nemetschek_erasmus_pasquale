package food.animals.animalFinalClasses.desertAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import food.animals.Herbivore;

public final class AddaxAntelope extends Herbivore {

	public AddaxAntelope(int x, int y) {
		super("addax antelope", 1, 8, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("grass", "leaf", "acacia"));
	}

}
