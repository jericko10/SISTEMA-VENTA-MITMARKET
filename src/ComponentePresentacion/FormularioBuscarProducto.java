package ComponentePresentacion;

import ComponenteClase.Producto;
import ComponenteClase.ProductoCliente;
import ComponenteNegocio.NegocioCompra;
import ComponenteNegocio.NegocioProducto;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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
public class FormularioBuscarProducto extends javax.swing.JFrame {
    private DefaultTableModel tablaProducto = new DefaultTableModel();
    FormularioTransaccion formularioTransaccion;
    private TableRowSorter rowSorter;
    static String codigoBarraProducto;
    static int cantidadProducto;
    static int idListaProducto;
    static String dniCliente;
    static int idEspera;
     /**
    * Método que muestra en el formulario un listado de transacciones realizadas.
    * @param formularioTransaccion lista las transacciones realizadas segun los campos en la base de datos
    */ 
    public FormularioBuscarProducto(final FormularioTransaccion formularioTransaccion, final String tipoCambio, final boolean actualizarStock) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        this.formularioTransaccion = formularioTransaccion;
        String tituloTablaProducto[] = {"CODIGO BARRA.", "NOMBRE", "PRECIO UND","PRECIO " + tipoCambio,"CATEGORIA","DETALLE CATEGORIA","STOCK"};
        tablaProducto.setColumnIdentifiers(tituloTablaProducto);
        try {
            NegocioProducto productoNegocio = new NegocioProducto();
            for (Producto producto : productoNegocio.mostrarProducto()) {
                double precioUnidadProductoDivisa = 0.0;
                if(tipoCambio.equals("DOLAR")){
                    precioUnidadProductoDivisa = producto.getPrecioUnidad()*0.31;
                }
                else if(tipoCambio.equals("EURO")){
                    precioUnidadProductoDivisa = producto.getPrecioUnidad()*0.25;
                }
                else{
                    precioUnidadProductoDivisa = producto.getPrecioUnidad();
                }
                String datoTablaProducto[] = {String.valueOf(producto.getCodigoBarra()), producto.getNombre(), String.valueOf(producto.getPrecioUnidad()),String.valueOf(Math.round((precioUnidadProductoDivisa)*100d)/100d), producto.getCategoria().getNombreCategoria(),producto.getCategoria().getDetalleCategoria(), String.valueOf(producto.getStock())};
                tablaProducto.addRow(datoTablaProducto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        this.formularioTransaccion = formularioTransaccion;
        txtcantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NegocioProducto productoNegocio = new NegocioProducto();
                NegocioCompra negocioCompra = new NegocioCompra();
                Producto producto = new Producto(0,"","",null,0,"","",0){};
                if(txtcantidad.getText().equals("") || txtcantidad.getText().equals("0") || Integer.parseInt(txtcantidad.getText())<0){
                    JOptionPane.showMessageDialog(rootPane, "¡Ingrese una cantidad para el producto!");
                }
                else{
                    if(actualizarStock){
                        try {
                            producto = productoNegocio.buscarProductoCodigoBarra(txtbuscarCat.getText());
                            if(producto.getStock() == 0){
                                JOptionPane.showMessageDialog(null, "No hay stock para el producto.");
                                return;
                            }
                        } catch (SQLException ex) {
                        }
                        int stockActualizado = 0;
                        if(cantidadProducto == Integer.parseInt(txtcantidad.getText())){
                            JOptionPane.showMessageDialog(null, "La cantidad a cambiar es igual a la cantidad actual del producto.");
                            return;
                        }
                        else if(cantidadProducto < Integer.parseInt(txtcantidad.getText())){
                            stockActualizado = producto.getStock()-(Integer.parseInt(txtcantidad.getText())-cantidadProducto);
                        }
                        else{
                            stockActualizado = producto.getStock()+ (cantidadProducto - Integer.parseInt(txtcantidad.getText()));
                        }
                        if(producto.getIdProducto() != 0){
                            double precioUnidadProductoDivisa = 0.0;
                            if(tipoCambio.equals("DOLAR")){
                                precioUnidadProductoDivisa = producto.getPrecioUnidad()*0.31;
                            }
                            else if(tipoCambio.equals("EURO")){
                                precioUnidadProductoDivisa = producto.getPrecioUnidad()*0.25;
                            }
                            else{
                                precioUnidadProductoDivisa = producto.getPrecioUnidad();
                            }
                            final String datosProducto[] = {String.valueOf(idListaProducto),producto.getCodigoBarra(), String.valueOf(txtcantidad.getText()), producto.getNombre() , String.valueOf(Math.round((precioUnidadProductoDivisa)*100d)/100d), String.valueOf(Math.round((precioUnidadProductoDivisa*Integer.parseInt(txtcantidad.getText()))*100d)/100d)};
                            if(stockActualizado<0){
                                JOptionPane.showMessageDialog(null, "La cantidad es mayor al stock");
                                return;
                            }
                            else{
                                Producto productoEditadoStock = new Producto(producto.getIdProducto(), producto.getNombre(), producto.getUnidadMedida(), producto.getCategoria(), producto.getPrecioUnidad(), producto.getImagen(), producto.getCodigoBarra(), stockActualizado);
                                ProductoCliente productoCliente = new ProductoCliente(idEspera,idListaProducto, "", null, "", Integer.parseInt(txtcantidad.getText()));
                                
                                try {
                                    productoNegocio.actualizarProducto(productoEditadoStock);
                                    negocioCompra.actualizarCantidadProductoEspera(productoCliente);
                                } catch (SQLException ex) {
                                }
                                for (int i = 0;formularioTransaccion.jtTransacProd.getRowCount()>i; i++) {
                                    String idTabla = String.valueOf(formularioTransaccion.jtTransacProd.getValueAt(i, 0));
                                    if(idTabla.equals(String.valueOf(idListaProducto))){
                                        formularioTransaccion.tablaTransaccion.setValueAt(Integer.parseInt(txtcantidad.getText()), i, 2);
                                        formularioTransaccion.tablaTransaccion.setValueAt(String.valueOf(Math.round((precioUnidadProductoDivisa*Integer.parseInt(txtcantidad.getText()))*100d)/100d), i, 5);
                                        dispose();
                                    }
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No existe el producto.");
                        }
                    }
                    else{
                        try {
                            producto = productoNegocio.buscarProductoCodigoBarra(txtbuscarCat.getText());
                            if(producto.getStock() == 0){
                                JOptionPane.showMessageDialog(null, "No hay stock para el producto.");
                                return;
                            }
                        } catch (SQLException ex) {
                        }
                        for (int i = 0; i < formularioTransaccion.jtTransacProd.getRowCount(); i++) {
                            String codigoBarraExistente = String.valueOf(formularioTransaccion.jtTransacProd.getModel().getValueAt(i, 1));
                            if(codigoBarraExistente.equals(txtbuscarCat.getText())){
                                JOptionPane.showMessageDialog(null, "El producto ya existe en el carrito. Puede modificar el stock haciendo clic en la lista del carrito.");
                                return;
                            }
                        }
                        if(producto.getIdProducto() != 0){
                            double precioUnidadProductoDivisa = 0.0;
                            if(tipoCambio.equals("DOLAR")){
                                precioUnidadProductoDivisa = producto.getPrecioUnidad()*0.31;
                            }
                            else if(tipoCambio.equals("EURO")){
                                precioUnidadProductoDivisa = producto.getPrecioUnidad()*0.25;
                            }
                            else{
                                precioUnidadProductoDivisa = producto.getPrecioUnidad();
                            }
                            int stockActualizado = producto.getStock()-Integer.parseInt(txtcantidad.getText());
                            if(stockActualizado<0){
                                JOptionPane.showMessageDialog(null, "La cantidad es mayor al stock");
                                return;
                            }
                            else{
                                Producto productoEditadoStock = new Producto(producto.getIdProducto(), producto.getNombre(), producto.getUnidadMedida(), producto.getCategoria(), producto.getPrecioUnidad(), producto.getImagen(), producto.getCodigoBarra(), stockActualizado);
                                ProductoCliente productoCliente = new ProductoCliente(idEspera,0,dniCliente,null,producto.getCodigoBarra(), Integer.parseInt(txtcantidad.getText()));
                                int ultimoIdListaProductoCliente = 0;
                                try {
                                    productoNegocio.actualizarProducto(productoEditadoStock);
                                    negocioCompra.insertarNuevoProductoEspera(productoCliente);
                                    ultimoIdListaProductoCliente = negocioCompra.obtenerUltimoIdListaProductoCliente();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                final String datosProducto[] = {String.valueOf(ultimoIdListaProductoCliente), producto.getCodigoBarra(), String.valueOf(txtcantidad.getText()), producto.getNombre() , String.valueOf(Math.round((precioUnidadProductoDivisa)*100d)/100d), String.valueOf(Math.round((precioUnidadProductoDivisa*Integer.parseInt(txtcantidad.getText()))*100d)/100d)};
                                formularioTransaccion.tablaTransaccion.addRow(datosProducto);
                                dispose();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No existe el producto.");
                        }
                    }
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproductos = new javax.swing.JTable();
        txtbuscarCat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTA DE PRODUCTOS");

        jtproductos.setBackground(new java.awt.Color(247, 254, 255));
        jtproductos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtproductos.setModel(tablaProducto);
        jScrollPane1.setViewportView(jtproductos);

        txtbuscarCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarCatKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código de Barras:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad:");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscarCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarCatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarCatKeyTyped
        txtbuscarCat.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtbuscarCat.getText()));
            }

        });

        rowSorter = new TableRowSorter(tablaProducto);
        jtproductos.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtbuscarCatKeyTyped

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("[0-9]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtbuscarCat.setText(codigoBarraProducto);
        txtcantidad.setText(String.valueOf(cantidadProducto));
    }//GEN-LAST:event_formWindowOpened

    /**Metodo principal de la clase FormularioBuscarProducto
     * @param args 
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FormularioBuscarProducto(null,"",false) {
                }.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtproductos;
    private javax.swing.JTextField txtbuscarCat;
    private javax.swing.JTextField txtcantidad;
    // End of variables declaration//GEN-END:variables
}
