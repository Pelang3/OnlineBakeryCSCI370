package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Factory.NineCake;
import Factory.SixCake;
import Decorator.CakeDecorator;
import Decorator.CandyDecorator;
import Decorator.FruitDecorator;
import Decorator.SprinkleDecorator;
import Decorator.FreshCreamDecorator;




class cakeDecoTest {

	//to see if candy and fruit decorators work, if that works, they all work.
	@Test
	public void testAddDecotoToppingList() 
	{
		NineCake test = new NineCake();
		CandyDecorator testDeco = new CandyDecorator(test);
		FruitDecorator testDeco1 =  new FruitDecorator(test);
		
		String decorator = testDeco.getToppingList();
		String decorator2 = testDeco1.getToppingList();
		assertTrue(decorator.contains("Candy"));
		assertTrue(decorator2.contains("Fruit")); 
		
		//alright this test works.
		//just a check to see if it really works right.
		System.out.println("Test 1: " + test.getToppingList()+ " :LIT IT WORKED");
		
		
	}
	//tried to tie in CakeDecorator base class with this. 
	@Test
	public void testCakeDecorator() 
	{
		SixCake testCake = new SixCake();
		CakeDecorator testBaseCake = new CakeDecorator(testCake);
		
		SprinkleDecorator testSpr = new SprinkleDecorator(testCake);
		FreshCreamDecorator testFC =  new FreshCreamDecorator(testCake);
		
		String cake = testSpr.getToppingList();
		String cakey = testFC.getToppingList();
		
		assertTrue(cake.contains("Sprinkles"));
		assertTrue(cakey.contains("Fresh Cream")); 
		
		System.out.println("Test 2: " + testBaseCake.getSize()+ ", "
		+ testBaseCake.getToppingList() + "," + testBaseCake.getPrice() +" :LIT IT WORKED");
		
		//it works!!
	}
	
}
