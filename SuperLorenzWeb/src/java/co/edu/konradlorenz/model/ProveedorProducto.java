
package co.edu.konradlorenz.model;


public class ProveedorProducto {
    private int proveedorProductoID;
    private int productoID;
    private int proveedorID;
    private float valorMinimo;
    private float valorMaximo;
 
    public ProveedorProducto(){
    }

    public int getProveedorProductoID() {
        return proveedorProductoID;
    }

    public void setProveedorProductoID(int proveedorProductoID) {
        this.proveedorProductoID = proveedorProductoID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        this.proveedorID = proveedorID;
    }

    public float getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(float valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public float getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(float valorMaximo) {
        this.valorMaximo = valorMaximo;
    }
    
}
