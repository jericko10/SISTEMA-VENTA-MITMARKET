package ComponenteNegocio;

import ComponenteClase.Categoria;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mamani Bedregal
 */
public class NegocioCategoriaTest {
    
    private Categoria categoria;
    
    @Before
    public void setUp() {
        categoria = new Categoria(1,"AGUA","120ml","");
    }
    
    @After
    public void tearDown() {
        categoria = null;
    }

    /**
     * Test of buscarCategoriaDetalle method, of class NegocioCategoria.
     */
    @Test
    public void testBuscarCategoriaDetalle() throws Exception {
        System.out.println("buscarCategoriaDetalle");
        NegocioCategoria instance = new NegocioCategoria();
        Categoria result = instance.buscarCategoriaDetalle("120ml");
        if(categoria.getCodigoCategoria() == result.getCodigoCategoria() && categoria.getDetalleCategoria().equals(result.getDetalleCategoria())){
            assertTrue(true);
        }
        else{
            assertTrue("Prueba falló: Categoria no se encuentra.",false);
        }
    }

    /**
     * Test of buscarCategoriaCodigo method, of class NegocioCategoria.
     */
    @Test
    public void testBuscarCategoriaCodigo() throws Exception {
        System.out.println("buscarCategoriaCodigo");
        NegocioCategoria instance = new NegocioCategoria();
        Categoria result = instance.buscarCategoriaCodigo(1);
        if(categoria.getCodigoCategoria() == result.getCodigoCategoria() && categoria.getDetalleCategoria().equals(result.getDetalleCategoria())){
            assertTrue(true);
        }
        else{
            assertTrue("Prueba falló: Categoria no se encuentra.",false);
        }
    }
    
    /**
     * Test of mostrarCategoria method, of class NegocioCategoria.
     */
    @Test
    public void testMostrarCategoria() throws Exception {
        System.out.println("mostrarCategoria");
        NegocioCategoria instance = new NegocioCategoria();
        ArrayList<Categoria> result = instance.mostrarCategoria();
        if(result.size()>=0){
            assertTrue(true);
        }
    }

    /**
     * Test of comprobarIgualdadDetalle method, of class NegocioCategoria.
     */
    @Test
    public void testComprobarIgualdadDetalle() throws Exception {
        System.out.println("comprobarIgualdadDetalle");
        NegocioCategoria instance = new NegocioCategoria();
        boolean result = instance.comprobarIgualdadDetalle("AGUA", "120ml");
        assertEquals(true, result);
    }
    
}
