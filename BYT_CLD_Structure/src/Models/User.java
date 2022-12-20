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
     */

    public void deleteAccount() {
        // TODO: Implement deleteAccount logic
    }
}