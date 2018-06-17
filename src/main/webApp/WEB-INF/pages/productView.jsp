<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <title>Product page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Product edit form</h2>

    <c:forEach items="${productErrors}" var="error">
        <div class="alert alert-danger">
            ${error.value}
        </div>
    </c:forEach>
    <form:form action="/product/save" method="post" modelAttribute="productModel">
        <form:hidden path="id"/>
        <div class="form-group">
            <form:label path="name" id="productName">Product name</form:label>
            <form:errors path="name" id="productName" cssClass="alert alert-danger" element="div" cssStyle="max-width: 50%"></form:errors>
            <form:input path="name" cssClass="form-control" id="productName" placeholder="Enter product name"></form:input>
        </div>
        <div class="form-group">
            <form:label path="ean" id="productEan">Product ean</form:label>
            <form:errors path="ean" id="productEan" cssClass="alert alert-danger" element="div" cssStyle="max-width: 50%"></form:errors>
            <form:input path="ean" cssClass="form-control" id="productEan" placeholder="Enter product ean"></form:input>
        </div>
        <div class="form-group">
            <form:label path="price" id="productPrice">Product price</form:label>
            <form:errors path="price" id="productPrice" cssClass="alert alert-danger" element="div" cssStyle="max-width: 50%"></form:errors>
            <form:input path="price" cssClass="form-control" id="productPrice" placeholder="Enter product price"></form:input>
        </div>
        <div class="form-group">
            <form:label path="type" id="productType">Product type: </form:label>
            <form:select path="type" id="productType">
                <form:options items="${productTypes}" itemValue="id" itemLabel="name"/>
            </form:select>
        </div>
        <button type="Save" class="btn btn-default">Save</button>

    </form:form>
</div>

</body>
</html>