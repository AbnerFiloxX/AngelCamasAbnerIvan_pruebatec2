<%-- 
    Document   : login
    Created on : 21 ene. 2025, 11:04:02
    Author     : satel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
    <form action="UsuarioServlet" method="POST">
    <label for="username">Usuario:</label>
    <input type="text" name="username" id="username" required>
    <br>
    <label for="password">Contraseña:</label>
    <input type="password" name="password" id="password" required>
    <br>
    <input type="submit" value="Iniciar sesión">
</form>

    <p style="color: red;">
        ${error}
    </p>
</body>
</html>

