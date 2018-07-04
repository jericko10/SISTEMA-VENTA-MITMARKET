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
 * 
 * @author Mamani Bedregal
 * @version 2.2
 */
public class Usuario {

    private final int idUsuario;
    private final String nombreUsuario;
    private final Empleado empleado;
    private final String contrasenaUsuario;
    private final String tipoUsuario;
    
    public Usuario(final int idUsuario, final String nombreUsuario, final Empleado empleado, final String contrasenaUsuario, final String tipoUsuario){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.empleado = empleado;
        this.contrasenaUsuario = contrasenaUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
    
}
