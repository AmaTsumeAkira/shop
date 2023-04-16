package com.akira.service;

import com.akira.model.CartItem;
import com.akira.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    /**
     * 获取用户购物车列表
     */
    public List<CartItem> getCartItemsByUserId(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    /**
     * 添加商品到购物车
     */
    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    /**
     * 修改购物车中的商品数量
     */
    public void updateCartItemQuantity(Long id, Integer quantity) {
        CartItem oldItem = cartItemRepository.findById(id).orElse(null);
        if (oldItem != null) {
            oldItem.setQuantity(quantity);
            cartItemRepository.save(oldItem);
        }
    }

    /**
     * 删除购物车中的商品
     */
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
