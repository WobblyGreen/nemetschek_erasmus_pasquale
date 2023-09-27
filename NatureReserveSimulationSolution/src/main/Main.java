package main;

import food.animals.AnimalFactory;


import food.animals.animalFinalClasses.AnimalMap;

import food.nonAnimals.nonAnimalFinalClasses.PlantMap;
import food.nonAnimals.PlantFactory;

import java.util.Scanner;

import biomes.BiomeFactory;
import biomes.biomeFinalClasses.BiomeMap;

import events.EventFormatter;
import log.Logger;

import simulation.Generator;
import simulation.SimulationLogic;

public class Main {
	static Logger eventLogger = new Logger(new EventFormatter(), false);

	static AnimalFactory animalFactory=new AnimalFactory((new AnimalMap()).getAnimalHashMap());
	static PlantFactory plantFactory = new PlantFactory((new PlantMap()).getPlantHashMap());
	static BiomeFactory biomeFactory = new BiomeFactory((new BiomeMap()).getBiomeHashMap());
	static Generator gen = new Generator(animalFactory, plantFactory, biomeFactory);
	
	public static void main(String[] args) {
		System.out.println("Welcome to Nature Reserve Simulation.");
		System.out.println("\nCREATE THE MAP");
		
		Scanner sc = new Scanner(System.in);
		
		int numOfRows = 3;
		int numOfCols = 3;
		boolean summerized = false;
		
		do {
			System.out.print("Number of rows: ");
			numOfRows=sc.nextInt();
			System.out.print("Number of coloumns: ");
			numOfCols=sc.nextInt();
			
			System.out.print("Do you want summerized version?(Y/N) ");
			String summ = sc.next();
			summ=summ.toLowerCase();
			if(!summ.equals("y")||!summ.equals("n")) continue;
			
		} while(numOfRows<=0 && numOfCols<=0);
		sc.close();
		
		eventLogger.setSummary(summerized);
		SimulationLogic sl = new SimulationLogic(gen.generateWorld(numOfRows, numOfCols),gen, eventLogger);
		sl.simulate();
		
		System.out.println("\nBy Pascal.");
	}

}
