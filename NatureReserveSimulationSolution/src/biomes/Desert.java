package biomes;

import java.util.ArrayList;
import java.util.Arrays;

public final class Desert extends Biome {

	public Desert(int x, int y) {
		super("Desert",
				10,
				new ArrayList<String>(Arrays.asList("lion", "zebra")),
				new ArrayList<String>(Arrays.asList("banana", "cauliflower")),
				x, y);
	}
	
	

}
