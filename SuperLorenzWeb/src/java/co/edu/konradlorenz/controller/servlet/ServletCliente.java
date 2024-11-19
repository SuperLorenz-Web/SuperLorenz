package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.dao.*;
import co.edu.konradlorenz.model.enums.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class ServletCliente extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action"); // Identifica la acción solicitada

        if ("register".equals(action)) {
            registerClient(request, response);
        } else if ("login".equals(action)) {
            loginClient(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
        }
        
    }
    //processRequest

    //Abre: registerClient
    private void registerClient(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try{
            //Persona:
            String numeroDocumento = request.getParameter("numeroDocumento");
            TipoDocumento tipoDocumento = TipoDocumento.valueOf(request.getParameter("tipoDocumento")); // Enum conversion
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String celular = request.getParameter("celular");
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            
            //Cliente:
            TipoCliente tipoCliente = TipoCliente.valueOf(request.getParameter("tipoCliente")); // Enum conversion
            String direccion = request.getParameter("direccion");
            //Conversión de fecha de String a Date
                String fechaStr = request.getParameter("fechaNacimiento");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaNacimiento = formatter.parse(fechaStr);
            EstadoCivil estadoCivil = EstadoCivil.valueOf(request.getParameter("estadoCivil"));
            boolean autorizacionDeDatos = Boolean.parseBoolean(request.getParameter("autorizacionDeDatos"));

            Cliente nuevoCliente = new Cliente();
        
            //Persona:
            nuevoCliente.setNumeroDocumento(numeroDocumento);
            nuevoCliente.setTipoDocumento(tipoDocumento);
            nuevoCliente.setNombres(nombres);
            nuevoCliente.setApellidos(apellidos);
            nuevoCliente.setCelular(celular);
            nuevoCliente.setCorreo(correo);
            nuevoCliente.setPassword(password);
        
            //Cliente:
            nuevoCliente.setTipoCliente(tipoCliente);
            nuevoCliente.setDireccion(direccion);
            nuevoCliente.setFechaNacimiento(fechaNacimiento);
            nuevoCliente.setEstadoCivil(estadoCivil);
            nuevoCliente.setAutorizacionDeDatos(autorizacionDeDatos);

            int status = ClienteDAO.agregarCliente(nuevoCliente);
        
            if (status > 0){
                response.sendRedirect("mensaje.jsp?msg=registro-exitoso");
            } else {
                response.sendRedirect("error.jsp?msg=registro-fallido");
            }
            //if
            
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
        //try-catch
        
        //request.getRequestDispatcher("/cliente.jsp").forward(request, response); //TODO: Creo que está linea va al final.
    }
    //Cierra: registerClient
    
    //Abre: loginClient
    private void loginClient(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        Cliente cliente = ClienteDAO.iniciarSesion(correo, password);

        if (cliente != null) {
            // Crear sesión y redirigir al dashboard
            HttpSession session = request.getSession(true);
            session.setAttribute("cliente", cliente);
            response.sendRedirect("dashboard.jsp");
        } else {
            // Redirigir al formulario de inicio de sesión con error
            response.sendRedirect("login.jsp?msg=credenciales-invalidas");
        }
    }
    //Cierra: loginClient
    
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
        return "Servlet para la gestión de la vista de cliente";
    }
    // </editor-fold>
    
}
//class