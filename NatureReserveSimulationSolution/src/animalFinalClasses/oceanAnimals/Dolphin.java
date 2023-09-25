package animalFinalClasses.oceanAnimals;

import java.util.ArrayList;
import java.util.Arrays;

import animals.Carnivore;

public class Dolphin extends Carnivore {

	public Dolphin(String name, double size, int maxEnergy, ArrayList<String> diet, int x, int y) {
		super("dolphin", 1, 10, null, x, y);
		this.diet=new ArrayList<String>(Arrays.asList("fish", "shrimp", "jellyfish"));
	}
}
