
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Turnos</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
    <h1>Bienvenido al Sistema de Gestión de Turnos</h1>
    <a href="turnos.jsp">Ver Turnos</a>
    <!<!-- <a href="crear_turno.jsp">Crear Nuevo Turno</a> -->
    <form action="LogoutServlet" method="post">
        <button type="submit">Cerrar Sesión</button>
    </form>
</body>
</html>