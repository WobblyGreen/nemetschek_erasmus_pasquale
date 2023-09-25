package biomeSubClasses.copy;

import java.util.ArrayList;
import java.util.Arrays;

import biomes.Biome;

public final class Desert extends Biome {

	public Desert(int x, int y) {
		super("Desert",
				4,
				new ArrayList<String>(Arrays.asList("addaxAntelope", "oryx", "sandCat", "bactrianCamel", "snake", "rats")),
				new ArrayList<String>(Arrays.asList("leaf", "grass", "acacia")),
				x, y);
	}
	
	

}
