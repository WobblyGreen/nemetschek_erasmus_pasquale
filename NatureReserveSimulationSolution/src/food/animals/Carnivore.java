package food.animals;

import java.util.ArrayList;


import events.Event;
import food.Food;
import food.nonAnimals.Plant;

public abstract class Carnivore extends Animal {
	
	public Carnivore(String name, double size, int maxEnergy, ArrayList<String> diet, int x, int y) {
		super(name, size, maxEnergy, diet, x, y);
	}

	@Override
	public Event addFoodToDiet(Food food) {
		if(food instanceof Plant) return null;
		return super.addFoodToDiet(food);
	}
	
	public Event feed(Food food) {
		if(food instanceof Plant) {
			starve();
			return Event.CANT_EAT;
		}
		if(food==this) {
			starve();
			return Event.EAT_ITSELF;
		}
		food.die();
		return super.feed(food);
	}

}
