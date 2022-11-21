package Factory;
import java.util.ArrayList;

public class Cake implements IItem {
	protected int Price = 0;
	protected int Size = 0;
	public ArrayList<String> toppings = new ArrayList<>();
	
	public Cake() {
	}
	
	@Override
	public int getPrice() {
		return Price;
	}
	
	public int getSize() {
		return Size;
	}

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return getSize()+"in. Cake";
	}

	@Override
	public double getUnitPrice() {
		// TODO Auto-generated method stub
		return Price;
	}


}
