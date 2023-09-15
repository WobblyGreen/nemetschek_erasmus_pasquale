package animals;

import java.util.ArrayList;

import events.Event;
import food.Food;
import food.FoodName;
import nonAnimal.Plants;

public abstract class Herbivore extends Animal {
	
	public Herbivore(FoodName name, double size, int maxEnergy, ArrayList<FoodName> diet) {
		super(name, size, maxEnergy, diet);
	}

	public Event addFoodToDiet(Food food) {
		if(!(food instanceof Plants)) return null;
		return super.addFoodToDiet(food);
	}
	
	@Override
	public Event feed(Food food) {
		if(!(food instanceof Plants)) {
			starve();
			return Event.CANT_EAT;
		}
		return super.feed(food);
	}

}

