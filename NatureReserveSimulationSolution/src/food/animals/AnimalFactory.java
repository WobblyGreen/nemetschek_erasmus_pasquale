package food.animals;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.function.BiFunction;

public class AnimalFactory {
	private HashMap<String, BiFunction<Integer, Integer, Animal>> availableAnimals;
	
	public AnimalFactory(HashMap<String, BiFunction<Integer, Integer, Animal>> availableAnimals) {
		this.availableAnimals=availableAnimals;
	}
	
	public Animal createAnimal(String animalName, int x, int y) {
		BiFunction<Integer, Integer, Animal> animalSupplier = availableAnimals.get(animalName);
		return (animalSupplier==null ? null : animalSupplier.apply(x, y));
	}
	
	public ArrayList<Animal> createAnimals(int num, int x, int y){
		ArrayList<Animal> createdAnimals = new ArrayList<>();
		String[] animalsNames = availableAnimals.keySet().toArray(String[]::new);
		
		for(int i=0; i<num; i++) {
			createdAnimals.add(createAnimal(animalsNames[(int)(Math.random()*animalsNames.length)], x, y));
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
