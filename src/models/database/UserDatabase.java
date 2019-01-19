package models.database;

import models.database.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    static List<User> userList;

    public UserDatabase() {
        userList=new ArrayList<User>();
        User a = new User("Karol","Gorski","KarolGorski","password");
        User b = new User("admin","admin","admin","admin");
        userList.add(a);
        userList.add(b);
        System.out.println(userList.toString());
    }

    public static void addUser(User user){
        userList.add(user);
    }

    public static boolean CheckUser(String login, String password)
    {
        for(User user : userList)
        {
            if(user.checkUser(login,password))
                return true;
        }
        return false;
    }

    public static User getUser(String login, String password)
    {
        if(CheckUser(login, password)){
            for(User user : userList)
                if(user.checkUser(login,password))
                    return user;
        }
        return null;
    }

}
