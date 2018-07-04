package ComponenteClase;
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
public class Transaccion {

    private final Producto producto;
    private final Compra compra;
    private final int cantidad;

    public Transaccion(final Producto producto, final Compra compra, final int cantidad){
        this.producto = producto;
        this.compra = compra;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Compra getCompra() {
        return compra;
    }

    public int getCantidad() {
        return cantidad;
    }
}
