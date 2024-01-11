package com.cyberiashop.models.business_logic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.cyberiashop.models.data_models.User;

public interface Authentication extends Remote {
    boolean authenticate(String username, String password) throws RemoteException;
}
