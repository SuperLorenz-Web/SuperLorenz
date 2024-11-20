package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.Precio;
import co.edu.konradlorenz.model.Producto;
import co.edu.konradlorenz.model.connection.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private final Conexion conexionBD = new Conexion();
    private PrecioDAO precioDAO;
    
    public ProductoDAO() {
    this.precioDAO = new PrecioDAO();
    }

    // Obtener un producto por su ID, incluyendo el precio
    public Producto getProductoByID(int productoID) throws SQLException {
        String query = "SELECT * FROM Producto p WHERE productoID = ?";
        try (Connection con = conexionBD.crearConexion()) {
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, productoID);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Producto producto = mapResultSetToProducto(rs);
                        // Recuperar el precio del producto
                        Precio precio = precioDAO.getPrecioByID(producto.getProductoID());
                        if (precio != null) {
                            // Aquí podrías relacionar el precio con el producto si es necesario
                            System.out.println("Precio asociado: " + precio.getPrecioUnitarioTotal());
                        }
                        return producto;
                    }
                }
            }
            return null;
        }
    }

    // Obtener todos los productos, incluyendo sus precios
    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM Producto p";
        try (Connection connection = conexionBD.crearConexion();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setProductoID(resultSet.getInt("productoID"));
                producto.setNombreProducto(resultSet.getString("nombreProducto"));
                producto.setDescripcionProducto(resultSet.getString("descripcionProducto"));
                producto.setCategoria(resultSet.getString("categoria"));
                producto.setMarca(resultSet.getString("marca"));
                productos.add(producto);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return productos;
    }

    // Mapeo de ResultSet a objeto Producto
    private Producto mapResultSetToProducto(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setProductoID(rs.getInt("productoID"));
        producto.setNombreProducto(rs.getString("nombreProducto"));
        producto.setDescripcionProducto(rs.getString("descripcionProducto"));
        producto.setCategoria(rs.getString("categoria"));
        producto.setMarca(rs.getString("marca"));
        return producto;
    }
}