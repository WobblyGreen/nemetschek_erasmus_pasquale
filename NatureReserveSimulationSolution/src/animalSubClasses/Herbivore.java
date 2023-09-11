package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Interfaces.DietItem;
import Interfaces.Eatable;
import NonAnimal.VegeterianFood;
import NonAnimal.VegeterianSpecies;

public class Herbivore extends Animal {

	public Herbivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<DietItem> veggieToEat) {
		super(as, maxEnergy, size, veggieToEat);
	}

	public Herbivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}
	
	public boolean addFoodToDiet(DietItem foodName) {
		if(foodName instanceof AnimalSpecies) return false;
		return super.addFoodToDiet(foodName);
	}
	
	@Override
	public Eatable feed(Eatable toEat) {
		if(!(toEat instanceof VegeterianFood)) return null;
		return super.feed(toEat);
	}

}

