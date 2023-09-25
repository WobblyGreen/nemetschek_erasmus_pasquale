package main;

import animalFinalClasses.*;
import biomes.BiomeFactory;
import biomes.BiomeMap;
import events.EventFormatter;
import log.Logger;
import nonAnimal.PlantFactory;
import nonAnimal.PlantMap;
import simulation.Generator;
import simulation.SimulationLogic;

public class Main {

	public static void main(String[] args) {
		Logger eventLogger = new Logger(new EventFormatter(), true);
		
		AnimalFactory animalFactory=new AnimalFactory((new AnimalMap()).getAnimalHashMap());
		PlantFactory plantFactory = new PlantFactory((new PlantMap()).getPlantHashMap());
		BiomeFactory biomeFactory = new BiomeFactory((new BiomeMap()).getBiomeHashMap());
		Generator gen = new Generator(animalFactory, plantFactory, biomeFactory);
		
		SimulationLogic sl = new SimulationLogic(gen.generateWorld(3, 3),gen, eventLogger);
		sl.simulate();
	}

}
