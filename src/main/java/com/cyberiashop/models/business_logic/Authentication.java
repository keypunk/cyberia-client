package com.cyberiashop.models.business_logic;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Authentication extends Remote {
    boolean credentialsExist(String username, String password) throws RemoteException;
}
