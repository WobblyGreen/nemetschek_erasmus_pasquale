package biomes.biomeFinalClasses;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Jungle extends Biome {

	public Jungle(int x, int y) {
		super("Jungle",
				8,
				new ArrayList<String>(Arrays.asList("lion", "zebra")),
				new ArrayList<String>(Arrays.asList("banana", "cauliflower")),
				x, y);
	}
	
	

}
