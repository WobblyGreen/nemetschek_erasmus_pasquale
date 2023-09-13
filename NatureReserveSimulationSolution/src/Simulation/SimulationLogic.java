package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.*;
import Interfaces.*;
import NonAnimal.Plants;
import NonAnimal.VegeterianSpecies;
import events.EmitMessage;
import events.Event;
import events.EventListener;
import food.Food;
import food.FoodName;

public class SimulationLogic {
	ArrayList<Food> foods;
	Generator gen;
	EventListener eventListener;
	
	public SimulationLogic(Generator gen, EventListener eventListener) {
		this.gen=gen;
		this.eventListener=eventListener;
	}
	
	public void simulate() {
		System.out.println("Starting simulation.\n");

	}
	
	private void feedOneAnimal() {
		
	}
	
	private void startAllAnimalsLifeCycle() {
		HashMap<Integer, Animal> animalLifes = new HashMap<>();
		ArrayList<Animal> diedAnimals = new ArrayList<>();
		
		int day=0;
		
		while(!areAllAnimalsDeath()) {
			eventListener.notify(Event.SUMMARY, new EmitMessage(null, "DAY: "+day+" | ANIMALS ALIVE: "+(animals.size()-diedAnimals.size())+"/"+animals.size()+"\n"));
			eventListener.notify(Event.NEW_DAY, new EmitMessage(null, day+""));
			
			for(Animal animal:animals) {
				EmitMessage messageToEmit = new EmitMessage(animal);
				
				if(!animal.isAlive()) {
					if(!animalLifes.containsValue(animal)) {
						diedAnimals.add(animal);
						insertDeadAnimal(animalLifes, day, animal);
					}
					continue;
				}
				messageToEmit.setMessage(animal.getName()+" "+animal.getEnergy()+"/"+animal.getMaxEnergy());
				eventListener.notify(Event.ANIMAL_CYCLE_STARTED, messageToEmit);
				
				Eatable eatable=getEatableReference(gen.generateRandomDietItem());
				
				hasAnimalEaten(animal, animal.feed(eatable), messageToEmit);
				
				isAnimalGrowing(animal, day, messageToEmit);
				
				isAnimalExpandingDiet(animal, messageToEmit);
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
		for(Plants veggie:veggies)
			veggie.setEnergy((int)gen.getRandom(veggie.getMaxEnergy())+1);
	}
	
	private void insertDeadAnimal(HashMap<Integer, Animal> animalLifes, int day, Animal animal) {
		animalLifes.put(day, animal);
	}
	
	private void printStatistics(HashMap<Integer, Animal> animalLifes) {
		int minLife = Collections.min(animalLifes.keySet());
		int maxLife = Collections.max(animalLifes.keySet());
		
		System.out.println("\nStatistic>>");
		System.out.println(">> Minimum lived for " + minLife +" days\n"+ animalLifes.get(minLife));
		System.out.println(">> Maximum lived for " + maxLife +" days\n"+ animalLifes.get(maxLife));
		System.out.println(">> Average living of " + average(animalLifes.keySet()) +" days");
	}
	
	private boolean isAnimalExpandingDiet(Animal animal, EmitMessage emitMessage) {
		int dietLen = animal.getDiet().size();
		animal.addFoodToDiet(gen.generateRandomDietItem());
		
		if(dietLen==animal.getDiet().size()) return false;
		
		emitMessage.setMessage(""+animal.getDiet().get(dietLen));
		eventListener.notify(Event.ANIMAL_EXPANDING_DIET, emitMessage);
		return true;
	}
	
	private boolean isAnimalGrowing(Animal animal, int lifeByFar, EmitMessage emitMessage) {
		if(lifeByFar%3!=0 || animal.isStarving()) {
			return false;
		}
		
		animal.grow();
		
		emitMessage.setMessage((animal.getSize()+" ").substring(0, 4));
		eventListener.notify(Event.ANIMAL_GROW, emitMessage);
		
		return true;
	}
	
	private boolean hasAnimalEaten(Animal animal, Eatable eatableAnimalAte, EmitMessage emitMessage) {
		if(eatableAnimalAte!=null) {
			emitMessage.setMessage(""+eatableAnimalAte.getName()+" "+eatableAnimalAte.getEnergy()+"/"+eatableAnimalAte.getMaxEnergy());
			eventListener.notify(Event.ANIMAL_EAT, emitMessage);
			return true;
		}
		
		animal.starve();
		
		emitMessage.setMessage("");
		eventListener.notify(Event.ANIMAL_STARVE, emitMessage);
		
		return false;
	}
	
	private Eatable getEatableReference(DietItem dietItem) {
		Eatable eatable = null;
		if(dietItem instanceof AnimalSpecies)
			eatable=getAnimalReference(dietItem);
		
		else if(dietItem instanceof VegeterianSpecies)
			eatable=getVeggieReference(dietItem);
		
		return eatable;
	}
	
	private Plants getVeggieReference(DietItem dietItem) {
		for(Plants veggie:veggies) {
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
