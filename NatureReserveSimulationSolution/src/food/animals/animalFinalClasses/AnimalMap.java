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
		//desert
		animalHashMap.put("addax antelope", (Integer x, Integer y)->new AddaxAntelope(x, y));
		animalHashMap.put("bactrian camel", (Integer x, Integer y)->new BactrianCamel(x, y));
		animalHashMap.put("oryx", (Integer x, Integer y)->new Oryx(x, y));
		animalHashMap.put("sand cat", (Integer x, Integer y)->new SandCat(x, y));
		//jungle
		animalHashMap.put("anaconda", (Integer x, Integer y)->new Anaconda(x, y));
		animalHashMap.put("bongo", (Integer x, Integer y)->new Bongo(x, y));
		animalHashMap.put("gorilla", (Integer x, Integer y)->new Gorilla(x, y));
		animalHashMap.put("bonobo", (Integer x, Integer y)->new Bonobo(x, y));
		//ocean
		animalHashMap.put("dolphin", (Integer x, Integer y)->new Dolphin(x, y));
		animalHashMap.put("fish", (Integer x, Integer y)->new Fish(x, y));
		animalHashMap.put("jellyfish", (Integer x, Integer y)->new Jellyfish(x, y));
		animalHashMap.put("shark", (Integer x, Integer y)->new Shark(x, y));
		animalHashMap.put("shrimp", (Integer x, Integer y)->new Shrimp(x, y));
		animalHashMap.put("turtle", (Integer x, Integer y)->new Turtle(x, y));
		animalHashMap.put("whale", (Integer x, Integer y)->new Whale(x, y));
		//savanna
		animalHashMap.put("elephant", (Integer x, Integer y)->new Elephant(x, y));
		animalHashMap.put("warthog", (Integer x, Integer y)->new Warthog(x, y));
		animalHashMap.put("lion", (Integer x, Integer y)->new Lion(x, y));
		animalHashMap.put("lev", (Integer x, Integer y)->new Lion(x, y));
		animalHashMap.put("zebra", (Integer x, Integer y)->new Zebra(x, y));
		//everywhereAnimals
		animalHashMap.put("bird", (Integer x, Integer y)->new Bird(x, y));
		animalHashMap.put("insect", (Integer x, Integer y)->new Insect(x, y));
		animalHashMap.put("rat", (Integer x, Integer y)->new Rat(x, y));
	}
	
	public HashMap<String, BiFunction<Integer, Integer, Animal>> getAnimalHashMap(){
		return animalHashMap;
	}
}
