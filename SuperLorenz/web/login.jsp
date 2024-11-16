<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inicio de Sesi�n</title>
<style>
body {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    font-family: Arial, sans-serif;
}
.login-container {
    width: 300px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.login-container h2 {
    text-align: center;
}
.input-field {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}
.login-button {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
.login-button:hover {
    background-color: #45a049;
}
.error-message {
    color: red;
    font-size: 0.9em;
    text-align: center;
}
</style>
</head>
<body>

<div class="login-container">
    <h2>Inicio de Sesi�n</h2>
    
    <!-- Mostrar mensaje de error si existe -->
    <c:if test="${not empty error}">
        <p class="error-message">${error}</p>
    </c:if>
    
    <!-- Formulario de inicio de sesi�n -->
    <form action="LoginCliente" method="post">
        <!-- Campo para el correo -->
        <input type="email" name="correo" class="input-field" placeholder="Correo electr�nico" required>
        <!-- Campo para la contrase�a -->
        <input type="password" name="password" class="input-field" placeholder="Contrase�a" required>
        <!-- Campo oculto para la acci�n -->
        <input type="hidden" name="accion" value="Ingresar">
        <!-- Bot�n de env�o -->
        <button type="submit" class="login-button">Ingresar</button>
    </form>
</div>

</body>
</html>