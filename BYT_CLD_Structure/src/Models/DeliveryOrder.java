package Models;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This is a junction table for association attribute between Order and DeliveryOption
 */
public class DeliveryOrder {
    public static Map<Integer, DeliveryOrder> allDeliveryOrders = new HashMap<>();
    private static int idCounter = 0; //we will use this as unique ID, but it might get changed later (tmp solution)
    /**
     * References to the associations objects
     */
    private final Order order;
    private final DeliveryOption deliveryOption;
    private final int id;
    private LocalDate startDate;
    //Optional attributes can also be created by using overloaded constructors with or without this field
    private Optional<LocalDate> endDate; //Might get changed;

    public DeliveryOrder(Order order, DeliveryOption deliveryOption, LocalDate startDate, Optional<LocalDate> endDate) {
        this.id = setId();
        this.order = order;
        this.deliveryOption = deliveryOption;
        this.startDate = startDate;
        this.endDate = endDate;
        allDeliveryOrders.put(this.id,this);
    }

    public int getId() {
        return id;
    }

    /**
     * Done in order not to manually check the uniqueness of the id
     *
     * @return current value of the counter
     */
    private int setId() {
        ++idCounter;
        return idCounter;
    }

    public Order getOrder() {
        return order;
    }

    public DeliveryOption getDeliveryOption() {
        return deliveryOption;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Optional<LocalDate> getEndDate() {
        return endDate;
    }

    public void setEndDate(Optional<LocalDate> endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "order=" + order +
                ", deliveryOption=" + deliveryOption +
                ", id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
