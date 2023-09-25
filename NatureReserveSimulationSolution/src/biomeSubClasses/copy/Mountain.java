package biomeSubClasses.copy;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Mountain extends Biome {

	public Mountain(int x, int y) {
		super("Mountain",
				8,
				new ArrayList<String>(Arrays.asList("lion", "zebra")),
				new ArrayList<String>(Arrays.asList("banana", "cauliflower")),
				x, y);
	}
	
	

}
