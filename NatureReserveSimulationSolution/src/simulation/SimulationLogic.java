package simulation;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import animals.*;
import biomes.Biome;
import events.EmitMessage;
import events.Event;
import events.EventListener;
import food.Food;
import nonAnimal.Plant;

public class SimulationLogic {
	private Generator gen;
	private EventListener eventListener;
	private Biome[][] world;
	
	private int day;
	private int totalAnimals;
	private ArrayList<Animal> allAliveAnimals;
	private HashMap<Integer, Animal> animalLifes;
	private ArrayList<EmitMessage> animalEventsToEmit;
	
	public SimulationLogic(Biome[][] world, Generator gen, EventListener eventListener) {
		this.gen=gen;
		this.eventListener=eventListener;
		this.world=world;
		
		this.day=1;
		this.allAliveAnimals=getAllAliveAnimals();
		this.animalEventsToEmit=new ArrayList<>();
		this.animalLifes = new HashMap<>();
		this.totalAnimals=allAliveAnimals.size();
	}
	
	private ArrayList<Animal> getAllAliveAnimals(){
		ArrayList<Animal> animals = new ArrayList<>();
		for(Biome[] biomeRow:world) {
			for(Biome biome:biomeRow) {
				animals.addAll(biome.getCurrentLivingAnimals());
			}
		}
		
		return animals;
	}
	
	public void simulate() {
		System.out.println("Starting simulation.\n");
		printEnvironment();
		startAllAnimalsLifeCycle();

	}
	
	private void startAllAnimalsLifeCycle() {
		while(allAliveAnimals.size()>0) {
			eventListener.notify(null, new EmitMessage(Event.SUMMARY, "DAY: "+day+" | ANIMALS ALIVE: "+allAliveAnimals.size()+"/"+totalAnimals+"\n"));
			eventListener.notify(null, new EmitMessage(Event.NEW_DAY, day+""));
			for(Biome[] biomeRow:world) {
				for(Biome biome:biomeRow) {
					eventListener.notify(null, new EmitMessage(Event.BIOME, biome.getName()));
					animateAnimals(biome, biome.getCurrentLivingAnimals());
				}
			}
			regrowAllPlants();
			day++;
		}
		
		printStatistics(animalLifes);
	}
	
	
	private void regrowAllPlants() {
		for(Biome[] biomeRow:world) {
			for(Biome biome:biomeRow) {
				biome.regrowPlants();
			}
		}
	}
	
	private void animateAnimals(Biome biome, ArrayList<Animal> animals) {
		for(Animal animal:animals) {
			eventListener.notify(animal, new EmitMessage(Event.ANIMAL_CYCLE_STARTED, animal.getName()+" "+animal.getCurrentEnergy()+"/"+animal.getMaxEnergy()));
			
			if(!animal.isAlive()) {
				if(!animalLifes.containsValue(animal)) {
					allAliveAnimals.remove(animal);
					insertDeadAnimal(animalLifes, day, animal);
					eventListener.notify(animal, new EmitMessage(Event.DIE, ""));
				}
				continue;
			}
			
			Food toEat = getRandomFoodFromEnvironment(biome);
			Event eatingEvent = animal.feed(toEat);
			
			animalEventsToEmit.add(new EmitMessage(eatingEvent, toEat+""));
			
			if(day%3==0 && animal.isStarving()==null) {
				Event growingEvent = animal.grow();
				Event dietEvent = animal.addFoodToDiet(getRandomFoodFromEnvironment(biome));
				
				animalEventsToEmit.add(new EmitMessage(growingEvent, animal.getSize()+""));
				animalEventsToEmit.add(new EmitMessage(dietEvent, animal.getDiet().get(animal.getDiet().size()-1)+""));
			}
			
			eventListener.notifyAll(animal, animalEventsToEmit);
			animalEventsToEmit.clear();
		}
	}
	
	private Food getRandomFoodFromEnvironment(Biome biome) {
		return biome.getAllEatableItems().get((int)gen.getRandom(biome.getAllEatableItems().size()));
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
	
	private void printEnvironment() {
		System.out.println("Map of the world:\n");
		//printing the matrix
		String spaceFromEdgeOfTheScreen = "    ";
		System.out.print(spaceFromEdgeOfTheScreen+"  ");
		for(int i=0; i<world[0].length; i++)
			System.out.print(i+" ");
		
		System.out.println("");
		
		for(int i=0; i<world.length; i++) {
			System.out.print(spaceFromEdgeOfTheScreen+i+" ");
			for(int j=0; j<world[i].length; j++) {
				System.out.print(world[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("");
		//printing each biome
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				System.out.println("- "+world[i][j].displayEnvironment());
			}
		}
		
		System.out.println("");
		
		
	}
}
