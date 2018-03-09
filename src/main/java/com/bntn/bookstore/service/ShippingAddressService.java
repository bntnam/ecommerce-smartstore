package com.bntn.bookstore.service;

import com.bntn.bookstore.model.ShippingAddress;
import com.bntn.bookstore.model.UserShipping;

public interface ShippingAddressService {
    ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
