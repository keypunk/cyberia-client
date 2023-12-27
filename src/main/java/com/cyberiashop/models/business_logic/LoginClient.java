package com.cyberiashop.models.business_logic;

import com.cyberiashop.models.business_logic.Authentication;

import java.rmi.Naming;

public class LoginClient {
    private Authentication loginAuthentication;

    public LoginClient() throws Exception {
        loginAuthentication = (Authentication) Naming.lookup("/employee");
    }

    public Authentication getLoginAuthentication() {
        return loginAuthentication;
    }
}
