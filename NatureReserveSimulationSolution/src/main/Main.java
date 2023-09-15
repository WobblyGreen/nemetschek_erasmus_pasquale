package main;

import events.EventFormatter;
import log.Logger;
import simulation.Generator;
import simulation.SimulationLogic;

public class Main {

	public static void main(String[] args) {
		Generator gen = new Generator();
		Logger eventLogger = new Logger(new EventFormatter(), true);
		SimulationLogic sl = new SimulationLogic(gen, eventLogger);
		sl.simulate();

	}

}
