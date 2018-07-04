package ComponenteOtros;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public class Imagen {

    private BufferedImage imagen = null;
    private FileNameExtensionFilter filtradorTipoImagen = new FileNameExtensionFilter("Archivo de Imagen", "jpg", "png");
    private URL obtenerUrlImagen;

    public Imagen() {
    }
    
    /**
    * Método que obtiene la direccion fisica de un archivo de imagen, y la coloca en el objeto BufferedImage.
    * @param url El parámetro url define la ruta de la imagen a mostrar.
    */
    public void cargarImagen(final URL url) {       
        try {
            if(url != null){
                imagen = ImageIO.read(url);
            }
        } catch (IOException error) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, error);
        }
    }
    
    /**
    * Método que retorna el objeto almacenado en memoria.
    * @return La imagen en memoria Buffered.
    */
    public BufferedImage obtenerImagenBuffered() {
        return imagen;
    }
    
    /**
    * Método que muestra una ventana de dialogo para seleccionar la imagen.
    * @param panel El parámetro panel define el contenedor donde se mostrará la imagen.
    */
    public void abrirDialogoSeleccionImagen(JPanel panel) {
        JFileChooser escogerImagen = new JFileChooser();
        escogerImagen.setFileFilter(filtradorTipoImagen);
        int resultado = escogerImagen.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                //Se asigna a "url" el archivo de imagen seleccionado
                setObtenerUrlImagen(escogerImagen.getSelectedFile().toURL());
                URL url = escogerImagen.getSelectedFile().toURL();
                //Se lo coloca en memoria
                cargarImagen(url);
                //Se añade al contenedor panel respectivo
                panel.add(new PanelImagen(obtenerImagenBuffered(), panel.getSize()) {});
                panel.setVisible(true);
                panel.repaint();
            } catch (IOException error) {
                Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, error);
            }
        }
    }

    /**
    * Método que muestra la imagen en el contenedor respectivo.
    * @param panel El parámetro panel define el contenedor donde se mostrará la imagen.
    */
    public void mostrarImagen(JPanel panel) {
        try {
            //Se asigna a "url" el archivo de imagen seleccionado
            URL url = getObtenerUrlImagen();
            //Se lo coloca en memoria
            cargarImagen(url);
            //se añade al contenedor panel respectivo
            panel.add(new PanelImagen(obtenerImagenBuffered(), panel.getSize()) {});
            panel.setVisible(true);
            panel.repaint();
        } catch (Exception error) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, error);
        }
    }

    /**
    * Método que obtiene la ruta de la imagen del disco duro.
    */
    public String obtenerUrl() {
        return " " + getObtenerUrlImagen() + " ";
    }

    public URL getObtenerUrlImagen() {
        return obtenerUrlImagen;
    }

    public void setObtenerUrlImagen( final URL obtenerUrlImagen) {
        this.obtenerUrlImagen = obtenerUrlImagen;
    }
}
