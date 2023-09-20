package animals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public class AnimalFactory {
	private HashMap<String, Supplier<Animal>> availableAnimals;
	
	public AnimalFactory(HashMap<String, Supplier<Animal>> availableAnimals) {
		this.availableAnimals=availableAnimals;
	}
	
	public Animal createAnimal(String animalName) {
		Supplier<Animal> animalSupplier = availableAnimals.get(animalName);
		return (animalSupplier==null ? null : animalSupplier.get());
	}
	
	public ArrayList<Animal> createAnimals(int num){
		ArrayList<Animal> createdAnimals = new ArrayList<>();
		String[] animalsNames = availableAnimals.keySet().toArray(String[]::new);
		
		for(int i=0; i<num; i++) {
			createdAnimals.add(createAnimal(animalsNames[(int)(Math.random()*animalsNames.length)]));
		}
		
		return createdAnimals;
	}
	
	public String getAnimalKey(int index) {
		return availableAnimals.keySet().toArray(String[]::new)[index];
	}
	
	public int getAnimalLength() {
		return availableAnimals.keySet().size();
	}
}
