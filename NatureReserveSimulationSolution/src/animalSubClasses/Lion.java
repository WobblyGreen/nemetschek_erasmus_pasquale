package animalSubClasses;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Carnivore;

public final class Lion extends Carnivore {

	public Lion(int x, int y) {
		super("lion", 1, 7, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("zebra"));
	}

}
