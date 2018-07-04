package ComponenteDatos;

import ComponenteClase.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 * 
 * @author Mamani Bedregal
 * @version 2.1
 */
public class BaseDatosUsuario {
    
    private static Connection conexionBaseDatos;
    
    /**
    * Método que inserta un nuevo usuario a la base de datos.
    * @param usuario El parámetro usuario define el objeto de la Clase Usuario que contiene los datos sobre el usuario y 
    * que será usado para poder ser insertado en la base de datos.
    */
    public static void insertarUsuario(final Usuario usuario) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarUsuario = null;
        instruccionInsertarUsuario = conexionBaseDatos.prepareStatement("INSERT INTO USUARIO (id,usuario,nroEmpleado, contrasena, tipoUsuario) VALUES (?,?,?,?,?)");
        instruccionInsertarUsuario.setInt(1, usuario.getIdUsuario());
        instruccionInsertarUsuario.setString(2, usuario.getNombreUsuario());
        instruccionInsertarUsuario.setInt(3, usuario.getEmpleado().getNumeroEmpleado());
        instruccionInsertarUsuario.setString(4, usuario.getContrasenaUsuario());
        instruccionInsertarUsuario.setString(5, usuario.getTipoUsuario());
        instruccionInsertarUsuario.executeUpdate();
        conexionBaseDatos.close();
        instruccionInsertarUsuario.close();
    }

    /**
    * Método que contiene toda la lógica de búsqueda del usuario en base al ID del usuario (nombre del usuario).
    * @param idUsuario El parámetro idUsuario define el ID del usuario a ser buscado.
    * @return El objeto de la clase Usuario con los datos encontrados del proceso de búsqueda.
    */ 
    public static Usuario buscarUsuario(final int idUsuario) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Usuario usuario = null;
        if(conexionBaseDatos != null)
        {
            PreparedStatement instruccionBusquedaUsuario = null;
            instruccionBusquedaUsuario = conexionBaseDatos.prepareStatement("select * from USUARIO where id=?");
            instruccionBusquedaUsuario.setInt(1, idUsuario);
            ResultSet resultado = instruccionBusquedaUsuario.executeQuery();
            if (resultado.next()) {
                usuario = new Usuario(resultado.getInt("id"),resultado.getString("usuario"),BaseDatosEmpleado.buscarEmpleado(resultado.getInt("nroEmpleado")), resultado.getString("contrasena"),resultado.getString("tipoUsuario"));
            }
            conexionBaseDatos.close();
            instruccionBusquedaUsuario.close();
            return usuario; 
        }
        return null;
        
    }
    
    public static Usuario buscarUsuarioNombre(final String nombreUsuario) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Usuario usuario = null;
        if(conexionBaseDatos != null)
        {
            PreparedStatement instruccionBusquedaUsuario = null;
            instruccionBusquedaUsuario = conexionBaseDatos.prepareStatement("select * from USUARIO where usuario=?");
            instruccionBusquedaUsuario.setString(1, nombreUsuario);
            ResultSet resultado = instruccionBusquedaUsuario.executeQuery();
            if (resultado.next()) {
                usuario = new Usuario(resultado.getInt("id"),resultado.getString("usuario"),BaseDatosEmpleado.buscarEmpleado(resultado.getInt("nroEmpleado")), resultado.getString("contrasena"),resultado.getString("tipoUsuario"));
            }
            conexionBaseDatos.close();
            instruccionBusquedaUsuario.close();
            return usuario; 
        }
        return null;
        
    }

    /**
    * Método que elimina de la base de datos al usuario según su ID de usuario (nombre de usuario).
    * @param idUsuario El parámetro idUsuario define el ID del usuario a ser eliminado.
    */ 
    public static void eliminarUsuario(final int idUsuario) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionEliminarUsuario = null;
        instruccionEliminarUsuario = conexionBaseDatos.prepareStatement("delete from USUARIO WHERE id=?");
        instruccionEliminarUsuario.setInt(1, idUsuario);
        instruccionEliminarUsuario.executeUpdate();
        conexionBaseDatos.close();
        instruccionEliminarUsuario.close();
    }

    /**
    * Método que actualiza los datos de la base de datos de un usuario.
    * @param usuario El parámetro usuario define el objeto de la clase Usuario que contiene toda la información del usuario, el
    * cual se actualizará sus datos.
    */  
    public static void actualizarUsuario(final Usuario usuario) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarUsuario = null;
        instruccionActualizarUsuario = conexionBaseDatos.prepareStatement("UPDATE USUARIO SET usuario=?, nroEmpleado=?, contrasena=?, tipoUsuario = ? where id =" + usuario.getIdUsuario());
        instruccionActualizarUsuario.setString(1, usuario.getNombreUsuario());
        instruccionActualizarUsuario.setInt(2, usuario.getEmpleado().getNumeroEmpleado());
        instruccionActualizarUsuario.setString(3, usuario.getContrasenaUsuario());
        instruccionActualizarUsuario.setString(4, usuario.getTipoUsuario());
        instruccionActualizarUsuario.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarUsuario.close();
    }

    /**
    * Método que obtiene la lista de los usuarios actualmente almacenados en la base de datos.
    * @return La lista de los usuarios.
    */ 
    public static ArrayList<Usuario> mostrarUsuario() throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarUsuario = null;
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();

        instruccionListarUsuario = conexionBaseDatos.prepareStatement("SELECT * FROM USUARIO");
        ResultSet resultado = instruccionListarUsuario.executeQuery();
        while (resultado.next()) {
            Usuario usuario = new Usuario(resultado.getInt("id"),resultado.getString("usuario"),BaseDatosEmpleado.buscarEmpleado(resultado.getInt("nroEmpleado")), resultado.getString("contrasena"),resultado.getString("tipoUsuario"));
            listaUsuario.add(usuario);
        }
        conexionBaseDatos.close();
        instruccionListarUsuario.close();
        return listaUsuario;
    }
}
