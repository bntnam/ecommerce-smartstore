package com.bntn.smartstore.service.impl;

import com.bntn.smartstore.model.Payment;
import com.bntn.smartstore.model.UserPayment;
import com.bntn.smartstore.service.PaymentService;
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
