package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Models.DeliveryOption;
import Models.Order;
import Models.DeliveryOrder;

import java.time.LocalDate;
import java.util.Optional;

class DeliveryOrderTest {
    static DeliveryOrder order;
    static Order order1;
    static DeliveryOption Do;

    /**
     * Tests are only for getters and setters because other methods didn't have to be implemented.
     */
    @BeforeAll
    static void setUp() {
        Do = new DeliveryOption("first delivery", 37.5);
        order1 = new Order(LocalDate.of(2022, 10, 15), Optional.of(LocalDate.of(2022, 10, 30)), 1, "address123", null);
        order = new DeliveryOrder(order1, Do, LocalDate.of(2022, 11, 15), Optional.of(LocalDate.of(2022, 11, 30)));
    }

    @Test
    void getId() {
        int id = 1;
        assertEquals(id, order.getId());
    }

    @Test
    void getOrder() {
        assertEquals(order1, order.getOrder());
    }

    @Test
    void getDeliveryOption() {
        assertEquals(Do, order.getDeliveryOption());
    }

    @Test
    void getStartDate() {
        assertEquals(LocalDate.of(2022, 11, 15), order.getStartDate());
    }

    @Test
    void setStartDate() {
        order.setStartDate(LocalDate.of(2022, 12, 5));
        assertEquals(LocalDate.of(2022, 12, 5), order.getStartDate());
    }

    @Test
    void getEndDate() {
        assertEquals(Optional.of(LocalDate.of(2022, 11, 30)), order.getEndDate());
    }

    @Test
    void setEndDate() {
        order.setEndDate(Optional.of(LocalDate.of(2022, 11, 20)));
        assertEquals(Optional.of(LocalDate.of(2022, 11, 20)), order.getEndDate());
    }
}