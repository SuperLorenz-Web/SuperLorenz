package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.Proveedor;
import co.edu.konradlorenz.model.enums.TipoProveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/SuperLorenzWeb";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public List<Proveedor> getAllProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setProveedorID(rs.getInt("proveedorID"));
                proveedor.setPersonaID(rs.getInt("personaID"));
                proveedor.setTipoProveedor(TipoProveedor.valueOf(rs.getString("tipoProveedor")));
                proveedor.setNombreContacto(rs.getString("nombreContacto"));
                proveedor.setNumeroContacto(rs.getString("numeroContacto"));
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Manejo de errores de la base de datos
        }
        
        return proveedores;
    }
}

