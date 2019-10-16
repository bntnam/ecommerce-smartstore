package com.bntn.smartstore.service;

import com.bntn.smartstore.model.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

    void clearShoppingCart(ShoppingCart shoppingCart);
}
