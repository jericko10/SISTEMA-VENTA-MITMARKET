package ComponenteDatos;

import ComponenteClase.Compra;
import ComponenteClase.Producto;
import ComponenteClase.ProductoCliente;
import ComponenteNegocio.NegocioCaja;
import ComponenteNegocio.NegocioEmpleado;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class BaseDatosCompra {

    static Connection conexionBaseDatos = null;   
    /**
    * Método que inserta una nueva categoria a la base de datos.
    * @param compra El parámetro compra define el objeto que contiene los datos sobre la compra y que será usado para poder ser
    * insertado en la base de datos. Los valores de compra no tiene que ser nulos.
    */   
    public static void insertarCompra(final Compra compra) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarCompra = null;
        instruccionInsertarCompra = conexionBaseDatos.prepareStatement("INSERT INTO COMPRA (idcompra,dniCliente,nroEmpleado,fechacompra,tipoCambio,estado) VALUES (?,?,?,?,?,?)");
        instruccionInsertarCompra.setInt(1, compra.getIdCompra());
        instruccionInsertarCompra.setString(2, compra.getDniCliente());
        instruccionInsertarCompra.setInt(3, compra.getEmpleado().getNumeroEmpleado());
        instruccionInsertarCompra.setString(4, compra.getFechaCompra());
        instruccionInsertarCompra.setString(5, compra.getTipoCambio());
        instruccionInsertarCompra.setString(6, compra.getEstado());
        instruccionInsertarCompra.executeUpdate();
        conexionBaseDatos.close();
        instruccionInsertarCompra.close();
    }

    /**
    * Método que contiene la lógica de búsqueda de la compra en base al id de la compra.
    * @param idCompra El parámetro idCompra define el id de la compra a ser buscado. Valor entero positivo mayor que cero.
    * @return El objeto de la clase Compra con los datos encontrados del proceso de búsqueda.
    */ 
    public static Compra buscarCompra(final int idCompra) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionBusquedaCompra = null;
        Compra compra = null;
        instruccionBusquedaCompra = conexionBaseDatos.prepareStatement("select * from COMPRA where idcompra=?");
        instruccionBusquedaCompra.setInt(1, idCompra);
        ResultSet resultado = instruccionBusquedaCompra.executeQuery();
        if (resultado.next()) {
            compra = new Compra(idCompra,resultado.getString("dniCliente"),BaseDatosEmpleado.buscarEmpleado(resultado.getInt("nroEmpleado")),
            resultado.getString("fechaCompra"),resultado.getString("tipoCambio"),resultado.getDouble("montoTotal"),resultado.getString("estado")) {};
        }
        conexionBaseDatos.close();
        instruccionBusquedaCompra.close();
        return compra;
    }
    
    /**
    * Método que contiene la lógica de obtención del ultimo Id de compra almacenada en la base de datos,
    * y le agrega +1 para generar un nuevo id de para la nueva compra.
    * @return El id de compra para la nueva compra.
    */    
    public static int obtenerUltimoIdCompra() throws SQLException {
        int ultimoIdCompra = 0;
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Statement sentenciaBaseDatos = conexionBaseDatos.createStatement();
        ResultSet resultadoBaseDatos = sentenciaBaseDatos.executeQuery("select max(idcompra) from COMPRA ");
        while (resultadoBaseDatos.next()) {
            ultimoIdCompra = resultadoBaseDatos.getInt(1) + 1;
        }
        resultadoBaseDatos.close();
        sentenciaBaseDatos.close();
        conexionBaseDatos.close();
        return ultimoIdCompra;
    }
   
    /**
    * Método que inserta el monto total de la compra a la base al id de la nueva compra.
    * @param idCompra El parámetro idCompra define el id de la nueva compra. Valor entero positivo mayor que cero.
    * @param montoTotalCompra  El parámetro montoTotalCompra define el monto total de la nueva compra. Valor decimal positivo mayor que cero
    */   
    public static void insertarMontoTotal(final int idCompra, final double montoTotalCompra) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarMontoTotalCompra = null;
        instruccionInsertarMontoTotalCompra = conexionBaseDatos.prepareStatement("UPDATE COMPRA SET montoTotal = ?, estado = ? where idCompra = ?");
        instruccionInsertarMontoTotalCompra.setDouble(1, montoTotalCompra);
        instruccionInsertarMontoTotalCompra.setString(2, "Completo");
        instruccionInsertarMontoTotalCompra.setInt(3, idCompra);
        instruccionInsertarMontoTotalCompra.executeUpdate();
        conexionBaseDatos.close();
        instruccionInsertarMontoTotalCompra.close();
    }
    
    public static ArrayList<Compra> listarVenta() throws SQLException{
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarVenta = null;
        ArrayList<Compra> listaVenta = new ArrayList<Compra>();
        instruccionListarVenta = conexionBaseDatos.prepareStatement("SELECT * FROM Compra");
        ResultSet resultado = instruccionListarVenta.executeQuery();
        while (resultado.next()) {
            Compra compra = new Compra(resultado.getInt("idcompra"),resultado.getString("dniCliente"),BaseDatosEmpleado.buscarEmpleado(resultado.getInt("nroEmpleado")),
            resultado.getString("fechacompra"),resultado.getString("tipoCambio"),resultado.getDouble("montoTotal"),resultado.getString("estado")) {};
            listaVenta.add(compra);
        }
        conexionBaseDatos.close();
        instruccionListarVenta.close();
        return listaVenta;
    }
    
    public static ArrayList<ProductoCliente> listarProductoCliente(String dniCliente) throws SQLException{
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarProductoCliente = null;
        ProductoCliente productoCliente =  new ProductoCliente(0,0, "", null, "", 0);
        NegocioCaja negocioCaja =  new NegocioCaja();
        ArrayList<ProductoCliente> listarProductoCliente = new ArrayList<ProductoCliente>();
        instruccionListarProductoCliente = conexionBaseDatos.prepareStatement("SELECT * FROM productoEsperaCliente where dniCliente = ?");
        instruccionListarProductoCliente.setString(1, dniCliente);
        ResultSet resultado = instruccionListarProductoCliente.executeQuery();
        while (resultado.next()) {
            productoCliente = new ProductoCliente(resultado.getInt("id"),0, resultado.getString("dniCliente"), negocioCaja.buscarCajaCodigo(resultado.getInt("idCaja")), "", 0);
            PreparedStatement instruccionListarProductoClienteDetalle = null;
            instruccionListarProductoClienteDetalle = conexionBaseDatos.prepareStatement("SELECT * FROM productoEsperaClienteDetalle where dniCliente = ?");
            instruccionListarProductoClienteDetalle.setString(1, dniCliente);
            ResultSet resultadoDetalle = instruccionListarProductoClienteDetalle.executeQuery();
            while(resultadoDetalle.next()){
                productoCliente = new ProductoCliente(resultado.getInt("id"),resultadoDetalle.getInt("id"), dniCliente, negocioCaja.buscarCajaCodigo(resultado.getInt("idCaja")), resultadoDetalle.getString("codigo_barra"), resultadoDetalle.getInt("cantidad"));
                listarProductoCliente.add(productoCliente);
            }
            instruccionListarProductoClienteDetalle.close();
        }
        instruccionListarProductoCliente.close();
        return listarProductoCliente;
    }
    
    public static ProductoCliente obtenerProductoCliente(String dniCliente) throws SQLException{
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarProductoCliente = null;
        ProductoCliente productoCliente =  new ProductoCliente(0,0, "", null, "", 0);
        NegocioCaja negocioCaja =  new NegocioCaja();
        instruccionListarProductoCliente = conexionBaseDatos.prepareStatement("SELECT * FROM productoEsperaCliente where dniCliente = ?");
        instruccionListarProductoCliente.setString(1, dniCliente);
        ResultSet resultado = instruccionListarProductoCliente.executeQuery();
        while (resultado.next()) {
            productoCliente = new ProductoCliente(resultado.getInt("id"),0, resultado.getString("dniCliente"), negocioCaja.buscarCajaCodigo(resultado.getInt("idCaja")), "", 0);
        }
        instruccionListarProductoCliente.close();
        return productoCliente;
    }
    
    public static void actualizarCantidadProductoEspera(final ProductoCliente productoCliente) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarCantidadProductoEspera = null;
        instruccionActualizarCantidadProductoEspera = conexionBaseDatos.prepareStatement("UPDATE productoesperaclientedetalle SET cantidad = ? where id = ? AND idEspera = ?");
        instruccionActualizarCantidadProductoEspera.setInt(1, productoCliente.getCantidadProducto());
        instruccionActualizarCantidadProductoEspera.setInt(2, productoCliente.getIdProductoCliente());
        instruccionActualizarCantidadProductoEspera.setInt(3, productoCliente.getIdGeneral());
        instruccionActualizarCantidadProductoEspera.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarCantidadProductoEspera.close();
    }
    
    public static void insertarNuevoProductoEspera(final ProductoCliente productoCliente) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarNuevoProductoEspera = null;
        instruccionInsertarNuevoProductoEspera = conexionBaseDatos.prepareStatement("INSERT INTO productoesperaclientedetalle(idEspera,codigo_barra,dniCliente,cantidad) VALUES (?,?,?,?)");
        instruccionInsertarNuevoProductoEspera.setInt(1, productoCliente.getIdGeneral());
        instruccionInsertarNuevoProductoEspera.setString(2, productoCliente.getCodigoBarraProducto());
        instruccionInsertarNuevoProductoEspera.setString(3, productoCliente.getDniCliente());
        instruccionInsertarNuevoProductoEspera.setInt(4, productoCliente.getCantidadProducto());
        instruccionInsertarNuevoProductoEspera.executeUpdate();
        conexionBaseDatos.close();
        instruccionInsertarNuevoProductoEspera.close();
    }
    
    public static int obtenerUltimoIdListaProductoCliente() throws SQLException {
        int ultimoIdListaProductoCliente = 0;
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Statement sentenciaBaseDatos = conexionBaseDatos.createStatement();
        ResultSet resultadoBaseDatos = sentenciaBaseDatos.executeQuery("select max(id) from productoesperaclientedetalle ");
        while (resultadoBaseDatos.next()) {
            ultimoIdListaProductoCliente = resultadoBaseDatos.getInt(1);
        }
        resultadoBaseDatos.close();
        sentenciaBaseDatos.close();
        conexionBaseDatos.close();
        return ultimoIdListaProductoCliente;
    }
    
    public static void eliminarEsperaProductoCliente(final int idEsperaProductoCliente) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionEliminarEsperaProductoCliente = null;
        instruccionEliminarEsperaProductoCliente = conexionBaseDatos.prepareStatement("delete from productoesperacliente WHERE id=?");
        instruccionEliminarEsperaProductoCliente.setInt(1, idEsperaProductoCliente);
        instruccionEliminarEsperaProductoCliente.executeUpdate();
        instruccionEliminarEsperaProductoCliente = conexionBaseDatos.prepareStatement("delete from productoesperaclientedetalle WHERE idEspera=?");
        instruccionEliminarEsperaProductoCliente.setInt(1, idEsperaProductoCliente);
        instruccionEliminarEsperaProductoCliente.executeUpdate();
        instruccionEliminarEsperaProductoCliente.close();
        conexionBaseDatos.close();
    }
    
    public static void eliminarFilaEsperaProductoCliente(final int idProductoCliente,final int cantidadProducto, final String codigoBarraProducto) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionEliminarEsperaProductoCliente = null;
        instruccionEliminarEsperaProductoCliente = conexionBaseDatos.prepareStatement("delete from productoesperaclientedetalle WHERE id=?");
        instruccionEliminarEsperaProductoCliente.setInt(1, idProductoCliente);
        instruccionEliminarEsperaProductoCliente.executeUpdate();      
        PreparedStatement instruccionActualizarStockProducto = null;
        instruccionActualizarStockProducto = conexionBaseDatos.prepareStatement("update producto set stock = stock + ? where codigo_barra = ?");
        instruccionActualizarStockProducto.setInt(1, cantidadProducto);
        instruccionActualizarStockProducto.setString(2, codigoBarraProducto);
        instruccionActualizarStockProducto.executeUpdate();
        instruccionEliminarEsperaProductoCliente.close();
        instruccionActualizarStockProducto.close();
        conexionBaseDatos.close();
    }
    
    public static void cancelarCompra(final int nroCompra) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarCompraEstado = null;
        instruccionActualizarCompraEstado = conexionBaseDatos.prepareStatement("UPDATE compra SET estado = ? where idcompra = ?");
        instruccionActualizarCompraEstado.setString(1, "Anulado");
        instruccionActualizarCompraEstado.setInt(2, nroCompra);
        instruccionActualizarCompraEstado.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarCompraEstado.close();
    }
    
    public static ArrayList<ProductoCliente> listarProductoClienteEspera() throws SQLException{
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarProductoClienteEspera = null;
        ArrayList<ProductoCliente> listaProductoEspera = new ArrayList();
        ProductoCliente productoCliente =  new ProductoCliente(0,0, "", null, "", 0);
        instruccionListarProductoClienteEspera = conexionBaseDatos.prepareStatement("SELECT * FROM productoEsperaCliente where (idCaja is null OR idCaja = 0) AND estado != 'Tomado' AND estado != 'Listo'");
        ResultSet resultado = instruccionListarProductoClienteEspera.executeQuery();
        while (resultado.next()) {
            productoCliente = new ProductoCliente(resultado.getInt("id"),0, resultado.getString("dniCliente"), null, "",0);
            listaProductoEspera.add(productoCliente);
        }
        instruccionListarProductoClienteEspera.close();
        return listaProductoEspera;
    }
    
    public static void actualizarEstadoTomadoProductoClienteEspera(final int idCaja, final int idProductoClienteEspera) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarEstadoTomadoProductoClienteEspera = null;
        instruccionActualizarEstadoTomadoProductoClienteEspera = conexionBaseDatos.prepareStatement("update productoesperacliente set idCaja = ?, estado = ? where id = ?");
        instruccionActualizarEstadoTomadoProductoClienteEspera.setInt(1, idCaja);
        instruccionActualizarEstadoTomadoProductoClienteEspera.setString(2, "Tomado");
        instruccionActualizarEstadoTomadoProductoClienteEspera.setInt(3, idProductoClienteEspera);
        instruccionActualizarEstadoTomadoProductoClienteEspera.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarEstadoTomadoProductoClienteEspera.close();
    }
    
    public static ArrayList<ProductoCliente> listarProductoClienteEsperaTomado(final int idCaja) throws SQLException{
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarProductoClienteEsperaTomado = null;
        ArrayList<ProductoCliente> listaProductoEspera = new ArrayList();
        ProductoCliente productoCliente =  new ProductoCliente(0,0, "", null, "", 0);
        instruccionListarProductoClienteEsperaTomado = conexionBaseDatos.prepareStatement("SELECT * FROM productoEsperaCliente where idCaja = ? AND estado = 'Tomado'");
        instruccionListarProductoClienteEsperaTomado.setInt(1, idCaja);
        ResultSet resultado = instruccionListarProductoClienteEsperaTomado.executeQuery();
        while (resultado.next()) {
            productoCliente = new ProductoCliente(resultado.getInt("id"),0, resultado.getString("dniCliente"), BaseDatosCaja.buscarCajaCodigo(idCaja), "",0);
            listaProductoEspera.add(productoCliente);
        }
        instruccionListarProductoClienteEsperaTomado.close();
        return listaProductoEspera;
    }
    
    public static ArrayList<ProductoCliente> listarProductoClienteTomado(int idEspera) throws SQLException{
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarProductoCliente = null;
        ProductoCliente productoCliente =  new ProductoCliente(0,0, "", null, "", 0);
        NegocioCaja negocioCaja =  new NegocioCaja();
        ArrayList<ProductoCliente> listarProductoCliente = new ArrayList<ProductoCliente>();
        instruccionListarProductoCliente = conexionBaseDatos.prepareStatement("SELECT * FROM productoEsperaClientedetalle where idEspera = ?");
        instruccionListarProductoCliente.setInt(1, idEspera);
        ResultSet resultado = instruccionListarProductoCliente.executeQuery();
        while (resultado.next()) {
            productoCliente = new ProductoCliente(idEspera, resultado.getInt("id"), resultado.getString("dniCliente"),null, resultado.getString("codigo_barra"), resultado.getInt("cantidad"));
            listarProductoCliente.add(productoCliente);
        }
        instruccionListarProductoCliente.close();
        return listarProductoCliente;
    }
    
    public static void actualizarEstadoTomadoProductoClienteListo(final int idCaja, final int idProductoClienteEspera) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarEstadoTomadoProductoClienteEspera = null;
        instruccionActualizarEstadoTomadoProductoClienteEspera = conexionBaseDatos.prepareStatement("update productoesperacliente set idCaja = ?, estado = ? where id = ?");
        instruccionActualizarEstadoTomadoProductoClienteEspera.setInt(1, idCaja);
        instruccionActualizarEstadoTomadoProductoClienteEspera.setString(2, "Listo");
        instruccionActualizarEstadoTomadoProductoClienteEspera.setInt(3, idProductoClienteEspera);
        instruccionActualizarEstadoTomadoProductoClienteEspera.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarEstadoTomadoProductoClienteEspera.close();
    }
}
