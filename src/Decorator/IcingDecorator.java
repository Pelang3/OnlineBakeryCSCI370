package Decorator;

import Factory.Cake;

public class IcingDecorator extends CakeDecorator {
	
	
	public IcingDecorator(Cake baseCake) {
		super(baseCake);
	}
	
	public void decorate() {
		baseCake.toppings.add("Icing");
	}
	
}