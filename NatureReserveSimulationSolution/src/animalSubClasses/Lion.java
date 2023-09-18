package animalSubClasses;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Carnivore;

public final class Lion extends Carnivore {

	public Lion() {
		super("lion", 1, 7, null);
		this.diet=new ArrayList<String>(Arrays.asList("zebra"));
	}

}
