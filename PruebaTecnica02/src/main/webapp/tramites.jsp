<%-- 
    Document   : tramites
    Created on : 21 ene. 2025, 17:20:38
    Author     : satel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Trámites</title>
</head>
<body>
    <h1>Lista de Trámites</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
        </tr>
        <c:forEach var="tramite" items="${tramites}">
            <tr>
                <td>${tramite.id}</td>
                <td>${tramite.nombre}</td>
                <td>${tramite.descripcion}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
