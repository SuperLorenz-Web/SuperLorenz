package co.edu.konradlorenz.model;

public class Empleado extends Persona{
    
    
    private int empleadoID;
    private int personaID;
    private String cargo;
    private String dependencia;
    private String tipoContrato;
    private String eps;
    private String arl;
    private String nombreEmergencia;
    private String celularEmergencia;

    public Empleado() {
    }

    public Empleado(int empleadoID, int personaID, String cargo, String dependencia, String tipoContrato, String eps, String arl, String nombreEmergencia, String celularEmergencia) {
        this.empleadoID = empleadoID;
        this.personaID = personaID;
        this.cargo = cargo;
        this.dependencia = dependencia;
        this.tipoContrato = tipoContrato;
        this.eps = eps;
        this.arl = arl;
        this.nombreEmergencia = nombreEmergencia;
        this.celularEmergencia = celularEmergencia;
    }

    public Empleado(int empleadoID, int personaID, String cargo, String dependencia, String tipoContrato, String eps, String arl, String nombreEmergencia, String celularEmergencia, String numeroDocumento, String tipoDocumento, String nombres, String apellidos, String celular, String correo) {
        super(numeroDocumento, tipoDocumento, nombres, apellidos, celular, correo);
        this.empleadoID = empleadoID;
        this.personaID = personaID;
        this.cargo = cargo;
        this.dependencia = dependencia;
        this.tipoContrato = tipoContrato;
        this.eps = eps;
        this.arl = arl;
        this.nombreEmergencia = nombreEmergencia;
        this.celularEmergencia = celularEmergencia;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public int getPersonaID() {
        return personaID;
    }

    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getNombreEmergencia() {
        return nombreEmergencia;
    }

    public void setNombreEmergencia(String nombreEmergencia) {
        this.nombreEmergencia = nombreEmergencia;
    }

    public String getCelularEmergencia() {
        return celularEmergencia;
    }

    public void setCelularEmergencia(String celularEmergencia) {
        this.celularEmergencia = celularEmergencia;
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

