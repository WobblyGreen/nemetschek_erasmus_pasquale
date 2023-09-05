package Animals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Food.Food;
import Food.FoodName;
import animalSubClasses.*;
import foodSubClasses.*;

class animalTest {
	@Test
	void zebraEatsAllowedFoodWhenFull() {
		ArrayList<FoodName> zebraDiet = new ArrayList<>(Arrays.asList(FoodName.BANANA));
		Zebra zebra = new Zebra(10, zebraDiet);
		
		zebra.feed(new Banana(2));
		assertEquals(zebra.maxEnergy, zebra.currentEnergy);
	}
	
	@Test
	void zebraEatsAllowedFoodWhenEmpty() {
		ArrayList<FoodName> zebraDiet = new ArrayList<>(Arrays.asList(FoodName.BANANA));
		Zebra zebra = new Zebra(10, zebraDiet);
		
		zebra.currentEnergy=1;
		zebra.feed(new Banana(2));
		assertEquals(3, zebra.currentEnergy);
	}
	
	@Test
	void zebraEatsDisallowedFoodWhenFull() {
		ArrayList<FoodName> zebraDiet = new ArrayList<>(Arrays.asList(FoodName.BANANA));
		Zebra zebra = new Zebra(10, zebraDiet);
		
		zebra.feed(new Lamb(2));
		assertEquals(8, zebra.currentEnergy);
	}
	
	@Test
	void zebraEatsDisallowedFoodWhenEmpty() {
		ArrayList<FoodName> zebraDiet = new ArrayList<>(Arrays.asList(FoodName.BANANA));
		Zebra zebra = new Zebra(10, zebraDiet);
		
		zebra.currentEnergy=1;
		zebra.feed(new Lamb(2));
		assertEquals(0, zebra.currentEnergy);
	}

}
