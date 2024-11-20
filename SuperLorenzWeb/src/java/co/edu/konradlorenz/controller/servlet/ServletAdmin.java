package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletAdmin", urlPatterns = {"/ServletAdmin"})
public class ServletAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Instancia de AdminDAO
    private AdminDAO adminDAO;

    public void init() {
        adminDAO = new AdminDAO(); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = ""; 
        }

        switch (action) {
            case "verProductos":
                List<Producto> productos = adminDAO.obtenerProductos();
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("botonProductos.jsp").forward(request, response);                break;
            case "comprarInsumos":
                List<CompraInsumos> compras = adminDAO.getComprasInsumos();
                request.setAttribute("compras", compras);
                request.getRequestDispatcher("botonCompraInsumos.jsp").forward(request, response);
                break;
            default:
                response.getWriter().append("Acción no válida");
                break;
        }
    }
}

