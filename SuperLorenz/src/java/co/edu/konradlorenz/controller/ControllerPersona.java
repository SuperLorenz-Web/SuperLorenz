package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import co.edu.konradlorenz.model.*;

public class ControllerPersona extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        int personaID;
        String personaIDString;
        String documentoID;
        String tipoDocumento;
        String nombre;
        String celular;
    
        personaIDString = new String(request.getParameter("personaID").getBytes("ISO-8859-1"),"UTF-8");
        documentoID = new String(request.getParameter("documentoID").getBytes("ISO-8859-1"),"UTF-8");
        tipoDocumento = new String(request.getParameter("tipoDocumento").getBytes("ISO-8859-1"),"UTF-8");
        nombre = new String(request.getParameter("nombre").getBytes("ISO-8859-1"),"UTF-8");
        celular = new String(request.getParameter("celular").getBytes("ISO-8859-1"),"UTF-8");
    
        try {
            personaID = Integer.parseInt(personaIDString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            personaID = 0; // O un valor por defecto si la conversión falla
        }
        //try-catch
        
        Persona persona = new Persona();
        persona.setPersonaID(personaID);
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