package ComponentePresentacion;

import ComponenteClase.Caja;
import ComponenteNegocio.NegocioCaja;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Mamani Bedregal
 * @version 1.0
 */
public class FormularioListarCaja extends javax.swing.JFrame {

    private DefaultTableModel tablaCaja= new DefaultTableModel();
    private FormularioCaja formularioCaja;
    private TableRowSorter rowSorter;
    
    public FormularioListarCaja(final FormularioCaja formularioCaja, boolean modal) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        String listaTituloTabla[]={"CODIGO","NOMBRE","ESTADO"};
        tablaCaja.setColumnIdentifiers(listaTituloTabla);
        try{
            NegocioCaja negocioCaja = new NegocioCaja();
        for(Caja caja : negocioCaja.mostrarCaja()){
            String datoTabla[]={String.valueOf(caja.getIdCaja()),caja.getNombreCaja(),caja.getEstadoCaja()};
            tablaCaja.addRow(datoTabla);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
        }       
        jCaja.setModel(tablaCaja);
        this.formularioCaja = formularioCaja;
        jCaja.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                final int fila = jCaja.rowAtPoint(e.getPoint());
                final int columna = jCaja.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    try {
                        NegocioCaja negocioCaja =  new NegocioCaja();
                        Caja caja = negocioCaja.buscarCajaCodigo(Integer.parseInt(String.valueOf(tablaCaja.getValueAt(fila, 0))));
                        formularioCaja.txtnombrecaja.setEnabled(true);
                        formularioCaja.txtnombrecaja.setText(caja.getNombreCaja());
                        formularioCaja.txtid.setText(String.valueOf(caja.getIdCaja()));
                        formularioCaja.btnAgregar.setEnabled(false);
                        formularioCaja.btnEditar.setEnabled(true);
                        formularioCaja.btnEliminar.setEnabled(true);
                        formularioCaja.btnCancelar.setEnabled(true);
                        formularioCaja.btnNuevo.setEnabled(false);                    
                    } catch (SQLException ex) {
                        Logger.getLogger(FormularioListaCategorias.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }

                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jCaja = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscarCat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jCaja.setModel(tablaCaja);
        jCaja.setGridColor(new java.awt.Color(247, 254, 255));
        jScrollPane1.setViewportView(jCaja);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTA DE CAJAS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Texto a buscar:");

        txtbuscarCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarCatKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscarCat)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscarCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        rowSorter = new TableRowSorter(tablaCaja);
        jCaja.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtbuscarCatKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioListarCaja dialog = new FormularioListarCaja(null, true) {};
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtbuscarCat;
    // End of variables declaration//GEN-END:variables
}
