
package Testing;
import Strategy.DeliveryManager;
import Strategy.UPSMailStrategy;
import Strategy.DoorDashStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StrategyTest {
    DeliveryManager dm;
    String cart;
    String address; 

    @BeforeEach
    void setUp(){
        dm = new DeliveryManager();
        cart = "Cookie $2.00\nCroissant $2.00\n";
        address = "50 Main Street, 22124, NY, USA";
    }

    @Test
    @DisplayName("UPSMailStrategy execution should execute correctly")
    void testUPSMailStrategy(){
        dm.setDeliveryMethod(new UPSMailStrategy());
        assertEquals(dm.deliver(cart, address) , ("UPS delivered: " + cart + "\nto "+address));
    }

    @Test
    @DisplayName("DoorSashStrategy execution should execute correctly")
    void testDoorDashStrategy(){
        dm.setDeliveryMethod(new DoorDashStrategy());
        assertEquals(dm.deliver(cart, address) , ("Doordasher delivered: " + cart + "\nto "+address));
    }

}
