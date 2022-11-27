package Observer;
public interface Subject {

	void addSubscriber(Observer o);
	
	void removeSubscriber(Observer o);
	
	void notifySubscriber(int discount);
	
	boolean contains(Observer o);

	int size();
}
