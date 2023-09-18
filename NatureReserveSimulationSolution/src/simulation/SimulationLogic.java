package simulation;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import animals.*;
import events.EmitMessage;
import events.Event;
import events.EventListener;
import food.Food;
import nonAnimal.Plant;

public class SimulationLogic {
	ArrayList<Animal> animals;
	ArrayList<Plant> plants;
	ArrayList<Food> foods;
	
	Generator gen;
	EventListener eventListener;
	
	public SimulationLogic(Generator gen, EventListener eventListener) {
		this.gen=gen;
		this.eventListener=eventListener;
		
		this.animals=gen.generateRandomAnimals();
		this.plants=gen.generateRandomPlants();
		
		this.foods=new ArrayList<>();
		foods.addAll(animals);
		foods.addAll(plants);
	}
	
	public void simulate() {
		System.out.println("Starting simulation.\n");
		System.out.println("Environment in this simulation:\n"+foods);
		startAllAnimalsLifeCycle();

	}
	
	private void startAllAnimalsLifeCycle() {
		HashMap<Integer, Animal> animalLifes = new HashMap<>();
		ArrayList<Animal> diedAnimals = new ArrayList<>();
		ArrayList<EmitMessage> animalEventsToEmit = new ArrayList<>();
		
		int day=1;
		
		while(animals.size()!=diedAnimals.size()) {
			eventListener.notify(null, new EmitMessage(Event.SUMMARY, "DAY: "+day+" | ANIMALS ALIVE: "+(animals.size()-diedAnimals.size())+"/"+animals.size()+"\n"));
			eventListener.notify(null, new EmitMessage(Event.NEW_DAY, day+""));
			
			for(Animal animal:animals) {
				eventListener.notify(animal, new EmitMessage(Event.ANIMAL_CYCLE_STARTED, animal.getName()+" "+animal.getCurrentEnergy()+"/"+animal.getMaxEnergy()));
				
				if(!animal.isAlive()) {
					if(!animalLifes.containsValue(animal)) {
						diedAnimals.add(animal);
						insertDeadAnimal(animalLifes, day, animal);
						eventListener.notify(animal, new EmitMessage(Event.DIE, ""));
					}
					continue;
				}
				
				Food toEat = getRandomFoodFromEnvironment();
				Event eatingEvent = animal.feed(toEat);
				
				animalEventsToEmit.add(new EmitMessage(eatingEvent, toEat+""));
				
				if(day%3==0 && animal.isStarving()==null) {
					Event growingEvent = animal.grow();
					Event dietEvent = animal.addFoodToDiet(getRandomFoodFromEnvironment());
					
					animalEventsToEmit.add(new EmitMessage(growingEvent, animal.getSize()+""));
					animalEventsToEmit.add(new EmitMessage(dietEvent, animal.getDiet().get(animal.getDiet().size()-1)+""));
				}
				
				eventListener.notifyAll(animal, animalEventsToEmit);
				animalEventsToEmit.clear();
			}
			
			veggieRegrow();
			day++;
		}
		
		printStatistics(animalLifes);
	}
	
	private Food getRandomFoodFromEnvironment() {
		return foods.get((int)gen.getRandom(foods.size()));
	}
	
	
	private void veggieRegrow() {
		for(Plant plant:plants) {
			plant.changeEnergy(plant.getCurrentEnergy() + (int)gen.getRandom(plant.getMaxEnergy()-plant.getCurrentEnergy())+1);
		}
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
	
	private int average(Set<Integer> nums) {
		int sum = 0;
		for(int n : nums) sum+=n;
		return sum/nums.size();
		
	}
}
