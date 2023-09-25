package biomes;

import java.util.HashMap;

import java.util.function.BiFunction;

public class BiomeFactory {
	private HashMap<String, BiFunction<Integer, Integer, Biome>> availableBiomes;
	
	public BiomeFactory(HashMap<String, BiFunction<Integer, Integer, Biome>> hashMap) {
		this.availableBiomes=hashMap;
	}
	
	public Biome createBiome(String biomeName, int x, int y) {
		BiFunction<Integer, Integer, Biome> biomeSupplier = availableBiomes.get(biomeName);
		return (biomeSupplier==null ? null : biomeSupplier.apply(x, y));
	}
	
	public String getBiomeKey(int index) {
		return (String) availableBiomes.keySet().toArray()[index];
	}
	
	public int getBiomeLength() {
		return availableBiomes.keySet().size();
	}
}
