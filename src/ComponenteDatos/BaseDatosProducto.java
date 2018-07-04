package ComponenteDatos;

import ComponenteClase.Producto;
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
 */
public class BaseDatosProducto {

    static Connection conexionBaseDatos = null;  
    /**
    * Método que inserta un nuevo producto a la base de datos.
    * @param producto El parámetro producto define el objeto que contiene los datos sobre el producto y que será usado para poder ser
    * insertado en la base de datos. Los valores de producto no tiene que ser nulos, excepto el valor imagen del producto.
    */   
    public static void insertarProducto(final Producto producto) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarProducto = null;
        if(verificarProductoSimilar(producto.getIdProducto(),producto.getNombre(),producto.getCategoria().getCodigoCategoria())){
            throw new SQLException("Existe el mismo producto almacenado. Compruebe el nombre o categoría del producto a guardar.");
        }
        else{
            instruccionInsertarProducto = conexionBaseDatos.prepareStatement("INSERT INTO PRODUCTO (nombre, codcateg, preciounidad,unidadmed,imagen,codigo_barra,stock) VALUES (?,?,?,?,?,?,?)");
            instruccionInsertarProducto.setString(1, producto.getNombre());
            instruccionInsertarProducto.setInt(2,producto.getCategoria().getCodigoCategoria());
            instruccionInsertarProducto.setDouble(3,producto.getPrecioUnidad());
            instruccionInsertarProducto.setString(4,producto.getUnidadMedida());
            instruccionInsertarProducto.setString(5, producto.getImagen());
            instruccionInsertarProducto.setString(6, producto.getCodigoBarra());
            instruccionInsertarProducto.setInt(7, producto.getStock());
            instruccionInsertarProducto.executeUpdate();
            conexionBaseDatos.close();
            instruccionInsertarProducto.close();
        }
    }
    
    /**
    * Método que contiene toda la lógica de búsqueda del producto en base al id del producto.
    * @param idProducto El parámetro idProducto define el id del producto a ser buscado. Valor entero positivo mayor que cero.
    * @return El objeto de la clase Producto con los datos encontrados del proceso de búsqueda.
    */ 
    public static Producto buscarProducto(final int idProducto) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Producto producto = new Producto(0,"","",null,0,"","",0){};
        PreparedStatement instruccionBusquedaProducto = null;
        instruccionBusquedaProducto = conexionBaseDatos.prepareStatement("select * from PRODUCTO where idProducto=?");
        instruccionBusquedaProducto.setInt(1, idProducto);
        ResultSet resultado = instruccionBusquedaProducto.executeQuery();
        if (resultado.next()) {
            producto = new Producto(idProducto,resultado.getString("nombre"),resultado.getString("unidadmed"),
            BaseDatosCategoria.buscarCategoriaCodigo(resultado.getInt("codcateg")), resultado.getFloat("preciounidad"),
            resultado.getString("imagen"), resultado.getString("codigo_barra"), resultado.getInt("stock"));
        }
        conexionBaseDatos.close();
        instruccionBusquedaProducto.close();
        return producto;
    }
    
    /**
    * Método que elimina de la base de datos al producto según su id de producto.
    * @param idProducto El parámetro idProducto define el id del producto a ser eliminado. Valor entero positivo mayor que cero.
    */ 
    public static void eliminarProducto(final int idProducto) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionEliminarProducto = null;
        instruccionEliminarProducto = conexionBaseDatos.prepareStatement("delete from PRODUCTO WHERE idProducto=?");
        instruccionEliminarProducto.setInt(1, idProducto);
        instruccionEliminarProducto.executeUpdate();
        conexionBaseDatos.close();
        instruccionEliminarProducto.close();
    }

    /**
    * Método que actualiza los datos de la base de datos de un producto.
    * @param producto El parámetro producto define el objeto de la clase Producto que contiene toda la información del producto, el
    * cual se actualizará sus datos.
    */ 
    public static void actualizarProducto(final Producto producto) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarDatoProducto = null;
        if(verificarProductoSimilar(producto.getIdProducto(),producto.getNombre(),producto.getCategoria().getCodigoCategoria())){
            throw new SQLException("Existe el mismo producto almacenado. Compruebe el nombre o categoría del producto a guardar.");
        }
        else{
            instruccionActualizarDatoProducto = conexionBaseDatos.prepareStatement("UPDATE PRODUCTO SET nombre=?, codcateg=?, preciounidad=?,unidadmed=?,imagen=?,codigo_barra=?,stock=? WHERE idProducto=" + producto.getIdProducto());
            instruccionActualizarDatoProducto.setString(1, producto.getNombre());
            instruccionActualizarDatoProducto.setInt(2, producto.getCategoria().getCodigoCategoria());
            instruccionActualizarDatoProducto.setFloat(3,producto.getPrecioUnidad());
            instruccionActualizarDatoProducto.setString(4,producto.getUnidadMedida());
            instruccionActualizarDatoProducto.setString(5, producto.getImagen());
            instruccionActualizarDatoProducto.setString(6, producto.getCodigoBarra());
            instruccionActualizarDatoProducto.setInt(7, producto.getStock());
            instruccionActualizarDatoProducto.executeUpdate();
            conexionBaseDatos.close();
            instruccionActualizarDatoProducto.close();
        }
    }

    /**
    * Método que obtiene la lista de los productos actualmente almacenados en la base de datos.
    * @return La lista de los productos.
    */ 
    public static ArrayList<Producto> mostrarProducto() throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionObtenerProductos = null;
        ArrayList<Producto> listaProducto = new ArrayList<Producto>();
        instruccionObtenerProductos = conexionBaseDatos.prepareStatement("SELECT * FROM PRODUCTO");
        ResultSet resultado = instruccionObtenerProductos.executeQuery();
        while (resultado.next()) {
            Producto producto = new Producto(resultado.getInt("idProducto"),resultado.getString("nombre"),resultado.getString("unidadmed"),
            BaseDatosCategoria.buscarCategoriaCodigo(resultado.getInt("codcateg")), resultado.getFloat("preciounidad"),
            resultado.getString("imagen"), resultado.getString("codigo_barra"),resultado.getInt("stock"));
            listaProducto.add(producto);
        }
        conexionBaseDatos.close();
        instruccionObtenerProductos.close();
        return listaProducto;
    }
    
    public static Producto buscarProductoCodigoBarra(String codigoBarraProducto) throws SQLException{
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Producto producto = new Producto(0,"","",null,0,"","",0){};
        PreparedStatement instruccionBusquedaCodigoBarraProducto = null;
        instruccionBusquedaCodigoBarraProducto = conexionBaseDatos.prepareStatement("select * from PRODUCTO where codigo_barra=?");
        instruccionBusquedaCodigoBarraProducto.setString(1, codigoBarraProducto);
        ResultSet resultado = instruccionBusquedaCodigoBarraProducto.executeQuery();
        if (resultado.next()) {
            producto = new Producto(resultado.getInt("idProducto"),resultado.getString("nombre"),resultado.getString("unidadmed"),
            BaseDatosCategoria.buscarCategoriaCodigo(resultado.getInt("codcateg")), resultado.getFloat("preciounidad"),
            resultado.getString("imagen"), resultado.getString("codigo_barra"),resultado.getInt("stock"));
        }
        conexionBaseDatos.close();
        instruccionBusquedaCodigoBarraProducto.close();
        return producto;
    }
    
    public static ArrayList<Producto> mostrarProductoSinVender() throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionObtenerProductos = null;
        ArrayList<Producto> listaProducto = new ArrayList<Producto>();
        instruccionObtenerProductos = conexionBaseDatos.prepareStatement("SELECT *\n" +
                    "FROM PRODUCTO as P\n" +
                    "WHERE NOT EXISTS (SELECT 1 FROM TRANSACCION as T WHERE P.codigo_barra = T.codigo_barra)");
        ResultSet resultado = instruccionObtenerProductos.executeQuery();
        while (resultado.next()) {
            Producto producto = new Producto(resultado.getInt("idProducto"),resultado.getString("nombre"),resultado.getString("unidadmed"),
            BaseDatosCategoria.buscarCategoriaCodigo(resultado.getInt("codcateg")), resultado.getFloat("preciounidad"),
            resultado.getString("imagen"), resultado.getString("codigo_barra"), resultado.getInt("stock"));
            listaProducto.add(producto);
        }
        conexionBaseDatos.close();
        instruccionObtenerProductos.close();
        return listaProducto;
    }
    
    public static Producto obtenerProductoSinVender(String codigoBarraProducto) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionObtenerProductos = null;
        Producto producto = new Producto(0,"","",null,0,"","",0){};
        instruccionObtenerProductos = conexionBaseDatos.prepareStatement("SELECT * \n" +
                    "FROM PRODUCTO as P \n" +
                    "WHERE NOT EXISTS (SELECT 1 FROM TRANSACCION as T WHERE P.codigo_barra = T.codigo_barra) AND P.codigo_barra = '" + codigoBarraProducto + "'");
        ResultSet resultado = instruccionObtenerProductos.executeQuery();
        while (resultado.next()) {
            producto = new Producto(resultado.getInt("idProducto"),resultado.getString("nombre"),resultado.getString("unidadmed"),
            BaseDatosCategoria.buscarCategoriaCodigo(resultado.getInt("codcateg")), resultado.getFloat("preciounidad"),
            resultado.getString("imagen"), resultado.getString("codigo_barra"), resultado.getInt("stock"));
        }
        conexionBaseDatos.close();
        instruccionObtenerProductos.close();
        return producto;
    }
    
    public static boolean verificarProductoSimilar(final int idProducto, final String nombreProducto, final int idCategoriaProducto) throws SQLException{
        boolean verificar = false;
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionObtenerProductos = null;
        if(idProducto == 0){
            instruccionObtenerProductos = conexionBaseDatos.prepareStatement("select * from producto where nombre='" + nombreProducto + "' AND codcateg=" + idCategoriaProducto);
            ResultSet resultado = instruccionObtenerProductos.executeQuery();
            while(resultado.next()){
                verificar=true;
                break;
            }
            return verificar;
        }
        else{
            return verificar;
        }
    }
}
