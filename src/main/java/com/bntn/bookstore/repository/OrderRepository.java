package com.bntn.bookstore.repository;

import com.bntn.bookstore.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
