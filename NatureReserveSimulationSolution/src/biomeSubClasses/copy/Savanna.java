package biomeSubClasses.copy;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Savanna extends Biome {

	public Savanna(int x, int y) {
		super("Savanna",
				6,
				new ArrayList<String>(Arrays.asList("lion", "zebra")),
				new ArrayList<String>(Arrays.asList("banana", "cauliflower")),
				x, y);
	}
	
	

}
