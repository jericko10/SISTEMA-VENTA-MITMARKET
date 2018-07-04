package ComponenteNegocio;

import ComponenteClase.Categoria;
import ComponenteDatos.BaseDatosCategoria;
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
public class NegocioCategoria {
    
    /**
    * Método que llama al método insertarCategoria() de la clase BaseDatosCategoria del paquete ComponenteDatos.
    * @param categoria El parámetro categoria define el objeto que contiene los datos sobre la categoria y que será usado para poder ser
    * insertado en la base de datos. Los valores de categoria no tiene que ser nulos, excepto el valor imagen de la
    * categoria.
    */  
    public void insertarCategoria(final Categoria categoria) throws SQLException
    {
        BaseDatosCategoria.insertarCategoria(categoria);
    }
    
    /**
    * Método que llama al método buscarCategoriaNombre() de la clase BaseDatosCategoria del paquete ComponenteDatos.
    * @param detalleCategoria El parámetro detalleCategoria define el detalle de la categoria a ser buscado.
    * @return El objeto de la clase Categoria con los datos encontrados del proceso de búsqueda.
    */  
    public Categoria buscarCategoriaDetalle(final String detalleCategoria) throws SQLException {
        Categoria categoria = null;
        categoria = BaseDatosCategoria.buscarCategoriaDetalle(detalleCategoria);
        return categoria;
    }
    
    public Categoria buscarCategoriaCodigo(final int codigoCategoria) throws SQLException {
        Categoria categoria = null;
        categoria = BaseDatosCategoria.buscarCategoriaCodigo(codigoCategoria);
        return categoria;
    }
    
    /**
    * Método que llama al método eliminarCategoria() de la clase BaseDatosCategoria del paquete ComponenteDatos.
    * @param codigoCategoria El parámetro codigoCategoria define el codigo de la categoria a ser eliminado. Valor entero positivo mayor que cero.
    */ 
    public void eliminarCategoria(final int codigoCategoria) throws SQLException
    {
        BaseDatosCategoria.eliminarCategoria(codigoCategoria);
    }
    
    /**
    * Método que llama al método actualizarCategoria() de la clase BaseDatosCategoria del paquete ComponenteDatos.
    * @param categoria El parámetro categoria define el objeto de la clase Categoria que contiene toda la información 
    * de la categoria para poder realizar la actualización de los datos de la categoria.
    */ 
    public void actualizarCategoria(final Categoria categoria) throws SQLException
    {
        BaseDatosCategoria.actualizarCategoria(categoria);
    }
    
    /**
    * Método que llama al método mostrarCategoria() de la clase BaseDatosCategoria del paquete ComponenteDatos.
    * @return La lista de las categorias de la base de datos.
    */ 
    public ArrayList<Categoria> mostrarCategoria() throws SQLException
    {
        return BaseDatosCategoria.mostrarCategoria();
    }
    
    /**
     * Método que llama al método comprobarIgualdadDetalle() de la clase BaseDatosCategoria del paquete ComponenteDatos.
     * @param nombreCategoria nombre de la categoria a buscar. String no vacío.
     * @param detalleCategoria detalle de la categoria a buscar. String no vacío.
     * @return Retorna un true si existe si existe similitud entre los detalles de una misma categoria, 
     * false si no lo es.
     */
    public boolean comprobarIgualdadDetalle(String nombreCategoria, String detalleCategoria) throws SQLException
    {
        return BaseDatosCategoria.comprobarIgualdadDetalle(nombreCategoria,detalleCategoria);
    }
}
