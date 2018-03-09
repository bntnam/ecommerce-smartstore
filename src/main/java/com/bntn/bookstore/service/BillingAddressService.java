package com.bntn.bookstore.service;

import com.bntn.bookstore.model.BillingAddress;
import com.bntn.bookstore.model.UserBilling;

public interface BillingAddressService {
    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
