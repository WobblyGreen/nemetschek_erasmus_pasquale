package food.animals.animalFinalClasses;


import java.util.HashMap;

import java.util.function.BiFunction;

import food.animals.Animal;
import food.animals.animalFinalClasses.savannaAnimals.*;
import food.animals.animalFinalClasses.jungleAnimals.*;
import food.animals.animalFinalClasses.oceanAnimals.*;
import food.animals.animalFinalClasses.desertAnimals.*;
import food.animals.animalFinalClasses.everywhereAnimals.*;

public final class AnimalMap {
	private HashMap<String, BiFunction<Integer, Integer, Animal>> animalHashMap;
	
	public AnimalMap() {
		animalHashMap = new HashMap<String, BiFunction<Integer, Integer, Animal>>();
		fillMapWithDefaults();
	}
	
	private void fillMapWithDefaults() {
		animalHashMap.put("lion", (Integer x, Integer y)->new Lion(x, y));
		animalHashMap.put("lev", (Integer x, Integer y)->new Lion(x, y));
		animalHashMap.put("zebra", (Integer x, Integer y)->new Zebra(x, y));
	}
	
	public HashMap<String, BiFunction<Integer, Integer, Animal>> getAnimalHashMap(){
		return animalHashMap;
	}
}
