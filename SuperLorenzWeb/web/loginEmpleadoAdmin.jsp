<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="co.edu.konradlorenz.model.*" %>
<%@ page import="co.edu.konradlorenz.model.dao.*" %>
<%@ page import="co.edu.konradlorenz.model.enums.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - SuperLorenz</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            color: white;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background: rgba(255, 255, 255, 0.1);
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            padding: 20px;
            max-width: 400px;
            width: 100%;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: none;
            border-radius: 5px;
            background: rgba(255, 255, 255, 0.2);
            color: white;
            outline: none;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #822fa1;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background: #9b50b6;
        }
        .extra-options {
            text-align: center;
            margin-top: 10px;
        }
        .extra-options a {
            color: #e0c3fc;
        }
    </style>
</head>
<body>
    <form id="loginForm" name="loginForm" action="ServletEmpleado" method="POST">
        <h1>Iniciar Sesión</h1>
        <label for="email">Correo:</label>
        <input type="text" id="email" name="email" placeholder="Ingrese su correo" required>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" placeholder="Ingrese su contraseña" required>
        <button type="submit">Ingresar</button>
    </form>
</body>
</html>

