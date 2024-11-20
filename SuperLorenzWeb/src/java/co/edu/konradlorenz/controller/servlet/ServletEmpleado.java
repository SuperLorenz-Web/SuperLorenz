package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.dao.EmpleadoDAO;
import co.edu.konradlorenz.model.dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletEmpleado", urlPatterns = {"/ServletEmpleado"})
public class ServletEmpleado extends HttpServlet {
    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO(); // Instancia del DAO

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        String correo = request.getParameter("email");
        String password = request.getParameter("password");

        // Responder al cliente
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (empleadoDAO.validarCredenciales(correo, password)) {
                // Si las credenciales son válidas, obtener el tipo de usuario
                String tipoUsuario = empleadoDAO.obtenerTipoUsuario(correo);

                // Redirigir según el tipo de usuario
                if ("EMPLEADO".equals(tipoUsuario)) {
                    response.sendRedirect("empleado.jsp"); // Página para clientes
                } else if ("ADMIN".equals(tipoUsuario)) {
                    response.sendRedirect("admin.jsp"); // Página para empleados
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


