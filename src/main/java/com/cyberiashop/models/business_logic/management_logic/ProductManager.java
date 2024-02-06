package com.cyberiashop.models.business_logic.management_logic;

import com.cyberiashop.models.data_models.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductManager extends Remote {
    void addProduct(Product product) throws RemoteException;
    void removeProduct(String productname) throws RemoteException;
}
