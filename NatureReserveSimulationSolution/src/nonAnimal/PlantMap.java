package nonAnimal;

import java.util.HashMap;
import java.util.function.BiFunction;
import nonAnimalSubClasses.*;

public final class PlantMap {
	private HashMap<String, BiFunction<Integer, Integer, Plant>> plantHashMap;
	
	public PlantMap() {
		plantHashMap = new HashMap<String, BiFunction<Integer, Integer, Plant>>();
		fillMapWithDefaults();
	}
	
	private void fillMapWithDefaults() {
		plantHashMap.put("banana", (Integer x, Integer y)->new Banana(x, y));
		plantHashMap.put("cauliflower", (Integer x, Integer y)->new Cauliflower(x, y));
	}
	
	public HashMap<String, BiFunction<Integer, Integer, Plant>> getPlantHashMap(){
		return plantHashMap;
	}
}
