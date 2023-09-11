package main;

import Simulation.Generator;
import Simulation.SimulationLogic;

public class Main {

	public static void main(String[] args) {
		Generator gen = new Generator();
		SimulationLogic sl = new SimulationLogic(gen);
		sl.simulate();

	}

}
