package ComponenteNegocio;

import ComponenteClase.Empleado;
import ComponenteDatos.BaseDatosEmpleado;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 * 
 * @author Rodriguez Zelada
 * @version 2.1
 */
public class NegocioEmpleado {
    
    /**
    * Método que llama al método insertarEmpleado() de la clase BaseDatosEmpleado del paquete ComponenteDatos.
    * @param empleado El parámetro empleado define el objeto de la clase Empleado que contiene los datos sobre el 
    * empleado y que será usado para poder ser insertado en la base de datos. Los valores de empleado no tiene 
    * que ser nulos, excepto el valor imagen del empleado.
    */   
    public void insertarEmpleado(final Empleado empleado) throws SQLException
    {
        BaseDatosEmpleado.insertarEmpleado(empleado);
    }
    
    /**
    * Método que llama al método buscarEmpleadoDNI() de la clase BaseDatosEmpleado del paquete ComponenteDatos.
    * @param dniEmpleado El parámetro dniEmpleado define el número de DNI del empleado a ser buscado. Cadena de texto de 8 dígitos númericos.
    * @return El objeto de la clase Empleado con los datos encontrados del proceso de búsqueda.
    */ 
    public Empleado buscarEmpleado(final String dniEmpleado) throws SQLException
    {
        Empleado empleado = null;      
        empleado = BaseDatosEmpleado.buscarEmpleadoDNI(dniEmpleado);    
        return empleado;
    }
    
    public Empleado buscarEmpleadoCodigo(final int codigoEmpleado) throws SQLException
    {
        Empleado empleado = null;      
        empleado = BaseDatosEmpleado.buscarEmpleado(codigoEmpleado);    
        return empleado;
    }
    
    /**
    * Método que llama al método buscarEmpleadoApellido() de la clase BaseDatosEmpleado del paquete ComponenteDatos.
    * @param empleadoApellido El parámetro empleadoApellido define el apellido del empleado a ser buscado.
    * @return El objeto de la clase Empleado con los datos encontrados del proceso de búsqueda.
    */ 
    public Empleado buscarEmpleadoApellido(final String empleadoApellido) throws SQLException
    {
        Empleado empleado = null;      
        empleado = BaseDatosEmpleado.buscarEmpleadoApellido(empleadoApellido);    
        return empleado;
    }
    
    /**
    * Método que llama al método eliminarEmpleadoDNI() de la clase BaseDatosEmpleado del paquete ComponenteDatos.
    * @param dniEmpleado El parámetro dniEmpleado define el número de DNI del empleado a ser eliminado. Cadena de 8 dígitos númericos.
    */ 
    public void eliminarEmpleado(final String dniEmpleado) throws SQLException
    {
        BaseDatosEmpleado.eliminarEmpleadoDNI(dniEmpleado);
    }
    
    /**
    * Método que llama al método actualizarEmpleado() de la clase BaseDatosEmpleado del paquete ComponenteDatos.
    * @param empleado El parámetro empleado define el objeto de la clase Empleado que contiene toda la información del Empleado, el
    * cual se actualizará sus datos.
    */ 
    public void actualizarEmpleado(final Empleado empleado) throws SQLException
    {
        BaseDatosEmpleado.actualizarEmpleado(empleado);
    }
    
    /**
    * Método que llama al método mostrarEmpleado() de la clase BaseDatosEmpleado del paquete ComponenteDatos.
    * @return La lista de los empleados.
    */ 
    public ArrayList<Empleado> mostrarEmpleado() throws SQLException
    {
        return BaseDatosEmpleado.mostrarEmpleado();
    }
}
