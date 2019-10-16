package com.bntn.smartstore.repository;

import com.bntn.smartstore.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
