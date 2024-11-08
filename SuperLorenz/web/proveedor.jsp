<%-- 
    Document   : proveedor
    Created on : 7/11/2024, 8:20:53 p. m.
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
