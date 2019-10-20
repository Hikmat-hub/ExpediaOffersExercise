<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Expedia Offer Form</title>
    <style>
        body { background-color: #eee; font: helvetica; }
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
        .green { font-weight: bold; color: green; }
        .message { margin-bottom: 10px; }
        label {width:70px; display:inline-block;}
        input { display:inline-block; margin-right: 10px; }
        form {line-height: 160%; }
        .hide { display: none; }
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>

<div id="container">

    <h2>Offers</h2>
    <form:form action="/filter" modelAttribute="offersRequest">
        <label for="destinationName">Destination Name: </label>
            <form:input path="destinationName" id="destinationName" />
            <form:errors path="destinationName" cssClass="error" />
        <br/>
        <input type="submit" value="Submit" />
    </form:form>
</div>
</body>
</html>
