package co.edu.konradlorenz.model;

import java.util.Date;

public class Cliente extends Persona {
    private int clienteID;
    private int personaID;
    private String direccion;
    private String tipoCliente;
    private Date fechaNacimiento;
    private String estadoCivil;
    private boolean autorizacionDeDatos;
    
    public Cliente() {
}

    public Cliente(int clienteID, int personaID, String direccion, String tipoCliente, Date fechaNacimiento, String estadoCivil, boolean autorizacionDeDatos) {
        this.clienteID = clienteID;
        this.personaID = personaID;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.autorizacionDeDatos = autorizacionDeDatos;
    }

    public Cliente(int clienteID, int personaID, String direccion, String tipoCliente, Date fechaNacimiento, String estadoCivil, boolean autorizacionDeDatos, String numeroDocumento, String tipoDocumento, String nombres, String apellidos, String celular, String correo) {
        super(numeroDocumento, tipoDocumento, nombres, apellidos, celular, correo);
        this.clienteID = clienteID;
        this.personaID = personaID;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.autorizacionDeDatos = autorizacionDeDatos;
    }
    
    public Cliente(int clienteID, int personaID, String direccion, String tipoCliente, Date fechaNacimiento, boolean autorizacionDeDatos) {
        this.clienteID = clienteID;
        this.personaID = personaID;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.autorizacionDeDatos = autorizacionDeDatos;
    }

    public Cliente(int clienteID, int personaID, String direccion, String tipoCliente, Date fechaNacimiento, boolean autorizacionDeDatos, String numeroDocumento, String tipoDocumento, String nombres, String apellidos, String celular, String correo) {
        super(numeroDocumento, tipoDocumento, nombres, apellidos, celular, correo);
        this.clienteID = clienteID;
        this.personaID = personaID;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.autorizacionDeDatos = autorizacionDeDatos;
    }
    
    public Cliente(int clienteID, int personaID, String direccion, String tipoCliente, boolean autorizacionDeDatos) {
        this.clienteID = clienteID;
        this.personaID = personaID;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
        this.autorizacionDeDatos = autorizacionDeDatos;
    }

    public Cliente(int clienteID, int personaID, String direccion, String tipoCliente, boolean autorizacionDeDatos, String numeroDocumento, String tipoDocumento, String nombres, String apellidos, String celular, String correo) {
        super(numeroDocumento, tipoDocumento, nombres, apellidos, celular, correo);
        this.clienteID = clienteID;
        this.personaID = personaID;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
        this.autorizacionDeDatos = autorizacionDeDatos;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getPersonaID() {
        return personaID;
    }

    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isAutorizacionDeDatos() {
        return autorizacionDeDatos;
    }

    public void setAutorizacionDeDatos(boolean autorizacionDeDatos) {
        this.autorizacionDeDatos = autorizacionDeDatos;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


