package ComponenteNegocio;

import ComponenteClase.Caja;
import ComponenteDatos.BaseDatosCaja;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mamani Bedregal
 * @version 1.0
 */
public class NegocioCaja {
    public void insertarCaja(final Caja Caja) throws SQLException
    {
        BaseDatosCaja.insertarCaja(Caja);
    }
    
    public Caja buscarCajaCodigo(final int codigoCaja) throws SQLException {
        Caja caja = null;
        caja = BaseDatosCaja.buscarCajaCodigo(codigoCaja);
        return caja;
    }
    
    public Caja buscarCajaNombre(final String nombreCaja) throws SQLException {
        Caja caja = null;
        caja = BaseDatosCaja.buscarCajaNombre(nombreCaja);
        return caja;
    }
    
    public void eliminarCaja(final int codigoCaja) throws SQLException
    {
        BaseDatosCaja.eliminarCaja(codigoCaja);
    }
    
    public void actualizarCaja(final Caja Caja) throws SQLException
    {
        BaseDatosCaja.actualizarCaja(Caja);
    }
    
    public ArrayList<Caja> mostrarCaja() throws SQLException
    {
        return BaseDatosCaja.mostrarCaja();
    }
    
    public void actualizarEstadoCaja(final int idCaja, final String estado) throws SQLException{
        BaseDatosCaja.actualizarEstadoCaja(idCaja,estado);
    }
}
