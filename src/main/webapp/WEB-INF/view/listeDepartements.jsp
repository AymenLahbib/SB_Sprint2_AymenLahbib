<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Produits</title>
</head>
<body>
<h1 >
Liste des Produits
</h1>
<table >
<tr>
<th>ID</th><th>Nom Produit</th><th>Prix</th><th>Date
Création</th><th>Suppression<th>Edition</th>
</tr>
<c:forEach items="${produits}" var="p">
<tr>
<td>${p.idDepartement }</td>
<td>${p.nomDepartement }</td>
<td>${p.surfaceDepartement }</td>
<td><fmt:formatDate pattern="dd/MM/yyyy"
value="${p.dateCreation}" /></td>
<td><a onclick="return confirm('Etes-vous sûr ?')"
href="supprimerDepartement?id=${p.idDepartement }">Supprimer</a></td>
<td><a href="modifierDepartement?id=${p.idDepartement }">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
-->
<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>
            <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
            <c:url value="/css/main.css" var="jstlCss" />
            <link href="${jstlCss}" rel="stylesheet" />
            <script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
                <title>Liste Departements</title>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="card">
                        <div class="card-header">
                            Liste des Departements
                        </div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <tr>
                                    <th>ID</th>
                                    <th>Nom Departement</th>
                                    <th>Surface</th>
                                    <th>Date Creation</th>
                                    <th>Suppression </th>
                                    <th>Edition</th>
                                </tr>
                                <c:forEach items="${produits}" var="p">
                                    <tr>
                                        <td>${p.idDepartement }</td>
                                        <td>${p.nomDepartement }</td>
                                        <td>${p.surfaceDepartement }</td>
                                        
                                        <td>
                                            <fmt:formatDate pattern="dd/MM/yyyy" value="${p.dateCreation}" />
                                        </td>
                                        <td><a onclick="return confirm('Etes-vous sur ?')"
                                                href="supprimerDepartement?id=${p.idDepartement }">Supprimer</a></td>
                                        <td><a href="modifierDepartement?id=${p.idDepartement }">Edit</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </body>

            </html>