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

    <h1 class="mt-5">Produits</h1>

    <form method="get" action="chercher.php" class="form-inline search-form">

        <label class="sr-only" for="motcle">Mot CLe</label>

        <input type="text" name="motcle" id="motcle" class="form-control mr-2" placeholder="Mot CLe">

        <button type="submit" class="btn btn-primary">Chercher</button>

    </form>

    <table class="table product-table mt-5">

        <thead>

        <tr>

            <th>ID</th>

            <th>DESIGNATIONNs</th>

            <th>PRIX</th>

            <th>QUANTITE</th>

            <th>ACTIONS</th>

        </tr>

        </thead>

        <tbody>

        <c:forEach items="${model.produits}" var="p">

            <tr>

                <td>${p.id}</td>

                <td>${p.designation}</td>

                <td>${p.prix}</td>

                <td>${p.quantite}</td>

                <td>

                    <a href="Supprimer.php?id=${p.id}" class="btn btn-danger" onclick="return confirm('etes vous sure?')">Supprimer</a>

                    <a href="Modifier.php?id=${p.id}" class="btn btn-warning">Modifier</a>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>

</div></body>
</html>
