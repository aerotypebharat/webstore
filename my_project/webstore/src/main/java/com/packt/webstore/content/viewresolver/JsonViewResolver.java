/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.content.viewresolver;

import java.util.Locale;
 
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
 

public class JsonViewResolver implements ViewResolver {
 
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.servlet.ViewResolver#resolveViewName(java.lang
     * .String, java.util.Locale)
     */
    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }
 
}
