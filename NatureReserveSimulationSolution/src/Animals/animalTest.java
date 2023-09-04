package Animals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Food.Food;
import animalSubClasses.*;
import foodSubClasses.*;

class animalTest {
	
	@Before
	
	@Test
	void eatAnAllowedFood() {
		Food allowedFood = new Banana(2);
		ArrayList<Food> diet = new ArrayList<>(Arrays.asList(allowedFood));
		Zebra zebra = new Zebra(10, diet);
		
		zebra.feed(allowedFood);
		assertEquals(zebra.maxEnergy, zebra.currentEnergy);
	}

}
