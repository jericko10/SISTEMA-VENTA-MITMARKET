package ComponenteNegocio;

import ComponenteClase.Producto;
import ComponenteDatos.BaseDatosProducto;
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
public class NegocioProducto {
    
    /**
    * Método que llama al método insertarProducto() de la clase BaseDatosProducto del paquete ComponenteDatos.
    * @param producto El parámetro producto define el objeto que contiene los datos sobre el producto y que será usado para poder ser
    * insertado en la base de datos. Los valores de producto no tiene que ser nulos, excepto el valor imagen del producto.
    */ 
    public void insertarProducto(final Producto producto) throws SQLException
    {
        BaseDatosProducto.insertarProducto(producto);
    }
    
    /**
    * Método que llama al método buscarProducto() de la clase BaseDatosProducto del paquete ComponenteDatos.
    * @param idProducto El parámetro idProducto define el id del producto a ser buscado. Valor entero positivo mayor que cero.
    * @return El objeto de la clase Producto con los datos encontrados del proceso de búsqueda.
    */ 
    public Producto buscarProducto(final int idProducto) throws SQLException {
        Producto producto = null;      
        producto = BaseDatosProducto.buscarProducto(idProducto);    
        return producto;
    }

    /**
    * Método que llama al método eliminarProducto() de la clase BaseDatosProducto del paquete ComponenteDatos.
    * @param idProducto El parámetro idProducto define el id del producto a ser eliminado. Valor entero positivo mayor que cero.
    */ 
    public void eliminarProducto(final int idProducto) throws SQLException
    {
        BaseDatosProducto.eliminarProducto(idProducto);
    }
    
    /**
    * Método que llama al método actualizarProducto() de la clase BaseDatosProducto del paquete ComponenteDatos.
    * @param producto El parámetro producto define el objeto de la clase Producto que contiene toda la información del producto, el
    * cual se actualizará sus datos.
    */ 
    public void actualizarProducto(final Producto producto) throws SQLException
    {
        BaseDatosProducto.actualizarProducto(producto);
    }
    
    /**
    * Método que llama al método mostrarProducto() de la clase BaseDatosProducto del paquete ComponenteDatos.
    * @return La lista de los productos.
    */ 
    public ArrayList<Producto> mostrarProducto() throws SQLException
    {
        return BaseDatosProducto.mostrarProducto();
    }
    
    public Producto buscarProductoCodigoBarra(final String codigoBarraProducto) throws SQLException{
        Producto producto = null;      
        producto = BaseDatosProducto.buscarProductoCodigoBarra(codigoBarraProducto);    
        return producto;
    }
}
