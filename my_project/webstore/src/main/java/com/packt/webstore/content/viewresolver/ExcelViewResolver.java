///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.packt.webstore.content.viewresolver;
//
//import java.util.Locale;
// 
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.ViewResolver;
// 
//import com.packt.webstore.util.GenerateExcel;
// 
//
//public class ExcelViewResolver implements ViewResolver {
// 
//    /* (non-Javadoc)
//     * @see org.springframework.web.servlet.ViewResolver#resolveViewName(java.lang.String, java.util.Locale)
//     */
//    @Override
//    public View resolveViewName(String viewname, Locale locale) throws Exception {
//        GenerateExcel generateExcel = new GenerateExcel();
//        return generateExcel;
//    }
// 
//}
