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
                        persona.setApellidos(rs.getString("apellidos"));
                        persona.setNumeroDocumento(rs.getString("numeroDocumento"));
                        String tipoDocumentoStr = rs.getString("tipoDocumento"); 
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
