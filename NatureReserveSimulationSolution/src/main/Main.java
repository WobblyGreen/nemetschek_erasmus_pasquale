package main;

import Simulation.Generator;
import Simulation.SimulationLogic;
import events.EventFormatter;
import log.Logger;

public class Main {

	public static void main(String[] args) {
		Generator gen = new Generator();
		Logger eventLogger = new Logger(new EventFormatter(), false);
		SimulationLogic sl = new SimulationLogic(gen, eventLogger);
		sl.simulate();

	}

}
