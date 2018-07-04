package ComponenteClase;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 * 
 * @author Mamani Bedregal
 * @version 2.1
 */
public class Producto {

    private final int idProducto;
    private final String nombre;
    private final String unidadMedida;
    private final Categoria categoria;
    private final float precioUnidad;
    private final int stock;
    private final String imagen;
    private final String codigoBarra;

    public Producto(final int idProducto, final String nombre, final String unidadMedida, final Categoria categoria, final float precioUnidad, final String imagen, final String codigoBarra, final int stock){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.categoria = categoria;
        this.precioUnidad = precioUnidad;
        this.imagen = imagen;
        this.codigoBarra = codigoBarra;
        this.stock = stock;
    }
    
    public String getCodigoBarra() {
        return codigoBarra;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public String getImagen() {
        return imagen;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public int getStock() {
        return stock;
    }
    
}
