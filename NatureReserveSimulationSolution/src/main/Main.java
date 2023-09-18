package main;

import animals.AnimalFactory;
import animals.AnimalMap;
import events.EventFormatter;
import log.Logger;
import nonAnimal.PlantFactory;
import nonAnimal.PlantMap;
import simulation.Generator;
import simulation.SimulationLogic;

public class Main {

	public static void main(String[] args) {
		Logger eventLogger = new Logger(new EventFormatter(), false);
		
		AnimalFactory animalFactory=new AnimalFactory((new AnimalMap()).getAnimalHashMap());
		PlantFactory plantFactory = new PlantFactory((new PlantMap()).getPlantHashMap());
		Generator gen = new Generator(animalFactory, plantFactory);
		
		SimulationLogic sl = new SimulationLogic(gen, eventLogger);
		sl.simulate();
	}

}
