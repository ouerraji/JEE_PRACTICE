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
<p></p>
<div>
    <div>
        <div > Recherche des produits</div>
        <div ></div>
        <form method="get" action="chercher.do">
        <label>Mot CLe</label>
            <input type="text" name="motcle"/>

        <button type="submit">Chercher</button>
        </form>
        <table>
            <tr>
            <th>ID</th><th>DESIGNATIONNs</th><th>PRIX</th><th>QUANTITE</th>
            </tr>
            <c:forEach items="${model.produits}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.designation}</td>
                    <td>${p.prix}</td>
                    <td>${p.quantite}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
