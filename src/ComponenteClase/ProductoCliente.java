package ComponenteClase;

/**
 *
 * @author Mamani Bedregal
 * @version 1.0
 */
public class ProductoCliente {
    private final int idGeneral;
    private final int idProductoCliente;
    private final String dniCliente;
    private final Caja caja;
    private final String codigoBarraProducto;
    private final int cantidadProducto;
    
    public ProductoCliente(final int idGeneral, final int idProductoCliente, final String dniCliente, final Caja caja, final String codigoBarraProducto, final int cantidadProducto){
        this.idGeneral = idGeneral;
        this.idProductoCliente = idProductoCliente;
        this.dniCliente = dniCliente;
        this.caja = caja;
        this.codigoBarraProducto = codigoBarraProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public int getIdProductoCliente() {
        return idProductoCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public Caja getCaja() {
        return caja;
    }

    public String getCodigoBarraProducto() {
        return codigoBarraProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public int getIdGeneral() {
        return idGeneral;
    }
}
