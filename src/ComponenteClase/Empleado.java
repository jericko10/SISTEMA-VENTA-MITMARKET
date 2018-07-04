package ComponenteClase;
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
public class Empleado {

    private final int numeroEmpleado;
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String sexo;
    private final int edad;
    private final String telefono;
    private final String celular;
    private final String direccion;
    private final String imagen;
    
    public Empleado(final int numeroEmpleado, final String dni, final String nombre, final String apellido, final String email, final String sexo, final int edad, final String telefono, final String celular, final String direccion, final String imagen){
        this.numeroEmpleado = numeroEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.sexo = sexo;
        this.edad = edad;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.imagen = imagen;
    }
    
    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }
    
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public String getImagen() {
        return imagen;
    }
}
