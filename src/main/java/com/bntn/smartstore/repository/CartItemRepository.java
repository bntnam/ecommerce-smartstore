package com.bntn.smartstore.repository;

import com.bntn.smartstore.model.CartItem;
import com.bntn.smartstore.model.Order;
import com.bntn.smartstore.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    List<CartItem> findByOrder(Order order);
}
