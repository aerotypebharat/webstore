/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import java.util.Map;
import java.util.Set;
@Service
public class ProductServiceImpl implements ProductService{
@Autowired
private ProductRepository productRepository;
@Override
public List<Product> getAllProducts() {
return productRepository.getAllProducts();
}
@Override
public Product getProductById(String productID) {
return productRepository.getProductById(productID);
}


@Override
public List<Product> getProductsByCategory(String category) {
return productRepository.getProductsByCategory(category);
}


@Override
public Set<Product> getProductsByFilter(Map<String,
List<String>> filterParams) {
return productRepository.getProductsByFilter(filterParams);
}

@Override
public void addProduct(Product product) {
productRepository.addProduct(product);
}
}


