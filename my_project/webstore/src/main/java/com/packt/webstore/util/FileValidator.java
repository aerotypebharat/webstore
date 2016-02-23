/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



import com.packt.webstore.domain.Product;

@Component

public class FileValidator implements Validator{
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }
 
    @Override
    public void validate(Object obj, Errors errors) {
        Product file = (Product) obj;
         
        if(file.getProductImage()!=null){
            
            if (file.getProductImage().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }
    }
    
}
