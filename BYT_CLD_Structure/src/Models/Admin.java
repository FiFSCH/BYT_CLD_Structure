package Models;

//TODO: Implement constraints, associations and methods according to the MAS lecture slides
public class Admin extends Person{
    public Admin(String login, String password, String nickname, String emailAddress) {
        super(login, password, nickname, emailAddress);
    }

    public Admin(Person prevPerson) { // dynamic inheritance
        super(prevPerson.getLogin(), prevPerson.getPassword(), prevPerson.getNickname(), prevPerson.getPassword());
    }
}
