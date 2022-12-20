package Tests;

import Models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    /**
     * Tests are only for getters and setters because other methods didn't have to be implemented.
     */
    static Order order;

    @BeforeAll
    static void setUp() {
        order = new Order(LocalDate.of(2022, 10, 15), Optional.of(LocalDate.of(2022, 10, 30)), 1, "address123", null);
    }

    @Test
    public void getPerson() {
        Assertions.assertNull(order.getPerson());
    }

    @Test
    public void setPerson() {
        Person p = new User("login", "password", "nick", "email", 1);
        order.setPerson(p);
        Assertions.assertEquals(p, order.getPerson());
        order.setPerson(null);
    }

    @Test
    public void getOffer() {
        Assertions.assertNull(order.getOffer());
    }

    @Test
    public void setOffer() {
        Offer offer = new Offer(LocalDate.now(), Optional.empty(), "title", 1, "author", Optional.empty(), 1, null);
        order.setOffer(offer);
        Assertions.assertEquals(offer, order.getOffer());
        order.setOffer(null);
    }

    @Test
    public void getDeliveryOrder() {
        Assertions.assertNull(order.getDeliveryOrder());
    }

    @Test
    public void setDeliveryOrder() {
        DeliveryOption deliveryOption = new DeliveryOption("Desc", 21.37);
        DeliveryOrder deliveryOrder = new DeliveryOrder(order, deliveryOption, LocalDate.now(), Optional.empty());
        order.setDeliveryOrder(deliveryOrder);
        Assertions.assertEquals(deliveryOrder, order.getDeliveryOrder());
        order.setPerson(null);
    }

    @Test
    void getId() {
        int id = 1;
        assertEquals(id, order.getId());
    }

    @Test
    void getDateCreated() {
        order.setDateCreated(LocalDate.of(2022, 10, 15));
        assertEquals(LocalDate.of(2022, 10, 15), order.getDateCreated());
    }

    @Test
    void setDateCreated() {
        order.setDateCreated(LocalDate.of(2022, 10, 12));
        assertEquals(LocalDate.of(2022, 10, 12), order.getDateCreated());
    }

    @Test
    void getDateFinished() {
        assertEquals(Optional.of(LocalDate.of(2022, 10, 30)), order.getDateFinished());
    }

    @Test
    void setDateFinished() {
        order.setDateFinished((Optional.of(LocalDate.of(2022, 10, 10))));
        assertEquals(Optional.of(LocalDate.of(2022, 10, 10)), order.getDateFinished());

    }

    @Test
    void getStatus() {
        order.setStatus(1);
        assertEquals("in progress", order.getStatus());

    }

    @Test
    void setStatus() {
        order.setStatus(2);
        assertEquals("finished", order.getStatus());
    }

    @Test
    void getDeliveryAddress() {
        assertEquals("address123", order.getDeliveryAddress());
    }

    @Test
    void setDeliveryAddress() {
        order.setDeliveryAddress("adress333");
        assertEquals("adress333", order.getDeliveryAddress());
    }

    @Test
    void getStatusType() {
        order.getStatusType(1);
        assertEquals("in progress", order.getStatusType(1));

    }
}