package com.cyberiashop.models.business_logic.authentication;

public class UserSession {
    private String username;
    private static UserSession userSession;

    private UserSession() {}

    public static UserSession getInstance() {
        if (userSession == null) {
            userSession = new UserSession();
        }

        return userSession;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
