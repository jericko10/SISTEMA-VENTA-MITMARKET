package ComponenteDatos;

import ComponenteClase.Caja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Mamani Bedregal
 * @version 1.0
 */
public class BaseDatosCaja {
    static Connection conexionBaseDatos;
     
    public static void insertarCaja(final Caja caja) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarCaja = null;
        instruccionInsertarCaja = conexionBaseDatos.prepareStatement("INSERT INTO caja (nombre,estado) VALUES (?,?)");
        instruccionInsertarCaja.setString(1, caja.getNombreCaja());
        instruccionInsertarCaja.setString(2, caja.getEstadoCaja());
        instruccionInsertarCaja.executeUpdate();
        conexionBaseDatos.close();
        instruccionInsertarCaja.close();
    }
     
    public static Caja buscarCajaCodigo(final int codigoCaja) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionBusquedaCaja = null;
        Caja caja = null;
        instruccionBusquedaCaja = conexionBaseDatos.prepareStatement("select * from caja where idCaja=?");
        instruccionBusquedaCaja.setInt(1, codigoCaja);
        ResultSet resultado= instruccionBusquedaCaja.executeQuery();
        if (resultado.next()) {
            caja = new Caja(codigoCaja, resultado.getString("nombre"), resultado.getString("estado")) {
            };
        }
        conexionBaseDatos.close();
        instruccionBusquedaCaja.close();
        return caja;
    }
    
     public static Caja buscarCajaNombre(final String nombreCaja) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionBusquedaCaja = null;
        Caja caja = null;
        instruccionBusquedaCaja = conexionBaseDatos.prepareStatement("select * from caja where nombre=?");
        instruccionBusquedaCaja.setString(1, nombreCaja);
        ResultSet resultado= instruccionBusquedaCaja.executeQuery();
        if (resultado.next()) {
            caja = new Caja(resultado.getInt("idCaja"), resultado.getString("nombre"), resultado.getString("estado")) {
            };
        }
        conexionBaseDatos.close();
        instruccionBusquedaCaja.close();
        return caja;
    }
    
    public static void eliminarCaja(final int codigoCaja) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionEliminarCaja = null;
        instruccionEliminarCaja = conexionBaseDatos.prepareStatement("delete from caja WHERE idCaja=?");
        instruccionEliminarCaja.setInt(1, codigoCaja);
        instruccionEliminarCaja.executeUpdate();
        conexionBaseDatos.close();
        instruccionEliminarCaja.close();
    }
    
    public static void actualizarCaja(final Caja caja) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarCaja = null;
        instruccionActualizarCaja = conexionBaseDatos.prepareStatement("UPDATE caja SET nombre = ?, estado=? WHERE idCaja=" + caja.getIdCaja());
        instruccionActualizarCaja.setString(1, caja.getNombreCaja());
        instruccionActualizarCaja.setString(2, caja.getEstadoCaja() );
        instruccionActualizarCaja.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarCaja.close();
    }
    
    public static ArrayList<Caja> mostrarCaja() throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarCaja = null;
        ArrayList<Caja> listaCaja = new ArrayList<Caja>();
        instruccionListarCaja = conexionBaseDatos.prepareStatement("SELECT * FROM caja");
        ResultSet resultado = instruccionListarCaja.executeQuery();
        while (resultado.next()) {
            Caja caja = new Caja(resultado.getInt("idCaja"), resultado.getString("nombre"),resultado.getString("estado")) {
            };
            listaCaja.add(caja);
        }
        conexionBaseDatos.close();
        instruccionListarCaja.close();
        return listaCaja;
    }
    
    public static void actualizarEstadoCaja(final int idCaja, final String estado) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarCaja = null;
        instruccionActualizarCaja = conexionBaseDatos.prepareStatement("UPDATE caja SET estado= ? WHERE idCaja= ?");
        instruccionActualizarCaja.setString(1, estado);
        instruccionActualizarCaja.setInt(2, idCaja);
        instruccionActualizarCaja.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarCaja.close();
    }
}
