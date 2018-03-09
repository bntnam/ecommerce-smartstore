package com.bntn.bookstore.service;

import com.bntn.bookstore.model.Payment;
import com.bntn.bookstore.model.UserPayment;

public interface PaymentService {
    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
