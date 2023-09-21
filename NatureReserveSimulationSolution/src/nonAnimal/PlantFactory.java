package nonAnimal;

import java.util.HashMap;
import java.util.function.BiFunction;

public class PlantFactory {
	HashMap<String, BiFunction<Integer, Integer, Plant>> availablePlants;
	
	public PlantFactory(HashMap<String, BiFunction<Integer, Integer, Plant>> availablePlants) {
		this.availablePlants=availablePlants;
	}
	
	public Plant createPlant(String plantName, int x, int y) {
		BiFunction<Integer, Integer, Plant> plantSupplier = availablePlants.get(plantName);
		return (plantSupplier==null ? null : plantSupplier.apply(x, y));
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
