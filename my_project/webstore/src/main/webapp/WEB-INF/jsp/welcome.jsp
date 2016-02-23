<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=ISO-8859-1">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
      integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
      crossorigin="anonymous">
        <title>Welcome</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> ${greeting} </h1>
                    <p> ${tagline} </p>
                    <p>We dont care about  tagline</p>
                </div>
                <div class="jumbotron">
                <div class="container">
                    <h1> ${message} </h1>
                    <p> ${attract} </p>
                </div>
                
                
            </div>
        </section>
    </body>
</html>