package ComponentePresentacion;

import javax.swing.UIManager;
import ComponenteClase.*;
import ComponenteNegocio.NegocioEmpleado;
import ComponenteNegocio.NegocioUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
public class FormularioUsuario extends javax.swing.JFrame {

    NegocioUsuario usuarioNegocio = new NegocioUsuario();
    NegocioEmpleado empleadoNegocio = new NegocioEmpleado();
    
    public FormularioUsuario() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();

        try {
            cboEmpleadoU.removeAll();
            NegocioEmpleado empleadoNegocio =  new NegocioEmpleado();
            ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
            listaEmpleado = empleadoNegocio.mostrarEmpleado();
            for (Empleado empleado : listaEmpleado) {
                cboEmpleadoU.addItem(empleado.getDni() + " " + empleado.getApellido());
            }
        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    /**
    * Método que contiene activa y limpia campos y botones del formulario FormularioUsuario según corresponda
    */ 
    public void limpiartextos() {
        txtNombreUsuario.setText("");
        txtID.setText("");
        txtPassU.setText("");
        cboEmpleadoU.setSelectedItem("");
        cboTipoUsuario.setSelectedItem("");
        btnNuevoU.setEnabled(true);
        btnEditarU.setEnabled(false);
        btnEliminarU.setEnabled(false);
        btnAgregarU.setEnabled(false);
        btnCancelarU.setEnabled(false);
        btnMostrar.setEnabled(true);
    }

    public void activartextos(boolean b) {
        txtNombreUsuario.setEnabled(b);
        txtPassU.setEnabled(b);
        cboEmpleadoU.setEnabled(b);
        cboTipoUsuario.setEnabled(b);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtPassU = new javax.swing.JPasswordField();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboEmpleadoU = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregarU = new javax.swing.JButton();
        btnNuevoU = new javax.swing.JButton();
        btnCancelarU = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnEditarU = new javax.swing.JButton();
        btnEliminarU = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboTipoUsuario = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("REGISTRAR USUARIO");

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));

        txtPassU.setText("jPasswordField1");
        txtPassU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPassU.setEnabled(false);
        txtPassU.setSelectionEnd(18);
        txtPassU.setSelectionStart(6);

        txtNombreUsuario.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("EMPLEADO :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("PASSWORD :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("USUARIO :");

        cboEmpleadoU.setEnabled(false);
        cboEmpleadoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpleadoUActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(81, 105, 138));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/LogoUsuario.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregarU.setText("Agregar");
        btnAgregarU.setEnabled(false);
        btnAgregarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUActionPerformed(evt);
            }
        });

        btnNuevoU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevoU.setText("Nuevo");
        btnNuevoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUActionPerformed(evt);
            }
        });

        btnCancelarU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelarU.setText("Cancelar");
        btnCancelarU.setEnabled(false);
        btnCancelarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarUActionPerformed(evt);
            }
        });

        btnMostrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnEditarU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditarU.setText("Editar");
        btnEditarU.setEnabled(false);
        btnEditarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUActionPerformed(evt);
            }
        });

        btnEliminarU.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminarU.setText("Eliminar");
        btnEliminarU.setEnabled(false);
        btnEliminarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtID.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("ID :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("TIPO USUARIO :");

        cboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Usuario" }));
        cboTipoUsuario.setEnabled(false);
        cboTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnNuevoU, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarU, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarU, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarU, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(cboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44))
                                            .addComponent(cboEmpleadoU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel1))
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel7))
                                                .addGap(17, 17, 17)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPassU, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarU, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboEmpleadoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(7, 7, 7))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoU, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnAgregarU, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnEditarU, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnEliminarU, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnCancelarU, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void cboEmpleadoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpleadoUActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cboEmpleadoUActionPerformed
/**
    * Método que permite agrgar un nuevo usuario solo si se completan todos los campos requeridos
    */ 
    private void btnAgregarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUActionPerformed
        if (txtNombreUsuario.getText().compareTo("") != 0 && txtPassU.getText().compareTo("") != 0) {
            Usuario usuario = new Usuario(0,"",null,"","") {
            };
            try {
                String empleadoSeleccionado = (String) cboEmpleadoU.getSelectedItem();
                String[] empleadoSeleccionadoDNI = empleadoSeleccionado.split(" ");
                Empleado empleado = empleadoNegocio.buscarEmpleado(empleadoSeleccionadoDNI[0]);
                String contrasena = new String(txtPassU.getPassword());
                usuario = new Usuario(0,txtNombreUsuario.getText(), empleado, contrasena, (String) cboTipoUsuario.getSelectedItem());
                usuarioNegocio.insertarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Datos Agregados.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Hubo un problema al insertar el registro");
            }
            limpiartextos();
            activartextos(false);
        }
}//GEN-LAST:event_btnAgregarUActionPerformed

    private void btnNuevoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUActionPerformed
        // TODO add your handling code here:
        btnAgregarU.setEnabled(true);
        btnCancelarU.setEnabled(true);
        btnMostrar.setEnabled(false);
        btnNuevoU.setEnabled(false);
        activartextos(true);
}//GEN-LAST:event_btnNuevoUActionPerformed

    private void btnCancelarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarUActionPerformed
        // TODO add your handling code here:
        limpiartextos();
        activartextos(false);
        txtNombreUsuario.setEditable(true);
        btnCancelarU.setEnabled(false);
        btnEliminarU.setEnabled(false);
        btnNuevoU.setEnabled(true);
        btnMostrar.setEnabled(true);
        btnAgregarU.setEnabled(false);
        btnEditarU.setEnabled(false);
}//GEN-LAST:event_btnCancelarUActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        FormularioListaUsuarios formularioListaUsuarios = new FormularioListaUsuarios(this, true);
        formularioListaUsuarios.setVisible(true);
}//GEN-LAST:event_btnMostrarActionPerformed

    
    private void btnEditarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUActionPerformed
        // TODO add your handling code here:
        Usuario usuario;
        Usuario usuarioEditado;
        try {
            usuario = usuarioNegocio.buscarUsuario(Integer.parseInt(txtID.getText()));
            String empleadoSeleccionado = (String) cboEmpleadoU.getSelectedItem();
            String[] empleadoSeleccionadoDNI = empleadoSeleccionado.split(" ");
            Empleado empleado = empleadoNegocio.buscarEmpleado(empleadoSeleccionadoDNI[0]);
            usuarioEditado = new Usuario(usuario.getIdUsuario(),txtNombreUsuario.getText(),empleado,new String(txtPassU.getPassword()),(String) cboTipoUsuario.getSelectedItem());
            usuarioNegocio.actualizarUsuario(usuarioEditado);
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el registro");
        }
        limpiartextos();
        activartextos(false);
}//GEN-LAST:event_btnEditarUActionPerformed

    private void btnEliminarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUActionPerformed
        // TODO add your handling code here:
        try {
            final Usuario usuario = usuarioNegocio.buscarUsuario(Integer.parseInt(txtID.getText()));
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            } else {
                usuarioNegocio.eliminarUsuario(usuario.getIdUsuario());
                JOptionPane.showMessageDialog(null, "Se eliminó exitosamente el usuario.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al eliminar el usuario.");
        }
        limpiartextos();
        activartextos(false);
}//GEN-LAST:event_btnEliminarUActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    private void cboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormularioUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarU;
    public javax.swing.JButton btnCancelarU;
    public javax.swing.JButton btnEditarU;
    public javax.swing.JButton btnEliminarU;
    private javax.swing.JButton btnMostrar;
    public javax.swing.JButton btnNuevoU;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox cboEmpleadoU;
    public javax.swing.JComboBox cboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtNombreUsuario;
    public javax.swing.JPasswordField txtPassU;
    // End of variables declaration//GEN-END:variables
}
