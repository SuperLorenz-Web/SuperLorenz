package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.connection.Conexion;
import co.edu.konradlorenz.model.Persona;
import co.edu.konradlorenz.model.enums.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonaDAO {
    private final Conexion conexionBD = new Conexion();

    // Método para validar las credenciales del usuario
    public boolean validarCredenciales(String correo, String passwordUsuario) {
        boolean credencialesValidas = false;
        String query = "SELECT * FROM Persona p INNER JOIN Cliente c ON p.personaID = c.personaID WHERE p.correo = ? AND p.password = ?";
        try (Connection con = conexionBD.crearConexion()) {
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, correo);
                ps.setString(2, passwordUsuario);

                try (ResultSet rs = ps.executeQuery()) {
                    credencialesValidas = rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credencialesValidas;
    }
    
    public Persona obtenerPorCorreo(String correo) {
        Persona persona = null;
        String query = "SELECT * FROM Persona WHERE correo = ?";
        try (Connection con = conexionBD.crearConexion()) {
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, correo);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        persona = new Persona();
                        persona.setPersonaID(rs.getInt("personaID"));
                        persona.setNombres(rs.getString("nombres"));
                        persona.setApellidos(rs.getString("nombres"));
                        persona.setNumeroDocumento(rs.getString("numeroDocumento"));
                        String tipoDocumentoStr = rs.getString("tipoDocumento"); // Suponiendo que el valor en la base de datos es un String
                        persona.setTipoDocumento(TipoDocumento.valueOf(tipoDocumentoStr));
                        persona.setCelular(rs.getString("celular"));
                        persona.setCorreo(rs.getString("correo"));
                        persona.setPassword(rs.getString("password"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persona;
    }
}
/*
    // Método para obtener el tipo de usuario (Cliente, Proveedor, Empleado)
    public String obtenerTipoUsuario(String numeroDocumento) {
        String tipoUsuario = null;

        try (Connection con = conexionBD.crearConexion()) {
            if (con != null) {
                // Comprobar si el número de documento es de un cliente
                String sqlCliente = "SELECT * FROM Cliente WHERE personaID = (SELECT personaID FROM Persona WHERE numeroDocumento = ?)";
                try (PreparedStatement psCliente = con.prepareStatement(sqlCliente)) {
                    psCliente.setString(1, numeroDocumento);

                    try (ResultSet rsCliente = psCliente.executeQuery()) {
                        if (rsCliente.next()) {
                            tipoUsuario = "CLIENTE";
                        }
                    }
                }

                // Comprobar si el número de documento es de un proveedor
                if (tipoUsuario == null) {
                    String sqlProveedor = "SELECT * FROM Proveedor WHERE personaID = (SELECT personaID FROM Persona WHERE numeroDocumento = ?)";
                    try (PreparedStatement psProveedor = con.prepareStatement(sqlProveedor)) {
                        psProveedor.setString(1, numeroDocumento);

                        try (ResultSet rsProveedor = psProveedor.executeQuery()) {
                            if (rsProveedor.next()) {
                                tipoUsuario = "PROVEEDOR";
                            }
                        }
                    }
                }

                // Comprobar si el número de documento es de un empleado
                if (tipoUsuario == null) {
                    String sqlEmpleado = "SELECT * FROM Empleado WHERE personaID = (SELECT personaID FROM Persona WHERE numeroDocumento = ?)";
                    try (PreparedStatement psEmpleado = con.prepareStatement(sqlEmpleado)) {
                        psEmpleado.setString(1, numeroDocumento);

                        try (ResultSet rsEmpleado = psEmpleado.executeQuery()) {
                            if (rsEmpleado.next()) {
                                tipoUsuario = "EMPLEADO";
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipoUsuario;
    }
    */