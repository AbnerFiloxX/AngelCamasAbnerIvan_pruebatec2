<%-- 
    Document   : turnos
    Created on : 21 ene. 2025, 11:04:45
    Author     : satel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hackaboss.logica.Turno" %>
<%@ page import="com.hackaboss.logica.ControladoraLogica" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Turnos</title>
</head>
<body>
    <h1>Gestión de Turnos</h1>
    <h2>Lista de Turnos</h2>
    
    
    
    <table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>DNI</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="ciudadano" items="${listaCiudadanos}">
            <tr>
                <td>${ciudadano.id}</td>
                <td>${ciudadano.nombre}</td>
                <td>${ciudadano.apellido}</td>
                <td>${ciudadano.dni}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

    <h2>Crear Turno</h2>
    <form action="TurnosSv" method="post">
        <label>Estado:</label>
        <select name="estado">
            <option value="En espera">En espera</option>
            <option value="Ya atendido">Ya atendido</option>
        </select>
        <br>
        <label for="tramite">Trámite:</label>
        <select id="tramite" name="tramite">
                <option value="">Seleccionar Tramite</option>
            <option value="1">Trámite de Registro</option>
        <option value="2">Trámite de Renovación</option>
        <option value="3">Trámite de Certificación</option>
        <option value="4">Trámite de Exoneración</option>
        <option value="5">Trámite de Cambio de Domicilio</option>
        </select>
        <br>
        <label>Ciudadano:</label>
        <label>ID Ciudadano:</label>
<input type="text" name="idCiudadano" required><br>

<label>Apellido:</label>
<input type="text" name="apellido" required><br>

<label>DNI:</label>
<input type="text" name="dni" required><br>

<label>Nombre:</label>
<input type="text" name="nombre" required><br>


        <button type="submit">Crear Turno</button>
    </form>
</body>
</html>
