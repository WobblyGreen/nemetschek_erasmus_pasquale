package Animals;

import java.util.ArrayList;

import Common.Eatable;

public abstract class Carnivore extends Animal{

	public Carnivore(AnimalSpecies as, int maxEnergy, ArrayList<Eatable> diet) {
		super(as, maxEnergy, diet);
	}
	
	

}
