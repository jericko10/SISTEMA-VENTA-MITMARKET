package ComponenteNegocio;

import ComponenteClase.Compra;
import ComponenteClase.Producto;
import ComponenteClase.ProductoCliente;
import ComponenteDatos.BaseDatosCompra;
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
 *  @author Mamani Bedregal
 * @version 2.2
 */
public class NegocioCompra {
    
    /**
    * Método que llama al método insertarCompra() de la clase BaseDatosCompra del paquete ComponenteDatos.
    * @param compra El parámetro compra define el objeto que contiene los datos sobre la compra y que será usado para poder ser
    * insertado en la base de datos. Los valores de compra no tiene que ser nulos.
    */   
    public void insertarCompra(final Compra compra) throws SQLException {
        BaseDatosCompra.insertarCompra(compra);
    }
    
    /**
    * Método que llama al método buscarCompra() de la clase BaseDatosCompra del paquete ComponenteDatos.
    * @param idCompra El parámetro idCompra define el id de la compra a ser buscado. Valor entero positivo mayor que cero.
    * @return El objeto de la clase Compra con los datos encontrados del proceso de búsqueda.
    */ 
    public Compra buscarCompra(final int idCompra) throws SQLException{
        return BaseDatosCompra.buscarCompra(idCompra);
    }
    
    /**
    * Método que llama al método obtenerUltimoIdCompra() de la clase BaseDatosCompra del paquete ComponenteDatos.
    * @return El id de compra para la nueva compra.
    */ 
    public int obtenerUltimoIdCompra() throws SQLException{
        return BaseDatosCompra.obtenerUltimoIdCompra();
    }
    
    /**
    * Método que llama al método insertarMontoTotal() de la clase BaseDatosCompra del paquete ComponenteDatos.
    * @param idCompra El parámetro idCompra define el id de la nueva compra. Valor entero positivo mayor que cero.
    * @param montoTotalCompra  El parámetro montoTotalCompra define el monto total de la nueva compra. Valor decimal positivo mayor que cero
    */  
    public void insertarMontoTotal(final int idCompra, final double montoTotalCompra) throws SQLException{
        BaseDatosCompra.insertarMontoTotal(idCompra, montoTotalCompra);
    }
    
    /**
     * Método que calcula el monto total de la compra.
     * @param montoListaProducto El parámetro montoListaProducto define el monto sub total de la compra. Valor decimal positivo mayor que cero.
     * @return El monto total de la compra, incluido el IGV.
     */
    public double calcularCompra(final Double montoListaProducto){
        final Double montoSubTotal = montoListaProducto;
        Double montoTotal = 0.0;             
        final Double totalIGV = Math.round((montoSubTotal * 0.18)*100d)/100d;
        montoTotal = montoSubTotal + totalIGV;     
        return montoTotal;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Compra> listarVenta() throws SQLException{
        return BaseDatosCompra.listarVenta();
    }
    
    public ProductoCliente obtenerProductoCliente(String dniCliente) throws SQLException{
        return BaseDatosCompra.obtenerProductoCliente(dniCliente);
    }
    
    public ArrayList<ProductoCliente> listarProductoCliente(String dniCliente) throws SQLException{
        return BaseDatosCompra.listarProductoCliente(dniCliente);
    }
    
    public void actualizarCantidadProductoEspera(final ProductoCliente productoCliente) throws SQLException{
        BaseDatosCompra.actualizarCantidadProductoEspera(productoCliente);
    }
    
    public void insertarNuevoProductoEspera(final ProductoCliente productoCliente) throws SQLException{
        BaseDatosCompra.insertarNuevoProductoEspera(productoCliente);
    }
    
    public int obtenerUltimoIdListaProductoCliente() throws SQLException{
        return BaseDatosCompra.obtenerUltimoIdListaProductoCliente();
    }
    
    public void eliminarEsperaProductoCliente(final int idEsperaProductoCliente) throws SQLException{
        BaseDatosCompra.eliminarEsperaProductoCliente(idEsperaProductoCliente);
    }
    
    public void eliminarFilaEsperaProductoCliente(final int idProductoCliente, final int cantidadProducto, final String codigoBarraProducto) throws SQLException{
        BaseDatosCompra.eliminarFilaEsperaProductoCliente(idProductoCliente,cantidadProducto,codigoBarraProducto);
    }
    
    public void cancelarCompra(final int nroCompra) throws SQLException{
        BaseDatosCompra.cancelarCompra(nroCompra);
    }
    
    public ArrayList<ProductoCliente> listarProductoClienteEspera() throws SQLException{
        return BaseDatosCompra.listarProductoClienteEspera();
    }
    
    public void actualizarEstadoTomadoProductoClienteEspera(final int idCaja, final int idProductoClienteEspera) throws SQLException{
        BaseDatosCompra.actualizarEstadoTomadoProductoClienteEspera(idCaja, idProductoClienteEspera);
    }
    
    public ArrayList<ProductoCliente> listarProductoClienteEsperaTomado(final int idCaja) throws SQLException{
        return BaseDatosCompra.listarProductoClienteEsperaTomado(idCaja);
    }
    
    public ArrayList<ProductoCliente> listarProductoClienteTomado(final int idEspera) throws SQLException{
        return BaseDatosCompra.listarProductoClienteTomado(idEspera);
    }
    
    public void actualizarEstadoTomadoProductoClienteListo(final int idCaja, final int idProductoClienteEspera) throws SQLException{
        BaseDatosCompra.actualizarEstadoTomadoProductoClienteListo(idCaja, idProductoClienteEspera);
    }
}
