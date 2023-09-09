package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.Animal;
import Animals.AnimalSpecies;
import Interfaces.DietItem;
import Interfaces.Eatable;
import NonAnimal.VegeterianFood;
import animalSubClasses.Carnivore;

public class SimulationLogic {
	ArrayList<Animal> animals;
	Generator gen;
	
	public SimulationLogic() {
		this.gen=new Generator();
		this.animals=gen.generateRandomAnimalArrayList();
	}
	
	public void simulate() {
		System.out.println("Starting this simulation with the following animals.\n"+animals);
		feedAllAnimals();
	}
	
	private void feedAllAnimals() {
		HashMap<Integer, Animal> animalLifes = new HashMap<>();
		ArrayList<Animal> toRemove = new ArrayList<>();
		
		for(int turn=1; !areAllAnimalsDeath() && !animals.isEmpty(); turn++) {
			System.out.print("\n---------- Day "+turn+" ----------");
			
			for(Animal animal:animals) {
				System.out.println("\n>>"+animal.getName()+" Log");
				
				Eatable e = gen.generateRandomFood();
				if(animal instanceof Carnivore) {
					e=animalsContainsAnimalSpecies(e.getDietItem());
					if(e==animal) e=null;
				}
				
				boolean didAnimalEat=animal.feed(e);
				
				if(!didAnimalEat) {
					animal.starve();
					System.out.println("_didn't eat");
				}
				else
					System.out.println("_eats "+e.getName());
				
				if(turn%3==0 && !animal.isStarving()) {
					animal.grow();
					System.out.println("_grows up to "+animal.getSize());
				}

				if(!animal.isAlive() && !animalLifes.containsValue(animal)) {
					animalLifes.put(turn, animal);
					toRemove.add(animal);
					System.out.println("<< "+animal.getName()+" died >>");
				}
			}
			
			for(Animal a:toRemove) {
				animals.remove(a);
			}
		}
		
		int minLife = Collections.min(animalLifes.keySet());
		int maxLife = Collections.max(animalLifes.keySet());
		
		System.out.println("\nStatistic>>");
		System.out.println(">Minimum lived for " + minLife +" turns\n"+ animalLifes.get(minLife));
		System.out.println(">Maximum lived for " + maxLife +" turns\n"+ animalLifes.get(maxLife));
		System.out.println(">Average living of " + average(animalLifes.keySet()) +" turns");
	}
	
	private Animal animalsContainsAnimalSpecies(DietItem di) {
		if(!(di instanceof AnimalSpecies)) return null;
		for(Animal a:animals) {
			if(a.getDietItem().equals(di)) return a;
		}
		
		return null;
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
