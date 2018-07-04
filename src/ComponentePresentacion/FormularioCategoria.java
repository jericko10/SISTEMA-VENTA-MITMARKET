package ComponentePresentacion;

import ComponenteClase.Categoria;
import ComponenteNegocio.NegocioCategoria;
import ComponenteOtros.Imagen;
import java.awt.Toolkit;
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
public class FormularioCategoria extends javax.swing.JFrame {

    Imagen imagen = new Imagen() {};
    private String imagenURL;
    private NegocioCategoria categoriaNegocio = new NegocioCategoria();
    
    public FormularioCategoria() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
    }
    
    /**
    * Método que contiene activa y limpia campos y botones del formulario FormularioCategoria según corresponda
    */
    public void limpiarFormulario(){
        txtnombreCat.setText("");
        txtdetalleCat.setText("");
        txtidCategoria.setText("");
        txtnombreCat.setEnabled(false);
        txtdetalleCat.setEnabled(false);
        btnAgregarCat.setEnabled(false);
        btnCancelarCat.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnEditarCat.setEnabled(false);
        btnEliminarCat.setEnabled(false);
        btnMostrarCat.setEnabled(true);
        btnSalirCat.setEnabled(true);
        btnAbrirCat.setEnabled(false);
        btnCancelarCat.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JPImagenCat = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEliminarCat = new javax.swing.JButton();
        btnMostrarCat = new javax.swing.JButton();
        btnEditarCat = new javax.swing.JButton();
        btnAgregarCat = new javax.swing.JButton();
        btnAbrirCat = new javax.swing.JButton();
        btnSalirCat = new javax.swing.JButton();
        btnCancelarCat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombreCat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdetalleCat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtidCategoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("REGISTRAR CATEGORIA");

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        JPImagenCat.setBackground(new java.awt.Color(255, 255, 255));
        JPImagenCat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout JPImagenCatLayout = new javax.swing.GroupLayout(JPImagenCat);
        JPImagenCat.setLayout(JPImagenCatLayout);
        JPImagenCatLayout.setHorizontalGroup(
            JPImagenCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        JPImagenCatLayout.setVerticalGroup(
            JPImagenCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminarCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminarCat.setText("Eliminar");
        btnEliminarCat.setEnabled(false);
        btnEliminarCat.setMaximumSize(new java.awt.Dimension(55, 23));
        btnEliminarCat.setMinimumSize(new java.awt.Dimension(55, 23));
        btnEliminarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCatActionPerformed(evt);
            }
        });

        btnMostrarCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMostrarCat.setText("Mostrar");
        btnMostrarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCatActionPerformed(evt);
            }
        });

        btnEditarCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditarCat.setText("Modificar");
        btnEditarCat.setEnabled(false);
        btnEditarCat.setMaximumSize(new java.awt.Dimension(55, 23));
        btnEditarCat.setMinimumSize(new java.awt.Dimension(55, 23));
        btnEditarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCatActionPerformed(evt);
            }
        });

        btnAgregarCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregarCat.setText("Agregar");
        btnAgregarCat.setEnabled(false);
        btnAgregarCat.setMaximumSize(new java.awt.Dimension(55, 23));
        btnAgregarCat.setMinimumSize(new java.awt.Dimension(55, 23));
        btnAgregarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCatActionPerformed(evt);
            }
        });

        btnAbrirCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAbrirCat.setText("Examinar");
        btnAbrirCat.setEnabled(false);
        btnAbrirCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCatActionPerformed(evt);
            }
        });

        btnSalirCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalirCat.setText("Salir");
        btnSalirCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCatActionPerformed(evt);
            }
        });

        btnCancelarCat.setText("Cancelar");
        btnCancelarCat.setEnabled(false);
        btnCancelarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre Categoria:");

        txtnombreCat.setEnabled(false);
        txtnombreCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreCatKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Detalle Categoria:");

        txtdetalleCat.setEnabled(false);
        txtdetalleCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdetalleCatKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ID:");

        txtidCategoria.setEnabled(false);
        txtidCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidCategoriaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnAbrirCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JPImagenCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnMostrarCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEditarCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnCancelarCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminarCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAgregarCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(btnSalirCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtdetalleCat)
                                .addComponent(txtnombreCat))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtidCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtidCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdetalleCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JPImagenCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrirCat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnAgregarCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditarCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrarCat)
                            .addComponent(btnCancelarCat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalirCat)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btnAbrirCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCatActionPerformed
        JPImagenCat.removeAll();
        imagen.abrirDialogoSeleccionImagen(JPImagenCat);
        imagenURL = imagen.obtenerUrl();
    }//GEN-LAST:event_btnAbrirCatActionPerformed

    private void btnSalirCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCatActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirCatActionPerformed

    /**
    * Método privado que agrega categorias a la base de datos.
    */ 
    private void btnAgregarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCatActionPerformed
        Categoria categoria = new Categoria(0,txtnombreCat.getText().toUpperCase(),txtdetalleCat.getText().toLowerCase().trim(),imagenURL) {};
        if(categoria.getNombreCategoria().equals("") || categoria.getDetalleCategoria().equals("")){
            JOptionPane.showMessageDialog(null, "Llene los campos.");
            return;
        }
        try {
            if(categoriaNegocio.comprobarIgualdadDetalle(categoria.getNombreCategoria(),categoria.getDetalleCategoria())){
                JOptionPane.showMessageDialog(null, "La nueva entrada ya está registrada.");
                return;
            }
            categoriaNegocio.insertarCategoria(categoria);
            JOptionPane.showMessageDialog(null, "Se agregó correctamente");
            JPImagenCat.removeAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un error al insertar el registro");
        }
        txtnombreCat.setText("");
        limpiarFormulario();        
    }//GEN-LAST:event_btnAgregarCatActionPerformed

    
    /**
    * Método de tipo validación que permite solo el ingreso del abecedario
    */ 

    private void txtnombreCatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreCatKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreCatKeyTyped

    private void btnEditarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCatActionPerformed
        Categoria categoria = new Categoria(0,"","","") {};
        Categoria categoriaEditada;
        try {
            categoria = categoriaNegocio.buscarCategoriaCodigo(Integer.parseInt(txtidCategoria.getText().trim()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: "+ex.getMessage());
        }
        categoriaEditada = new Categoria(categoria.getCodigoCategoria(), txtnombreCat.getText().toUpperCase(), txtdetalleCat.getText().toLowerCase().trim(), imagenURL);
        try {
            categoriaNegocio.actualizarCategoria(categoriaEditada);
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            JPImagenCat.removeAll();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el registro");
        }
        limpiarFormulario();
    }//GEN-LAST:event_btnEditarCatActionPerformed

    /**
    * Método que contiene activa y limpia campos y botones del formulario FormularioCategoria según corresponda 
    * para el ingreso de un nuevo registro
    */ 
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtnombreCat.setText("");
        txtdetalleCat.setText("");
        txtnombreCat.setEnabled(true);
        txtdetalleCat.setEnabled(true);
        JPImagenCat.setEnabled(true);
        btnAgregarCat.setEnabled(true);
        btnAbrirCat.setEnabled(true);
        btnCancelarCat.setEnabled(true);
        btnNuevo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    /**
    * Método que lista categorias almacenadas.
    */ 

    private void btnMostrarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCatActionPerformed
        FormularioListaCategorias formularioListaCategoria = new FormularioListaCategorias(this, true) {};
        formularioListaCategoria.setVisible(true);
    }//GEN-LAST:event_btnMostrarCatActionPerformed

    
    /**
    * Método que elimina una categoria de la base de datos.
    */ 

    private void btnEliminarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCatActionPerformed
        try {
            Categoria categoria = new Categoria(0,"","",""){};
            categoria = categoriaNegocio.buscarCategoriaDetalle(txtdetalleCat.getText().trim());
            if (categoria == null) {
                JOptionPane.showMessageDialog(null, "No existe la categoria.");
            } else {
                categoriaNegocio.eliminarCategoria(categoria.getCodigoCategoria());
                JOptionPane.showMessageDialog(null, "Se eliminó exitosamente la categoria.");
                JPImagenCat.removeAll();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        limpiarFormulario();
    }//GEN-LAST:event_btnEliminarCatActionPerformed

    private void btnCancelarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCatActionPerformed
        // TODO add your handling code here:
        limpiarFormulario();
    }//GEN-LAST:event_btnCancelarCatActionPerformed

    private void txtdetalleCatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdetalleCatKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("[a-zA-Z0-9]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtdetalleCatKeyTyped

    private void txtidCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidCategoriaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormularioCategoria().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel JPImagenCat;
    public javax.swing.JButton btnAbrirCat;
    public javax.swing.JButton btnAgregarCat;
    public javax.swing.JButton btnCancelarCat;
    public javax.swing.JButton btnEditarCat;
    public javax.swing.JButton btnEliminarCat;
    private javax.swing.JButton btnMostrarCat;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalirCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtdetalleCat;
    public javax.swing.JTextField txtidCategoria;
    public javax.swing.JTextField txtnombreCat;
    // End of variables declaration//GEN-END:variables
}
