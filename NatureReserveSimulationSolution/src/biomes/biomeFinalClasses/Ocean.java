package biomes.biomeFinalClasses;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Ocean extends Biome {

	public Ocean(int x, int y) {
		super("Ocean",
				10,
				new ArrayList<String>(Arrays.asList("lion", "zebra")),
				new ArrayList<String>(Arrays.asList("banana", "cauliflower")),
				x, y);
	}
	
	

}
