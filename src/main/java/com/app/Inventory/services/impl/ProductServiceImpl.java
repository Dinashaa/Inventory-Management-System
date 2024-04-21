package com.app.Inventory.services.impl;

import com.app.Inventory.model.Product;
import com.app.Inventory.repository.ProductRepository;
import com.app.Inventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        product.setCreatedDate(LocalDateTime.now());
        return productRepository.insert(product);
    }

    @Override
    public Product updateProduct(Product product) {
        product.setUpdatedDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public String deleteProduct(String id) {
        productRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

}
