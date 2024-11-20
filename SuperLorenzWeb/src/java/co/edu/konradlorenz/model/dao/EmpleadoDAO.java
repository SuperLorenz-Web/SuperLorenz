package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.connection.Conexion;
import co.edu.konradlorenz.model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class EmpleadoDAO {
     private final Conexion conexionBD = new Conexion();

    // Método para validar las credenciales del usuario
    public boolean validarCredenciales(String correo, String passwordUsuario) {
        boolean credencialesValidas = false;
        try (Connection con = conexionBD.crearConexion()) {
            if (con != null) {
                String sql = "SELECT * \n" +
"                    FROM Persona p\n" +
"                    INNER JOIN Empleado e ON p.personaID = e.personaID\n" +
"                    WHERE p.correo = ? AND p.password = ?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, correo);
                    ps.setString(2, passwordUsuario);

                    try (ResultSet rs = ps.executeQuery()) {
                        credencialesValidas = rs.next();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credencialesValidas;
    }

    // Método para obtener el tipo de usuario (Admin, Empleado)
    public String obtenerTipoUsuario(String correo) {
    String tipoUsuario = "DESCONOCIDO"; // Valor predeterminado por si no se encuentra el usuario

    String sql = "SELECT e.cargo FROM Empleado e "
               + "JOIN Persona p ON e.personaID = p.personaID "
               + "WHERE p.correo = ?"; // Se utiliza correo en lugar de numeroDocumento

    // Usamos try-with-resources para asegurar el cierre de la conexión y recursos
    try (Connection con = conexionBD.crearConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        if (con != null) {
            // Establecemos el valor para el correo
            ps.setString(1, correo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String cargo = rs.getString("cargo");

                    // Definir roles admins
                    Set<String> rolesAdmin = new HashSet<>(Arrays.asList("GERENTE_GENERAL", "SUBGERENTE", "JEFE_DE_RECURSOS_HUMANOS"));

                    // Clasificar el tipo de usuario
                    if (rolesAdmin.contains(cargo.toUpperCase())) {
                        tipoUsuario = "ADMIN";
                    } else {
                        tipoUsuario = "EMPLEADO";
                    }
                }
            }
        }
    } catch (SQLException e) {
        // Manejo de excepciones con logging
        e.printStackTrace(); // Cambiar por un log si es necesario
    }
    return tipoUsuario;
}

}




                