package service;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User("Hieu","123","Hieudz","hieu1@gmail.com",21));
        users.add(new User("Hung","123","hieudz2","hieu1@gmail.com",21));
        users.add(new User("Hien","123","hieudz3","hieu1@gmail.com",21));
    }
    public User checkLogin(Login login){
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
