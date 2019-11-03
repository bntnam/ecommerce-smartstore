package com.bntn.smartstore.repository;

import com.bntn.smartstore.model.PhoneToCartItem;
import com.bntn.smartstore.model.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PhoneToCartItemRepository extends CrudRepository<PhoneToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
