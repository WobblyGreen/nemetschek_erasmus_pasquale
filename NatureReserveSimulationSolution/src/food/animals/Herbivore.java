package food.animals;

import java.util.ArrayList;


import events.Event;
import food.Food;
import food.nonAnimals.Plant;

public abstract class Herbivore extends Animal {
	
	public Herbivore(String name, double size, int maxEnergy, ArrayList<String> diet, int x, int y) {
		super(name, size, maxEnergy, diet, x, y);
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

