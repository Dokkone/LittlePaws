package com.example.littlepaws.holder;

import com.example.littlepaws.model.User;

public class UserDataHolder {

    private static UserDataHolder instance;
    private User loggedInUser;

    private UserDataHolder() {
        // Private constructor to prevent instantiation
    }

    public static synchronized UserDataHolder getInstance() {
        if (instance == null) {
            instance = new UserDataHolder();
        }
        return instance;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

}
