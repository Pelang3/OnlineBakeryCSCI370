package Decorator;

import Factory.Cake;

public class FreshCreamDecorator extends CakeDecorator {
	String decorator = "Fresh Cream";
	
	public FreshCreamDecorator(Cake baseCake) {
		super(baseCake);
		if (!toppings.contains(decorator))
			decorate();
	}
	
	public void decorate() {
		baseCake.toppings.add(decorator);
	}
	
}
