package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.dao.ProveedorDAO;
import co.edu.konradlorenz.model.Proveedor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProveedor", urlPatterns = {"/ServletProveedor"})
public class ServletProveedor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) {
            action = ""; 
        }

        switch (action) {
            case "verProveedores":
                ProveedorDAO proveedorDAO = new ProveedorDAO();
                List<Proveedor> proveedores = proveedorDAO.getAllProveedores();  
                request.setAttribute("proveedores", proveedores);
                request.getRequestDispatcher("/botonProveedores.jsp").forward(request, response);
                break;
            default:
                response.getWriter().append("Acción no válida");
                break;
        }
    }

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
        return "Servlet para la gestión de proveedores";
    }
}



