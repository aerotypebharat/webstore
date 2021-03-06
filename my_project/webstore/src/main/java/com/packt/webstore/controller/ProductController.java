package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.service.ProductService;

import java.io.File;
import java.io.IOException;


import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/products")
public class ProductController{
    
    
    
    
    
    @Autowired
    private ProductService productService;
    

    @RequestMapping()
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String Category) {

        List<Product> products
                = productService.getProductsByCategory(Category);
        if (products == null || products.isEmpty()) {
            
            throw new NoProductsFoundUnderCategoryException("");
        }
        
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model) {
       
        
        
        model.addAttribute("products",productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product",
                productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
	   return "addProduct";
	}

        
        
        
    @RequestMapping(value = "/add", method = RequestMethod.POST) 
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result, HttpServletRequest request) {
        
        MultipartFile productImage= newProduct.getProductImage();
        System.out.println(productImage.getName());
        //String rootDirectory= request.getSession().getServletContext().getRealPath("/");
        
        String rootDirectory= "C:\\Users\\Dell\\Documents\\NetBeansProjects\\web\\webstore\\src\\main\\webapp\\resources\\images\\";
        
        
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory +  newProduct.getProductId() + ".png"));
            } catch (IOException | IllegalStateException e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }


            
 /////////////////////////////////////////////////////////////////////////////////////           
            

            
            
            
////////////////////////////////////////////////////////////////////////////////////////////////////////////            
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }	


		
	   	productService.addProduct(newProduct);
		return "redirect:/products";
	}

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        
        
      
        binder.setDisallowedFields("unitsInOrder", "discontinued");
        
      binder.setAllowedFields("productId","name","unitPrice","description","manufacturer","category","unitsInStock","condition", "productImage");


       
    }

    @ExceptionHandler(NoProductsFoundUnderCategoryException.class)
    public ModelAndView handleError(HttpServletRequest req, NoProductsFoundUnderCategoryException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
    
 
    
}
