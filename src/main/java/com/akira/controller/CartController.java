package com.akira.controller;

import com.akira.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.akira.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 获取用户购物车列表
     */
    @GetMapping("/{userId}")
    public List<CartItem> getCartItemsByUserId(@PathVariable("userId") Long userId) {
        return cartService.getCartItemsByUserId(userId);
    }

    /**
     * 添加商品到购物车
     */
    @PostMapping("")
    public void addCartItem(@RequestBody CartItem cartItem) {
        cartService.addCartItem(cartItem);
    }

    /**
     * 修改购物车中的商品数量
     */
    @PutMapping("/{id}")
    public void updateCartItemQuantity(@PathVariable("id") Long id, @RequestParam("quantity") Integer quantity) {
        cartService.updateCartItemQuantity(id, quantity);
    }

    /**
     * 删除购物车中的商品
     */
    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable("id") Long id) {
        cartService.deleteCartItem(id);
    }
}
