package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.conexion.Conexion;
import co.edu.konradlorenz.model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {

    public static int agregarEmpleado(Empleado empleado) {

        Connection connection;
        Conexion conexion = new Conexion();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        
        int status = 0;

        try {
            connection = conexion.crearConexion();

            String q = "INSERT INTO Empleado (personaID, empleadoID, cargo, dependencia, tipoContrato, eps, arl, nombreEmergencia, celularEmergencia)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(q);

            preparedStatement.setInt(1, empleado.getPersonaID());
            preparedStatement.setInt(2, empleado.getEmpleadoID());
            preparedStatement.setString(3, empleado.getCargo());
            preparedStatement.setString(4, empleado.getDependencia());
            preparedStatement.setString(5, empleado.getTipoContrato());
            preparedStatement.setString(6, empleado.getEps());
            preparedStatement.setString(7, empleado.getArl());
            preparedStatement.setString(8, empleado.getNombreEmergencia());
            preparedStatement.setString(9, empleado.getCelularEmergencia());

            status = preparedStatement.executeUpdate();
            connection.close();

            System.out.print("REGISTRO GUARDADO DE FORMA EXITOSA...");
        } catch (SQLException ex) {
            System.out.print("ERROR AL REGISTRAR LA ACTIVIDAD...");
            System.out.print(ex.getMessage());
        }

        return status;
    }
    //agregarEmpleado
}
//class
