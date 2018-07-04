package ComponentePresentacion;

import ComponenteClase.Caja;
import ComponenteClase.Usuario;
import ComponenteNegocio.NegocioCaja;
import ComponenteNegocio.NegocioUsuario;
import java.net.UnknownHostException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public abstract class FormularioLogin extends javax.swing.JFrame {

    private NegocioUsuario usuarioNegocio = new NegocioUsuario();
    
    public FormularioLogin() {
        this.setUndecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new ComponentePresentacion.FormularioPanelFondoLogin();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        botonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        botonIngresar = new javax.swing.JButton();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(177, 224, 245));

        jPanel3.setBackground(new java.awt.Color(177, 224, 245));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("USUARIO");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtUsuario.setPreferredSize(new java.awt.Dimension(105, 21));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/user.png"))); // NOI18N

        txtClave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtClave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtClave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtClave.setPreferredSize(new java.awt.Dimension(105, 21));
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/cerrar.png"))); // NOI18N
        botonSalir.setBorder(null);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("PASSWORD");

        botonIngresar.setBackground(new java.awt.Color(204, 204, 255));
        botonIngresar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/ingresar.png"))); // NOI18N
        botonIngresar.setBorder(null);
        botonIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonIngresar.setPreferredSize(new java.awt.Dimension(97, 25));
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(32, 32, 32)
                                .addComponent(botonSalir))
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir)))
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtUsuarioActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
}//GEN-LAST:event_botonSalirActionPerformed

    @SuppressWarnings("static-access")
    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        // TODO add your handling code here:
        final String textoUsuario = txtUsuario.getText();
        final String textoContrasena = new String(txtClave.getPassword());
        if(!textoUsuario.isEmpty() && !textoContrasena.isEmpty())
        {
           try {
                final Usuario usuario = usuarioNegocio.buscarUsuarioNombre(textoUsuario);
                if(usuario != null)
                {
                    if (textoUsuario.equals(usuario.getNombreUsuario()) && textoContrasena.equals(usuario.getContrasenaUsuario())) {
                        FormularioMenu formularioMenu = new FormularioMenu() {};
                        formularioMenu.lblNombresUsuario.setText(usuario.getEmpleado().getApellido().toUpperCase().trim() + ", " + usuario.getEmpleado().getNombre().trim());
                        formularioMenu.tipoUsuario = usuario.getTipoUsuario();
                        formularioMenu.idEmpleado = usuario.getEmpleado().getNumeroEmpleado();
                        java.net.InetAddress nombrePC = null;
                        try {
                            nombrePC = java.net.InetAddress.getLocalHost();
                        } catch (UnknownHostException ex) {
                        }
                        NegocioCaja negocioCaja = new NegocioCaja();
                        Caja caja = negocioCaja.buscarCajaNombre(nombrePC.getHostName());
                        if(caja.getIdCaja()==0){
                            JOptionPane.showMessageDialog(this, "Esta PC no está registrada como Caja.", "Verificar", JOptionPane.ERROR_MESSAGE); 
                            return;
                        }
                        else{
                            formularioMenu.nombreCaja = nombrePC.getHostName();
                            formularioMenu.idCaja = caja.getIdCaja();
                            formularioMenu.estadoCaja = "Activo";
                            negocioCaja.actualizarEstadoCaja(caja.getIdCaja(), "Activo");
                            formularioMenu.setVisible(true);
                            this.dispose();
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Datos incorrectos: verifique su nombre de usuario y contraseña.", "Datos no válidos", JOptionPane.ERROR_MESSAGE);      
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "El usuario no existe.", 
                                        "", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error BD: " + ex.getMessage());
            } 
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese Usuario y contraseña.", 
                                        "Error: Ingrese sus datos de usuario", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FormularioLogin() {
                }.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
