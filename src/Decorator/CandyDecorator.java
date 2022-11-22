package Decorator;

import Factory.Cake;

public class CandyDecorator extends CakeDecorator {
	String decorator = "Candy";
	
	public CandyDecorator(Cake baseCake) {
		super(baseCake);
		if (!toppings.contains(decorator))
			decorate();
	}
	
	public void decorate() {
		baseCake.toppings.add(decorator);
	}
	
}
