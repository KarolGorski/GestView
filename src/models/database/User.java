package models.database;

public class User {
    String name;
    String surname;
    String login;
    String password;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public boolean checkUser(String logs, String password)
    {
        boolean log=login.equals(logs);
        boolean pass= this.password.equals(password);
        System.out.println(log +" "+pass);
        return log && pass;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
