package Models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides
public class Offer {

    /**
     * Done in such a way because there are only a few available values of the status
     */
    public static Map<Integer, Offer> allOffers = new HashMap<>();
    private static final String[] possibleBookConditions = {"damaged", "used but not damaged", "new"};
    private static final String[] possibleOfferStatus = {"active", "archived"};
    private static int idCounter = 0; //we will use this as unique ID, but it might get changed later (tmp solution)
    private final int id;
    private LocalDate dateAdded;
    //Optional attributes can also be created by using overloaded constructors with or without this field
    private Optional<LocalDate> dateEnded; //Might get changed;
    private String bookTitle;
    private String bookCondition;
    private String bookAuthor;
    private Optional<String> publishingCompany; //Same case as with the "dateEnded"
    private Object[] picture = new Object[8];  /**This array was supposed to be an image array
                                     but after asking the teacher we agreed on omitting pictures
                                     for simplicity reasons*/
    private String status;

    //ASSOCIATIONS
    //Offer - person
    private Person person; //creator of the offer
    //Offer - delivery option
    private List<DeliveryOption> deliveryOptions; //delivery options available for this offer
    //Offer - order
    private Order order; // in MAS lectures it is mentioned the aggregation looks the same as classic association in code

    //getters and setters for associations
    public List<DeliveryOption> getDeliveryOptions() {
        return deliveryOptions;
    }
    public void setDeliveryOptions(List<DeliveryOption> deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Offer(LocalDate dateAdded, Optional<LocalDate> dateEnded, String bookTitle, int bookConditionIndex,
                 String bookAuthor, Optional<String> publishingCompany, int statusIndex, Person creatorOfOffer) {
        this.id = setId();
        this.dateAdded = dateAdded;
        this.dateEnded = dateEnded;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publishingCompany = publishingCompany;
        try {
            this.status = getOfferStatusTypes(statusIndex);
            this.bookCondition = getBookConditionTypes(bookConditionIndex);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        allOffers.put(this.id,this);
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

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Optional<LocalDate> getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Optional<LocalDate> dateEnded) {
        this.dateEnded = dateEnded;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(int index) {
        this.bookCondition = getBookConditionTypes(index);
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Optional<String> getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(Optional<String> publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    /**
     * Getters and setters for Picture are not implemented because it would require dealing with I/O etc.
     * Teacher agreed.
     *
     * @throws UnsupportedOperationException
     */

    public Object getPicture() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void setPicture(Object picture) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(int index) {
        this.status = getOfferStatusTypes(index);
    }

    public static String getBookConditionTypes(int index) throws IndexOutOfBoundsException {
        if (index < possibleBookConditions.length)
            return possibleBookConditions[index];
        throw new IndexOutOfBoundsException();
    }

    public static String getOfferStatusTypes(int index) throws IndexOutOfBoundsException {
        if (index < possibleOfferStatus.length)
            return possibleOfferStatus[index];
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", dateAdded=" + dateAdded +
                ", dateEnded=" + dateEnded +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookCondition='" + bookCondition + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publishingCompany=" + publishingCompany +
                ", status='" + status + '\'' +
                '}';
    }

    /**
     * Method implementation
     */
    public void changeStatus(int index) {
        // TODO: Implement changeStatus logic
    }

    public static void listAllOffers() {
        // TODO: Implement listAllOffers logic
    }

    public void createOffer() {
        // TODO: Implement createOffer logic
    }

    public void deleteOffer() {
        // TODO: Implement deleteOffer logic
    }

    public void reportOffer() {
        // TODO: Implement reportOffer logic
    }

    public void reserveOffer() {
        // TODO: Implement reserveOffer logic
    }
}