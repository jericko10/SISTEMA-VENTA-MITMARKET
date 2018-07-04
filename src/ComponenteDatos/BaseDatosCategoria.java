package ComponenteDatos;

import ComponenteClase.Categoria;
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
 * @author Rodriguez Zelada
 * @version 2.1
 * */
 
public class BaseDatosCategoria {

    static Connection conexionBaseDatos;
    
    /**
    * Método que inserta una nueva categoria a la base de datos.
    * @param categoria El parámetro categoria define el objeto que contiene los datos sobre la categoria y que será usado para poder ser
    * insertado en la base de datos. Los valores de categoria no tiene que ser nulos, excepto el valor imagen de la
    * categoria.
    */   
    public static void insertarCategoria(final Categoria categoria) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarCategoria = null;
        instruccionInsertarCategoria = conexionBaseDatos.prepareStatement("INSERT INTO Categoria (nombre,detalle,imagen) VALUES (?,?,?)");
        instruccionInsertarCategoria.setString(1, categoria.getNombreCategoria());
        instruccionInsertarCategoria.setString(2, categoria.getDetalleCategoria());
        instruccionInsertarCategoria.setString(3, categoria.getImagenCategoria());
        instruccionInsertarCategoria.executeUpdate();
        conexionBaseDatos.close();
        instruccionInsertarCategoria.close();
    }

    /**
    * Método que contiene la lógica de búsqueda de la categoria en base al codigo de la categoria.
    * @param codigoCategoria El parámetro codigoCategoria define el codigo de la categoria a ser buscado. Valor entero positivo mayor que cero.
    * @return El objeto de la clase Categoria con los datos encontrados del proceso de búsqueda.
    */ 
    public static Categoria buscarCategoriaCodigo(final int codigoCategoria) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionBusquedaCategoria = null;
        Categoria categoria = null;
        instruccionBusquedaCategoria = conexionBaseDatos.prepareStatement("select * from CATEGORIA where codcateg=?");
        instruccionBusquedaCategoria.setInt(1, codigoCategoria);
        ResultSet resultado= instruccionBusquedaCategoria.executeQuery();
        if (resultado.next()) {
            categoria = new Categoria(codigoCategoria, resultado.getString("nombre"), resultado.getString("detalle"),resultado.getString("imagen")) {
            };
        }
        conexionBaseDatos.close();
        instruccionBusquedaCategoria.close();
        return categoria;
    }

    /**
    * Método que contiene la lógica de búsqueda de la categoria en base al nombre de la categoria.
    * @param detalleCategoria El parámetro detalleCategoria define el detalle de la categoria a ser buscado.
    * @return El objeto de la clase Categoria con los datos encontrados del proceso de búsqueda.
    */ 
    public static Categoria buscarCategoriaDetalle(final String detalleCategoria) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionBusquedaCategoria = null;
        Categoria categoria = null;
        instruccionBusquedaCategoria = conexionBaseDatos.prepareStatement("select * from CATEGORIA where detalle=?");
        instruccionBusquedaCategoria.setString(1, detalleCategoria);
        ResultSet resultado = instruccionBusquedaCategoria.executeQuery();
        if (resultado.next()) {
            categoria = new Categoria(resultado.getInt("codcateg"), resultado.getString("nombre"), resultado.getString("detalle"), resultado.getString("imagen")) {
            };
        }
        conexionBaseDatos.close();
        instruccionBusquedaCategoria.close();
        return categoria;
    }

    /**
    * Método que elimina de la base de datos la categoria según su codigo de la categoria.
    * @param codigoCategoria El parámetro codigoCategoria define el codigo de la categoria a ser eliminado. Valor entero positivo mayor que cero.
    */ 
    public static void eliminarCategoria(final int codigoCategoria) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionEliminarCategoria = null;
        instruccionEliminarCategoria = conexionBaseDatos.prepareStatement("delete from CATEGORIA WHERE codcateg=?");
        instruccionEliminarCategoria.setInt(1, codigoCategoria);
        instruccionEliminarCategoria.executeUpdate();
        conexionBaseDatos.close();
        instruccionEliminarCategoria.close();
    }

    /**
    * Método que actualiza los datos de una categoria en la base de datos.
    * @param categoria El parámetro categoria define el objeto de la clase Categoria que contiene toda la información 
    * de la categoria para poder realizar la actualización de los datos de la categoria.
    */ 
    public static void actualizarCategoria(final Categoria categoria) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarCategoria = null;
        instruccionActualizarCategoria = conexionBaseDatos.prepareStatement("UPDATE CATEGORIA SET nombre = ?, detalle = ?, imagen=? WHERE codcateg=" + categoria.getCodigoCategoria());
        instruccionActualizarCategoria.setString(1, categoria.getNombreCategoria());
        instruccionActualizarCategoria.setString(2, categoria.getDetalleCategoria());
        instruccionActualizarCategoria.setString(3, categoria.getImagenCategoria());
        instruccionActualizarCategoria.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarCategoria.close();
    }

    /**
    * Método que obtiene la lista de las categorias actualmente almacenadas en la base de datos.
    * @return La lista de las categorias de la base de datos.
    */ 
    public static ArrayList<Categoria> mostrarCategoria() throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionListarCategoria = null;
        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        instruccionListarCategoria = conexionBaseDatos.prepareStatement("SELECT * FROM CATEGORIA");
        ResultSet resultado = instruccionListarCategoria.executeQuery();
        while (resultado.next()) {
            Categoria categoria = new Categoria(resultado.getInt("codcateg"), resultado.getString("nombre"), resultado.getString("detalle"), resultado.getString("imagen")) {
            };
            listaCategoria.add(categoria);
        }
        conexionBaseDatos.close();
        instruccionListarCategoria.close();
        return listaCategoria;
    }

    /**
     * Método que comprueba de que no exista similitud entre los detalles de una misma categoría.
     * @param nombreCategoria nombre de la categoria a buscar. String no vacío.
     * @param detalleCategoria detalle de la categoria a buscar. String no vacío.
     * @return Retorna un true si existe si existe similitud entre los detalles de una misma categoria, 
     * false si no lo es.
     */
    public static boolean comprobarIgualdadDetalle(String nombreCategoria, String detalleCategoria) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        boolean comprobarIgualdadDetalleCategoria = false;
        PreparedStatement instruccionBusquedaCategoriaDetalleIgualdad = null;
        instruccionBusquedaCategoriaDetalleIgualdad = conexionBaseDatos.prepareStatement("select * from CATEGORIA where nombre=? AND detalle=?");
        instruccionBusquedaCategoriaDetalleIgualdad.setString(1, nombreCategoria);
        instruccionBusquedaCategoriaDetalleIgualdad.setString(2, detalleCategoria);
        ResultSet resultado = instruccionBusquedaCategoriaDetalleIgualdad.executeQuery();
        if (resultado.next()) {
            comprobarIgualdadDetalleCategoria = true;
        }
        conexionBaseDatos.close();
        instruccionBusquedaCategoriaDetalleIgualdad.close();
        return comprobarIgualdadDetalleCategoria;
    }
}