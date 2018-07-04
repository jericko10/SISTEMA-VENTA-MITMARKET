package ComponenteNegocio;

import ComponenteClase.Usuario;
import ComponenteDatos.BaseDatosUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 * 
 * @author Rodriguez Zelada
 * @version 2.1
 * 
 * @author Mamani Bedregal
 * @version 2.2
 */
public class NegocioUsuario {
    
    /**
    * Método que llama al método insertarUsuario() de la clase BaseDatosUsuario del paquete ComponenteDatos.
    * @param usuario El parámetro usuario define el objeto de la Clase Usuario que contiene los datos sobre el usuario y 
    * que será usado para poder ser insertado en la base de datos.
    */
    public void insertarUsuario(final Usuario usuario) throws SQLException
    {
        BaseDatosUsuario.insertarUsuario(usuario);
    }
    
    /**
    * Método que llama al método buscarUsuario() de la clase BaseDatosUsuario del paquete ComponenteDatos.
    * @param idUsuario El parámetro idUsuario define el ID del usuario a ser buscado.
    * @return El objeto de la clase Usuario con los datos encontrados del proceso de búsqueda.
    */ 
    public Usuario buscarUsuario(final int idUsuario) throws SQLException {
        return BaseDatosUsuario.buscarUsuario(idUsuario);  
    }
    
    public Usuario buscarUsuarioNombre(final String nombreUsuario) throws SQLException {
        return BaseDatosUsuario.buscarUsuarioNombre(nombreUsuario);  
    }

    /**
    * Método que llama al método eliminarUsuario() de la clase BaseDatosUsuario del paquete ComponenteDatos.
    * @param idUsuario El parámetro idUsuario define el ID del usuario a ser eliminado.
    */ 
    public void eliminarUsuario(final int idUsuario) throws SQLException
    {
        BaseDatosUsuario.eliminarUsuario(idUsuario);
    }
    
    /**
    * Método que llama al método actualizarUsuario() de la clase BaseDatosUsuario del paquete ComponenteDatos.
    * @param usuario El parámetro usuario define el objeto de la clase Usuario que contiene toda la información del usuario, el
    * cual se actualizará sus datos.
    */  
    public void actualizarUsuario(final Usuario usuario) throws SQLException
    {
        BaseDatosUsuario.actualizarUsuario(usuario);
    }
    
    /**
    * Método que llama al método mostrarUsuario() de la clase BaseDatosUsuario del paquete ComponenteDatos.
    * @return La lista de los usuarios.
    */ 
    public ArrayList<Usuario> mostrarUsuario() throws SQLException
    {
        return BaseDatosUsuario.mostrarUsuario();
    }
}
