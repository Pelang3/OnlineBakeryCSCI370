package Decorator;

import Factory.Cake;

public class FreshCreamDecorator extends CakeDecorator {
	
	
	public FreshCreamDecorator(Cake baseCake) {
		super(baseCake);
	}
	
	public void decorate() {
		baseCake.toppings.add("Fresh Cream");
	}
	
}