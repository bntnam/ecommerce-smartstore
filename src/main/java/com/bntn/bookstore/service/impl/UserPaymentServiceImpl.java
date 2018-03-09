package com.bntn.bookstore.service.impl;

import com.bntn.bookstore.model.UserPayment;
import com.bntn.bookstore.repository.UserPaymentRepository;
import com.bntn.bookstore.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    private UserPaymentRepository userPaymentRepository;

    @Override
    public UserPayment findById(Long id) {
        return userPaymentRepository.findOne(id);
    }

    @Override
    public void removeById(Long id) {
        userPaymentRepository.delete(id);
    }
}
