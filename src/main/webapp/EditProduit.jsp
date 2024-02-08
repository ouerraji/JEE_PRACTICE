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
    <h1 class="mt-5">Edit Produit</h1>
    <form method="post" action="SaveProduit.php">
        <div class="mb-3">
            <label class="form-label">ID:</label>
            <input type="text" name="id" value="${ProduitEdit.id}" class="form-control">

        </div>
        <div class="mb-3">
            <label class="form-label">Designation</label>
            <input type="text" name="designation" value="${ProduitEdit.designation}" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Prix</label>
            <input type="text" name="prix" value="${ProduitEdit.prix}" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Quantite</label>
            <input type="number" name="quantite" value="${ProduitEdit.quantite}" class="form-control">
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Editer</button>
        </div>
    </form>
</div>
</body>
</html>
