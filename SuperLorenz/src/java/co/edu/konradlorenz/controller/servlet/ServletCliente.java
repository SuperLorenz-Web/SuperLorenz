package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.dao.*;
import co.edu.konradlorenz.model.enums.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.*;
import java.util.*;

public class ServletCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //request.getRequestDispatcher("/cliente.jsp").forward(request, response); //TODO: Creo que está linea va al final.

        //try-catch para ParseException
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
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
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
                response.sendRedirect("mensaje.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
            //if
            
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
        //try-catch
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
        return "Servlet para la gestión de la vista de cliente";
    }
    // </editor-fold>
    
}
//class