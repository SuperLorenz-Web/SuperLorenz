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

/*
public class ServletPersona extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String documentoID;
        String tipoDocumento;
        String nombre;
        String celular;
    
        documentoID = new String(request.getParameter("documentoID").getBytes("ISO-8859-1"),"UTF-8");
        tipoDocumento = new String(request.getParameter("tipoDocumento").getBytes("ISO-8859-1"),"UTF-8");
        nombre = new String(request.getParameter("nombre").getBytes("ISO-8859-1"),"UTF-8");
        celular = new String(request.getParameter("celular").getBytes("ISO-8859-1"),"UTF-8");
        
        Persona persona = new Persona();
        persona.setDocumentoID(documentoID);
        persona.setTipoDocumento(tipoDocumento);
        persona.setNombre(nombre);
        persona.setCelular(celular);
        
        int status = PersonaDAO.agregarPersona(persona);
        
        if (status > 0){
            response.sendRedirect("mensaje.jsp");
        }
        //if
        
    }
    //processRequest
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>

}
//class
*/