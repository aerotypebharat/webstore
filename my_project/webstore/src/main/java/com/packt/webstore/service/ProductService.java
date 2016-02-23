/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.service;

import com.packt.webstore.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Dell
 */
public interface ProductService {
    
    List<Product> getAllProducts();
Product getProductById(String productID);
List<Product> getProductsByCategory(String category);
Set<Product> getProductsByFilter(Map<String,
List<String>> filterParams);
void addProduct(Product product);
    
}
