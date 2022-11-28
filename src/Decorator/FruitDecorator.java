package Decorator;

import Factory.Cake;

public class FruitDecorator extends CakeDecorator {
	String decorator = "Fruit";
	
	public FruitDecorator(Cake baseCake) {
		super(baseCake);
		if (!toppings.contains(decorator))
			decorate();
	}
	
	public void decorate() {
		baseCake.toppings.add(decorator);
	}
	
}
