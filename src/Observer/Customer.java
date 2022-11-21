package Observer;
public class Customer implements Observer {

	private String name; // <-- 1.) Potentially modified later
	
	
	public Customer(String name) // <-- 2.) Potentially modified later
	{
		this.name = name;
	}
	
	public void update(int discount) 
	{
		System.out.println("Hello " + name +"! " + discount + "% discount available for you!");
	}
	
	
}
