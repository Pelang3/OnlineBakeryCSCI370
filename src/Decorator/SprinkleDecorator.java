package Decorator;

import Factory.Cake;

public class SprinkleDecorator extends CakeDecorator {
	
	
	public SprinkleDecorator(Cake baseCake) {
		super(baseCake);
	}
	
	public void decorate() {
		baseCake.toppings.add("Sprinkles");
	}
	
}