package com.bntn.bookstore.repository;

import com.bntn.bookstore.model.BookToCartItem;
import com.bntn.bookstore.model.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
