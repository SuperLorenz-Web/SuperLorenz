<%@ page import="java.util.List" %>
<%@ page import="co.edu.konradlorenz.model.CompraInsumos" %>
<%@ page import="co.edu.konradlorenz.model.enums.Estado" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Comprar Insumos</title>
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
            background-color: #fff;
        }
        #content h1 {
            margin-top: 0;
            text-align: center;
        }
        .insumo-card {
            display: inline-block;
            width: 30%;
            margin: 10px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 2px 2px 5px rgba(0,0,0,0.1);
            text-align: center;
            background-color: #fff;
            transition: transform 0.3s ease;
        }
        .insumo-card:hover {
            transform: translateY(-5px);
        }
        .insumo-card h3 {
            margin: 0;
            color: #6a1b9a;
        }
        .insumo-card p {
            color: #555;
        }
        .insumo-card .estado {
            font-weight: bold;
            color: #ff5722;
        }
        .insumo-card .btn-comprar {
            background-color: #6a1b9a;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            margin-top: 10px;
        }
        .insumo-card .btn-comprar:hover {
            background-color: #8e24aa;
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
        <h1>Comprar Insumos</h1>
        <div class="insumos-container">
            <% 
                List<CompraInsumos> compras = (List<CompraInsumos>) request.getAttribute("compras");
                if (compras != null && !compras.isEmpty()) {
                    for (CompraInsumos compra : compras) {
            %>
                <div class="insumo-card">
                    <h3>Compra ID: <%= compra.getCompraInsumosID() %></h3>
                    <p><strong>Proveedor Producto ID:</strong> <%= compra.getProveedorProductoID() %></p>
                    <p><strong>Cantidad:</strong> <%= compra.getCantidad() %></p>
                    <p><strong>Estado:</strong> <span class="estado"><%= compra.getEstado() %></span></p>
                    <p><strong>Fecha de Compra:</strong> <%= compra.getFechaCompra() %></p>
                    <p><strong>Fecha de Entrega:</strong> <%= compra.getFechaEntrega() %></p>
                    <p><strong>Valor Total:</strong> $<%= compra.getValorTotal() %></p>
                    <a href="comprarInsumos?id=<%= compra.getCompraInsumosID() %>" class="btn-comprar">Comprar</a>
                </div>
            <% 
                    }
                } else {
            %>
                <p>No hay compras de insumos registradas.</p>
            <% 
                }
            %>
        </div>
    </div>
</body>
</html>

