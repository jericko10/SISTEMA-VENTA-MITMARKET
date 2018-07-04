package ComponenteOtros;

import ComponenteClase.ProductoCliente;
import ComponenteNegocio.NegocioCompra;
import ComponentePresentacion.FormularioProductosEsperaCliente;
import java.util.ArrayList;

/**
 *
 * @author maest
 */
public class ListadoEsperaProductosClientes implements Runnable{
    private volatile Thread lectorProductoEspera;
    private final FormularioProductosEsperaCliente formularioProductosEsperaCliente;
    private final int idCaja;
    
    public ListadoEsperaProductosClientes(final FormularioProductosEsperaCliente formularioProductosEsperaCliente, final int idCaja){
        this.formularioProductosEsperaCliente = formularioProductosEsperaCliente;
        this.idCaja = idCaja;
    }

    public Thread getLectorProductoEspera() {
        return lectorProductoEspera;
    }

    public FormularioProductosEsperaCliente getFormularioProductosEsperaCliente() {
        return formularioProductosEsperaCliente;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setLectorProductoEspera(Thread lectorProductoEspera) {
        this.lectorProductoEspera = lectorProductoEspera;
    }
       
    @Override
    public void run() {
        while(lectorProductoEspera == Thread.currentThread()){
            try {
                NegocioCompra negocioCompra = new NegocioCompra();
                ArrayList<ProductoCliente> listaProductoCliente = negocioCompra.listarProductoClienteEsperaTomado(idCaja);
                for(ProductoCliente productoCliente : listaProductoCliente){
                    if(formularioProductosEsperaCliente.jproductosespera.getRowCount() == 0){
                        final String datosProducto[] = {String.valueOf(productoCliente.getIdGeneral()), productoCliente.getDniCliente(), productoCliente.getCaja().getNombreCaja()};
                        formularioProductosEsperaCliente.tablaProductoEspera.addRow(datosProducto);
                    }
                    else{
                        for(int i = 0; i<formularioProductosEsperaCliente.jproductosespera.getRowCount();i++){
                            if(!((String)formularioProductosEsperaCliente.jproductosespera.getValueAt(i, 0)).equals(String.valueOf(productoCliente.getIdGeneral()))){
                                final String datosProducto[] = {String.valueOf(productoCliente.getIdGeneral()), productoCliente.getDniCliente(), productoCliente.getCaja().getNombreCaja()};
                                formularioProductosEsperaCliente.tablaProductoEspera.addRow(datosProducto);
                            }
                        }
                    }
                }
                Thread.sleep(2000);
            } catch (Exception e) {
                
            }
        }
    }
}
