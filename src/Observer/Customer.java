package Observer;
public class Customer implements Observer {

	private String name; 
	
	
	public Customer(String name) 
	{
		this.name = name;
	}
	
	public void update(Integer discount) 
	{
		System.out.println("Congrats " + name +"! " + discount + "% discount available for you!");
	}
	
	
}
