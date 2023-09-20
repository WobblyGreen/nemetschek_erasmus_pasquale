package nonAnimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

import animals.Animal;

public class PlantFactory {
	HashMap<String, Supplier<Plant>> availablePlants;
	
	public PlantFactory(HashMap<String, Supplier<Plant>> availablePlants) {
		this.availablePlants=availablePlants;
	}
	
	public Plant createPlant(String plantName) {
		Supplier<Plant> plantSupplier = availablePlants.get(plantName);
		return (plantSupplier==null ? null : plantSupplier.get());
	}
	
	/*public ArrayList<Plant> createPlants(int num){
		ArrayList<Plant> createdPlants = new ArrayList<>();
		String[] plantsNames = availablePlants.keySet().toArray(String[]::new);
		
		for(int i=0; i<num; i++) {
			createdPlants.add(createPlant(plantsNames[(int)(Math.random()*plantsNames.length)]));
		}
		
		return createdPlants;
	}*/

	public String getPlantKey(int index) {
		return (String) availablePlants.keySet().toArray()[index];
	}
	
	public String[] getPlantKeys() {
		return availablePlants.keySet().toArray(String[]::new);
	}
	
	public int getPlantLength() {
		return availablePlants.keySet().size();
	}

}
