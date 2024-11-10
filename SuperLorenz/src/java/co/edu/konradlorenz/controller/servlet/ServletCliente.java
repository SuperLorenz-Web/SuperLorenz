package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.dao.*;
import co.edu.konradlorenz.model.enum.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class ServletCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/cliente.jsp").forward(request, response); //TODO: ¿Qué chotas hace esto exactamente?

    
        String numeroDocumento = new String(request.getParameter("numeroDocumento").getBytes("ISO-8859-1"),"UTF-8");
        TipoDocumento tipoDocumento = new String(request.getParameter("tipoDocumento").getBytes("ISO-8859-1"),"UTF-8");
        String nombres = new String(request.getParameter("nombres").getBytes("ISO-8859-1"),"UTF-8");
        String apellidos = new String(request.getParameter("apellidos").getBytes("ISO-8859-1"),"UTF-8");
        String celular = new String(request.getParameter("celular").getBytes("ISO-8859-1"),"UTF-8");
        String correo = new String(request.getParameter("correo").getBytes("ISO-8859-1"),"UTF-8");
        String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8"); 
        TipoCliente tipoCliente = new String(request.getParameter("tipoCliente").getBytes("ISO-8859-1"),"UTF-8");
        String direccion = new String(request.getParameter("direccion").getBytes("ISO-8859-1"),"UTF-8");
        Date fechaNacimiento = new String(request.getParameter("fechaNacimiento").getBytes("ISO-8859-1"),"UTF-8");
        EstadoCivil estadoCivil = new String(request.getParameter("estadoCivil").getBytes("ISO-8859-1"),"UTF-8");
        boolean autorizacionDeDatos = new String(request.getParameter("autorizacionDeDatos").getBytes("ISO-8859-1"),"UTF-8");
        
        Cliente nuevoCliente = new Cliente();
        
        //Persona
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
        return "Servlet para la gestión de la vista de empleado";
    }
    // </editor-fold>
    
}
//class