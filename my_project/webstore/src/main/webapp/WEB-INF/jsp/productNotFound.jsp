<%-- 
    Document   : ProductNotFound
    Created on : Jan 27, 2016, 10:12:10 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html
              charset=ISO-8859-1">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>Welcome</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger"> There is no product found with the Product id ${invalidProductId}</h1>
                </div>
            </div>
        </section>
        <section>
            <div class="container">
                <p>${url}</p>
                <p>${exception}</p>
            </div>
            <div class="container">
                <p>
                    <a href="<spring:url value="/products" />"
                       class="btn btn-primary">
                       <span class="glyphicon-hand-left glyphicon">
                        </span> products
                    </a>
                </p>
            </div>
        </section>
    </body>
</html>
