package Factory;
import java.util.ArrayList;

public class Cake implements IItem {
	private int Price = 2;
	private int Size = 2;
	public ArrayList<String> toppings;
	
	public Cake(int size) {
		toppings = new ArrayList<>();
		
		if(size == 6){
			Price = 20;
		}
		
		if(size == 9) {
			Price = 25;
		}
	}
	
	@Override
	public int getPrice() {
		return Price;
	}
	
	public int getSize() {
		return Size;
	}
}
