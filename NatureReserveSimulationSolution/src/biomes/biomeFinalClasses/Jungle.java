package biomes.biomeFinalClasses;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Jungle extends Biome {

	public Jungle(int x, int y) {
		super("Jungle",
				4,
				new ArrayList<String>(Arrays.asList("lion", "anaconda", "bongo", "bonobo", "gorilla", "fish", "insect", "rat", "bird")),
				new ArrayList<String>(Arrays.asList("banana", "grass", "leaf", "seed", "root", "bark")),
				x, y);
	}
	
	

}
