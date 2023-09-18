package animals;

import java.util.HashMap;
import java.util.function.Supplier;

import animalSubClasses.*;

public final class AnimalMap {
	private HashMap<String, Supplier<Animal>> animalHashMap;
	
	public AnimalMap() {
		animalHashMap = new HashMap<String, Supplier<Animal>>();
		fillMapWithDefaults();
	}
	
	private void fillMapWithDefaults() {
		animalHashMap.put("lion", ()->new Lion());
		animalHashMap.put("lev", ()->new Lion());
		animalHashMap.put("zebra", ()->new Zebra());
	}
	
	public HashMap<String, Supplier<Animal>> getAnimalHashMap(){
		return animalHashMap;
	}
}
