package ComponentePresentacion;

import ComponenteClase.*;
import ComponenteNegocio.NegocioCompra;
import ComponenteNegocio.NegocioEmpleado;
import ComponenteOtros.LecturaEsperaProductosClientes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public class FormularioNuevaCompra extends javax.swing.JFrame {

    NegocioEmpleado empleadoNegocio = new NegocioEmpleado();
    NegocioCompra compraNegocio = new NegocioCompra();
    private int limiteCaracterDNI = 8;
    int idEmpleado = 0;
    private boolean verificarCerrarFormulario = false;
    public boolean verificarCompraRealizada = false;
    
    public FormularioNuevaCompra() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
         try {
            txtnroCompra.setText(String.valueOf(compraNegocio.obtenerUltimoIdCompra()));
            txtdnicliente.setEnabled(false);
        } catch (Exception error) {
            System.out.print(error);
        }
         txtdnicliente.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(txtdnicliente.getText().length() == limiteCaracterDNI){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
         
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
 
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                try {
                    cerrarFormulario();
                } catch (SQLException ex) {
                }
            }
        });
    }
    private void cerrarFormulario() throws SQLException{
        if(verificarCompraRealizada){
            dispose();
        }
        else{
        if(!verificarCerrarFormulario){
            int respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro que desea cancelar la compra?");
            if(respuesta==0){
                compraNegocio.cancelarCompra(Integer.parseInt(txtnroCompra.getText()));
                JOptionPane.showMessageDialog(rootPane, "Compra cancelada.");
                btnNuevoComp.setEnabled(false);
                btnAgregarProdComp.setEnabled(false);
                btncancelarCompra.setEnabled(false);
                txtdnicliente.setEnabled(false);
                cboTipoCambio.setEnabled(false);
                verificarCerrarFormulario = true;
            }
        }
        else{
            this.dispose();
        }
        }
    }
    /**
    * Método que activa o desactiva los botones del formulario, según la acción que se toma dentro del formulario.
    * @param activaBoton El parámetro activaBoton define la activación o desactivación mediante "true" o "false", cuando es una 
    * nueva compra o se cancela la compra, según sea el caso.
    */
    public void activarBoton(boolean activaBoton) {
        btnNuevoComp.setEnabled(activaBoton);
        btnAgregarProdComp.setEnabled(!activaBoton);
    }

    /**
    * Método que limpia los componentes TextBox txtCodCliente y txtDatoClienteComp cuando se realiza una nueva compra.
    */
    public void limpiarTexto() {
        txtdnicliente.setText("");
    }

    /**
    * Método que activa o desactiva los componentes TextBox txtCodCliente y txtDatoClienteComp cuando se realiza una nueva compra.
    * @param activaTexto El parámetro activaTexto define la activación o desactivación mediante "true" o "false", cuando se realiza
    * una nueva compra.
    */
    public void activarTexto(boolean activaTexto) {
        txtdnicliente.setEditable(activaTexto);
        txtdnicliente.setEnabled(activaTexto);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtdnicliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        lbldatosEmp = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboTipoCambio = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevoComp = new javax.swing.JButton();
        btnAgregarProdComp = new javax.swing.JButton();
        btnListarCompras = new javax.swing.JButton();
        btncancelarCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnroCompra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        jLabel2.setText("FECHA:");

        txtFechaActual.setEditable(false);
        txtFechaActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaActual.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        jLabel3.setText("EMPLEADO:");

        txtdnicliente.setEditable(false);
        txtdnicliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("DNI CLIENTE :");

        lbldatosEmp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbldatosEmp.setText("APELLIDO, Nombre");

        jLabel8.setText("TIPO DE CAMBIO :");

        cboTipoCambio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DOLAR", "EURO", "NUEVO SOL" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldatosEmp)
                            .addComponent(txtdnicliente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(78, 78, 78)
                        .addComponent(cboTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbldatosEmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdnicliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cboTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jToolBar1.setBackground(new java.awt.Color(247, 254, 255));
        jToolBar1.setRollover(true);

        btnNuevoComp.setBackground(new java.awt.Color(247, 254, 255));
        btnNuevoComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/new.jpg"))); // NOI18N
        btnNuevoComp.setToolTipText("Nuevo");
        btnNuevoComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCompActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevoComp);

        btnAgregarProdComp.setBackground(new java.awt.Color(247, 254, 255));
        btnAgregarProdComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/shopping_cart_add_1.jpg"))); // NOI18N
        btnAgregarProdComp.setToolTipText("Agregar Productos al Carrito");
        btnAgregarProdComp.setEnabled(false);
        btnAgregarProdComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdCompActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregarProdComp);

        btnListarCompras.setBackground(new java.awt.Color(247, 254, 255));
        btnListarCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/sales-report.jpg"))); // NOI18N
        btnListarCompras.setToolTipText("Buscar Cliente");
        btnListarCompras.setFocusable(false);
        btnListarCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListarCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarComprasActionPerformed(evt);
            }
        });
        jToolBar1.add(btnListarCompras);

        btncancelarCompra.setText("Cancelar Compra");
        btncancelarCompra.setFocusable(false);
        btncancelarCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancelarCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarCompraActionPerformed(evt);
            }
        });
        jToolBar1.add(btncancelarCompra);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nro-COMPRA:");

        txtnroCompra.setEditable(false);
        txtnroCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnroCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(368, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     /**
    * Método que permite agregar una nueva compra a la base de datos solo 
    * si se ingresan todos los campos solicitados
    */
    private void btnAgregarProdCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdCompActionPerformed
        try {       
            ProductoCliente productoCliente = compraNegocio.obtenerProductoCliente(txtdnicliente.getText());
            ArrayList<ProductoCliente> listaProductoCliente = compraNegocio.listarProductoCliente(txtdnicliente.getText());
            if(listaProductoCliente.isEmpty()){
                JOptionPane.showMessageDialog(null, "El cliente '" + txtdnicliente.getText() + "' no tiene productos escaneados.");
                return;
            }
            else{
                java.net.InetAddress nombrePC = null;
                try {
                    nombrePC = java.net.InetAddress.getLocalHost();
                } catch (UnknownHostException ex) {
                }
                if(!productoCliente.getCaja().getNombreCaja().equals(nombrePC.getHostName())){
                    JOptionPane.showMessageDialog(null, "Los productos del cliente '" + txtdnicliente.getText() + "' no están asociados a esta Caja '" + nombrePC.getHostName() + "'. \n Sus productos están en la Caja '" + productoCliente.getCaja().getNombreCaja() + "'.");
                    return;
                }
                else{
                    if(compraNegocio.buscarCompra(Integer.parseInt(txtnroCompra.getText())) != null){
                        FormularioTransaccion formularioTransaccion = new FormularioTransaccion(this);
                        formularioTransaccion.txtDNICliente.setText(txtdnicliente.getText());
                        formularioTransaccion.dniCliente = txtdnicliente.getText();
                        formularioTransaccion.tipoCambio = (String)cboTipoCambio.getSelectedItem();
                        formularioTransaccion.nroCompra = Integer.parseInt(txtnroCompra.getText());
                        formularioTransaccion.setVisible(true);
                    }
                    else{
                        Compra compra;
                        Empleado empleado = new Empleado(idEmpleado, "", "", "", "", "", 0, "", "", "", "");
                        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaActualCompra = new Date();
                        try {
                            fechaActualCompra = formatoDelTexto.parse(txtFechaActual.getText());
                        } catch (ParseException ex) {
                            Logger.getLogger(FormularioNuevaCompra.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(txtdnicliente.getText().trim().equals("")){
                            JOptionPane.showMessageDialog(null, "Debe ingresar el DNI del cliente");
                            return;
                        }
                        try {
                            compra = new Compra(Integer.parseInt(txtnroCompra.getText()), txtdnicliente.getText(), empleado, formatoDelTexto.format(fechaActualCompra), (String) cboTipoCambio.getSelectedItem(),0.0,"En proceso");
                            compraNegocio.insertarCompra(compra);
                        } catch (SQLException error) {
                            JOptionPane.showMessageDialog(null, "Error BD: " + error.getMessage());
                            return;
                        }
                        FormularioTransaccion formularioTransaccion = new FormularioTransaccion(this);
                        formularioTransaccion.txtDNICliente.setText(txtdnicliente.getText());
                        formularioTransaccion.dniCliente = txtdnicliente.getText();
                        formularioTransaccion.tipoCambio = (String)cboTipoCambio.getSelectedItem();
                        formularioTransaccion.nroCompra = Integer.parseInt(txtnroCompra.getText());
                        formularioTransaccion.setVisible(true);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAgregarProdCompActionPerformed

    private void btnNuevoCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCompActionPerformed
        activarBoton(false);
        activarTexto(true);
        limpiarTexto();
    }//GEN-LAST:event_btnNuevoCompActionPerformed

    private void btnListarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarComprasActionPerformed
        FormularioListaVenta formularioListaVenta = null;
        try {
            formularioListaVenta = new FormularioListaVenta();
        } catch (SQLException ex) {
            Logger.getLogger(FormularioNuevaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        formularioListaVenta.setVisible(true);
    }//GEN-LAST:event_btnListarComprasActionPerformed

    private void btncancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarCompraActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro que desea cancelar la compra?");
        if(respuesta==0){
            try {
                compraNegocio.cancelarCompra(Integer.parseInt(txtnroCompra.getText()));
            } catch (SQLException ex) {
            }
            JOptionPane.showMessageDialog(rootPane, "Compra cancelada.");
            btnNuevoComp.setEnabled(false);
            btnAgregarProdComp.setEnabled(false);
            btncancelarCompra.setEnabled(false);
            txtdnicliente.setEnabled(false);
            cboTipoCambio.setEnabled(false);
            verificarCerrarFormulario = true;
            verificarCompraRealizada= true;
        }
    }//GEN-LAST:event_btncancelarCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FormularioNuevaCompra().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProdComp;
    private javax.swing.JButton btnListarCompras;
    private javax.swing.JButton btnNuevoComp;
    private javax.swing.JButton btncancelarCompra;
    public javax.swing.JComboBox cboTipoCambio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JLabel lbldatosEmp;
    private javax.swing.JTextField txtFechaActual;
    private javax.swing.JTextField txtdnicliente;
    private javax.swing.JTextField txtnroCompra;
    // End of variables declaration//GEN-END:variables
}
