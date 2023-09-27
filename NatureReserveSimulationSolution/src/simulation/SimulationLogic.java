package simulation;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import food.animals.Animal;
import biomes.Biome;
import events.*;

import food.Food;


public class SimulationLogic {
	private Generator gen;
	private EventListener eventListener;
	private Biome[][] world;
	
	private int day;
	private int totalAnimals;
	private ArrayList<Animal> allAliveAnimals;
	private HashMap<Integer, Animal> animalLifes;
	private ArrayList<EmitMessage> animalEventsToEmit;
	private ArrayList<Animal> animalsThatAlreadyPlayed;
	
	public SimulationLogic(Biome[][] world, Generator gen, EventListener eventListener) {
		this.gen=gen;
		this.eventListener=eventListener;
		this.world=world;
		
		this.day=1;
		this.allAliveAnimals=getAllAliveAnimals();
		this.animalEventsToEmit=new ArrayList<>();
		this.animalLifes = new HashMap<>();
		this.totalAnimals=allAliveAnimals.size();
		this.animalsThatAlreadyPlayed=new ArrayList<>();
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
			eventListener.notify(null, new EmitMessage(Event.NEW_DAY, day+"BREAK\n"+"ANIMALS ALIVE: "+allAliveAnimals.size()+"/"+totalAnimals+"\n"+getMapOnConsole()));
			for(Biome[] biomeRow:world) {
				for(Biome biome:biomeRow) {
					eventListener.notify(null, new EmitMessage(Event.BIOME, biome.getName()+"\n"+biome.getCurrentLivingPlants()));
					animateAnimals(biome);
				}
			}
			regrowAllPlants();
			animalsThatAlreadyPlayed.clear();
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
	
	private void animateAnimals(Biome biome) {
		ArrayList<Animal> animals = biome.getCurrentLivingAnimals();
		
		for(int i=animals.size()-1; i>=0; i--) {
			Animal animal = animals.get(i);
			if(animalsThatAlreadyPlayed.contains(animal)) continue;
			
			eventListener.notify(animal, new EmitMessage(Event.ANIMAL_CYCLE_STARTED, animal+""));
			
			if(!animal.isAlive()) {
				if(!animalLifes.containsValue(animal)) {
					allAliveAnimals.remove(animal);
					insertDeadAnimal(animalLifes, day, animal);
					eventListener.notify(animal, new EmitMessage(Event.DIE, ""));
				}
				continue;
			}
			
			animalEventsToEmit.addAll(animal.onEachTurn(world, gen));
			
			if(day%3==0 && animal.isStarving()==null) {
				Event growingEvent = animal.grow();
				Event dietEvent = animal.addFoodToDiet(getRandomFoodFromEnvironment(biome));
				
				animalEventsToEmit.add(new EmitMessage(growingEvent, animal.getSize()+""));
				animalEventsToEmit.add(new EmitMessage(dietEvent, animal.getDiet().get(animal.getDiet().size()-1)+""));
			}
			
			eventListener.notifyAll(animal, animalEventsToEmit);
			animalEventsToEmit.clear();
		}
		
		animalsThatAlreadyPlayed.addAll(animals);
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
		System.out.println(">> Minimum lived for " + minLife +" days: "+ animalLifes.get(minLife));
		System.out.println(">> Maximum lived for " + maxLife +" days: "+ animalLifes.get(maxLife));
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
		System.out.print(getMapOnConsole());
		System.out.println("");
		//printing each biome
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				System.out.println("- "+world[i][j].displayEnvironment());
			}
		}
		System.out.println("");
	}
	
	private String getMapOnConsole() {
		String spaceFromEdgeOfTheScreen = "    ";
		String map = spaceFromEdgeOfTheScreen+"  ";
		
		for(int i=0; i<world[0].length; i++)
			map+=i+" ";
		
		map+="\n";
		
		for(int i=0; i<world.length; i++) {
			map+=spaceFromEdgeOfTheScreen+i+" ";
			for(int j=0; j<world[i].length; j++) {
				map+=world[i][j]+" ";
			}
			map+="\n";
		}
		
		return map;
	}
}