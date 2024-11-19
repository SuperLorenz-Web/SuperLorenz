package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter; 

@WebServlet(name = "ServletPersona", urlPatterns = {"/ServletPersona"})
public class ServletPersona extends HttpServlet {
    private final PersonaDAO personaDAO = new PersonaDAO(); // Instancia del DAO

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        String numeroDocumento = request.getParameter("cedula");
        String password = request.getParameter("password");

        // Responder al cliente
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (personaDAO.validarCredenciales(numeroDocumento, password)) {
                // Si las credenciales son válidas, obtener el tipo de usuario
                String tipoUsuario = personaDAO.obtenerTipoUsuario(numeroDocumento);

                // Redirigir según el tipo de usuario
                if ("CLIENTE".equals(tipoUsuario)) {
                    response.sendRedirect("cliente.jsp"); // Página para clientes
                } else if ("PROVEEDOR".equals(tipoUsuario)) {
                    response.sendRedirect("proveedor.jsp"); // Página para proveedores
                } else if ("EMPLEADO".equals(tipoUsuario)) {
                    response.sendRedirect("empleado.jsp"); // Página para empleados
                } else {
                    out.println("<h1>Tipo de usuario no reconocido.</h1>");
                }
            } else {
                out.println("<h1>Error: Credenciales incorrectas</h1>");
                out.println("<p>Por favor, intenta nuevamente.</p>");
            }
        }
    }
}