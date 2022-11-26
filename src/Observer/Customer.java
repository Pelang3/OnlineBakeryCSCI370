package Observer;
public class Customer implements Observer {

	private String name; 
	
	
	public Customer(String name) 
	{
		this.name = name;
	}
	
	public void update(int discount) 
	{
		System.out.println("Congrats " + name +"! " + discount + "% discount available for you!");
	}
	
	
}
