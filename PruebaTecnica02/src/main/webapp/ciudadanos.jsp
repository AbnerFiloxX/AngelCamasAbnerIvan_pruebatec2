<%-- 
    Document   : ciudadanos
    Created on : 21 ene. 2025, 17:20:17
    Author     : satel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Ciudadanos</title>
</head>
<body>
    <h1>Lista de Ciudadanos</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>DNI</th>
        </tr>
        <c:forEach var="ciudadano" items="${ciudadanos}">
            <tr>
                <td>${ciudadano.id}</td>
                <td>${ciudadano.nombre}</td>
                <td>${ciudadano.apellido}</td>
                <td>${ciudadano.dni}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Agregar Ciudadano</h2>
    <form action="CiudadanosServlet" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" required>
        <br>
        <label>Apellido:</label>
        <input type="text" name="apellido" required>
        <br>
        <label>DNI:</label>
        <input type="text" name="dni" required>
        <br>
        <button type="submit">Agregar</button>
    </form>
</body>
</html>
