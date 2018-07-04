package ComponentePresentacion;

import ComponenteNegocio.NegocioCompra;
import ComponenteOtros.ListadoEsperaProductosClientes;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Mamani Bedregal
 */
public class FormularioProductosEsperaCliente extends javax.swing.JFrame {

    public DefaultTableModel tablaProductoEspera = new DefaultTableModel();
    private DefaultTableModel tablaVenta = new DefaultTableModel();
    public static int idCaja = 0;
    private volatile Thread hiloProductoClienteEsperaTomado;
    private ListadoEsperaProductosClientes listadoEsperaProductosClientes;
    private NegocioCompra negocioCompra = new NegocioCompra();
    private TableRowSorter rowSorter;
    
    public FormularioProductosEsperaCliente() {
        initComponents();
        String tituloTablaProducto[] = {"ID", "DNI CLIENTE", "NOMBRE DE CAJA"};
        tablaProductoEspera.setColumnIdentifiers(tituloTablaProducto);
        
        jproductosespera.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final int fila = jproductosespera.rowAtPoint(e.getPoint());
                final int columna = jproductosespera.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    FormularioProductosEsperaClienteDetalle formularioProductosEsperaClienteDetalle = null;
                    try {
                        formularioProductosEsperaClienteDetalle = new FormularioProductosEsperaClienteDetalle(Integer.parseInt(String.valueOf(jproductosespera.getValueAt(fila,0))));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    formularioProductosEsperaClienteDetalle.setVisible(true);
                }
            }
        });
        jproductosespera.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e){
                int fila = jproductosespera.getSelectedRow();
                if(fila != -1){
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de enviar a LISTO el listado de productos pendiente?","Enviar a LISTO",JOptionPane.YES_NO_OPTION);
                        if(respuesta == 0){
                            try {
                                negocioCompra.actualizarEstadoTomadoProductoClienteListo(idCaja, Integer.parseInt(String.valueOf(jproductosespera.getValueAt(fila, 0))));
                                for(int i = 0;i<jproductosespera.getRowCount();i++){
                                    tablaProductoEspera.removeRow(i);
                                }
                            } catch (SQLException ex) {
                            }
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
        jproductosespera = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTA DE PRODUCTOS EN ESPERA");

        jproductosespera.setBackground(new java.awt.Color(247, 254, 255));
        jproductosespera.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jproductosespera.setModel(tablaProductoEspera);
        jScrollPane1.setViewportView(jproductosespera);

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Texto a buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel1)
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listadoEsperaProductosClientes = new ListadoEsperaProductosClientes(this, idCaja);
        hiloProductoClienteEsperaTomado = new Thread(listadoEsperaProductosClientes);
        listadoEsperaProductosClientes.setLectorProductoEspera(hiloProductoClienteEsperaTomado);
        hiloProductoClienteEsperaTomado.start();
    }//GEN-LAST:event_formWindowOpened

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        txtbuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtbuscar.getText()));
                if(txtbuscar.getText().equals("")){
                    for(int i = 0;i<jproductosespera.getRowCount();i++){
                        tablaProductoEspera.removeRow(i);
                    }
                }
            }

        });
        rowSorter = new TableRowSorter(tablaProductoEspera);
        jproductosespera.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtbuscarKeyTyped

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioProductosEsperaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioProductosEsperaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioProductosEsperaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioProductosEsperaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioProductosEsperaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jproductosespera;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtbuscarVen;
    private javax.swing.JTextField txtbuscarVen1;
    // End of variables declaration//GEN-END:variables
}
