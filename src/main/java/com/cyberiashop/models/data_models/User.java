package com.cyberiashop.models.data_models;

import java.io.Serializable;

public interface User extends Serializable {
    void setUsername(String username);
    String getUsername();
    void setPassword(String password);
    String getPassword();
}
