package com.packt.webstore.config;



import com.packt.webstore.content.viewresolver.Jaxb2MarshallingXmlViewResolver;
import com.packt.webstore.content.viewresolver.JsonViewResolver;

import com.packt.webstore.domain.Product;
import com.packt.webstore.interceptor.PerformanceMonitorInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebMvc

@ComponentScan(basePackages = "com.packt.webstore")
public class AppConfig extends WebMvcConfigurerAdapter {
    
    
   
    // this is for logging properties
    

    @Bean
    public PerformanceMonitorInterceptor localeInterceptor() {
        return new PerformanceMonitorInterceptor();
    }

    
///////---------------XML nad JSON ------------------------------------------------------------------
   
    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer contentNegotiationConfigurer) {
        contentNegotiationConfigurer.ignoreAcceptHeader(true)
                .defaultContentType(MediaType.TEXT_HTML);
    }
    
    
    @Bean
    public ViewResolver contentNegotiationViewResolver(
            ContentNegotiationManager contentNegotiationManager) {
        ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
        contentNegotiatingViewResolver
                .setContentNegotiationManager(contentNegotiationManager);
 
        List<ViewResolver> resolvers = new ArrayList<>();
        resolvers.add(jaxb2MarshallingXmlViewResolver());
        resolvers.add(jsonViewResolver());
        resolvers.add(viewResolver());
//        resolvers.add(pdfViewResolver());
       
 
        contentNegotiatingViewResolver.setViewResolvers(resolvers);
        return contentNegotiatingViewResolver;
    }
    
    /*
     * Configure View resolver to provide XML output Uses JAXB2 marshaller to
     * marshall/unmarshall POJO's (with JAXB annotations) to XML
     */
    @Bean
    public ViewResolver jaxb2MarshallingXmlViewResolver() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Product.class);
        return new Jaxb2MarshallingXmlViewResolver(marshaller);
    }
    
    
    /*
     * Configure View resolver to provide JSON output using JACKSON library to
     * convert object in JSON format.
     */
    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }
    
   
    
    
    ///--------------------------- For internationalisation ----------------------------
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
  @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver(){
        return new CookieLocaleResolver();
    }
    
    
    
    
    
    
    // this is for fileupload ----------------------------------------------
    
    @Bean(name="multipartResolver") 
	public CommonsMultipartResolver getResolver() throws IOException{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		//Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(5242880);//5MB
		
		//You may also set other available properties.
		
		return resolver;
	}
    
    
    //-------------------------------------------------------------------------------------------------

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);       // costum url mapping
    }

     @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    //////
    
    
    
    

}
