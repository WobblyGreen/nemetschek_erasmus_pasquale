package Animals;

import java.util.ArrayList;

import Interfaces.DietItem;
import Interfaces.Eatable;
import NonAnimal.Plants;
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
		if(!(toEat instanceof Plants)) return null;
		return super.feed(toEat);
	}

}

