package Testing;

import Singleton.CartManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {

    @Test
    @DisplayName("Checking singleton object's equality")
    public void testSingleton() {

        CartManager instance1 = CartManager.getInstance();
        CartManager instance2 = CartManager.getInstance();
        assertEquals(true, instance1.equals(instance2));
    }

    @Test
    @DisplayName("Checking cartID when new cart gets created")
    public void testCartAdd() {

        CartManager cm = CartManager.getInstance();
        cm.addNewCart("Jay");
        assertEquals(1, cm.getIdIncrememter());
    }
}