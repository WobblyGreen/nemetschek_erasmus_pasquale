package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.Animal;
import Interfaces.Eatable;

public class SimulationLogic {
	ArrayList<Animal> animals;
	Generator gen;
	
	public SimulationLogic() {
		this.gen=new Generator();
		this.animals=gen.generateRandomAnimalArrayList();
		System.out.println(animals);
	}
	
	public void simulate() {
		feedAllAnimals();
	}
	
	private void feedAllAnimals() {
		HashMap<Integer, Animal> animalLifes = new HashMap<>();
		
		for(int turn=1; !areAllAnimalsDeath(); turn++) {
			for(Animal animal:animals) {
				Eatable e = gen.generateRandomFood();
				animal.feed(e);
				
				if(turn%3==0 && !animal.isStarving()) {
					animal.grow();
					animal.addFoodToDiet(gen.generateDietItem());

				}

				if(!animal.isAlive() && !animalLifes.containsValue(animal))
					animalLifes.put(turn, animal);	
			}
		}
		
		int minLife = Collections.min(animalLifes.keySet());
		int maxLife = Collections.max(animalLifes.keySet());
		
		System.out.println("\nStatistic>>");
		System.out.println(">Minimum lived for " + minLife +" turns\n"+ animalLifes.get(minLife));
		System.out.println(">Maximum lived for " + maxLife +" turns\n"+ animalLifes.get(maxLife));
		System.out.println(">Average living of " + average(animalLifes.keySet()) +" turns");
	}
	
	private boolean areAllAnimalsDeath() {
		for(Animal a:animals) {
			if(a.isAlive()) return false;
		}
		return true;
	}
	
	private int average(Set<Integer> nums) {
		int sum = 0;
		for(int n : nums) sum+=n;
		return sum/nums.size();
		
	}
}
