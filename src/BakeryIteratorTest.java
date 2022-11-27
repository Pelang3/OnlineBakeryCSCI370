import Factory.Donuts;
import Factory.Cookie;
import Factory.Croissants;
import Factory.SixCake;
import Factory.NineCake;
import org.junit.Test;

public class BakeryIteratorTest {

    @Test
    public static void main(String[] args) {
        // testing all the iterator methods used in Cart.java
        // showCart();
        // removeFromCart();
        // getTotalAmount();
        // printInvoice();

        // Setting up fake carts for testing purposes
        Cart cart = new Cart(1, "Nia");
        // Items for cart
        SixCake a = new SixCake();
        NineCake c = new NineCake();
        Donuts b = new Donuts();
        cart.addToCart(a);
        cart.addToCart(b);
        cart.addToCart(c);

        Cart second = new Cart(2, "Moss");
        Croissants cr = new Croissants();
        Donuts dnts = new Donuts();
        Cookie cookieOne = new Cookie();
        Cookie cookieTwo = new Cookie();
        second.addToCart(cr);
        second.addToCart(dnts);
        second.addToCart(cookieOne);
        second.addToCart(cookieTwo);

        // Using the iterator pattern
        BakeryIterator i = cart.getCartIterator();
        cart.showCart(i.createBakeryIterator());
        cart.removeFromCart(c, i.createBakeryIterator());
        cart.showCart(i.createBakeryIterator());
        cart.printInvoice(i.createBakeryIterator());

        second.showCart(i.createBakeryIterator());
        second.removeFromCart(cookieTwo, i.createBakeryIterator());
        second.showCart(i.createBakeryIterator());
        second.removeFromCart(dnts, i.createBakeryIterator());
        second.showCart(i.createBakeryIterator());
        second.removeFromCart(cookieTwo, i.createBakeryIterator());
        second.showCart(i.createBakeryIterator());
        second.printInvoice(i.createBakeryIterator());
    }
}
