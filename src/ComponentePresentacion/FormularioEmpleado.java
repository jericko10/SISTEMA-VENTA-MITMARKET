package ComponentePresentacion;

import ComponenteClase.Empleado;
import ComponenteNegocio.NegocioEmpleado;
import ComponenteOtros.*;
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
 * 
 * @author Rodriguez Zelada
 * @version 2.1
 */
public class FormularioEmpleado extends javax.swing.JFrame {
 
    private NegocioEmpleado empleadoNegocio =  new NegocioEmpleado();
    Imagen imagen = new Imagen() {};
    private String ImagenURL;
    
    public FormularioEmpleado() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
          }

    /**
    * Método que contiene activa y limpia campos y botones del formulario FormularioEmpleado según corresponda
    */ 
    public void LimpiarTextos()
    {
        txtDniE.setText("");
        txtNombreE.setText("");
        txtApellidoE.setText("");
        txtEdadE.setText("");
        txtEmailE.setText("");
        txtTelefonoE.setText("");
        txtCelularE.setText("");
        txtDireccionE.setText("");
        btnNuevoE.setEnabled(true);
        btnAgregarE.setEnabled(false);
        btnEditarE.setEnabled(false);
        btnEliminarE.setEnabled(false);
        btnCancelarE.setEnabled(false);
        JPImagen.removeAll();
    }

    public void EstadoButton(boolean b)
    {
        btnNuevoE.setEnabled(!b);
        btnAgregarE.setEnabled(b);
        btnAbrirE.setEnabled(b);
        btnCancelarE.setEnabled(b);
        btnEditarE.setEnabled(b);
        btnEliminarE.setEnabled(b);
        btnMostrarE.setEnabled(!b);

    }
    public void activarTextos(boolean t)
    {
        txtNombreE.setEnabled(t);
        txtApellidoE.setEnabled(t);
        txtEdadE.setEnabled(t);
        cboSexoE.setEnabled(t);
        txtEmailE.setEnabled(t);
        txtTelefonoE.setEnabled(t);
        txtCelularE.setEnabled(t);
        txtDireccionE.setEnabled(t);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JPImagen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDniE = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreE = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccionE = new javax.swing.JTextField();
        txtEdadE = new javax.swing.JTextField();
        txtEmailE = new javax.swing.JTextField();
        txtTelefonoE = new javax.swing.JFormattedTextField();
        txtCelularE = new javax.swing.JFormattedTextField();
        cboSexoE = new javax.swing.JComboBox();
        btnSalirE = new javax.swing.JButton();
        btnEditarE = new javax.swing.JButton();
        btnEliminarE = new javax.swing.JButton();
        btnNuevoE = new javax.swing.JButton();
        btnAbrirE = new javax.swing.JButton();
        btnMostrarE = new javax.swing.JButton();
        btnAgregarE = new javax.swing.JButton();
        btnCancelarE = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(81, 105, 138));

        jPanel1.setBackground(new java.awt.Color(247, 254, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        JPImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout JPImagenLayout = new javax.swing.GroupLayout(JPImagen);
        JPImagen.setLayout(JPImagenLayout);
        JPImagenLayout.setHorizontalGroup(
            JPImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        JPImagenLayout.setVerticalGroup(
            JPImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Dni:");

        try {
            txtDniE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDniE.setText("");
        txtDniE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniEActionPerformed(evt);
            }
        });
        txtDniE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniEKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        txtNombreE.setEnabled(false);
        txtNombreE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreEKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Apellido:");

        txtApellidoE.setEnabled(false);
        txtApellidoE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoEKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Edad:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Sexo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Telefono:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Celular:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Direccion:");

        txtDireccionE.setEnabled(false);

        txtEdadE.setEnabled(false);
        txtEdadE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadEKeyTyped(evt);
            }
        });

        txtEmailE.setEnabled(false);
        txtEmailE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailEActionPerformed(evt);
            }
        });

        try {
            txtTelefonoE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)-###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefonoE.setEnabled(false);

        try {
            txtCelularE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)-###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelularE.setEnabled(false);

        cboSexoE.setEditable(true);
        cboSexoE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));
        cboSexoE.setEnabled(false);
        cboSexoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSexoEActionPerformed(evt);
            }
        });

        btnSalirE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalirE.setText("Salir");
        btnSalirE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirEActionPerformed(evt);
            }
        });

        btnEditarE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditarE.setText("Editar");
        btnEditarE.setEnabled(false);
        btnEditarE.setPreferredSize(new java.awt.Dimension(75, 23));
        btnEditarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEActionPerformed(evt);
            }
        });

        btnEliminarE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminarE.setText("Eliminar");
        btnEliminarE.setEnabled(false);
        btnEliminarE.setMaximumSize(new java.awt.Dimension(75, 23));
        btnEliminarE.setMinimumSize(new java.awt.Dimension(75, 23));
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        btnNuevoE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevoE.setText("Nuevo");
        btnNuevoE.setPreferredSize(new java.awt.Dimension(65, 23));
        btnNuevoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEActionPerformed(evt);
            }
        });

        btnAbrirE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAbrirE.setText("Examinar");
        btnAbrirE.setEnabled(false);
        btnAbrirE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirEActionPerformed(evt);
            }
        });

        btnMostrarE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMostrarE.setText("Mostrar");
        btnMostrarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarEActionPerformed(evt);
            }
        });

        btnAgregarE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregarE.setText("Agregar");
        btnAgregarE.setEnabled(false);
        btnAgregarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEActionPerformed(evt);
            }
        });

        btnCancelarE.setText("Cancelar");
        btnCancelarE.setEnabled(false);
        btnCancelarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalirE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDniE, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cboSexoE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtEdadE, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addComponent(jLabel9))
                                                .addComponent(jLabel8))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtTelefonoE)
                                                .addComponent(txtCelularE, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(txtEmailE)
                                        .addComponent(txtDireccionE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtApellidoE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAbrirE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevoE, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDniE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEdadE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(cboSexoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtCelularE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelefonoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEmailE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDireccionE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbrirE, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnAgregarE, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnEditarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalirE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("REGISTRO DE EMPLEADO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirEActionPerformed
        JPImagen.removeAll();
        imagen.abrirDialogoSeleccionImagen(JPImagen);
        ImagenURL = imagen.obtenerUrl();
    }//GEN-LAST:event_btnAbrirEActionPerformed

    private void txtDniEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniEActionPerformed
 
    }//GEN-LAST:event_txtDniEActionPerformed
/**
    * Método de tipo validación que permite solo el ingreso del abecedario
    */ 
    private void txtNombreEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreEKeyTyped
/**
    * Método de tipo validación que permite solo el ingreso del abecedario
    */ 
    private void txtApellidoEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoEKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoEKeyTyped

    private void txtEmailEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailEActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_txtEmailEActionPerformed
/**
    * Método que agrega un nuevo empleado a la base de datos solo si se completaron todos los campos requeridos
    */ 
    private void btnAgregarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEActionPerformed
   if(txtDniE.getText().compareTo("")!=0 && txtNombreE.getText().compareTo("")!=0&& txtApellidoE.getText().compareTo("")!=0 
      && txtEdadE.getText().compareTo("")!=0 && (txtCelularE.getText().compareTo("")!=0 || txtTelefonoE.getText().compareTo("")!=0)
      && txtDireccionE.getText().compareTo("")!=0){
        Empleado empleado = new Empleado(0,txtDniE.getText(),txtNombreE.getText(),txtApellidoE.getText(),
        txtEmailE.getText(),(String) cboSexoE.getSelectedItem(), Integer.parseInt(txtEdadE.getText()),
        txtTelefonoE.getText(),txtCelularE.getText(),txtDireccionE.getText(),ImagenURL) {};
        try {
            empleadoNegocio.insertarEmpleado(empleado);
            JOptionPane.showMessageDialog(null, "Datos Agregados.");
            JPImagen.removeAll();
            LimpiarTextos();
            activarTextos(false);
            EstadoButton(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al insertar el registro.");
        }
   }else{
       JOptionPane.showMessageDialog(null, "Llene losc campos obligatorios.");
   }

    }//GEN-LAST:event_btnAgregarEActionPerformed

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed
        try {
            Empleado empleado = new Empleado(0, "", "", "", "", "", 0, "", "", "", ""); {};
            empleado = empleadoNegocio.buscarEmpleado(txtDniE.getText());
            if (empleado == null) {
                JOptionPane.showMessageDialog(null, "No existe el empleado");
            } else {
                empleadoNegocio.eliminarEmpleado(empleado.getDni());
                JOptionPane.showMessageDialog(null, "Se eliminó exitosamente el empleado");
                JPImagen.removeAll();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al eliminar el empleado.");
        }
        LimpiarTextos();
        activarTextos(false);
        EstadoButton(false);
    }//GEN-LAST:event_btnEliminarEActionPerformed
/**
    * Método que lista los empleados
    */ 
    private void btnMostrarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEActionPerformed
        FormularioListaEmpleados formularioListaEmpleado = new FormularioListaEmpleados(this, true);
        formularioListaEmpleado.setVisible(true);
    }//GEN-LAST:event_btnMostrarEActionPerformed

    private void btnNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEActionPerformed
        LimpiarTextos();
        txtDniE.setText("");
        EstadoButton(true);
        activarTextos(true);
    }//GEN-LAST:event_btnNuevoEActionPerformed

    /**
    * Método que modifica los datos de un empleado almacenado en la base de datos
    */ 
    private void btnEditarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEActionPerformed
        Empleado empleado = new Empleado(0, "", "", "", "", "", 0, "", "", "", "");
        Empleado empleadoEditado;
            try {
                empleado = empleadoNegocio.buscarEmpleado(txtDniE.getText());
                empleadoEditado = new Empleado(empleado.getNumeroEmpleado(),txtDniE.getText(),txtNombreE.getText(),txtApellidoE.getText(),
                txtEmailE.getText(),(String) cboSexoE.getSelectedItem(), Integer.parseInt(txtEdadE.getText()),
                txtTelefonoE.getText(),txtCelularE.getText(),txtDireccionE.getText(),ImagenURL) {};
                empleadoNegocio.actualizarEmpleado(empleadoEditado);
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                JPImagen.removeAll();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el registro");
            }
        LimpiarTextos();
        activarTextos(false);
        EstadoButton(false);
    }//GEN-LAST:event_btnEditarEActionPerformed

    private void btnSalirEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirEActionPerformed
         dispose();
    }//GEN-LAST:event_btnSalirEActionPerformed

    private void btnCancelarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEActionPerformed
        LimpiarTextos();
        activarTextos(false);
        btnCancelarE.setEnabled(false);
        btnEliminarE.setEnabled(false);
        btnNuevoE.setEnabled(true);
        btnMostrarE.setEnabled(true);
        btnAgregarE.setEnabled(false);
        btnAbrirE.setEnabled(false);
        btnEditarE.setEnabled(false);
    }//GEN-LAST:event_btnCancelarEActionPerformed

    private void cboSexoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSexoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSexoEActionPerformed
/**
    * Método de tipo validación que permite solo el ingreso de numeros enteros
    */ 
    private void txtEdadEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadEKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("[0-9]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEdadEKeyTyped
/**
    * Método de tipo validación que permite solo el ingreso de numeros enteros
    */ 
    private void txtDniEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniEKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("[0-9]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDniEKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormularioEmpleado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel JPImagen;
    public javax.swing.JButton btnAbrirE;
    public javax.swing.JButton btnAgregarE;
    public javax.swing.JButton btnCancelarE;
    public javax.swing.JButton btnEditarE;
    public javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnMostrarE;
    public javax.swing.JButton btnNuevoE;
    private javax.swing.JButton btnSalirE;
    public javax.swing.JComboBox cboSexoE;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txtApellidoE;
    public javax.swing.JFormattedTextField txtCelularE;
    public javax.swing.JTextField txtDireccionE;
    public javax.swing.JFormattedTextField txtDniE;
    public javax.swing.JTextField txtEdadE;
    public javax.swing.JTextField txtEmailE;
    public javax.swing.JTextField txtNombreE;
    public javax.swing.JFormattedTextField txtTelefonoE;
    // End of variables declaration//GEN-END:variables
}
