<%-- 
    Document   : proveedor
<<<<<<< HEAD
    Created on : 7/11/2024, 8:20:53 p. m.
    Author     : usuario
=======
    Created on : 18/11/2024, 5:19:20 p. m.
    Author     : Usuario
>>>>>>> 18fe666 (Conexión base datos - interfaces)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<<<<<<< HEAD
    <title>Proveedores</title>
    <style>
        :root {
            --menu-bg-color: #333;
            --menu-hover-color: #575757;
            --content-bg-color: #f4f4f4;
            --text-color: #fff;
            --table-border-color: #ddd;
        }

        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            height: 100vh;
            background-color: var(--content-bg-color);
        }
        #menu {
            width: 200px;
            background-color: #6a1b9a; /* Morado oscuro */
            color: var(--text-color);
            padding: 15px;
            box-shadow: 2px 0 5px rgba(0,0,0,0.1);
            height: 100%;
            position: fixed;
        }
        #menu h2 {
            margin-top: 0;
        }
        #menu ul {
            list-style: none;
            padding: 0;
        }
        #menu ul li {
            margin: 10px 0;
        }
        #menu ul li a {
            color: var(--text-color);
            text-decoration: none;
            font-size: 16px;
            display: block;
            padding: 10px;
            border-radius: 4px;
        }
        #menu ul li a:hover {
             background-color: #8e24aa; /* Morado claro */
        }
        #content {
            margin-left: 220px;
            padding: 20px;
            width: calc(100% - 220px);
            overflow-y: auto;
            background-image: url(https://lists.office.com/Images/299a2881-1380-4020-b42f-715a35e1bcaf/5616957d-4af4-42cd-9328-9855b17805a5/T9LCYIWXXHO7DEXFJXW93GTRCN/aa364d76-7f78-40e2-a72f-17891fbce1b3);
        }
        
        #content h1 {
            margin-top: 0;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid var(--table-border-color);
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <div id="menu">
        <h2>Menú</h2>
        <ul>
            <li><a href="client-dashboard.html">Dashboard Cliente</a></li>
            <li><a href="provider-dashboard.html">Proveedores</a></li>
        </ul>
    </div>
    <div id="content">
        <h1>Proveedores</h1>
        <table>
            <thead>
                <tr>
                    <th>Nombres</th>
                    <th>Productos</th>
                    <th>Opción de Compra</th>
                </tr>
            </thead>
            <tbody id="provider-table-body">
                <!-- Aquí se cargarán los proveedores dinámicamente -->
            </tbody>
        </table>
    </div>

    <script>
        const isAdmin = true; // Cambia a false si el usuario no es administrador

        const providers = [
            { name: "Proveedor Ejemplo", products: "Producto A, Producto B" },
            { name: "Proveedor 2", products: "Producto C, Producto D" },
            // Agrega más proveedores según sea necesario
        ];

        function loadProviders() {
            const tableBody = document.getElementById('provider-table-body');
            tableBody.innerHTML = ''; // Limpiar contenido previo

            providers.forEach(provider => {
                const row = document.createElement('tr');

                const nameCell = document.createElement('td');
                nameCell.textContent = provider.name;
                row.appendChild(nameCell);

                const productsCell = document.createElement('td');
                productsCell.textContent = provider.products;
                row.appendChild(productsCell);

                const optionCell = document.createElement('td');
                if (isAdmin) {
                    const buyLink = document.createElement('a');
                    buyLink.href = "buy-supplies.html";
                    buyLink.textContent = "Comprar";
                    optionCell.appendChild(buyLink);
                } else {
                    optionCell.textContent = "No autorizado";
                }
                row.appendChild(optionCell);

                tableBody.appendChild(row);
            });
        }

        loadProviders();
    </script>
</body>
</html>
=======
    <title>SuperLorenz - Proveedores</title>
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
                <li>Mis Ventas</li>
                <li>Mis Productos</li>
            </ul>
        </div>

        <!-- Sección de contenido -->
        <div class="content">
            <!-- Encabezado de la sección de contenido -->
            <div class="content-header">
                <input type="button" value="Nuevo Proveedor">
                <input type="text" placeholder="Buscar proveedor...">
            </div>

            <!-- Tabla de proveedores -->
            <div class="table-container">
                <!-- Filas de la tabla (simulación) -->
                <div class="table-row">
                    <div class="cell">Proveedor #001</div>
                    <div class="cell">Proveedor A</div>
                    <div class="cell">Activo</div>
                    <div class="cell">Ver Detalles</div>
                </div>
                <div class="table-row">
                    <div class="cell">Proveedor #002</div>
                    <div class="cell">Proveedor B</div>
                    <div class="cell">Inactivo</div>
                    <div class="cell">Ver Detalles</div>
                </div>
                <div class="table-row">
                    <div class="cell">Proveedor #003</div>
                    <div class="cell">Proveedor C</div>
                    <div class="cell">Activo</div>
                    <div class="cell">Ver Detalles</div>
                </div>
                <!-- Más filas -->
            </div>
        </div>
    </div>

</body>
</html>


>>>>>>> 18fe666 (Conexión base datos - interfaces)
