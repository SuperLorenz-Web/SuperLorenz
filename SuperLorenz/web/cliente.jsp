<%-- 
    Document   : cliente
    Created on : 7/11/2024, 8:33:24 p. m.
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SuperLorenz</title>
    <style>
        
        p{
            color:black;
        }
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #333;
            color: white;
        }
        .header {
            background-color: #B07CB6;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header .logo {
            display: flex;
            align-items: center;
        }
        .header img {
            height: 40px;
            margin-right: 10px;
        }
        .header input[type="text"] {
            padding: 5px;
            border-radius: 5px;
            border: none;
            width: 300px;
        }
        .header .nav-links {
            display: flex;
            gap: 15px;
        }
        .carousel-container {
            background-color: #4C1166;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        .carousel-item {
            background-color: #6D217F;
            padding: 15px;
            border-radius: 8px;
            text-align: center;
            color: white;
            flex: 1;
            margin: 0 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .carousel-item .image-container {
            height: 100px;
            width: 100px;
            margin-bottom: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #E7D845;
            clip-path: polygon(50% 0%, 100% 25%, 82% 100%, 18% 100%, 0% 25%);
        }
        .carousel-buttons {
            color: #E7D845;
            cursor: pointer;
            font-size: 30px;
        }
        .container {
            width: 80%;
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
            background-color: #4C1166;
            padding: 20px;
            border-radius: 8px;
            margin: 0 auto;
        }
        .product-card {
            background-color: #6D217F;
            padding: 15px;
            border-radius: 8px;
            text-align: center;
            color: white;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }
        .product-card .image-container {
            height: 100px;
            width: 100px;
            margin: 0 auto;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #E7D845;
            clip-path: polygon(50% 0%, 100% 25%, 82% 100%, 18% 100%, 0% 25%);
        }
        .product-card .image-container span {
            color: #6D217F;
            font-weight: bold;
        }
        .product-info {
            margin: 10px 0;
        }
        .plus-btn {
            cursor: pointer;
            font-size: 20px;
            color: #E7D845;
            background: none;
            border: none;
            padding: 5px;
            margin-top: 10px;
            align-self: center;
        }
    </style>
</head>
<body>
    <header class="header">
        <div class="logo">
            <img src="logo.png" alt="SuperLorenz Logo">
            <span>SuperLorenz</span>
        </div>
        <input type="text" placeholder="Buscar producto...">
        <div class="nav-links">
            <a href="#">Carrito</a>
            <a>Hola Usuario</a>
            <a href="#">Cerrar sesión</a>
        </div>
    </header>

    <div class="carousel-container">
        <span class="carousel-buttons">&lt;</span>
        <div class="carousel-item">
            <div class="image-container">
                <span>Imagen de Producto</span>
            </div>
            <strong>Nombre Producto</strong><br>
            Descripción de producto.<br>
            Precio producto.
        </div>
        <div class="carousel-item">
            <div class="image-container">
                <span>Imagen de Producto</span>
            </div>
            <strong>Nombre Producto</strong><br>
            Descripción de producto.<br>
            Precio producto.
        </div>
        <span class="carousel-buttons">&gt;</span>
    </div>

    <div class="container">
        <!-- Card 1 -->
        <div class="product-card">
            <div class="image-container">
                <span>Imagen de Producto</span>
            </div>
            <div class="product-info">
                <strong>Nombre Producto</strong><br>
                Descripción de producto.<br>
                Precio producto.
            </div>
            <button class="plus-btn">+</button>
        </div>
        <!-- Card 2 -->
        <div class="product-card">
            <div class="image-container">
                <span>Imagen de Producto</span>
            </div>
            <div class="product-info">
                <strong>Nombre Producto</strong><br>
                Descripción de producto.<br>
                Precio producto.
            </div>
            <button class="plus-btn">+</button>
        </div>
        <!-- Card 3 -->
        <div class="product-card">
            <div class="image-container">
                <span>Imagen de Producto</span>
            </div>
            <div class="product-info">
                <strong>Nombre Producto</strong><br>
                Descripción de producto.<br>
                Precio producto.
            </div>
            <button class="plus-btn">+</button>
        </div>
        <!-- Card 4 -->
        <div class="product-card">
            <div class="image-container">
                <span>Imagen de Producto</span>
            </div>
            <div class="product-info">
                <strong>Nombre Producto</strong><br>
                Descripción de producto.<br>
                Precio producto.
            </div>
            <button class="plus-btn">+</button>
        </div>
    </div>
</body>
</html>
