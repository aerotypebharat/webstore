/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.content.viewresolver;

import java.util.Locale;
 
import org.springframework.oxm.Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;
 

public class Jaxb2MarshallingXmlViewResolver implements ViewResolver {
 
    private final Marshaller marshaller;
 
    public Jaxb2MarshallingXmlViewResolver(Marshaller marshaller) {
        this.marshaller = marshaller;
    }
 
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
        MarshallingView view = new MarshallingView();
        view.setMarshaller(marshaller);
        return view;
    }
 
}
