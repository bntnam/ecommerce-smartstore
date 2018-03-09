package com.bntn.bookstore.service;

import com.bntn.bookstore.model.UserPayment;

public interface UserPaymentService {

    UserPayment findById(Long id);

    void removeById(Long id);
}
