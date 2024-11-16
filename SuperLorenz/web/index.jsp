<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SuperLorenz</title>
        <style>
            /* CSS Unificado */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #f7f7f7;
                color: #333;
            }

            header {
                background-color: #B089B6;
                padding: 10px;
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            .logo {
                display: flex;
                align-items: center;
            }

            .logo img {
                width: 40px;
                height: 40px;
                margin-right: 10px;
            }

            .search-bar {
                display: flex;
                align-items: center;
                flex-grow: 1;
                margin: 0 20px;
            }

            .search-bar input[type="text"] {
                width: 100%;
                padding: 5px;
                border-radius: 4px 0 0 4px;
                border: 1px solid #ccc;
            }

            .search-button {
                background-color: #794f7f;
                border: none;
                padding: 5px 10px;
                color: #fff;
                font-size: 16px;
                cursor: pointer;
                border-radius: 0 4px 4px 0;
            }

            nav .nav-button {
                margin-left: 20px;
                color: #fff;
                background-color: #794f7f;
                border: none;
                padding: 5px 10px;
                border-radius: 4px;
                cursor: pointer;
            }

            nav .user-text {
                font-weight: bold;
                color: white;
            }

            .carousel {
                position: relative;
                overflow: hidden;
                width: 90%;
                height: 300px;
                margin: 20px auto;
                border-radius: 10px;
                background-color: #ffffff;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }

            .carousel-container {
                display: flex;
                transition: transform 0.5s ease;
            }

            .carousel img {
                width: 100%;
                height: 300px;
                object-fit: cover;
            }

            .carousel-button {
                position: absolute;
                top: 50%;
                transform: translateY(-50%);
                font-size: 24px;
                color: #fff;
                background: rgba(0, 0, 0, 0.1);
                border: none;
                padding: 10px;
                cursor: pointer;
                border-radius: 50%;
            }

            .carousel-button.left {
                left: 10px;
            }

            .carousel-button.right {
                right: 10px;
            }

            .product-grid {
                display: grid;
                grid-template-columns: repeat(5, 1fr);
                gap: 20px;
                padding: 20px;
                max-width: 90%;
                margin: 0 auto;
            }

            .product-card {
                background-color: #fff;
                padding: 15px;
                text-align: center;
                border: 1px solid #ddd;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .product-image {
                width: 100%;
                height: 150px;
                object-fit: cover;
                margin-bottom: 10px;
            }

            h3 {
                font-size: 16px;
                margin-bottom: 5px;
            }

            p {
                font-size: 14px;
                color: #666;
                margin-bottom: 10px;
            }

            .price {
                font-size: 18px;
                font-weight: bold;
                color: #e74c3c;
                margin-bottom: 15px;
                display: block;
            }

            .add-to-cart {
                background-color: #794f7f;
                color: #fff;
                border: none;
                padding: 10px 20px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;
            }

            .add-to-cart:hover {
                background-color: #794f7f;
            }
        </style>
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="imagenes/LogoKonrad.png" alt="SuperLorenz Logo">
                <h1>SuperLorenz</h1>
            </div>
            <div class="search-bar">
                <input type="text" placeholder="Buscar producto...">
                <button class="search-button">&#128269;</button>
            </div>





            <nav>
                <button class="nav-button" onclick="goToCart()">Carrito</button>
                <button class="nav-button" onclick="goToEmpleado()">Empleado</button>
                <button class="nav-button" onclick="goToProveedor()">Proveedor</button>
                <button class="nav-button" onclick="goToLogin()">Ingresar</button>    

            </nav>
        </header>

        <main>
            <section class="carousel">
                <div class="carousel-container">
                    <img src="imagenes/carrusel1.png" alt="Imagen Carrusel 1">
                    <img src="imagenes/carrusel2.png" alt="Imagen Carrusel 2">
                    <img src="imagenes/carrusel3.png" alt="Imagen Carrusel 3">
                    <img src="imagenes/carrusel4.png" alt="Imagen Carrusel 4">
                    <img src="imagenes/carrusel5.png" alt="Imagen Carrusel 5">
                    <img src="imagenes/carrusel6.png" alt="Imagen Carrusel 6">
                    <img src="imagenes/carrusel7.png" alt="Imagen Carrusel 7">
                    <img src="imagenes/carrusel8.png" alt="Imagen Carrusel 8">
                </div>
                <button class="carousel-button left" onclick="moveCarousel(-1)">&#10094;</button>
                <button class="carousel-button right" onclick="moveCarousel(1)">&#10095;</button>
            </section>

            <section class="product-grid">
                <div class="product-card">
                    <img src="imagenes/imagen1.png" alt="Producto 1" class="product-image">
                    <h3>Nombre Producto 1</h3>
                    <p>Descripción breve del producto 1.</p>
                    <span class="price">$ 1.988.030</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen2.png" alt="Producto 2" class="product-image">
                    <h3>Nombre Producto 2</h3>
                    <p>Descripción breve del producto 2.</p>
                    <span class="price">$ 2.099.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen3.png" alt="Producto 3" class="product-image">
                    <h3>Nombre Producto 3</h3>
                    <p>Descripción breve del producto 3.</p>
                    <span class="price">$ 1.750.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen4.png" alt="Producto 4" class="product-image">
                    <h3>Nombre Producto 4</h3>
                    <p>Descripción breve del producto 4.</p>
                    <span class="price">$ 1.600.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen5.png" alt="Producto 5" class="product-image">
                    <h3>Nombre Producto 5</h3>
                    <p>Descripción breve del producto 5.</p>
                    <span class="price">$ 1.550.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen6.png" alt="Producto 6" class="product-image">
                    <h3>Nombre Producto 6</h3>
                    <p>Descripción breve del producto 6.</p>
                    <span class="price">$ 1.499.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen7.png" alt="Producto 7" class="product-image">
                    <h3>Nombre Producto 7</h3>
                    <p>Descripción breve del producto 7.</p>
                    <span class="price">$ 1.250.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen8.png" alt="Producto 8" class="product-image">
                    <h3>Nombre Producto 8</h3>
                    <p>Descripción breve del producto 8.</p>
                    <span class="price">$ 1.200.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen9.png" alt="Producto 9" class="product-image">
                    <h3>Nombre Producto 9</h3>
                    <p>Descripción breve del producto 9.</p>
                    <span class="price">$ 1.100.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
                <div class="product-card">
                    <img src="imagenes/imagen10.png" alt="Producto 10" class="product-image">
                    <h3>Nombre Producto 10</h3>
                    <p>Descripción breve del producto 10.</p>
                    <span class="price">$ 1.050.000</span>
                    <button class="add-to-cart">Agregar</button>
                </div>
            </section>
        </main>

        <script>
            // JavaScript Unificado
            let currentIndex = 0;

            function moveCarousel(direction) {
                const carouselContainer = document.querySelector('.carousel-container');
                const images = carouselContainer.children;
                const totalImages = images.length;

                currentIndex = (currentIndex + direction + totalImages) % totalImages;
                const offset = -currentIndex * 100;
                carouselContainer.style.transform = `translateX(${offset}%)`;
            }

            function goToCart() {
                window.location.href = 'Carrito_de_compras.html';
            }

            function logout() {
                window.location.href = 'home.html';
            }
        </script>
    </body>
</html>



