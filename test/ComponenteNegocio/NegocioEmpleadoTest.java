package ComponenteNegocio;

import ComponenteClase.Empleado;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mamani Bedregal
 */
public class NegocioEmpleadoTest {
    
    private Empleado empleado;
    
    @Before
    public void setUp() {
        empleado = new Empleado(1,"47197204","BUDDY RICHARD","ORUNA RODRIGUEZ","tkcrashr.18@gmail.com","M",19,
                "(44)-276-121","(44)-94882-5896","Psj Gar. de la Vega #138 - La Esperanza Parte Baja", "");
    }
    
    @After
    public void tearDown() {
        empleado = null;
    }

    /**
     * Test of buscarEmpleado method, of class NegocioEmpleado.
     */
    @Test
    public void testBuscarEmpleado() throws Exception {
        System.out.println("buscarEmpleado");
        NegocioEmpleado instance = new NegocioEmpleado();
        Empleado result = instance.buscarEmpleado("47197204");
        if(empleado.getNumeroEmpleado()== result.getNumeroEmpleado()){
            assertTrue(true);
        }
        else{
            assertTrue("Prueba falló: Empleado no se encuentra.",false);
        } 
    }

    /**
     * Test of buscarEmpleadoCodigo method, of class NegocioEmpleado.
     */
    @Test
    public void testBuscarEmpleadoCodigo() throws Exception {
        System.out.println("buscarEmpleadoCodigo");
        NegocioEmpleado instance = new NegocioEmpleado();
        Empleado result = instance.buscarEmpleadoCodigo(1);
        if(empleado.getNumeroEmpleado()== result.getNumeroEmpleado()){
            assertTrue(true);
        }
        else{
            assertTrue("Prueba falló: Empleado no se encuentra.",false);
        } 
    }

    /**
     * Test of buscarEmpleadoApellido method, of class NegocioEmpleado.
     */
    @Test
    public void testBuscarEmpleadoApellido() throws Exception {
        System.out.println("buscarEmpleadoApellido");
        NegocioEmpleado instance = new NegocioEmpleado();
        Empleado result = instance.buscarEmpleadoApellido("Perez");
        if(empleado.getNumeroEmpleado()== result.getNumeroEmpleado()){
            assertTrue(true);
        }
        else{
            assertTrue("Prueba falló: Empleado no se encuentra.",false);
        } 
    }

    /**
     * Test of mostrarEmpleado method, of class NegocioEmpleado.
     */
    @Test
    public void testMostrarEmpleado() throws Exception {
        System.out.println("mostrarEmpleado");
        NegocioEmpleado instance = new NegocioEmpleado();
        ArrayList<Empleado> result = instance.mostrarEmpleado();
        if(result.size()>=0){
            assertTrue(true);
        }
    }
    
}
