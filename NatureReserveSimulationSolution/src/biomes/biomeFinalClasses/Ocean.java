package biomes.biomeFinalClasses;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Ocean extends Biome {

	public Ocean(int x, int y) {
		super("Ocean",
				4,
				new ArrayList<String>(Arrays.asList("bird", "dolphin", "shark", "whale", "fish", "jellyfish", "shrimp", "turtle")),
				new ArrayList<String>(Arrays.asList("algae")),
				x, y);
	}
	
	

}
