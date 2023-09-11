package main;

import Simulation.Generator;
import Simulation.SimulationLogic;
import log.Logger;

public class Main {

	public static void main(String[] args) {
		Generator gen = new Generator();
		Logger eventLogger = new Logger();
		SimulationLogic sl = new SimulationLogic(gen, eventLogger);
		sl.simulate();

	}

}
