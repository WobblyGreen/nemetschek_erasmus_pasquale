package animals;

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
	
	public String getAnimalKey(int index) {
		return (String) availableAnimals.keySet().toArray()[index];
	}
	
	public int getAnimalLength() {
		return availableAnimals.keySet().size();
	}
}
