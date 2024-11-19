package co.edu.konradlorenz.model;

import co.edu.konradlorenz.model.enums.TipoDocumento;
import co.edu.konradlorenz.model.enums.TipoProveedor;

public class Proveedor extends Persona {
    private int proveedorID;
    private int personaID; 
    private TipoProveedor tipoProveedor;
    private String nombreContacto;
    private String numeroContacto;
    
    public Proveedor(){
    }

    public Proveedor(int proveedorID, int personaID, TipoProveedor tipoProveedor, String nombreContacto, String numeroContacto) {
        this.proveedorID = proveedorID;
        this.personaID = personaID;
        this.tipoProveedor = tipoProveedor;
        this.nombreContacto = nombreContacto;
        this.numeroContacto = numeroContacto;
    }

    public Proveedor(int proveedorID, int personaID, TipoProveedor tipoProveedor, String nombreContacto, String numeroContacto, String numeroDocumento, String tipoDocumento, String nombres, String apellidos, String celular, String correo) {
        this.proveedorID = proveedorID;
        this.personaID = personaID;
        this.tipoProveedor = tipoProveedor;
        this.nombreContacto = nombreContacto;
        this.numeroContacto = numeroContacto;
    }

    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        this.proveedorID = proveedorID;
    }

    public int getPersonaID() {
        return personaID;
    }

    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }

    public TipoProveedor getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(TipoProveedor tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
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