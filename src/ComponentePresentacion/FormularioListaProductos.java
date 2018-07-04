package ComponentePresentacion;

import ComponenteClase.Producto;
import ComponenteNegocio.NegocioProducto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
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
 */
public class FormularioListaProductos extends javax.swing.JDialog {

    private DefaultTableModel tablaProducto = new DefaultTableModel();
    private FormularioProducto formularioProducto;
    private TableRowSorter rowSorter;

    public FormularioListaProductos(final FormularioProducto formularioProducto, boolean modal) {
        super(formularioProducto, modal);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        String listaTituloTabla[] = {"IdProd.", "NOMBRE", "PRECIO UND.","CATEGORIA","CODIGO BARRA","STOCK"};
        tablaProducto.setColumnIdentifiers(listaTituloTabla);
        try {
            NegocioProducto productoNegocio =  new NegocioProducto();
            for (Producto producto : productoNegocio.mostrarProducto()) {
                String datoTabla[] = {String.valueOf(producto.getIdProducto()), producto.getNombre(), String.valueOf(producto.getPrecioUnidad()), producto.getCategoria().getNombreCategoria(),producto.getCodigoBarra(),String.valueOf(producto.getStock())};
                tablaProducto.addRow(datoTabla);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        
        this.formularioProducto = formularioProducto;
        jtproductos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                final int fila = jtproductos.rowAtPoint(e.getPoint());
                final int columna = jtproductos.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    try {
                        NegocioProducto productoNegocio =  new NegocioProducto();
                        Producto producto = productoNegocio.buscarProducto(Integer.parseInt(String.valueOf(tablaProducto.getValueAt(fila, 0))));
                        formularioProducto.txtIdProducto.setText(String.valueOf(producto.getIdProducto()));
                        formularioProducto.txtNombreP.setText(producto.getNombre());
                        formularioProducto.txtUnidadMedP.setText(String.valueOf(producto.getUnidadMedida()));
                        formularioProducto.txtPrecioUP.setText(String.valueOf(producto.getPrecioUnidad()));
                        formularioProducto.txtcodcat.setText(String.valueOf(producto.getCategoria().getCodigoCategoria()));
                        formularioProducto.txtcategoria.setText(String.valueOf(producto.getCategoria().getNombreCategoria()));
                        formularioProducto.txtdetallecat.setText(String.valueOf(producto.getCategoria().getDetalleCategoria()));
                        formularioProducto.txtcodigobarra.setText(String.valueOf(producto.getCodigoBarra()));
                        formularioProducto.txtstock.setText(String.valueOf(producto.getStock()));
                        formularioProducto.btnEditarP.setEnabled(true);
                        formularioProducto.btnEliminarP.setEnabled(true);
                        formularioProducto.btnCancelarP.setEnabled(true);
                        formularioProducto.btnExaminar.setEnabled(true);
                        formularioProducto.btnNuevoP.setEnabled(false);
                        formularioProducto.btnSeleccionarCategoria.setEnabled(true);
                        formularioProducto.txtNombreP.setEditable(true);
                        formularioProducto.txtUnidadMedP.setEditable(true);
                        formularioProducto.txtPrecioUP.setEditable(true);
                        formularioProducto.txtcodigobarra.setEditable(true);
                        formularioProducto.txtcodigobarra.setEnabled(true);
                        formularioProducto.txtstock.setEditable(true);
                        formularioProducto.txtstock.setEnabled(true);
                        formularioProducto.jpImageProd.removeAll();
                        try {
                            formularioProducto.jpImageProd.removeAll();
                            final URL url = new URL(producto.getImagen());
                            formularioProducto.imagen.setObtenerUrlImagen(url);
                            formularioProducto.imagen.mostrarImagen(formularioProducto.jpImageProd);
                        } catch (MalformedURLException ex) {
                            
                        }

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error BD: " + ex.getMessage());
                    }

                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtbuscarVen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTA DE PRODUCTOS");

        jtproductos.setBackground(new java.awt.Color(247, 254, 255));
        jtproductos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtproductos.setModel(tablaProducto);
        jScrollPane1.setViewportView(jtproductos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Texto a buscar:");

        txtbuscarVen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarVenKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(176, 176, 176))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscarVen))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscarVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarVenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarVenKeyTyped
        txtbuscarVen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtbuscarVen.getText()));
            }

        });

        rowSorter = new TableRowSorter(tablaProducto);
        jtproductos.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtbuscarVenKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FormularioListaProductos dialog = new FormularioListaProductos(null,true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtproductos;
    private javax.swing.JTextField txtbuscarVen;
    // End of variables declaration//GEN-END:variables
}
