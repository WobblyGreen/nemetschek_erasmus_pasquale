package foodSubClasses;

import Food.*;

public class Banana extends Food{
	
	public Banana() {
		super(FoodName.BANANA, 1);
	}
	public Banana(int energy) {
		super(FoodName.BANANA, energy);
	}

}
