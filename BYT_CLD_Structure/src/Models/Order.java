package Models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides
public class Order {
    /**
     * Done in such a way because there are only a few available values of the status
     */
    public static Map<Integer, Order> allOrders = new HashMap<>();
    private static final String[] possibleOrderStatuses = {"cancelled", "in progress", "finished"};
    private static int idCounter = 0; //we will use this as unique ID, but it might get changed later (tmp solution)
    private final int id;
    private LocalDate dateCreated;
    //Optional attributes can also be created by using overloaded constructors with or without this field
    private Optional<LocalDate> dateFinished; //Might get changed;
    private String status;
    private String deliveryAddress; //String instead of some geoLocation for simplicity

    //ASSOCIATIONS
    //Order - person
    private Person person; //the person who ordered this order
    //Order - offer
    private Offer offer; // in MAS lectures it is mentioned the aggregation looks the same as classic association in code
    //Order - DeliveryOrder
    private DeliveryOrder deliveryOrder;

    //getters and setters for associations
    public DeliveryOrder getDeliveryOrder() {
        return deliveryOrder;
    }
    public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }
    public Offer getOffer() {
        return offer;
    }
    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Order(LocalDate dateCreated, Optional<LocalDate> dateFinished, int statusIndex, String deliveryAddress, Person receiver) {
        this.id = setId();
        this.dateCreated = dateCreated;
        this.dateFinished = dateFinished;
        this.deliveryAddress = deliveryAddress;
        try {
            this.status = getStatusType(statusIndex);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        allOrders.put(this.id,this);
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Optional<LocalDate> getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Optional<LocalDate> dateFinished) {
        this.dateFinished = dateFinished;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(int index) {
        this.status = getStatusType(index);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * We can omit this method and simply directly access the value from the array
     * But I thought that adding some validation would be nice
     */
    public String getStatusType(int index) throws IndexOutOfBoundsException {
        if (index < possibleOrderStatuses.length)
            return possibleOrderStatuses[index];
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", dateFinished=" + dateFinished +
                ", status='" + status + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }

    /**
     * Method implementation
     */

    //Slightly redundant, but 3 lines of code doesn't make any major difference and leaving it here will
    //get rid of any unnecessary confusion about the method not being implemented, as it exists in the class diagram
    public void changeStatus(int index) {
        setStatus(index);
    }

    public static void notifyAboutReadyOrders() {
        // TODO: Implement notifyAboutReadyOrders logic
    }

    public static String generateMonthlyReport() {
        // TODO: Implement generateMonthlyReport logic
        return "";
    }
}