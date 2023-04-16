package com.akira.service;

import com.akira.model.Order;
import com.akira.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    /**
     * 获取所有订单列表
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * 根据id获取订单详情
     */
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    /**
     * 添加新订单
     */
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    /**
     * 修改订单状态
     */
    public void updateOrderStatus(Long id, String status) {
        Order oldOrder = getOrderById(id);
        if (oldOrder != null) {
            oldOrder.setStatus(status);
            orderRepository.save(oldOrder);
        }
    }

    /**
     * 删除订单
     */
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
