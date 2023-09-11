package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.*;
import Interfaces.*;
import NonAnimal.VegeterianFood;
import NonAnimal.VegeterianSpecies;

public class SimulationLogic {
	ArrayList<Animal> animals;
	ArrayList<VegeterianFood> veggies;
	Generator gen;
	
	public SimulationLogic(Generator gen) {
		this.gen=gen;
		this.animals=gen.generateRandomAnimalArrayList();
		this.veggies=gen.generateRandomVeggieArrayList();
	}
	
	public void simulate() {
		System.out.println("Starting simulation.\n");
		System.out.println("-Available animals:\n"+animals);
		System.out.println("-Available veggies:\n"+veggies);
		startAllAnimalsLifeCycle();
	}
	
	private void startAllAnimalsLifeCycle() {
		HashMap<Integer, Animal> animalLifes = new HashMap<>();
		ArrayList<Animal> diedAnimals = new ArrayList<>();
		
		int day=0;
		
		while(!areAllAnimalsDeath()) {
			System.out.print("\n---------- Day "+day+" ----------");
			
			for(Animal animal:animals) {
				if(!animal.isAlive()) {
					if(!animalLifes.containsValue(animal)) {
						diedAnimals.add(animal);
						insertDeadAnimal(animalLifes, day, animal);
					}
					continue;
				}
				System.out.println("\n>>"+animal.getName()+" "+animal.getEnergy()+"/"+animal.getMaxEnergy());
				
				Eatable eatable=getEatableReference(gen.generateRandomDietItem());
				
				hasAnimalEaten(animal, animal.feed(eatable));
				isAnimalGrowing(animal, day);
				isAnimalExpandingDiet(animal);
			}
			
			veggieRegrow();
			day++;
		}
		insertDeadAnimal(animalLifes, day, getLastDeadAnimal(diedAnimals));
		printStatistics(animalLifes);
	}
	
	private Animal getLastDeadAnimal(ArrayList<Animal> diedAnimals) {
		for(Animal animal : animals) {
			if(!diedAnimals.contains(animal)) return animal;
		}
		
		return null;
	}
	
	private void veggieRegrow() {
		for(VegeterianFood veggie:veggies)
			veggie.setEnergy((int)gen.getRandom(veggie.getMaxEnergy())+1);
	}
	
	private void insertDeadAnimal(HashMap<Integer, Animal> animalLifes, int day, Animal animal) {
		animalLifes.put(day, animal);
		System.out.println("\n<< "+animal.getName()+" died >>");
	}
	
	private void printStatistics(HashMap<Integer, Animal> animalLifes) {
		int minLife = Collections.min(animalLifes.keySet());
		int maxLife = Collections.max(animalLifes.keySet());
		
		System.out.println("\nStatistic>>");
		System.out.println(">> Minimum lived for " + minLife +" days\n"+ animalLifes.get(minLife));
		System.out.println(">> Maximum lived for " + maxLife +" days\n"+ animalLifes.get(maxLife));
		System.out.println(">> Average living of " + average(animalLifes.keySet()) +" days");
	}
	
	private void removeDeadAnimals(ArrayList<Animal> deadAnimals) {
		for(Animal animal:deadAnimals) {
			if(animal.getEnergy()<=0) animals.remove(animal);
		}
	}
	
	private boolean isAnimalExpandingDiet(Animal animal) {
		int dietLen = animal.getDiet().size();
		animal.addFoodToDiet(gen.generateRandomDietItem());
		
		if(dietLen==animal.getDiet().size()) return false;
		
		System.out.println("_added "+animal.getDiet().get(animal.getDiet().size()-1)+" to diet");
		return true;
	}
	
	private boolean isAnimalGrowing(Animal animal, int lifeByFar) {
		if(lifeByFar%3!=0 || animal.isStarving()) return false;
		
		animal.grow();
		System.out.println("_grows up to "+animal.getSize());
		return true;
		
	}
	
	private boolean hasAnimalEaten(Animal animal, Eatable eatableAnimalAte) {
		if(eatableAnimalAte==null) {
			animal.starve();
			System.out.println("_starving");
			return false;
		}
		else
			System.out.println("_eats "+eatableAnimalAte.getName());
		
		return true;
	}
	
	private Eatable getEatableReference(DietItem dietItem) {
		Eatable eatable = null;
		if(dietItem instanceof AnimalSpecies)
			eatable=getAnimalReference(dietItem);
		
		else if(dietItem instanceof VegeterianSpecies)
			eatable=getVeggieReference(dietItem);
		
		return eatable;
	}
	
	private VegeterianFood getVeggieReference(DietItem dietItem) {
		for(VegeterianFood veggie:veggies) {
			if(veggie.getDietItem().equals(dietItem)) return veggie;
		}
		
		return null;
	}
	
	private Animal getAnimalReference(DietItem di) {
		for(Animal a:animals) {
			if(a.getDietItem().equals(di)) return a;
		}
		
		return null;
	}
	
	private boolean areAllAnimalsDeath() {
		for(Animal animal:animals) {
			if(animal.isAlive()) return false;
		}
		return true;
	}
	
	private int average(Set<Integer> nums) {
		int sum = 0;
		for(int n : nums) sum+=n;
		return sum/nums.size();
		
	}
}
