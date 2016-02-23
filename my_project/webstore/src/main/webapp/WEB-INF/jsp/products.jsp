<%-- 
    Document   : products
    Created on : Jan 20, 2016, 9:04:50 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=ISO-8859-1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h2>Products</h2>
                    <p>All the available products in our store</p>
                </div>
            </div>
        </section>
        <section class="container">
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <div class="col-sm-6 col-md-3" style="padding-bottom:
                         15px">
                        <div class="thumbnail">
                            <img src="<c:url
                                     value="/resources/images/${product.productId}.png"></c:url>"
                                     alt="image" style = "width:250px;height:175px"/>
                                 <div class="caption">
                                     <h3>${product.name}</h3>
                                 <p>${product.description}</p>
                                 <p>$${product.unitPrice}</p>
                                 <p>Available ${product.unitsInStock} units in stock</p>
                                 <p>
                                     <a href=" <spring:url value=
                                                 "/products/product?id=${product.productId}" /> " class=
                                        "btn btn-primary">
                                         <span class="glyphicon-info-sign glyphicon"/></span> Details
                                     </a>
                                 </p>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </body>
</html>
