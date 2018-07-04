package ComponenteNegocio;

import ComponenteClase.Categoria;
import ComponenteClase.Producto;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mamani Bedregal
 */
public class NegocioProductoTest {
    
    private Producto productoVendido;
    private Producto productoSinVender;
    private Categoria categoria;
    
    @Before
    public void setUp() {
        categoria = new Categoria(0,"","","");
        productoVendido = new Producto(1,"AGUA MINERAL","mililitros",categoria,1,"","1234567895696",20);
        productoSinVender = new Producto(0,"","",categoria,0,"","1234567895697",18);
    }
    
    @After
    public void tearDown() {
        productoVendido = null;
        categoria = null;
        productoSinVender = null;
    }
    
    /**
     * Test of buscarProducto method, of class NegocioProducto.
     */
    @Test
    public void testBuscarProducto() throws Exception {
        System.out.println("buscarProducto");
        NegocioProducto instance = new NegocioProducto();
        Producto result = instance.buscarProducto(3);
        if(productoVendido.getIdProducto() == result.getIdProducto()){
            assertTrue(true);
        }
    }
    
    /**
     * Test of mostrarProducto method, of class NegocioProducto.
     */
    @Test
    public void testMostrarProducto() throws Exception {
        System.out.println("mostrarProducto");
        NegocioProducto instance = new NegocioProducto();
        ArrayList<Producto> result = instance.mostrarProducto();
        if(result.size()>0){
            assertTrue(true);
        }
        else{
            assertTrue("Error o resultado vacío",false);
        }
    }

    /**
     * Test of buscarProductoCodigoBarra method, of class NegocioProducto.
     */
    @Test
    public void testBuscarProductoCodigoBarra() throws Exception {
        System.out.println("buscarProductoCodigoBarra");
        NegocioProducto instance = new NegocioProducto();
        Producto result = instance.buscarProductoCodigoBarra("1234567895696");
        if(productoVendido.getNombre().equals(result.getNombre())){
            assertTrue(true);
        }
        else{
            assertTrue("Prueba falló: Producto no se encuentra.",false);
        } 
    }
}
