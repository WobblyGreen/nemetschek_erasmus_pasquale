package nonAnimal;

import java.util.HashMap;
import java.util.function.Supplier;

public class PlantFactory {
	HashMap<String, Supplier<Plant>> availablePlants;
	
	public PlantFactory(HashMap<String, Supplier<Plant>> availablePlants) {
		this.availablePlants=availablePlants;
	}
	
	public Plant createPlant(String plantName) {
		Supplier<Plant> plantSupplier = availablePlants.get(plantName);
		return (plantSupplier==null ? null : plantSupplier.get());
	}

	public String getPlantKey(int index) {
		return (String) availablePlants.keySet().toArray()[index];
	}
	
	public int getPlantLength() {
		return availablePlants.keySet().size();
	}

}
