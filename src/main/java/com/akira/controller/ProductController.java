package com.akira.controller;

import com.akira.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.akira.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 获取所有商品列表
     */
    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * 根据id获取商品详情
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    /**
     * 添加新商品
     */
    @PostMapping("")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    /**
     * 修改商品信息
     */
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
