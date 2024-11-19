<%-- 
    Document   : empleado
    Created on : 18/11/2024, 5:19:51 p. m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SuperLorenz - Empleado</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #ddd;
        }

        /* Encabezado */
        .header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #a168a3;
            padding: 10px;
            color: white;
        }

        .header .logo {
            display: flex;
            align-items: center;
        }

        .header .logo img {
            width: 40px;
            height: 40px;
            margin-right: 10px;
        }

        .header .user-info {
            display: flex;
            gap: 20px;
        }

        /* Contenedor principal */
        .container {
            display: flex;
        }

        /* Barra lateral */
        .sidebar {
            width: 200px;
            background-color: #6a2f88; /* Color de fondo morado fuerte */
            padding: 20px 0;
            color: white;
            text-align: center;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
        }

        .sidebar ul li {
            padding: 15px 0;
            cursor: pointer;
        }

        .sidebar ul li:hover {
            background-color: #8c4ea8;
        }

        /* Sección de contenido */
        .content {
            flex-grow: 1;
            padding: 20px;
        }

        .content-header {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
        }

        .content-header input[type="button"] {
            background-color: #a168a3;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        .content-header input[type="text"] {
            padding: 10px;
            width: 200px;
        }

        /* Tabla de contenido */
        .table-container {
            background-color: #b48ebf;
            padding: 10px;
            border-radius: 8px;
        }

        .table-row {
            display: flex;
            justify-content: space-between;
            background-color: #d8aad7;
            height: 40px;
            margin-bottom: 10px;
            padding: 0 10px;
            align-items: center;
        }

        .table-row:hover {
            background-color: #b78cd5;
        }

        .table-row .cell {
            flex: 1;
            text-align: center;
        }

    </style>
</head>
<body>

    <!-- Encabezado -->
    <div class="header">
        <div class="logo">
            <img src="img/logo.png" alt="Logo">
            <h1>SuperLorenz</h1>
        </div>
        <div class="user-info">
            <span>¡Hola Juan!</span>
            <span>Cerrar Sesión</span>
        </div>
    </div>

    <!-- Contenedor principal -->
    <div class="container">
        <!-- Barra lateral -->
        <div class="sidebar">
            <ul>
                <li>Mi Cuenta</li>
                <li>Proveedores</li>
                <li>Clientes</li>
                <li>Pedidos</li>
                <li>Productos</li>
                <li>Informes de Ventas</li>
                <li>Gestión de Empleados</li>
            </ul>
        </div>

        <!-- Sección de contenido -->
        <div class="content">
            <!-- Encabezado de la sección de contenido -->
            <div class="content-header">
                <input type="button" value="Nuevo Pedido">
                <input type="text" placeholder="Buscar productos...">
            </div>

            <!-- Tabla de contenido -->
            <div class="table-container">
                <!-- Filas de la tabla (simulación) -->
                <div class="table-row">
                    <div class="cell">Pedido #001</div>
                    <div class="cell">Juan Pérez</div>
                    <div class="cell">Pendiente</div>
                    <div class="cell">Ver Detalles</div>
                </div>
                <div class="table-row">
                    <div class="cell">Pedido #002</div>
                    <div class="cell">María López</div>
                    <div class="cell">Enviado</div>
                    <div class="cell">Ver Detalles</div>
                </div>
                <div class="table-row">
                    <div class="cell">Pedido #003</div>
                    <div class="cell">Carlos García</div>
                    <div class="cell">Pendiente</div>
                    <div class="cell">Ver Detalles</div>
                </div>
                <!-- Más filas -->
            </div>
        </div>
    </div>

</body>
</html>