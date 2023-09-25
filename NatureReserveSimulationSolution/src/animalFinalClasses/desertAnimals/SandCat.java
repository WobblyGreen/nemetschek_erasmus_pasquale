package animalFinalClasses.desertAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Carnivore;

public final class SandCat extends Carnivore {

	public SandCat(int x, int y) {
		super("sand cat", 1, 4, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("snake", "spider", "rat", "bird"));
	}

}
