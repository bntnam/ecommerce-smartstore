package com.bntn.smartstore.service;

import com.bntn.smartstore.model.ShippingAddress;
import com.bntn.smartstore.model.UserShipping;

public interface ShippingAddressService {
    ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
