<%-- 
    Document   : addProduct
    Created on : Jan 21, 2016, 6:48:23 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">

                
                
                
                <a href="<c:url value="/products"  var="productHome"/>" ></a>
                <p class="btn btn-block btn-primary btn-default">Welcome Admin</p><br>
                <a href="<c:url value="/logout" />" class= "btn btn-danger btn-mini pull-right">Logout</a>
                <div class="pull-right" style="padding-right:50px"><a href="?language=en" >English</a>|<a href="?language=nl"
>Dutch</a>
</div>
                <a href="<c:url value="/products"  />" class= "btn btn-primary" role="button">Product List</a>
                <div class="container">
                    <h1>Products</h1>
                    <p>Add products</p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form  modelAttribute="newProduct" class="form-horizontal" method="post"  enctype="multipart/form-data" action="${productHome}/add?${_csrf.parameterName}=${_csrf.token}">
                <legend>Add new product</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for=
                           "productId"><spring:message code="addProduct.form.productId.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="productId" path="productId" type= "text" class="form:input-large"/>
                    </div>
                </div>



                <div class="form-group">

                    <label class="control-label col-lg-2 col-lg-2" for=
                           "productId"><spring:message code="addProduct.form.name.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="name" path="name" type=
                                    "text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for=
                           "productId"><spring:message code="addProduct.form.unitPrice.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="unitPrice" path="unitPrice" type=
                                    "text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for=
                           "productId"><spring:message code="addProduct.form.manufacturer.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="manufacturer" path="manufacturer" type=
                                    "text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for=
                           "productId"><spring:message code="addProduct.form.category.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="category" path="category" type=
                                    "text" class="form:input-large"/>
                    </div>
                </div>



                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for=
                           "productId"><spring:message code="addProduct.form.unitsInStock.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="unitsInStock" path="unitsInStock" type=
                                    "text" value= '0' class="form:input-large"/>
                    </div>


                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2" for=
                           "description"><spring:message code="addProduct.form.description.label"/></label>
                    <div class="col-lg-10">
                        <form:textarea id="description" path=
                                       "description" rows = "2"/>
                    </div>
                </div>

                        <div class="form-group">
                            <label class="control-label col-lg-2" for=
                                   "condition"><spring:message code="addProduct.form.condition.label"/></label>
                            <div class="col-lg-10">
                                <form:radiobutton path="condition" value=
                                                  "New" />New
                                <form:radiobutton path="condition" value=
                                                  "Old" />Old
                                <form:radiobutton path="condition" value=
                                                  "Refurbished" />Refurbished
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="productImage">
                                <spring:message code="addProdcut.form.productImage.label"/>
                            </label>
                            <div class="col-lg-10">
                                <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
                            </div>
                        </div>



                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <input type="submit" id="btnAdd" class=
                                       "btn btn-primary" value ="Add"/>
                            </div>
                        </div>

                 
            </form:form>
        </section>
    </body>
</html>