package biomes.biomeFinalClasses;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Desert extends Biome {

	public Desert(int x, int y) {
		super("Desert",
				4,
				new ArrayList<String>(Arrays.asList("addax antelope", "oryx", "sand cat", "bactrian camel", "insect", "rat", "bird")),
				new ArrayList<String>(Arrays.asList("leaf", "grass", "seed")),
				x, y);
	}
	
	

}
