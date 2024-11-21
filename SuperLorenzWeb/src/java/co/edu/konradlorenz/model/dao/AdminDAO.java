package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.CompraInsumos;
import co.edu.konradlorenz.model.Kardex;
import co.edu.konradlorenz.model.Pedido;
import co.edu.konradlorenz.model.Persona;
import co.edu.konradlorenz.model.Producto;
import co.edu.konradlorenz.model.enums.Estado;
import co.edu.konradlorenz.model.enums.MedioPago;
import co.edu.konradlorenz.model.enums.MotivoSalida;
import co.edu.konradlorenz.model.enums.TipoDocumento;
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
                
                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compras;
    }
    public Persona obtenerPersonaPorId(int personaID) {
    Persona persona = null;
    String query = "SELECT * FROM Persona WHERE personaID = ?";

    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setInt(1, personaID);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            persona = new Persona();
            persona.setPersonaID(rs.getInt("personaID"));
            persona.setNumeroDocumento(rs.getString("numeroDocumento"));
            persona.setTipoDocumento(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
            persona.setNombres(rs.getString("nombres"));
            persona.setApellidos(rs.getString("apellidos"));
            persona.setCelular(rs.getString("celular"));
            persona.setCorreo(rs.getString("correo"));
            persona.setPassword(rs.getString("password"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return persona;
}
    public List<Pedido> obtenerPedidos() {
    List<Pedido> pedidos = new ArrayList<>();
    String query = "SELECT * FROM Pedido";

    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Pedido pedido = new Pedido();
            pedido.setPedidoID(rs.getInt("pedidoID"));
            pedido.setEmpleadoID(rs.getInt("empleadoID"));
            pedido.setClienteID(rs.getInt("clienteID"));
            pedido.setMedioPago(MedioPago.valueOf(rs.getString("medioPago")));
            pedido.setFechaPago(rs.getDate("fechaPago"));
            pedido.setFechaEnvio(rs.getDate("fechaEnvio"));
            pedido.setFechaEntrega(rs.getDate("fechaEntrega"));
            pedido.setValorTotal(rs.getFloat("valorTotal"));
            
            pedidos.add(pedido);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return pedidos;
}
    public List<Kardex> obtenerKardex() {
        List<Kardex> kardexList = new ArrayList<>();
        String sql = "SELECT * FROM Kardex";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Kardex kardex = new Kardex();
                kardex.setKardexID(rs.getInt("kardexID"));
                kardex.setProductoID(rs.getInt("productoID"));
                kardex.setCantidadEntrada(rs.getInt("cantidadEntrada"));
                kardex.setCantidadSalida(rs.getInt("cantidadSalida"));
                kardex.setCantidadDisponible(rs.getInt("cantidadDisponible"));
                kardex.setMotivosalida(MotivoSalida.valueOf(rs.getString("motivoSalida")));
                kardex.setOtroMotivoSalida(rs.getString("otroMotivoSalida"));
                kardex.setFecha(rs.getDate("fecha"));

                kardexList.add(kardex);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones
        }

        return kardexList;
    }

    

}