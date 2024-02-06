package com.cyberiashop.controllers;

import com.cyberiashop.models.data_models.Product;

// listener for switching the chosen item card (large item box inside the shop main view)
public interface ShopListener {
    void onClickListener(Product product);
}
