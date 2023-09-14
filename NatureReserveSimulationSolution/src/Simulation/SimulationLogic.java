package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.*;
import NonAnimal.Plants;
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
		this.foods=gen.generateRandomFoods();
	}
	
	public void simulate() {
		System.out.println("Starting simulation.\n");
		System.out.println("Food used in this simulation:\n"+foods);
		startAllAnimalsLifeCycle();

	}
	
	private void startAllAnimalsLifeCycle() {
		HashMap<Integer, Animal> animalLifes = new HashMap<>();
		ArrayList<Animal> diedAnimals = new ArrayList<>();
		ArrayList<EmitMessage> animalEventsToEmit = new ArrayList<>();
		
		int day=1;
		
		while(!areAllAnimalsDeath()) {
			eventListener.notify(null, new EmitMessage(Event.SUMMARY, "DAY: "+day+" | ANIMALS ALIVE: "+"/"+"\n"));
			eventListener.notify(null, new EmitMessage(Event.NEW_DAY, day+""));
			
			for(Food food:foods) {
				if(!(food instanceof Animal)) continue;
				
				Animal animal = (Animal)food;
				
				if(!animal.isAlive()) {
					if(!animalLifes.containsValue(animal)) {
						diedAnimals.add(animal);
						insertDeadAnimal(animalLifes, day, animal);
					}
					continue;
				}
				
				eventListener.notify(null, new EmitMessage(Event.ANIMAL_CYCLE_STARTED, animal.getName()+" "+animal.getCurrentEnergy()+"/"+animal.getMaxEnergy()));
				
				Food toEat = getRandomFoodFromEnvironment();
				Event eatingEvent = animal.feed(toEat);
				animalEventsToEmit.add(new EmitMessage(eatingEvent, toEat+""));
				
				if(day%3==0 && animal.isStarving()==null) {
					Event growingEvent = animal.grow();
					Event dietEvent = animal.addFoodToDiet(gen.generateRandomFood());
					
					animalEventsToEmit.add(new EmitMessage(growingEvent, animal.getSize()+""));
					animalEventsToEmit.add(new EmitMessage(dietEvent, animal.getDiet().get(animal.getDiet().size())+""));
				}
				
				eventListener.notifyAll(animal, animalEventsToEmit);
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
		for(Food veggie:foods) {
			if(veggie instanceof Plants)
				veggie.setCurrentEnergy((int)gen.getRandom(veggie.getMaxEnergy())+1);
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
	
	private boolean areAllAnimalsDeath() {
		for(Food f:foods) {
			if((f instanceof Animal) && f.isAlive()) return false;
		}
		return true;
	}
	
	private int average(Set<Integer> nums) {
		int sum = 0;
		for(int n : nums) sum+=n;
		return sum/nums.size();
		
	}
}
