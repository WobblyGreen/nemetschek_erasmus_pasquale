package animals;

import java.util.ArrayList;

import events.Event;
import food.Food;
import nonAnimal.Plant;

public abstract class Herbivore extends Animal {
	
	public Herbivore(String name, double size, int maxEnergy, ArrayList<String> diet) {
		super(name, size, maxEnergy, diet);
	}

	public Event addFoodToDiet(Food food) {
		if(!(food instanceof Plant)) return null;
		return super.addFoodToDiet(food);
	}
	
	@Override
	public Event feed(Food food) {
		if(!(food instanceof Plant)) {
			starve();
			return Event.CANT_EAT;
		}
		return super.feed(food);
	}

}

