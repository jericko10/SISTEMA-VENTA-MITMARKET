package ComponenteOtros;

import ComponenteClase.ProductoCliente;
import ComponenteNegocio.NegocioCompra;
import ComponentePresentacion.FormularioMenu;
import ComponentePresentacion.FormularioProductosEsperaCliente;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LecturaEsperaProductosClientes implements Runnable{
    private volatile Thread lectorProductoEspera;
    private final FormularioMenu formularioMenu;
    private final int idCaja;
    private FormularioProductosEsperaCliente formularioProductosEsperaCliente;
    private String estadoCaja;

    public LecturaEsperaProductosClientes(final FormularioMenu formularioMenu, final int idCaja){
        this.formularioMenu = formularioMenu;
        this.idCaja = idCaja;
    }

    public Thread getLectorProductoEspera() {
        return lectorProductoEspera;
    }

    public FormularioMenu getFormularioMenu() {
        return formularioMenu;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setLectorProductoEspera(Thread lectorProductoEspera) {
        this.lectorProductoEspera = lectorProductoEspera;
    }

    public void setEstadoCaja(String estadoCaja) {
        this.estadoCaja = estadoCaja;
    }
        
    @Override
    public void run() {
        while(lectorProductoEspera == Thread.currentThread()){
            try {
                NegocioCompra negocioCompra = new NegocioCompra();
                ArrayList<ProductoCliente> listaProductoCliente = negocioCompra.listarProductoClienteEspera();
                for(ProductoCliente productoCliente : listaProductoCliente){
                    negocioCompra.actualizarEstadoTomadoProductoClienteEspera(idCaja, productoCliente.getIdGeneral());
                    DesktopNotify.showDesktopMessage("Lista de Productos en Espera", "Tienes un listado de productos en espera del cliente: " + productoCliente.getDniCliente(), DesktopNotify.INPUT_REQUEST,6000, new ActionListener() {
                    @Override
                        public void actionPerformed(ActionEvent e) {
                            if(formularioProductosEsperaCliente == null){
                                formularioProductosEsperaCliente = new FormularioProductosEsperaCliente();
                                formularioProductosEsperaCliente.idCaja = idCaja;
                                formularioProductosEsperaCliente.setVisible(true);
                            }
                        }
                    });
                }
                Thread.sleep(2000);
            } catch (Exception e) {
                
            }
        }
    }
}
