package com.bntn.smartstore.repository;

import com.bntn.smartstore.model.BookToCartItem;
import com.bntn.smartstore.model.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
