package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.dao.EmpleadoDAO;
import co.edu.konradlorenz.model.dao.PersonaDAO;
import co.edu.konradlorenz.model.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
                // Si las credenciales son válidas, obtener la persona del usuario
                PersonaDAO personaDAO = new PersonaDAO();
                Persona usuario = personaDAO.obtenerPorCorreo(correo); // Método para obtener la persona por correo

                // Guardar la persona en la sesión
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario); // Almacenamos el usuario en la sesión

                // Redirigir según el tipo de usuario
                String tipoUsuario = empleadoDAO.obtenerTipoUsuario(correo);
                if ("EMPLEADO".equals(tipoUsuario)) {
                    response.sendRedirect("portalEmpleado.jsp"); 
                } else if ("ADMIN".equals(tipoUsuario)) {
                    response.sendRedirect("portalAdmin.jsp"); 
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



