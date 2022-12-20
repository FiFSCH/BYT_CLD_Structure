package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Models.DeliveryOption;
import Models.Offer;
import Models.DeliveryOrder;
import Models.Order;
import Models.User;

import java.time.LocalDate;
import java.util.Optional;

class DeliveryOptionTest {
    /**
     * Tests are only for getters and setters because other methods didn't have to be implemented.
     */
    DeliveryOption deliveryOption;
    Order order;
    User user;
    User user2;
    Offer offer;

    @BeforeEach
    void setUp() {
        deliveryOption = new DeliveryOption("first delivery", 37.5);
        user = new User("login", "password", "nick", "email", 1);
        user2 = new User("login2", "password2", "nick2", "email2", 1);
        order = new Order(LocalDate.now(), Optional.empty(), 1, "Address", user);
        offer = new Offer(LocalDate.now(), Optional.empty(), "Title", 1, "Author", Optional.empty(), 1, user2);
    }

    @Test
    void getDeliveryOrder() {
        Assertions.assertNull(deliveryOption.getDeliveryOrder());
    }

    @Test
    void setDeliveryOrder() {
        DeliveryOrder deliveryOrder = new DeliveryOrder(order, deliveryOption, LocalDate.now(), Optional.empty());
        deliveryOption.setDeliveryOrder(deliveryOrder);
        Assertions.assertEquals(deliveryOrder, deliveryOption.getDeliveryOrder(), "Objects should be the same!");
        deliveryOption.setDeliveryOrder(null);
    }

    @Test
    void getOffer() {
        Assertions.assertNull(deliveryOption.getOffer());
    }

    @Test
    void setOffer() {
        deliveryOption.setOffer(offer);
        Assertions.assertEquals(offer, deliveryOption.getOffer(), "Objects should be the same!");
        deliveryOption.setOffer(null);
    }

    @Test
    void getDescription() {
        assertEquals("first delivery", deliveryOption.getDescription());
    }

    @Test
    void setDescription() {
        assertEquals("first delivery", deliveryOption.getDescription());
        deliveryOption.setDescription("discounted");
        assertEquals("discounted", deliveryOption.getDescription());
    }

    @Test
    void getPrice() {
        assertEquals(37.5, deliveryOption.getPrice());
    }

    @Test
    void setPrice() {
        assertEquals(37.5, deliveryOption.getPrice());
        deliveryOption.setPrice(20);
        assertEquals(20, deliveryOption.getPrice());
    }
}
