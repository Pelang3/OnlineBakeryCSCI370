
package Testing;
import Factory.BakeryFactory;
import Factory.Donuts;
import Factory.IItem;
import Factory.SixCake;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BakeryFactoryTest {
    BakeryFactory BFtest;

    @BeforeEach
    void setUp(){
        BFtest = new BakeryFactory();
    }

    @Test
    @DisplayName("Get item should work")
    void testGetItem(){
        assertEquals(BFtest.getItem("6inCake") , BFtest.getItem("6inCake"), "Should have worked bozo");
    }

    @Test
    @DisplayName("ObjectName should be correct")
    void testGetProductName(){
        assertEquals(BFtest.getItem("Donuts").getProductName(), "Donuts");
    }


}
