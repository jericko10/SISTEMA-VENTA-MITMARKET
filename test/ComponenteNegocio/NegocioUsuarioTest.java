package ComponenteNegocio;

import ComponenteClase.Empleado;
import ComponenteClase.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mamani Bedregal
 */
public class NegocioUsuarioTest {
    
    private Usuario usuario;
    private Empleado empleado;
    
    @Before
    public void setUp() {
        empleado = new Empleado(1,"","","","","",0,"","","","");
        usuario = new Usuario(1,"ADMINISTRADOR",empleado,"123456","Administrador");
    }
    
    @After
    public void tearDown() {
        usuario = null;
        empleado = null;
    }

    /**
     * Test of buscarUsuario method, of class NegocioUsuario.
     */
    @Test
    public void testBuscarUsuario() throws Exception {
        System.out.println("buscarUsuario");
        NegocioUsuario instance = new NegocioUsuario();
        Usuario result = instance.buscarUsuario(usuario.getIdUsuario());
        if(usuario.getNombreUsuario().equals(result.getNombreUsuario()) && usuario.getContrasenaUsuario().equals(result.getContrasenaUsuario()) &&
               usuario.getEmpleado().getNumeroEmpleado() == result.getEmpleado().getNumeroEmpleado()){
            assertTrue(true);
        }
        else{
            assertTrue("Prueba falló: Categoria no se encuentra.",false);
        }        
    }
    
    /**
     * Test of mostrarUsuario method, of class NegocioUsuario.
     */
    @Test
    public void testMostrarUsuario() throws Exception {
        System.out.println("mostrarUsuario");
        NegocioUsuario instance = new NegocioUsuario();
        ArrayList<Usuario> result = instance.mostrarUsuario();
        if(result.size()>=0){
            assertTrue(true);
        }
    }
    
}
