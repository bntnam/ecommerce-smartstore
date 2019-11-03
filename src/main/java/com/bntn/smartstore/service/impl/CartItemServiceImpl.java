package com.bntn.smartstore.service.impl;

import com.bntn.smartstore.model.*;
import com.bntn.smartstore.repository.PhoneToCartItemRepository;
import com.bntn.smartstore.repository.CartItemRepository;
import com.bntn.smartstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private PhoneToCartItemRepository phoneToCartItemRepository;

    @Override
    public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal bigDecimal = new BigDecimal(cartItem.getPhone().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));

        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        cartItem.setSubtotal(bigDecimal);

        cartItemRepository.save(cartItem);

        return cartItem;
    }

    @Override
    public CartItem addPhoneToCartItem(Phone phone, User user, int qty) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if (phone.getId() == cartItem.getPhone().getId()) {
                cartItem.setQty(cartItem.getQty()+qty);
                cartItem.setSubtotal(new BigDecimal(phone.getOurPrice()).multiply(new BigDecimal(qty)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setPhone(phone);

        cartItem.setQty(qty);
        cartItem.setSubtotal(new BigDecimal(phone.getOurPrice()).multiply(new BigDecimal(qty)));
        cartItem = cartItemRepository.save(cartItem);

        PhoneToCartItem phoneToCartItem = new PhoneToCartItem();
        phoneToCartItem.setPhone(phone);
        phoneToCartItem.setCartItem(cartItem);
        phoneToCartItemRepository.save(phoneToCartItem);

        return cartItem;
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findOne(id);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        phoneToCartItemRepository.deleteByCartItem(cartItem);
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findByOrder(Order order) {
        return cartItemRepository.findByOrder(order);
    }

}
