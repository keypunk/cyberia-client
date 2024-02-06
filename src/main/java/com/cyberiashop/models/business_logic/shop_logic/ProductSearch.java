package com.cyberiashop.models.business_logic.shop_logic;

import com.cyberiashop.models.data_models.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductSearch extends Remote {
    List<Product> emptySearch() throws RemoteException;
    List<Product> searchByProductName(String productName) throws RemoteException;
}
