<%@page import="java.util.List"%>
<%@page import="co.edu.konradlorenz.model.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos Registrados</title>
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
        }
        #content h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #6a1b9a;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
    <div id="menu">
        <img src="imagenes/LogoKonrad.png" alt="SuperLorenz Logo">
        <h2>Menú Administrador</h2>
        <ul>
            <li><a href="ServletAdmin?action=verProductos">Ver Productos</a></li>
            <li><a href="ServletAdmin?action=comprarInsumos">Comprar Insumos</a></li>
            <li><a href="sell-products.html">Venta de Productos</a></li>
            <li><a href="kardex.html">Kardex</a></li>
            <li><a href="view-suppliers.html">Ver Proveedores</a></li>
        </ul>
    </div>
    <div id="content">
        <h1>Lista de Productos</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Categoría</th>
                    <th>Marca</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                    if (productos != null && !productos.isEmpty()) {
                        for (Producto producto : productos) {
                %>
                            <tr>
                                <td><%= producto.getProductoID() %></td>
                                <td><%= producto.getNombreProducto() %></td>
                                <td><%= producto.getDescripcionProducto() %></td>
                                <td><%= producto.getCategoria() %></td>
                                <td><%= producto.getMarca() %></td>
                            </tr>
                <%
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="5" style="text-align: center;">No hay productos registrados</td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>