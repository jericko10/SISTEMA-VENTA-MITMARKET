package ComponenteDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public class BaseDatosConexion {

    private static Connection conexionBaseDatos;
    private static String urlBaseDatos;
    private static String usuarioBaseDatos;
    private static String contrasenaBaseDatos;
    
    public static Connection getConexionBaseDatos() {
        return conexionBaseDatos;
    }

    public static String getUrlBaseDatos() {
        return urlBaseDatos;
    }

    public static String getUsuarioBaseDatos() {
        return usuarioBaseDatos;
    }

    public static String getContrasenaBaseDatos() {
        return contrasenaBaseDatos;
    }

    public static void setConexionBaseDatos(final Connection conexionBaseDatos) {
        BaseDatosConexion.conexionBaseDatos = conexionBaseDatos;
    }

    public static void setUrlBaseDatos(final String urlBaseDatos) {
        BaseDatosConexion.urlBaseDatos = urlBaseDatos;
    }

    public static void setUsuarioBaseDatos(final String usuarioBaseDatos) {
        BaseDatosConexion.usuarioBaseDatos = usuarioBaseDatos;
    }

    public static void setContrasenaBaseDatos(final String contrasenaBaseDatos) {
        BaseDatosConexion.contrasenaBaseDatos = contrasenaBaseDatos;
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            setUrlBaseDatos("jdbc:mysql://localhost:3307/bdsistema");
            setUsuarioBaseDatos("root");
            setContrasenaBaseDatos("");            
            setConexionBaseDatos(DriverManager.getConnection(getUrlBaseDatos(),getUsuarioBaseDatos(),getContrasenaBaseDatos()));
            } catch (ClassNotFoundException e) {
                setConexionBaseDatos(null);
                JOptionPane.showMessageDialog(null, "Error no se puede cargar el driver:" + e.getMessage());
            } catch (SQLException e) {
                setConexionBaseDatos(null);
                if(e.getErrorCode() == 0){
                    JOptionPane.showMessageDialog(null, "El servidor de base de datos no responde.\n"
                                                    + "Verifique que el servidor de base de datos este activo.\n"
                                                    + "También Verifique que exista la base de datos bdsistema", 
                                                    "Error: Coneccion Fallida.", JOptionPane.ERROR_MESSAGE);
                }
            }
        return getConexionBaseDatos();
    }
}
