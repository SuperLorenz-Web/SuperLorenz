package co.edu.konradlorenz.model;

public abstract class Persona {
    
    protected int personaID;
    protected String numeroDocumento;
    protected String tipoDocumento;
    protected String nombres;
    protected String apellidos;
    protected String celular;
    protected String correo;
    protected String password;

    public Persona() {
    }

    public Persona(String numeroDocumento, String tipoDocumento, String nombres, String apellidos, String celular, String correo) {
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.password = password;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String correo){
        this.password = password;
    }

    @Override
    public String toString() {
        return "Persona{" + "personaID=" + personaID + ", numeroDocumento=" + numeroDocumento + ", tipoDocumento=" + tipoDocumento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", celular=" + celular + ", correo=" + correo + ", password=" + password + '}';
    }

}

    

   