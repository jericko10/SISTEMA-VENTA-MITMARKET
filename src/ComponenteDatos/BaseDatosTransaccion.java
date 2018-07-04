package ComponenteDatos;

import ComponenteClase.Transaccion;
import ComponenteNegocio.NegocioCompra;
import ComponenteNegocio.NegocioProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
**/
public class BaseDatosTransaccion {

    static Connection conexionBaseDatos = null;  
    /**
    * Método que inserta una nueva transaccion (detalle de la compra) a la base de datos.
    * @param transaccion El parámetro transaccion define el objeto de la clase Transaccion que contiene los datos 
    * sobre la transaccion (detalle de la compra) y que será usado para poder ser insertado en la base de datos.
    * Los valores de transaccion no tiene que ser nulos.
    */
     public static void insertarTransaccion(final Transaccion transaccion) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarTransaccion = null;
        instruccionInsertarTransaccion = conexionBaseDatos.prepareStatement("INSERT INTO TRANSACCION (idcompra,codigo_barra,cantidad) VALUES (?,?,?)");
        instruccionInsertarTransaccion.setInt(1, transaccion.getCompra().getIdCompra());
        instruccionInsertarTransaccion.setString(2, transaccion.getProducto().getCodigoBarra());
        instruccionInsertarTransaccion.setInt(3, transaccion.getCantidad());
        instruccionInsertarTransaccion.executeUpdate();
        conexionBaseDatos.close();
        instruccionInsertarTransaccion.close();
    }

    /**
    * Método que obtiene el último id de la compra que representará a la compra actual.
    * @return El Id de la última compra almacenada en la base de datos para la compra actual.
    */    
    public static int obtenerUltimoIdCompra() throws SQLException {
         int ultimoIdCompra = 0;
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Statement sentenciaBaseDatos = conexionBaseDatos.createStatement();
        ResultSet resultadoBaseDatos = sentenciaBaseDatos.executeQuery("select max(idcompra) from COMPRA ");
        while (resultadoBaseDatos.next()) {
            ultimoIdCompra = resultadoBaseDatos.getInt(1);
        }
        resultadoBaseDatos.close();
        sentenciaBaseDatos.close();
        conexionBaseDatos.close();
        return ultimoIdCompra;
    }
    
    /**
     * Método que obtiene los elementos contenidos en el detalle de la compra a buscar.
     * @param codigoCompra El parámetro codigoCompra define el codigo de compra del cual se obtendrá su detalle. Entero positivo mayor a cero.
     * @return Una lista de los elementos contenidos en el detalle de la compra.
     * @throws SQLException 
     */
    public static ArrayList<Transaccion> obtenerTransaccion(int codigoCompra) throws SQLException{
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarTransaccion = null;
        ArrayList<Transaccion> listaTransaccion = new ArrayList<Transaccion>();
        NegocioProducto productoNegocio = new NegocioProducto();
        NegocioCompra compraNegocio = new NegocioCompra();
        instruccionListarTransaccion = conexionBaseDatos.prepareStatement("SELECT * FROM transaccion where idcompra = ?");
        instruccionListarTransaccion.setInt(1, codigoCompra);
        ResultSet resultado = instruccionListarTransaccion.executeQuery();
        while (resultado.next()) {
            Transaccion transaccion = new Transaccion(productoNegocio.buscarProductoCodigoBarra(resultado.getString("codigo_barra")),
            compraNegocio.buscarCompra(resultado.getInt("idcompra")), resultado.getInt("cantidad")) {};
            listaTransaccion.add(transaccion);
        }
        conexionBaseDatos.close();
        instruccionListarTransaccion.close();
        return listaTransaccion;
    }
}
