package Observer;
import static org.junit.jupiter.api.Assertions.*;

public class ObservableTest {
    private StoreObservable onlineBakery = new StoreObservable();
    @org.junit.jupiter.api.Test
    void observableDiscount()
    {
        onlineBakery.setDiscount(10);
        onlineBakery.setDiscount(20);
        assertTrue(onlineBakery.getDiscount() != 10);
    }

    @org.junit.jupiter.api.Test
    void observableAccurateSub()
    {
        Customer c1 = new Customer("Pedro");
        Customer c2 = new Customer("Ben");
        Customer c3 = new Customer("Will");
        
        onlineBakery.addSubscriber(c1);
        onlineBakery.addSubscriber(c2);
        onlineBakery.addSubscriber(c3);

        onlineBakery.removeSubscriber(c1);

        assertFalse(onlineBakery.contains(c1));
    }
}
/*
 * Component Test: 
 * 5 users subscribe to the online bakery newsletter to receive
 * discounts.
 * The size of the subscriber count should be 5.
 * When the online bakery sets the discount to (for example) 15%
 * that day, a user who subcribes to the newsletter and gets
 * lucky, a message will display informing the user they have
 * received an exclusive 15% discount.
 */
