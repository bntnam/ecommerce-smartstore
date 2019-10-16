package com.bntn.smartstore.service;

import com.bntn.smartstore.model.UserPayment;

public interface UserPaymentService {

    UserPayment findById(Long id);

    void removeById(Long id);
}
