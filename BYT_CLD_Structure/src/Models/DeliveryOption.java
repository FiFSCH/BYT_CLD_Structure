package Models;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides
public class DeliveryOption {
    private String description;
    private double price;

    public DeliveryOption(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DeliveryOption{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
