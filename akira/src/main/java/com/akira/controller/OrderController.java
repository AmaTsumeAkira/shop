package com.akira.controller;

import com.akira.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.akira.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 获取所有订单列表
     */
    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * 根据id获取订单详情
     */
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    /**
     * 添加新订单
     */
    @PostMapping("")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    /**
     * 修改订单状态
     */
    @PutMapping("/{id}")
    public void updateOrderStatus(@PathVariable("id") Long id, @RequestParam("status") String status) {
        orderService.updateOrderStatus(id, status);
    }

    /**
     * 删除订单
     */
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }
}
