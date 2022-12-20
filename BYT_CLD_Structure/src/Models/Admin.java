package Models;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides
public class Admin extends Person{
    public Admin(String login, String password, String nickname, String emailAddress) {
        super(login, password, nickname, emailAddress);
    }

    public Admin(Person prevPerson) {
        super(prevPerson.getLogin(), prevPerson.getPassword(), prevPerson.getNickname(), prevPerson.getPassword());
    }

    /**
     * Method implementation
     * similar issue compared to Person, I set the login and register methods to be static
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

    public void reviewUser(User user) {
        // TODO: Implement review user logic
    }

    public void reviewOffer(Offer offer) {
        // TODO: Implement review offer logic
    }
}
