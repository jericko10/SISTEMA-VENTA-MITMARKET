package ComponentePresentacion;

import ComponenteClase.Empleado;
import ComponenteNegocio.NegocioEmpleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public class FormularioListaEmpleados extends javax.swing.JDialog {

    private DefaultTableModel tablaEmpleado = new DefaultTableModel();
    private FormularioEmpleado formularioEmpleado;
    private TableRowSorter rowSorter;

    public FormularioListaEmpleados(final FormularioEmpleado formularioEmpleado, boolean modal) {
        super(formularioEmpleado, modal);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String listaTituloTabla[] = {"NroEmp", "DNI", "APELLIDOS y NOMBRES", "EDAD", "EMAIL", "CELULAR-TELEFONO", "DIRECCION"};
        tablaEmpleado.setColumnIdentifiers(listaTituloTabla);
        try {
            NegocioEmpleado empleadoNegocio = new NegocioEmpleado();
            for (Empleado empleado : empleadoNegocio.mostrarEmpleado()) {
                String datoTabla[] = {String.valueOf(empleado.getNumeroEmpleado()), String.valueOf(empleado.getDni()), empleado.getApellido() + " " + empleado.getNombre(), String.valueOf(empleado.getEdad()), empleado.getEmail(), empleado.getCelular() + " / " + empleado.getTelefono(), empleado.getDireccion()};
                tablaEmpleado.addRow(datoTabla);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        initComponents();
        this.formularioEmpleado = formularioEmpleado;
        jEmpleado.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                final int fila = jEmpleado.rowAtPoint(e.getPoint());
                final int columna = jEmpleado.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    try {
                        NegocioEmpleado empleadoNegocio =  new NegocioEmpleado();
                        Empleado empleado = empleadoNegocio.buscarEmpleado(String.valueOf(tablaEmpleado.getValueAt(fila, 1)));
                        formularioEmpleado.txtDniE.setText(empleado.getDni());
                        formularioEmpleado.txtNombreE.setText(empleado.getNombre());
                        formularioEmpleado.txtApellidoE.setText(empleado.getApellido());
                        formularioEmpleado.txtEdadE.setText(String.valueOf(empleado.getEdad()));
                        if(empleado.getSexo().equals("F")){
                            formularioEmpleado.cboSexoE.setSelectedIndex(0);
                        }
                        if(empleado.getSexo().equals("M")){
                            formularioEmpleado.cboSexoE.setSelectedIndex(1);
                        }
                        formularioEmpleado.txtCelularE.setText(empleado.getCelular());
                        formularioEmpleado.txtTelefonoE.setText(empleado.getTelefono());
                        formularioEmpleado.txtEmailE.setText(empleado.getEmail());
                        formularioEmpleado.txtDireccionE.setText(empleado.getDireccion());
                        formularioEmpleado.btnEditarE.setEnabled(true);
                        formularioEmpleado.btnEliminarE.setEnabled(true);
                        formularioEmpleado.btnCancelarE.setEnabled(true);
                        formularioEmpleado.btnAbrirE.setEnabled(true);
                        formularioEmpleado.cboSexoE.setEnabled(true);
                        formularioEmpleado.btnNuevoE.setEnabled(false);
                        formularioEmpleado.activarTextos(true);
                        formularioEmpleado.JPImagen.removeAll();
                        try {
                            formularioEmpleado.JPImagen.removeAll();
                            final URL url = new URL(empleado.getImagen());
                            formularioEmpleado.imagen.setObtenerUrlImagen(url);
                            formularioEmpleado.imagen.mostrarImagen(formularioEmpleado.JPImagen);
                        } catch (MalformedURLException ex) {
                            
                        }

                    } catch (SQLException ex) {
                        JOptionPane.showConfirmDialog(null, "Error BD: " + ex.getMessage());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jEmpleado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscarVen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jEmpleado.setModel(tablaEmpleado);
        jEmpleado.setGridColor(new java.awt.Color(247, 254, 255));
        jScrollPane1.setViewportView(jEmpleado);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTA DE EMPLEADOS");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscarVen)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscarVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        rowSorter = new TableRowSorter(tablaEmpleado);
        jEmpleado.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtbuscarVenKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FormularioListaEmpleados dialog = new FormularioListaEmpleados(null, true);
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
    private javax.swing.JTable jEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtbuscarVen;
    // End of variables declaration//GEN-END:variables
}
