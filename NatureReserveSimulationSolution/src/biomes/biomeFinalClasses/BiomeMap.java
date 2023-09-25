package biomes.biomeFinalClasses;

import java.util.HashMap;
import java.util.function.BiFunction;

import biomes.Biome;

public class BiomeMap {
	private HashMap<String, BiFunction<Integer, Integer, Biome>> biomeHashMap;
	
	public BiomeMap() {
		biomeHashMap = new HashMap<String, BiFunction<Integer, Integer, Biome>>();
		fillMapWithDefaults();
	}
	
	private void fillMapWithDefaults() {
		biomeHashMap.put("desert", (Integer x, Integer y)->new Desert(x, y));
		biomeHashMap.put("ocean", (Integer x, Integer y)->new Ocean(x, y));
		biomeHashMap.put("savanna", (Integer x, Integer y)->new Savanna(x, y));
		biomeHashMap.put("jungle", (Integer x, Integer y)->new Jungle(x, y));
	}
	
	public HashMap<String, BiFunction<Integer, Integer, Biome>> getBiomeHashMap(){
		return biomeHashMap;
	}
}
