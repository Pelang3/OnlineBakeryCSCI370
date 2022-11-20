package Decorator;

import Factory.Cake;

public class CandyDecorator extends CakeDecorator {
	
	
	public CandyDecorator(Cake baseCake) {
		super(baseCake);
	}
	
	public void decorate() {
		baseCake.toppings.add("Candy");
	}
	
}