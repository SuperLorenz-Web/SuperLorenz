package co.edu.konradlorenz.controller.servlet;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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