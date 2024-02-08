<%--
  Created by IntelliJ IDEA.
  User: erraj
  Date: 22/12/2023
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Produits</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">

    <h1 class="mt-5">Confirmation</h1>
    <div>
        <label>ID:</label>
        <label>${produit.id}</label>
    </div>
    <div>
        <label>DESIGNATION:</label>
        <label>${produit.designation}</label>
    </div>
    <div>
        <label>PRIX:</label>
        <label>${produit.prix}</label>
    </div>
    <div>
        <label>QUANTITE:</label>
        <label>${produit.quantite}</label>
    </div>

</div>
</body>
</html>
