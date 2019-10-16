package com.bntn.smartstore.service;

import com.bntn.smartstore.model.BillingAddress;
import com.bntn.smartstore.model.UserBilling;

public interface BillingAddressService {
    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
