package ComponenteDatos;

import ComponenteClase.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public class BaseDatosEmpleado {
    
    static Connection conexionBaseDatos = null;
    /**
    * Método que inserta un nuevo empleado a la base de datos.
    * @param empleado El parámetro empleado define el objeto de la clase Empleado que contiene los datos sobre el 
    * empleado y que será usado para poder ser insertado en la base de datos. Los valores de empleado no tiene 
    * que ser nulos, excepto el valor imagen del empleado.
    */    
    public static void insertarEmpleado(final Empleado empleado) throws SQLException {    
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionInsertarEmpleado = conexionBaseDatos.prepareStatement("INSERT INTO EMPLEADO (dni, nombre, apellido, email, sexo, edad, telefono, celular,direccion,imagen) VALUES (?,?,?,?,?,?,?,?,?,?)");
        instruccionInsertarEmpleado.setString(1, empleado.getDni());
        instruccionInsertarEmpleado.setString(2, empleado.getNombre());
        instruccionInsertarEmpleado.setString(3, empleado.getApellido());
        instruccionInsertarEmpleado.setString(4, empleado.getEmail());
        instruccionInsertarEmpleado.setString(5, String.valueOf(empleado.getSexo()));
        instruccionInsertarEmpleado.setInt(6, empleado.getEdad());
        instruccionInsertarEmpleado.setString(7, empleado.getTelefono());
        instruccionInsertarEmpleado.setString(8, empleado.getCelular());
        instruccionInsertarEmpleado.setString(9, empleado.getDireccion());
        instruccionInsertarEmpleado.setString(10, empleado.getImagen());
        instruccionInsertarEmpleado.executeUpdate();
        conexionBaseDatos.close();
        instruccionInsertarEmpleado.close();
    }

    /**
    * Método que contiene toda la lógica de búsqueda del empleado en base al número del empleado.
    * @param numeroEmpleado El parámetro numeroEmpleado define el número del empleado a ser buscado. Valor entero positivo mayor que cero.
    * @return El objeto de la clase Empleado con los datos encontrados del proceso de búsqueda.
    */ 
    public static Empleado buscarEmpleado(final int numeroEmpleado) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Empleado empleado = new Empleado(0,"","","","","",0,"","","",""){};
        PreparedStatement instruccionBuscarEmpleado = null;
        instruccionBuscarEmpleado = conexionBaseDatos.prepareStatement("select * from EMPLEADO where nroEmpleado=?");
        instruccionBuscarEmpleado.setInt(1, numeroEmpleado);
        ResultSet resultado = instruccionBuscarEmpleado.executeQuery();
        if (resultado.next()) {
            empleado = new Empleado(numeroEmpleado,resultado.getString("dni"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("email"),
            resultado.getString("sexo"),resultado.getInt("edad"),resultado.getString("telefono"),resultado.getString("celular"),resultado.getString("direccion"),resultado.getString("imagen"));
        }
        conexionBaseDatos.close();
        instruccionBuscarEmpleado.close();
        return empleado;
    }

    /**
    * Método que contiene toda la lógica de búsqueda del empleado en base al DNI del empleado.
    * @param dniEmpleado El parámetro dniEmpleado define el número de DNI del empleado a ser buscado. Cadena de texto de 8 dígitos númericos.
    * @return El objeto de la clase Empleado con los datos encontrados del proceso de búsqueda.
    */ 
    public static Empleado buscarEmpleadoDNI(final String dniEmpleado) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Empleado empleado = new Empleado(0,"","","","","",0,"","","",""){};
        PreparedStatement instruccionBusquedaEmpleado = null;
        instruccionBusquedaEmpleado = conexionBaseDatos.prepareStatement("select * from EMPLEADO where dni=?");
        instruccionBusquedaEmpleado.setString(1, dniEmpleado);
        ResultSet resultado = instruccionBusquedaEmpleado.executeQuery();
        if (resultado.next()) {
            empleado = new Empleado(resultado.getInt("nroEmpleado"),resultado.getString("dni"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("email"),
            resultado.getString("sexo"),resultado.getInt("edad"),resultado.getString("telefono"),resultado.getString("celular"),resultado.getString("direccion"),resultado.getString("imagen"));
        } else {
            empleado = null;
        }
        conexionBaseDatos.close();
        instruccionBusquedaEmpleado.close();
        return empleado;
    }
    
    /**
    * Método que contiene toda la lógica de búsqueda del empleado en base al apellido del empleado.
    * @param apellidoEmpleado El parámetro apellidoEmpleado define el apellido del empleado a ser buscado.
    * @return El objeto de la clase Empleado con los datos encontrados del proceso de búsqueda.
    */ 
    public static Empleado buscarEmpleadoApellido(final String apellidoEmpleado) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        Empleado empleado = new Empleado(0, "", "", "", "", "", 0, "", "", "", "");
        PreparedStatement instruccionBusquedaEmpleado = null;
        instruccionBusquedaEmpleado = conexionBaseDatos.prepareStatement("select * from EMPLEADO where apellido=?");
        instruccionBusquedaEmpleado.setString(1, apellidoEmpleado);
        ResultSet resultado = instruccionBusquedaEmpleado.executeQuery();
        if (resultado.next()) {
            empleado = new Empleado(resultado.getInt("nroEmpleado"),resultado.getString("dni"),resultado.getString("nombre"),
            resultado.getString("apellido"),resultado.getString("email"),resultado.getString("sexo"),resultado.getInt("edad"),
            resultado.getString("telefono"),resultado.getString("celular"),resultado.getString("direccion"),resultado.getString("imagen"));
        } else {
            empleado = null;
        }
        conexionBaseDatos.close();
        instruccionBusquedaEmpleado.close();
        return empleado;
    }

    /**
    * Método que elimina de la base de datos al empleado según su DNI.
    * @param dniEmpleado El parámetro dniEmpleado define el número de DNI del empleado a ser eliminado. Cadena de 8 dígitos númericos.
    */ 
    public static void eliminarEmpleadoDNI(final String dniEmpleado) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionEliminarEmpleado = conexionBaseDatos.prepareStatement("delete from EMPLEADO WHERE dni=?");
        instruccionEliminarEmpleado.setString(1, dniEmpleado);
        instruccionEliminarEmpleado.executeUpdate();
        conexionBaseDatos.close();
        instruccionEliminarEmpleado.close();
    }

    /**
    * Método que actualiza los datos de la base de datos de un empleado.
    * @param empleado El parámetro empleado define el objeto de la clase Empleado que contiene toda la información del Empleado, el
    * cual se actualizará sus datos.
    */ 
    public static void actualizarEmpleado(final Empleado empleado) throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionActualizarDatoEmpleado = conexionBaseDatos.prepareStatement("UPDATE EMPLEADO SET dni=?, nombre=?, apellido=?, email=?, sexo=?, edad=?, telefono=?, celular=?, direccion=?,imagen=? WHERE nroEmpleado=" + empleado.getNumeroEmpleado());
        instruccionActualizarDatoEmpleado.setString(1, empleado.getDni());
        instruccionActualizarDatoEmpleado.setString(2, empleado.getNombre());
        instruccionActualizarDatoEmpleado.setString(3, empleado.getApellido());
        instruccionActualizarDatoEmpleado.setString(4, empleado.getEmail());
        instruccionActualizarDatoEmpleado.setString(5, empleado.getSexo());
        instruccionActualizarDatoEmpleado.setInt(6, empleado.getEdad());
        instruccionActualizarDatoEmpleado.setString(7, empleado.getTelefono());
        instruccionActualizarDatoEmpleado.setString(8, empleado.getCelular());
        instruccionActualizarDatoEmpleado.setString(9, empleado.getDireccion());
        instruccionActualizarDatoEmpleado.setString(10, empleado.getImagen());
        instruccionActualizarDatoEmpleado.executeUpdate();
        conexionBaseDatos.close();
        instruccionActualizarDatoEmpleado.close();
    }

    /**
    * Método que obtiene la lista de los empleados actualmente almacenados en la base de datos.
    * @return La lista de los empleados.
    */ 
    public static ArrayList<Empleado> mostrarEmpleado() throws SQLException {
        conexionBaseDatos = BaseDatosConexion.getConnection();
        PreparedStatement instruccionObtenerEmpleados = null;
        ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();

        instruccionObtenerEmpleados = conexionBaseDatos.prepareStatement("SELECT * FROM Empleado");
        ResultSet resultado = instruccionObtenerEmpleados.executeQuery();
        while (resultado.next()) {
            Empleado empleado = new Empleado(resultado.getInt("nroEmpleado"),resultado.getString("dni"),resultado.getString("nombre"),
            resultado.getString("apellido"),resultado.getString("email"),resultado.getString("sexo"),resultado.getInt("edad"),
            resultado.getString("telefono"),resultado.getString("celular"),resultado.getString("direccion"),resultado.getString("imagen"));
            listaEmpleado.add(empleado);
        }
        conexionBaseDatos.close();
        instruccionObtenerEmpleados.close();
        return listaEmpleado;
    }
}
