package nonAnimal;

import java.util.HashMap;
import java.util.function.Supplier;
import nonAnimalSubClasses.*;

public final class PlantMap {
	private HashMap<String, Supplier<Plant>> plantHashMap;
	
	public PlantMap() {
		plantHashMap = new HashMap<String, Supplier<Plant>>();
		fillMapWithDefaults();
	}
	
	private void fillMapWithDefaults() {
		plantHashMap.put("banana", ()->new Banana());
		plantHashMap.put("cauliflower", ()->new Cauliflower());
	}
	
	public HashMap<String, Supplier<Plant>> getPlantHashMap(){
		return plantHashMap;
	}
}
