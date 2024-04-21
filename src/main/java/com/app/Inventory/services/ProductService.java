package com.app.Inventory.services;

import com.app.Inventory.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Product product);

    String deleteProduct(String id);

    List<Product> getAllProducts();

    Product getProductById(String id);
}
