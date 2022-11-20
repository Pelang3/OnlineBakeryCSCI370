package Decorator;

import Factory.Cake;

public class FruitDecorator extends CakeDecorator {
	
	
	public FruitDecorator(Cake baseCake) {
		super(baseCake);
	}
	
	public void decorate() {
		baseCake.toppings.add("Candy");
	}
	
}