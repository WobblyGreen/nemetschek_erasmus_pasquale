package animals;

import java.util.ArrayList;

import events.Event;
import food.Food;
import food.FoodName;
import nonAnimal.Plants;

public abstract class Carnivore extends Animal {
	
	public Carnivore(FoodName name, double size, int maxEnergy, ArrayList<FoodName> diet) {
		super(name, size, maxEnergy, diet);
	}

	@Override
	public Event addFoodToDiet(Food food) {
		if(food instanceof Plants) return null;
		return super.addFoodToDiet(food);
	}
	
	public Event feed(Food food) {
		if(food instanceof Plants) {
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
