package Observer;
public interface Subject {

	void addSubscriber(Observer o);
	
	void removeSubscriber(Observer o);
	
	void notifySubscriber(Integer discount);
	
	boolean contains(Observer o);

	int size();
}
