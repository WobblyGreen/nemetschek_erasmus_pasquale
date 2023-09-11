package animalSubClasses;

import java.util.ArrayList;

import Animals.*;
import Interfaces.DietItem;
import Interfaces.Eatable;
import NonAnimal.VegeterianFood;
import NonAnimal.VegeterianSpecies;

public class Carnivore extends Animal {

	public Carnivore(AnimalSpecies as, int maxEnergy, double size, ArrayList<DietItem> animalsToEat) {
		super(as, maxEnergy, size, animalsToEat);
	}
	
	public Carnivore(AnimalSpecies as, int maxEnergy) {
		super(as, maxEnergy, 1, null);
	}
	
	@Override
	public boolean addFoodToDiet(DietItem foodName) {
		if(foodName instanceof VegeterianSpecies) return false;
		return super.addFoodToDiet(foodName);
	}
	
	public Eatable feed(Eatable toEat) {
		if(toEat instanceof VegeterianFood) return null;
		if(toEat==this) return null;
		
		return super.feed(toEat);
	}

}
