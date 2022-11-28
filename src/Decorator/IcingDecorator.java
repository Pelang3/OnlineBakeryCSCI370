package Decorator;

import Factory.Cake;

public class IcingDecorator extends CakeDecorator {
	String decorator = "Icing";
	
	public IcingDecorator(Cake baseCake) {
		super(baseCake);
		if (!toppings.contains(decorator))
			decorate();
	}
	
	public void decorate() {
		baseCake.toppings.add(decorator);
	}
	
}
