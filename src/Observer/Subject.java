
public interface Subject {

	void addSubscriber(Observer o);
	
	void removeSubscriber(Observer o);
	
	void notifySubscriber(int discount);
}
