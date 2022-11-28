package Testing;

import Factory.Donuts;
import Factory.Cookie;
import Factory.Croissants;
import Factory.SixCake;
import Factory.NineCake;
import Singleton.Cart;
import Singleton.CartManager;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Iterator.BakeryIterator;

public class BakeryIteratorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);

    }

    @Test
    public void testOne() {
        // testing the iterator methods used in Cart.java:
        // showCart();
        // removeFromCart();

        String first = "Items in your cart:\n";

        int num = 1;

        CartManager manager = CartManager.getInstance();
        Cart cart = manager.setUpCart("Nia");
        // Items for cart
        SixCake a = new SixCake();
        NineCake c = new NineCake();
        Donuts b = new Donuts();
        cart.addToCart(a);
        cart.addToCart(b);
        cart.addToCart(c);
        // Using the iterator pattern
        BakeryIterator i = cart.getCartIterator();
        first += num + ") " + a.getProductName();
        first += " $" + String.format("%.2f", a.getUnitPrice()) + "\n";
        num++;
        first += num + ") " + b.getProductName();
        first += " $" + String.format("%.2f", b.getUnitPrice()) + "\n";
        num++;
        first += num + ") " + c.getProductName();
        first += " $" + String.format("%.2f", c.getUnitPrice()) + "\n";
        first += "\r\n";
        first += "Item Count: " + num;
        first += "\r\n";
        cart.showCart(i.createBakeryIterator());
        assertEquals(first.trim().length(), outContent.toString().trim().length());
        String second = "Items in your cart:\n";
        num = 1;
        cart.removeFromCart(c, i.createBakeryIterator());
        second += num + ") " + a.getProductName();
        second += " $" + String.format("%.2f", a.getUnitPrice()) + "\n";
        num++;
        second += num + ") " + b.getProductName();
        second += " $" + String.format("%.2f", b.getUnitPrice()) + "\n";
        second += "\r\n";
        second += "Item Count: " + num;
        second += "\r\n";
        outContent.reset();
        cart.showCart(i.createBakeryIterator());
        assertEquals(second.trim().length(), outContent.toString().trim().length());

    }

    @Test
    public void testTwo() {
        // testing iterator method used in Cart.java:
        // getTotalAmount();

        CartManager mTwo = CartManager.getInstance();

        Cart second = mTwo.setUpCart("Moss");
        Croissants cr = new Croissants();
        Donuts dnts = new Donuts();
        Cookie cookieOne = new Cookie();
        Cookie cookieTwo = new Cookie();
        second.addToCart(cr);
        second.addToCart(dnts);
        second.addToCart(cookieOne);
        second.addToCart(cookieTwo);

        BakeryIterator j = second.getCartIterator();
        System.out.print(second.getTotalAmount(j.createBakeryIterator()));
        assertEquals("6.0", outContent.toString());

    }
}
