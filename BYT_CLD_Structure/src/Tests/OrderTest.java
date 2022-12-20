package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Order;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    //TODO: Fill those test cases
    static Order order;
    //Create necessary object here but, don't initialize them here!
    @BeforeAll
    static void setUp() {
        order=new Order(LocalDate.of(2022, 10, 15), Optional.of(LocalDate.of(2022,10,30)),1,"address123", null);

        //Initialize those objects here.
    }

    @Test
    void getId() {
        int id=1;
        assertEquals(id,order.getId());
    }

    @Test
    void getDateCreated() {
        order.setDateCreated(LocalDate.of(2022, 10, 15));
        assertEquals(LocalDate.of(2022, 10, 15),order.getDateCreated());
    }

    @Test
    void setDateCreated() {
        order.setDateCreated(LocalDate.of(2022, 10, 12));
        assertEquals(LocalDate.of(2022, 10, 12),order.getDateCreated());
    }

    @Test
    void getDateFinished() {
        assertEquals(Optional.of(LocalDate.of(2022,10,30)),order.getDateFinished());
    }

    @Test
    void setDateFinished() {
        order.setDateFinished((Optional.of(LocalDate.of(2022,10,10))));
        assertEquals(Optional.of(LocalDate.of(2022,10,10)),order.getDateFinished());

    }

    @Test
    void getStatus() {
        order.setStatus(1);
        assertEquals("in progress",order.getStatus());

    }

    @Test
    void setStatus() {
        order.setStatus(2);
        assertEquals("finished",order.getStatus());
    }

    @Test
    void getDeliveryAddress() {
        assertEquals("address123",order.getDeliveryAddress());
    }

    @Test
    void setDeliveryAddress() {
        order.setDeliveryAddress("adress333");
        assertEquals("adress333",order.getDeliveryAddress());
    }

    @Test
    void getStatusType() {
        order.getStatusType(1);
        assertEquals("in progress",order.getStatusType(1));

    }
}