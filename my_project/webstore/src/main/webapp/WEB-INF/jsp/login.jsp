<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content=
              "text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Products</h1>
                    <p>Add products</p>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please sign in</h3>
                        </div>
                        <div class="panel-body">
                            
                            <form action="${loginUrl}" method="post" class="form-horizontal">
                                
                                
                                <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/>
                                </div>
                            </c:if>
                                <c:if test="${param.logout != null}">
                                    <div class="alert alert-success">
                                        <p>You have been logged out successfully.</p>
                                    </div>
                                </c:if>
                                <div class="input-group input-sm">
                                    <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                    <input type="text" class="form-control" id="username" name="j_username" placeholder="Enter Username" required>
                                </div>
                                <div class="input-group input-sm">
                                    <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                    <input type="password" class="form-control" id="password" name="j_password" placeholder="Enter Password" required>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

                                <div class="form-actions">
                                    <input type="submit"
                                           class="btn btn-block btn-primary btn-default" value="Log in">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>