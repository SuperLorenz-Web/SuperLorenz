<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SuperLorenz</title>
    <style>
        /* Estilos generales */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f7f7f7;
            color: #333;
        }

        /* Encabezado */
        .header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #a168a3;
            padding: 10px 20px;
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
            gap: 15px;
        }

        .header .user-info span {
            cursor: pointer;
        }

        .header .user-info span:hover {
            text-decoration: underline;
        }

        /* Contenedor principal */
        .container {
            display: flex;
            margin-top: 20px;
        }

        /* Barra lateral */
        .sidebar {
            width: 200px;
            background-color: #6a2f88;
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
            justify-content: space-between;
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
            border: 1px solid #ccc;
        }

        .content-header input[type="text"]:focus {
            border-color: #a168a3;
        }

        /* Tabla de contenido */
        .table-container {
            background-color: #fff;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .table-row {
            display: flex;
            justify-content: space-between;
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }

        .table-row:last-child {
            border-bottom: none;
        }

        .table-row:hover {
            background-color: #f2f2f2;
        }

        .cell {
            flex: 1;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Encabezado -->
    <div class="header">
        <div class="logo">
            <img src="imagenes/LogoKonrad.png" alt="Logo SuperLorenz">
            <h1>SuperLorenz</h1>
        </div>
        <div class="user-info">
            <span>¡Hola Pepito!</span>
            <span onclick="logout()">Cerrar Sesión</span>
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
                <li>Compras de Insumos</li>
                <li>Productos</li>
                <li>Pedidos</li>
                <li>Kárdex</li>
            </ul>
        </div>

        <!-- Sección de contenido -->
        <div class="content">
            <div class="content-header">
                <input type="button" value="Nuevo Registro" onclick="addNew()">
                <input type="text" placeholder="Buscar...">
            </div>
            <div class="table-container">
                <div class="table-row">
                    <div class="cell">Producto 1</div>
                    <div class="cell">Descripción 1</div>
                    <div class="cell">$1,000</div>
                </div>
                <div class="table-row">
                    <div class="cell">Producto 2</div>
                    <div class="cell">Descripción 2</div>
                    <div class="cell">$2,000</div>
                </div>
                <div class="table-row">
                    <div class="cell">Producto 3</div>
                    <div class="cell">Descripción 3</div>
                    <div class="cell">$3,000</div>
                </div>
            </div>
        </div>
    </div>

    <script>
        function logout() {
            window.location.href = 'home.html';
        }

        function addNew() {
            alert("Función para añadir un nuevo registro");
        }
    </script>

</body>
</html>

