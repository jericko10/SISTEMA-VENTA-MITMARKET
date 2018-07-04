package ComponentePresentacion;

import ComponenteClase.*;
import ComponenteNegocio.NegocioCategoria;
import ComponenteNegocio.NegocioProducto;
import ComponenteOtros.*;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class FormularioProducto extends javax.swing.JFrame {

    Imagen imagen = new Imagen() {};
    private String imagenURL;
    private NegocioProducto productoNegocio =  new NegocioProducto();
    private NegocioCategoria categoriaNegocio =  new NegocioCategoria();
    private int limiteCaracterCodigoBarra = 13;
    
    public FormularioProducto() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        txtcodigobarra.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(txtcodigobarra.getText().length() == limiteCaracterCodigoBarra){
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
    }
    
    /**
    * Método que contiene activa y limpia campos y botones del formulario FormularioProducto según corresponda
    */ 
    public void limpiarTextos() {
        txtIdProducto.setText("");
        txtNombreP.setText("");
        txtUnidadMedP.setText("");
        txtPrecioUP.setText("");
        txtcodcat.setText("");
        txtcategoria.setText("");
        txtdetallecat.setText("");
        txtcodigobarra.setText("");
        txtstock.setText("");
        btnNuevoP.setEnabled(true);
        btnAgregarP.setEnabled(false);
        btnEditarP.setEnabled(false);
        btnEliminarP.setEnabled(false);
        btnCancelarP.setEnabled(false);
        btnSeleccionarCategoria.setEnabled(false);
        btnMostrarP.setEnabled(true);
    }

    public void activarTextos(boolean b) {
        txtNombreP.setEditable(b);
        txtUnidadMedP.setEditable(b);
        txtPrecioUP.setEditable(b);
        txtcodigobarra.setEnabled(b);
        txtstock.setEnabled(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtPrecioUP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jpImageProd = new javax.swing.JPanel();
        btnExaminar = new javax.swing.JButton();
        btnSalirP = new javax.swing.JButton();
        btnAgregarP = new javax.swing.JButton();
        btnNuevoP = new javax.swing.JButton();
        btnCancelarP = new javax.swing.JButton();
        btnEditarP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        btnMostrarP = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JTextField();
        txtcodcat = new javax.swing.JTextField();
        txtcodigobarra = new javax.swing.JTextField();
        txtcategoria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnSeleccionarCategoria = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtdetallecat = new javax.swing.JTextField();
        txtUnidadMedP = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Categoria :");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        txtPrecioUP.setEditable(false);
        txtPrecioUP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUPKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("ID Producto :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Código Cat. :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Precio Und. /S.:");

        txtIdProducto.setEditable(false);
        txtIdProducto.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpImageProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jpImageProdLayout = new javax.swing.GroupLayout(jpImageProd);
        jpImageProd.setLayout(jpImageProdLayout);
        jpImageProdLayout.setHorizontalGroup(
            jpImageProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpImageProdLayout.setVerticalGroup(
            jpImageProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpImageProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpImageProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnExaminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExaminar.setText("Examinar");
        btnExaminar.setEnabled(false);
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        btnSalirP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalirP.setText("Salir");
        btnSalirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPActionPerformed(evt);
            }
        });

        btnAgregarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregarP.setText("Agregar");
        btnAgregarP.setEnabled(false);
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });

        btnNuevoP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevoP.setText("Nuevo");
        btnNuevoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPActionPerformed(evt);
            }
        });

        btnCancelarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelarP.setText("Cancelar");
        btnCancelarP.setEnabled(false);
        btnCancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPActionPerformed(evt);
            }
        });

        btnEditarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditarP.setText("Editar");
        btnEditarP.setEnabled(false);
        btnEditarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPActionPerformed(evt);
            }
        });

        btnEliminarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminarP.setText("Eliminar");
        btnEliminarP.setEnabled(false);
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });

        btnMostrarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMostrarP.setText("Mostrar");
        btnMostrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Unid.Med:");

        txtNombreP.setEditable(false);

        txtcodcat.setEditable(false);
        txtcodcat.setEnabled(false);
        txtcodcat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodcatKeyTyped(evt);
            }
        });

        txtcodigobarra.setEditable(false);
        txtcodigobarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigobarraKeyTyped(evt);
            }
        });

        txtcategoria.setEditable(false);
        txtcategoria.setEnabled(false);
        txtcategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcategoriaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Categoria :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Código de Barra:");

        btnSeleccionarCategoria.setText("Seleccionar Categoría");
        btnSeleccionarCategoria.setEnabled(false);
        btnSeleccionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCategoriaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Detalle :");

        txtdetallecat.setEditable(false);
        txtdetallecat.setEnabled(false);
        txtdetallecat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdetallecatKeyTyped(evt);
            }
        });

        txtUnidadMedP.setEditable(false);

        txtstock.setEditable(false);
        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstockKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Cantidad (STOCK):");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnidadMedP, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnSeleccionarCategoria))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcodigobarra)
                                .addComponent(txtdetallecat)
                                .addComponent(txtcodcat)
                                .addComponent(txtPrecioUP)
                                .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalirP, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNuevoP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtUnidadMedP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtcodcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExaminar)
                    .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtdetallecat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionarCategoria)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigobarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoP)
                    .addComponent(btnAgregarP)
                    .addComponent(btnEditarP)
                    .addComponent(btnCancelarP)
                    .addComponent(btnEliminarP)
                    .addComponent(btnMostrarP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalirP)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REGISTRO DE PRODUCTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
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

    /**
    * Método que agrega un nuevo producto a la base de datos solo si se completan todos los campos requeridos
    */ 
    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
        if (txtNombreP.getText().compareTo("") != 0 && txtPrecioUP.getText().compareTo("") != 0 && txtcodcat.getText().compareTo("") != 0 && txtcodigobarra.getText().compareTo("") != 0 
                && txtstock.getText().compareTo("") != 0) {
            try {
                Categoria categoria = new Categoria(0,"","",""){};
                categoria = categoriaNegocio.buscarCategoriaCodigo(Integer.parseInt(txtcodcat.getText()));
                Producto producto = new Producto(0,txtNombreP.getText().toUpperCase(),txtUnidadMedP.getText(),categoria,Float.parseFloat(txtPrecioUP.getText()),
                imagenURL, txtcodigobarra.getText(), Integer.parseInt(txtstock.getText())) {};
                productoNegocio.insertarProducto(producto);
                JOptionPane.showMessageDialog(null, "Datos registrados.");
                jpImageProd.removeAll();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error BD: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "Hubo un problema al insertar el registro");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Complete los campos del formulario.");
            return;
        }
        limpiarTextos();
        activarTextos(false);
    }//GEN-LAST:event_btnAgregarPActionPerformed

    /**
    * Método que modifica datos de un producto registrado en la base de datos
    */ 
    private void btnEditarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPActionPerformed
        // TODO add your handling code here:
        Producto producto = new Producto(0,"","",null,0,"","",0){};
        Producto productoEditado;
        Categoria categoria = new Categoria(0,"","","") {};
        try {
            categoria = categoriaNegocio.buscarCategoriaCodigo(Integer.parseInt(txtcodcat.getText()));
            producto = productoNegocio.buscarProducto(Integer.parseInt(txtIdProducto.getText()));
            productoEditado = new Producto(producto.getIdProducto(), txtNombreP.getText(), txtUnidadMedP.getText(),
            categoria, Float.parseFloat(txtPrecioUP.getText()), imagenURL, txtcodigobarra.getText(), Integer.parseInt(txtstock.getText()));
            productoNegocio.actualizarProducto(productoEditado);
            JOptionPane.showMessageDialog(null, "Datos Actualizados.");
            jpImageProd.removeAll();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar el registro");
        }
        limpiarTextos();
        activarTextos(false);
    }//GEN-LAST:event_btnEditarPActionPerformed

    /**
    * Método que lista los productos almacenados
    */ 
    private void btnMostrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPActionPerformed

        FormularioListaProductos formularioListaProductos = new FormularioListaProductos(this, true);
        formularioListaProductos.setVisible(true);
    }//GEN-LAST:event_btnMostrarPActionPerformed

    private void btnSalirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirPActionPerformed
 /**
    * Método que elimina de la base de datos un producto buscado
    */
    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        // TODO add your handling code here:
        try {
            Producto producto = new Producto(0,"","",null,0,"","",0){};
            producto = productoNegocio.buscarProducto(Integer.parseInt(txtIdProducto.getText()));
            if (producto == null) {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            } else {
                productoNegocio.eliminarProducto(producto.getIdProducto());
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente el producto.");
                jpImageProd.removeAll();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al eliminar el producto.");
        }
        limpiarTextos();
        activarTextos(false);
    }//GEN-LAST:event_btnEliminarPActionPerformed

    
    private void btnNuevoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPActionPerformed
        limpiarTextos();
        activarTextos(true);
        txtIdProducto.setEditable(false);
        btnNuevoP.setEnabled(false);
        btnAgregarP.setEnabled(true);
        btnCancelarP.setEnabled(true);
        btnExaminar.setEnabled(true);
        btnMostrarP.setEnabled(false);
        btnSeleccionarCategoria.setEnabled(true);
        txtcodigobarra.setEditable(true);
        txtcodigobarra.setEnabled(true);
        txtstock.setEditable(true);
        txtstock.setEnabled(true);
    }//GEN-LAST:event_btnNuevoPActionPerformed

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        jpImageProd.removeAll();
        imagen.abrirDialogoSeleccionImagen(jpImageProd);
        imagenURL = imagen.obtenerUrl();
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void btnCancelarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPActionPerformed
        limpiarTextos();
        activarTextos(false);
        txtIdProducto.setEditable(false);
        btnCancelarP.setEnabled(false);
        btnEliminarP.setEnabled(false);
        btnNuevoP.setEnabled(true);
        btnMostrarP.setEnabled(true);
        btnAgregarP.setEnabled(false);
        btnExaminar.setEnabled(false);
        btnEditarP.setEnabled(false);
        btnSeleccionarCategoria.setEnabled(false);
        txtcodigobarra.setEditable(false);
        txtcodigobarra.setEnabled(false);
    }//GEN-LAST:event_btnCancelarPActionPerformed

    /**
    * Método de tipo validación que permite solo el ingreso de numeros
    */ 
    private void txtPrecioUPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUPKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("[0-9.]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioUPKeyTyped

    private void txtcodcatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodcatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodcatKeyTyped

    private void txtcodigobarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigobarraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigobarraKeyTyped

    private void txtcategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategoriaKeyTyped

    private void txtdetallecatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdetallecatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdetallecatKeyTyped

    private void btnSeleccionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCategoriaActionPerformed
        FormularioListaCategoriaProducto formularioListaCategoriaProducto =  new FormularioListaCategoriaProducto(this, true);
        formularioListaCategoriaProducto.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarCategoriaActionPerformed

    private void txtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormularioProducto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarP;
    public javax.swing.JButton btnCancelarP;
    public javax.swing.JButton btnEditarP;
    public javax.swing.JButton btnEliminarP;
    public javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnMostrarP;
    public javax.swing.JButton btnNuevoP;
    private javax.swing.JButton btnSalirP;
    public javax.swing.JButton btnSeleccionarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jpImageProd;
    public javax.swing.JTextField txtIdProducto;
    public javax.swing.JTextField txtNombreP;
    public javax.swing.JTextField txtPrecioUP;
    public javax.swing.JTextField txtUnidadMedP;
    public javax.swing.JTextField txtcategoria;
    public javax.swing.JTextField txtcodcat;
    public javax.swing.JTextField txtcodigobarra;
    public javax.swing.JTextField txtdetallecat;
    public javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}
