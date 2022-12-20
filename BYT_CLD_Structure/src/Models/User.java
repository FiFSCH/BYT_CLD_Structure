package Models;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides
public class User extends Person {
    /**
     * Done in such a way because there are only a few available values of the status
     */
    private static final String[] possibleAccountStatuses = {"active", "suspended"};
    private String accountStatus;

    public User(String login, String password, String nickname, String emailAddress, int accountStatusIndex) {
        super(login, password, nickname, emailAddress);
        try {
            this.accountStatus = getStatusType(accountStatusIndex);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public User(Person prevPerson, int accountStatusIndex) {
        super(prevPerson.getLogin(), prevPerson.getPassword(), prevPerson.getNickname(), prevPerson.getEmailAddress());
        try {
            this.accountStatus = getStatusType(accountStatusIndex);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        Person.allPeople.remove(prevPerson.getId());
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatusIndex) {
        this.accountStatus = getStatusType(accountStatusIndex);
    }

    /**
     * We can omit this method and simply directly access the value from the array
     * But I thought that adding some validation would be nice
     */
    public String getStatusType(int index) throws IndexOutOfBoundsException {
        if (index < possibleAccountStatuses.length)
            return possibleAccountStatuses[index];
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        return "User{" +
                "accountStatus='" + accountStatus + '\'' +
                super.toString() +
                '}';
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

    public void deleteAccount() {
        // TODO: Implement deleteAccount logic
    }
}