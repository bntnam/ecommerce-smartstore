package com.bntn.bookstore.repository;

import com.bntn.bookstore.model.CartItem;
import com.bntn.bookstore.model.Order;
import com.bntn.bookstore.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    List<CartItem> findByOrder(Order order);
}
