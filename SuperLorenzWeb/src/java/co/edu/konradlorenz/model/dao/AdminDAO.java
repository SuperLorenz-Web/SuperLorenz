package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.CompraInsumos;
import co.edu.konradlorenz.model.Producto;
import co.edu.konradlorenz.model.enums.Estado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/SuperLorenzWeb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM Producto";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setProductoID(rs.getInt("productoID"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcionProducto(rs.getString("descripcionProducto"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setMarca(rs.getString("marca"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
    // Método para obtener todas las compras de insumos
    public List<CompraInsumos> getComprasInsumos() {
        List<CompraInsumos> compras = new ArrayList<>();
        String sql = "SELECT * FROM CompraInsumos";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Recorrer los resultados de la consulta
            while (rs.next()) {
                CompraInsumos compra = new CompraInsumos();
                compra.setCompraInsumosID(rs.getInt("compraInsumosID"));
                compra.setProveedorProductoID(rs.getInt("proveedorProductoID"));
                compra.setCantidad(rs.getInt("cantidad"));
                String estadoStr = rs.getString("estado");
                Estado estado = Estado.valueOf(estadoStr); // Convierte el string a Enum
                compra.setEstado(estado);
                compra.setFechaCompra(rs.getDate("fechaCompra"));
                compra.setFechaEntrega(rs.getDate("fechaEntrega"));
                compra.setValorTotal(rs.getFloat("valorTotal"));
                
                // Agregar la compra a la lista
                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compras;
    }
}