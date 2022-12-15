package Models;
import java.time.LocalDate;
import java.util.Optional;

//TODO: Implement constraints, associations and methods according tho the MAS lecture slides
public class Order {
    /**
     * Done in such a way because there are only a few available values of the status
     */
    private static final String[] possibleOrderStatuses = new String[]{"cancelled", "in progress", "finished"};
    private int id;
    private LocalDate dateCreated;
    private Optional<LocalDate> dateFinished = Optional.empty(); //Might get changed
    private String accountStatus;
    private String deliveryAddress; //String instead of some geoLocation for simplicity

    public Order(int id, LocalDate dateCreated, Optional<LocalDate> dateFinished, String accountStatus, String deliveryAddress) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateFinished = dateFinished;
        this.accountStatus = accountStatus;
        this.deliveryAddress = deliveryAddress;
    }
}