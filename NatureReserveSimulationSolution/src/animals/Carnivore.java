package animals;

import java.util.ArrayList;

import events.Event;
import food.Food;
import nonAnimal.Plant;

public abstract class Carnivore extends Animal {
	
	public Carnivore(String name, double size, int maxEnergy, ArrayList<String> diet) {
		super(name, size, maxEnergy, diet);
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
