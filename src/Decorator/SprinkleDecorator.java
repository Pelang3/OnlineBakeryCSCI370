package Decorator;

import Factory.Cake;

public class SprinkleDecorator extends CakeDecorator {
	String decorator = "Sprinkles";
	
	public SprinkleDecorator(Cake baseCake) {
		super(baseCake);
		if (!toppings.contains(decorator))
			decorate();
	}
	
	public void decorate() {
		baseCake.toppings.add(decorator);
	}
	
}
