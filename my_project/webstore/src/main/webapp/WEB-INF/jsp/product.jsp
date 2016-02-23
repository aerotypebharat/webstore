<%-- 
    Document   : product
    Created on : Jan 21, 2016, 1:28:54 AM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
        <script src="/webstore/resources/js/controllers.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
      integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
      crossorigin="anonymous">
        
        
        
      
        
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Products</h1>
                </div>
            </div>
        </section>
        <section class="container" ng-app="cartApp">
            
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url
                             value="/resources/images/${product.productId}.png"></c:url>"
                             alt="image" style = "width:100%"/>
                    </div>
                    <div class="col-md-5">
                        <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p>
                        <strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
                    </p>
                    <p>
                        <strong>manufacturer</strong> :
                        ${product.manufacturer}
                    </p>
                    <p>
                        <strong>category</strong> : ${product.category}</p>
                    <p>
                        <strong>Availble units in stock </strong> :${product.unitsInStock}</p>
                    <h4>${product.unitPrice} USD</h4>
                    <p ng-controller= "cartCtrl"  >
                        <a href="#" class="btn btn-warning btn-large"  ng-click="addToCart('${product.productId}')"> <span class="glyphicon-shopping-cart glyphicon"></span> Order Now </a>
                                
                                <a href="<spring:url value="/products" />" class="btn btndefault">                                  
                                    <span class="glyphicon-hand-left glyphicon"></span> Back
                                </a>
                                    
                                <a href="<spring:url value="/cart" />" class="btn btn-default">
                                    <span class="glyphicon-hand-right glyphicon"></span> View Cart
                                </a>
                        </a>
                    </p>
                </div>
            </div>
        </section>
                                    
    </body>
</html>
