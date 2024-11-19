<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Administrador</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            height: 100vh;
            background-color: #f4f4f4;
        }
        #menu {
            width: 220px;
            background-color: #6a1b9a; /* Morado oscuro */
            color: #fff;
            padding: 20px;
            box-shadow: 2px 0 5px rgba(0,0,0,0.1);
            height: 100%;
            position: fixed;
        }
        #menu h2 {
            margin-top: 0;
            color: #fff;
        }
        #menu ul {
            list-style: none;
            padding: 0;
        }
        #menu ul li {
            margin: 10px 0;
        }
        #menu ul li a {
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            display: block;
            padding: 10px;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        #menu ul li a:hover {
            background-color: #8e24aa; /* Morado claro */
        }
        #content {
            margin-left: 240px;
            padding: 20px;
            width: calc(100% - 240px);
            overflow-y: auto;
            background-image: url(https://lists.office.com/Images/299a2881-1380-4020-b42f-715a35e1bcaf/5616957d-4af4-42cd-9328-9855b17805a5/T9LCYIWXXHO7DEXFJXW93GTRCN/aa364d76-7f78-40e2-a72f-17891fbce1b3);
        }
        #content h1 {
            margin-top: 0;
        }
    </style>
</head>
<body>
    <div id="menu">
        <h2>Menú Administrador</h2>
        <ul>
            <li><a href="admin-products.html">Ver Productos</a></li>
            <li><a href="buy-supplies.html">Comprar Insumos</a></li>
            <li><a href="sell-products.html">Venta de Productos</a></li>
            <li><a href="kardex.html">Kardex</a></li>
            <li><a href="view-suppliers.html">Ver Proveedores</a></li>
        </ul>
    </div>
    <div id="content">
        <h1>Bienvenido, Administrador</h1>
        <p>Selecciona una opción del menú para ver más detalles.</p>
    </div>
</body>
</html>