package ComponenteNegocio;

import ComponenteClase.Transaccion;
import ComponenteDatos.BaseDatosTransaccion;
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
 */
public class NegocioTransaccion {
    
    /**
    * Método que llama al método insertarTransaccion() de la clase BaseDatosTransaccion del paquete ComponenteDatos.
    * @param transaccion El parámetro transaccion define el objeto de la clase Transaccion que contiene los datos 
    * sobre la transaccion (detalle de la compra) y que será usado para poder ser insertado en la base de datos.
    * Los valores de transaccion no tiene que ser nulos.
    */
    public void insertarTransaccion(final Transaccion transaccion) throws SQLException {
        BaseDatosTransaccion.insertarTransaccion(transaccion);
    }
    
    /**
    * Método que llama al método obtenerUltimoIdCompra() de la clase BaseDatosTransaccion del paquete ComponenteDatos.
    * @return El Id de la última compra almacenada en la base de datos para la compra actual.
    */   
    public int obtenerUltimoIdCompra() throws SQLException{
        return BaseDatosTransaccion.obtenerUltimoIdCompra();
    }
    
    /**
     * Método que llama al método obtenerTransaccion() de la clase BaseDatosTransaccion del paquete ComponenteDatos.
     * @param codigoCompra El parámetro codigoCompra define el codigo de compra del cual se obtendrá su detalle. Entero positivo mayor a cero.
     * @return Una lista de los elementos contenidos en el detalle de la compra.
     * @throws SQLException 
     */
    public ArrayList<Transaccion> obtenerTransaccion(final int codigoCompra) throws SQLException{
        return BaseDatosTransaccion.obtenerTransaccion(codigoCompra);
    }
}
