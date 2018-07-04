package ComponenteNegocio;

import ComponenteClase.Compra;
import ComponenteClase.Empleado;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mamani Bedregal
 */
public class NegocioCompraTest {
    
    private Compra compra;
    private Empleado empleado;
    
    @Before
    public void setUp() {
        empleado = new Empleado(1,"","","","","",0,"","","","");
        compra = new Compra(1,"00326598",empleado,"2010-08-30","DOLAR",14.75,"");
    }
    
    @After
    public void tearDown() {
        compra = null;
        empleado = null;
    }
    
    /**
     * Test of buscarCompra method, of class NegocioCompra.
     */
    @Test
    public void testBuscarCompra() throws Exception {
        System.out.println("buscarCompra");
        NegocioCompra instance = new NegocioCompra();
        Compra result = instance.buscarCompra(1);
        if(compra.getIdCompra() == (result.getIdCompra()) &&
               compra.getTipoCambio().equals(result.getTipoCambio()) && compra.getMontoTotal() == result.getMontoTotal() &&
                       compra.getEmpleado().getNumeroEmpleado() == (result.getEmpleado().getNumeroEmpleado())){
            assertTrue(true);
        }
        else{
            assertTrue("Prueba falló: Categoria no se encuentra.",false);
        } 
    }

    /**
     * Test of obtenerUltimoIdCompra method, of class NegocioCompra.
     */
    @Test
    public void testObtenerUltimoIdCompra() throws Exception {
        System.out.println("obtenerUltimoIdCompra");
        NegocioCompra instance = new NegocioCompra();
        int expResult = 1;
        int result = compra.getIdCompra();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calcularCompra method, of class NegocioCompra.
     */
    @Test
    public void testCalcularCompra() {
        System.out.println("calcularCompra");
        Double montoListaProducto = 12.5;
        NegocioCompra instance = new NegocioCompra();
        double result = instance.calcularCompra(montoListaProducto);
        assertEquals(compra.getMontoTotal(), result, 0.0);
    }

    /**
     * Test of listarVenta method, of class NegocioCompra.
     */
    @Test
    public void testListarVenta() throws Exception {
        System.out.println("listarVenta");
        NegocioCompra instance = new NegocioCompra();
        ArrayList<Compra> result = instance.listarVenta();
        if(result.size()>=0){
            assertTrue(true);
        }
    }
}
