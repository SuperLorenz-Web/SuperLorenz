package co.edu.konradlorenz.model;

public class Persona {
    
    protected int personaID;
    protected String documentoID;
    protected String tipoDocumento;
    protected String nombre;
    protected String celular;

    public Persona() {
    }

    public Persona(int personaID, String documentoID, String tipoDocumento, String nombre, String celular) {
        this.personaID = personaID;
        this.documentoID = documentoID;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.celular = celular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getPersonaID() {
        return personaID;
    }

    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }

    public String getDocumentoID() {
        return documentoID;
    }

    public void setDocumentoID(String documentoID) {
        this.documentoID = documentoID;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
//class
