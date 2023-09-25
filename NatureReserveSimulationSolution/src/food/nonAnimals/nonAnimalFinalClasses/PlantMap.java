package food.nonAnimals.nonAnimalFinalClasses;

import java.util.HashMap;
import java.util.function.BiFunction;

import food.nonAnimals.Plant;

public final class PlantMap {
	private HashMap<String, BiFunction<Integer, Integer, Plant>> plantHashMap;
	
	public PlantMap() {
		plantHashMap = new HashMap<String, BiFunction<Integer, Integer, Plant>>();
		fillMapWithDefaults();
	}
	
	private void fillMapWithDefaults() {
		plantHashMap.put("banana", (Integer x, Integer y)->new Banana(x, y));
		plantHashMap.put("cauliflower", (Integer x, Integer y)->new Cauliflower(x, y));
		plantHashMap.put("bark", (Integer x, Integer y)->new Bark(x, y));
		plantHashMap.put("grass", (Integer x, Integer y)->new Grass(x, y));
		plantHashMap.put("leaf", (Integer x, Integer y)->new Leaf(x, y));
		plantHashMap.put("potato", (Integer x, Integer y)->new Potato(x, y));
		plantHashMap.put("root", (Integer x, Integer y)->new Root(x, y));
		plantHashMap.put("seed", (Integer x, Integer y)->new Seed(x, y));
		plantHashMap.put("algae", (Integer x, Integer y)->new Algae(x, y));
	}
	
	public HashMap<String, BiFunction<Integer, Integer, Plant>> getPlantHashMap(){
		return plantHashMap;
	}
}
