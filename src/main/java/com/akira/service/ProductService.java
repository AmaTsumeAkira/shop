package com.akira.service;

import com.akira.model.Product;
import com.akira.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * 获取所有商品列表
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * 根据id获取商品详情
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * 添加新商品
     */
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    /**
     * 修改商品信息
     */
    public void updateProduct(Long id, Product product) {
        Product oldProduct = getProductById(id);
        if (oldProduct != null) {
            oldProduct.setName(product.getName());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setDescription(product.getDescription());
            productRepository.save(oldProduct);
        }
    }

    /**
     * 删除商品
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
