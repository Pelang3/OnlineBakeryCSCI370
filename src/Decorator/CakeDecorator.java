package Decorator;

import Factory.Cake;

public class CakeDecorator extends Cake {
	protected Cake baseCake;

	public CakeDecorator(int size) {
		super(size);
	}
	
	public CakeDecorator(Cake baseCake) {
		super(baseCake.getSize());
		this.baseCake = baseCake;
	}
	
}
