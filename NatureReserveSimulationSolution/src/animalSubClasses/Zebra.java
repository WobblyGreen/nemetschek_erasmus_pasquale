package animalSubClasses;

import java.util.ArrayList;
import java.util.Arrays;
import animals.Herbivore;

public final class Zebra extends Herbivore{

	public Zebra() {
		super("zebra", 1, 9, null);
		this.diet=new ArrayList<String>(Arrays.asList("banana", "cauliflower"));
	}

}
