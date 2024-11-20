package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.Precio;
import co.edu.konradlorenz.model.connection.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrecioDAO {
    private Conexion conexionBD;
    
    public PrecioDAO() {
    this.conexionBD = new Conexion();
    }

    // Obtener un precio por su ID
    public Precio getPrecioByID(int precioID) throws SQLException {
        String query = "SELECT * FROM Precio pr WHERE precioID = ?";
        try (Connection con = conexionBD.crearConexion()) {
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setInt(1, precioID);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            return mapResultSetToPrecio(rs);
                        }
                    }
                }
            return null;
        }
    }

    // Obtener todos los precios asociados a un producto
    public List<Precio> getPreciosByProductoID(int productoID) throws SQLException {
        List<Precio> precios = new ArrayList<>();
        String query = "SELECT * FROM Precio pr WHERE productoID = ?";
        try (Connection con = conexionBD.crearConexion()) {
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, productoID);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        precios.add(mapResultSetToPrecio(rs));
                    }
                }
            }
            return precios;
        }
    }

    // Mapeo de ResultSet a objeto Precio
    private Precio mapResultSetToPrecio(ResultSet rs) throws SQLException {
        Precio precio = new Precio();
        precio.setPrecioID(rs.getInt("precioID"));
        precio.setProductoID(rs.getInt("productoID"));
        precio.setValorUnitario(rs.getDouble("valorUnitario"));
        precio.setIva(rs.getDouble("iva"));
        precio.setPrecioUnitarioTotal(rs.getDouble("precioUnitarioTotal"));
        precio.setFecha(rs.getDate("fecha"));
        return precio;
    }
}