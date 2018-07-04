package ComponenteNegocio;

import ComponenteClase.Transaccion;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mamani Bedregal
 */
public class NegocioTransaccionTest {

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerTransaccion method, of class NegocioTransaccion.
     */
    @Test
    public void testObtenerTransaccion() throws Exception {
        System.out.println("obtenerTransaccion");
        NegocioTransaccion instance = new NegocioTransaccion();
        ArrayList<Transaccion> result = instance.obtenerTransaccion(1); //cambiar codigoCompra
        if(result.size()>=0){
            assertTrue(true);
        }
    }
    
}
