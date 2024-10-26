package co.edu.konradlorenz.model;

public class Empleado extends Persona{
    
    private int empleadoID;
    private String cargo;
    private String dependencia;
    private String tipoContrato;
    private String eps;
    private String arl;
    private String nombreEmergencia;
    private String celularEmergencia;

    public Empleado() {
    }

    public Empleado(int empleadoID, String cargo, String dependencia, String tipoContrato, String eps, String arl, String nombreEmergencia, String celularEmergencia, int personaID, String documentoID, String tipoDocumento, String nombre, String celular) {
        super(personaID, documentoID, tipoDocumento, nombre, celular);
        this.empleadoID = empleadoID;
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
    
}
