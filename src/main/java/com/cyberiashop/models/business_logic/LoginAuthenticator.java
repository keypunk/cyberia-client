package com.cyberiashop.models.business_logic;

public class LoginAuthenticator {
    private LoginClient loginClient;

    public LoginAuthenticator() {
        try {
            loginClient = new LoginClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateAsEmployee(String username, String password) {
        try {
            return loginClient.getLoginAuthentication().credentialsExist(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
