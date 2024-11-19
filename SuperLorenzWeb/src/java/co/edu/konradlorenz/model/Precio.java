
package co.edu.konradlorenz.model;

import java.util.Date;


public class Precio {
    private int precioID;
    private int productoID;
    private float valorUnitario;
    private float iva;
    private float precioUnitarioTotal;
    private Date fecha;
    
    
    public Precio(){
}

    public int getPrecioID() {
        return precioID;
    }

    public void setPrecioID(int precioID) {
        this.precioID = precioID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getPrecioUnitarioTotal() {
        return precioUnitarioTotal;
    }

    public void setPrecioUnitarioTotal(float precioUnitarioTotal) {
        this.precioUnitarioTotal = precioUnitarioTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}