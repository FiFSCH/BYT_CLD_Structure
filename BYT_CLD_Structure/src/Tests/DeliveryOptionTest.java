package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Models.DeliveryOption;

class DeliveryOptionTest {
    //TODO: Fill those test cases
    DeliveryOption deliveryOption;
    //Create necessary object here but, don't initialize them here!
    @BeforeEach
    void setUp() {
        deliveryOption=new DeliveryOption("first delivery",37.5);
        //Initialize those objects here.
    }

    @Test
    void getDescription() {
        assertEquals("first delivery",deliveryOption.getDescription());
    }

    @Test
    void setDescription() {
        assertEquals("first delivery",deliveryOption.getDescription());
        deliveryOption.setDescription("discounted");
        assertEquals("discounted",deliveryOption.getDescription());
    }

    @Test
    void getPrice() {
        assertEquals(37.5,deliveryOption.getPrice());
    }

    @Test
    void setPrice() {
        assertEquals(37.5,deliveryOption.getPrice());
        deliveryOption.setPrice(20);
        assertEquals(20,deliveryOption.getPrice());
    }
}
