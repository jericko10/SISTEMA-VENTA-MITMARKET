package ComponenteClase;
import java.util.Date;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public class Compra {

    private final int idCompra;
    private final String dniCliente;
    private final Empleado empleado;
    private final String fechaCompra;
    private final String tipoCambio;
    private final double montoTotal;
    private final String estado;
    
    public Compra(final int idCompra, final String dniCliente, final Empleado empleado, final String fechaCompra, final String tipoCambio, final double montoTotal, final String estado){
        this.idCompra = idCompra;
        this.dniCliente = dniCliente;
        this.empleado = empleado;
        this.fechaCompra = fechaCompra;
        this.tipoCambio = tipoCambio;
        this.montoTotal = montoTotal;
        this.estado =  estado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }
    
    public String getDniCliente() {
        return dniCliente;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public String getEstado() {
        return estado;
    }
}
