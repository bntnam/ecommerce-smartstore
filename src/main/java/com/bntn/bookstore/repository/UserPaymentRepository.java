package com.bntn.bookstore.repository;

import com.bntn.bookstore.model.UserPayment;
import org.springframework.data.repository.CrudRepository;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {
}
