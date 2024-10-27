<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> SuperLorenz Web </title>
    </head>
    <body>
        <h1>Formulario Persona</h1>
        <form id="form1" name="form1" action="ServletPersona" method="POST" >
            <p><label>ID Persona: </label><input type="text" name="personaID"></p>
            <p><label>Número de documento: </label><input type="text" name="documentoID"></p>
            <p><label>Tipo de documento: </label><input type="text" name="tipoDocumento"></p>
            <p><label>Nombre: </label><input type="text" name="nombre"></p>
            <p><label>Celular: </label><input type="text" name="celular"></p>
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
