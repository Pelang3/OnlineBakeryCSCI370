package Factory;
import java.util.ArrayList;

public class Cake implements IItem {
	protected int Price;
	protected int Size;
	public ArrayList<String> toppings = new ArrayList<>();
	
	public Cake(int size){
		this.Size = size;
	}

	public Cake(int size, int price) {
		this.Price = price;
		this.Size = size;
	}

	public Cake(int size, int price, ArrayList<String> toppings) {
		this.Price = price;
		this.Size = size;
		this.toppings = toppings;
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

	public String getToppingList() {
		String toppingList = "";
		for(int i=0; i<toppings.size(); i++) {
			toppingList += toppings.get(i) + " ";
		}

		return toppingList;
	}

}
