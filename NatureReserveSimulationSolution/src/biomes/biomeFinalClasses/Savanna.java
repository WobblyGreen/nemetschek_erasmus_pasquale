package biomes.biomeFinalClasses;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Savanna extends Biome {

	public Savanna(int x, int y) {
		super("Savanna",
				4,
				new ArrayList<String>(Arrays.asList("lion", "zebra", "warthog", "elephant", "insect", "rat", "bird")),
				new ArrayList<String>(Arrays.asList("banana", "cauliflower", "seed", "bark", "root", "potato")),
				x, y);
	}
	
	

}
