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
public class Categoria {

    private final int codigoCategoria;
    private final String nombreCategoria;
    private final String detalleCategoria;
    private final String imagenCategoria;
    
    public Categoria(final int codigoCategoria, final String nombreCategoria, final String detalleCategoria, final String imagenCategoria){
        this.codigoCategoria = codigoCategoria;
        this.nombreCategoria = nombreCategoria;
        this.detalleCategoria = detalleCategoria;
        this.imagenCategoria = imagenCategoria;
    }
    
    public String getDetalleCategoria() {
        return detalleCategoria;
    }
    
    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getImagenCategoria() {
        return imagenCategoria;
    }
}
