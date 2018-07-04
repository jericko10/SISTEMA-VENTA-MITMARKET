package ComponenteClase;
/**
 *
 * @author Mamani Bedregal
 * @version 1.0
 */
public class Caja {
    private final int idCaja;
    private final String nombreCaja;
    private final String estadoCaja;
    
    public Caja(final int idCaja, final String nombreCaja, final String estadoCaja){
        this.idCaja = idCaja;
        this.nombreCaja = nombreCaja;
        this.estadoCaja = estadoCaja;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public String getNombreCaja() {
        return nombreCaja;
    }

    public String getEstadoCaja() {
        return estadoCaja;
    }
}
