package Models;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides
public abstract class Person {
    private static int idCounter = 0; //we will use this as unique ID, but it might get changed later (tmp solution)
    private final int id;
    private String login;
    private String password;
    private String nickname;
    private String emailAddress;
    private Object profilePicture; /*There was supposed to be an image here
                                     but after asking the teacher we agreed on omitting this field
                                     for simplicity reasons*/


    public Person(String login, String password, String nickname, String emailAddress) {
        this.id = setId();
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.emailAddress = emailAddress;
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
}
