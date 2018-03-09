package com.bntn.bookstore.service.impl;

import com.bntn.bookstore.model.Payment;
import com.bntn.bookstore.model.UserPayment;
import com.bntn.bookstore.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
        payment.setType(userPayment.getType());
        payment.setHolderName(userPayment.getHolderName());
        payment.setCardNumber(userPayment.getCardNumber());
        payment.setExpiredMonth(userPayment.getExpiredMonth());
        payment.setExpiredYear(userPayment.getExpiredYear());
        payment.setCvc(userPayment.getCvc());

        return payment;

    }
}
