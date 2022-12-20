package Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides
public abstract class Person {
    public static Map<Integer, Person> allPeople = new HashMap<>();
    private static int idCounter = 0; //we will use this as unique ID, but it might get changed later (tmp solution)
    private final int id;
    private String login;
    private String password;
    private String nickname;
    private String emailAddress;
    private Object profilePicture; /*There was supposed to be an image here
                                     but after asking the teacher we agreed on omitting this field
                                     for simplicity reasons*/

    //ASSOCIATIONS
    //Person - order
    private List<Order> orders;
    //Person - offer
    private List<Offer> offers;
    // getters and setters for associations
    public List<Offer> getOffers() {
        return offers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Person(String login, String password, String nickname, String emailAddress) {
        this.id = setId();
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.emailAddress = emailAddress;
        allPeople.put(this.id,this);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Getters and setters for Profile pictures are not implemented because it would require dealing with I/O etc.
     * Teacher agreed.
     *
     * @throws UnsupportedOperationException
     */
    public Object getProfilePicture() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void setProfilePicture(Object profilePicture) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    /**
     Method implementation
     I set login and register to static, because it doesn't really make sense otherwise. It's different in the diagram
     */
    public static boolean login(String username, String password) {
        // TODO: Implement login logic
        return false;
    }

    public static boolean register(String username, String password, String nickname, String email, Object profilePicture) {
        // TODO: Implement register logic
        return false;
    }

    public void changeNickname(String nickname) {
        // TODO: Implement change nickname logic
    }

    public void changePassword(String password) {
        // TODO: Implement change password logic
    }

    public void changeProfilePicture(Object profilePicture) {
        // TODO: Implement change profile picture logic
    }

    public void reportUser(String user, String reportDescription) {
        // TODO: Implement report user logic
    }
}
