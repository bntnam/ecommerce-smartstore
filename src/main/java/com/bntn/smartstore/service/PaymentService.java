package com.bntn.smartstore.service;

import com.bntn.smartstore.model.Payment;
import com.bntn.smartstore.model.UserPayment;

public interface PaymentService {
    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
