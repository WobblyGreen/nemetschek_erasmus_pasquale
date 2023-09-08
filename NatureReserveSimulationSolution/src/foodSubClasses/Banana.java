package foodSubClasses;

import Food.*;

public class Banana extends Food{
	
	public Banana() {
		super(FoodName.BANANA, 1, 1);
	}
	public Banana(int energy, double size) {
		super(FoodName.BANANA, energy, size);
	}

}
