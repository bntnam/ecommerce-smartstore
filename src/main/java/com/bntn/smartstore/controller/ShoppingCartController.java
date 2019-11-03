package com.bntn.smartstore.controller;

import com.bntn.smartstore.model.Phone;
import com.bntn.smartstore.model.CartItem;
import com.bntn.smartstore.model.ShoppingCart;
import com.bntn.smartstore.model.User;
import com.bntn.smartstore.service.PhoneService;
import com.bntn.smartstore.service.CartItemService;
import com.bntn.smartstore.service.ShoppingCartService;
import com.bntn.smartstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private PhoneService phoneService;

    @RequestMapping("/cart")
    public String shoppingCart(Model model,
                               Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart";
    }

    @RequestMapping("/addItem")
    public String addItem(@ModelAttribute("phone") Phone phone,
                          @ModelAttribute("qty") String qty,
                          Model model,
                          Principal principal) {

        User user = userService.findByUsername(principal.getName());
        phone = phoneService.findOne(phone.getId());

        if (Integer.parseInt(qty) > phone.getInStockNumber()) {
            model.addAttribute("notEnoughStock", true);
            return "forward:/phoneDetail?id="+phone.getId();
        }

        CartItem cartItem = cartItemService.addPhoneToCartItem(phone, user, Integer.parseInt(qty));
        model.addAttribute("addPhoneSuccess", true);

        return "forward:/phoneDetail?id="+phone.getId();
    }

    @RequestMapping("/updateCartItem")
    public String updateShoppingCart(@ModelAttribute("id") Long cartItemId,
                                     @ModelAttribute("qty") int qty) {

        CartItem cartItem = cartItemService.findById(cartItemId);
        cartItem.setQty(qty);
        cartItemService.updateCartItem(cartItem);

        return "forward:/shoppingCart/cart";
    }

    @RequestMapping("/removeItem")
    public String removeItem(@RequestParam("id") Long id) {

        cartItemService.removeCartItem(cartItemService.findById(id));

        return "forward:/shoppingCart/cart";
    }

}
