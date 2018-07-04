package ComponentePresentacion;

import ComponenteNegocio.NegocioCaja;
import ComponenteOtros.LecturaEsperaProductosClientes;
import java.sql.SQLException;
import javax.swing.UIManager;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public abstract class FormularioMenu extends javax.swing.JFrame {
   
    public static String tipoUsuario = "";
    public static String nombreCaja = "";
    public static int idEmpleado = 0;
    public static int idCaja = 0;
    private volatile Thread hiloProductoClienteEspera;
    public LecturaEsperaProductosClientes productoClienteEspera;
    public static String estadoCaja = "";
    
    public FormularioMenu() {
        this.setUndecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblNombresUsuario = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblTipoUsuarioLogeado = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTipoUsuario1 = new javax.swing.JLabel();
        lblNombreCaja = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMInicio = new javax.swing.JMenu();
        JMISalir = new javax.swing.JMenuItem();
        JMMantenimiento = new javax.swing.JMenu();
        JMICategoria = new javax.swing.JMenuItem();
        JMIEmpleado = new javax.swing.JMenuItem();
        JMIProducto = new javax.swing.JMenuItem();
        JMIUsuario = new javax.swing.JMenuItem();
        JMICaja = new javax.swing.JMenuItem();
        JMVenta = new javax.swing.JMenu();
        JMIGenerarVenta = new javax.swing.JMenuItem();
        JMIGenerarVenta1 = new javax.swing.JMenuItem();
        JMReporte = new javax.swing.JMenu();
        JMReporteVentas = new javax.swing.JMenuItem();
        JMReporteProducto = new javax.swing.JMenuItem();
        JMReporteMejorVenta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/imageToMP.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel4.setText("BRINDAR UN BUEN SERVICIO AL CLIENTE ES LO PRIMORDIAL ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel8.setText("POR ESO ATIENDELO BIEN Y SERAS RECOMPENSADO.....");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BIENVENIDOS AL SISTEMA");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/p031_1_00.jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MITMARKET");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        lblNombre.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombrel Usuario");

        lblNombresUsuario.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        lblNombresUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombresUsuario.setText("APELLIDOS. Nombres");

        jLabel11.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":");

        lblTipoUsuario.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuario.setText("Tipo de Usuario");

        lblTipoUsuarioLogeado.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        lblTipoUsuarioLogeado.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuarioLogeado.setText("Tipo de Usuario");

        jLabel12.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":");

        lblTipoUsuario1.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        lblTipoUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuario1.setText("Nombre de Caja:");

        lblNombreCaja.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        lblNombreCaja.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCaja.setText("Nombre de Caja");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombresUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTipoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTipoUsuario1)
                        .addGap(15, 15, 15)
                        .addComponent(lblNombreCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoUsuario1)
                            .addComponent(lblNombreCaja))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(jLabel11)
                            .addComponent(lblNombresUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoUsuario)
                            .addComponent(jLabel12)
                            .addComponent(lblTipoUsuarioLogeado))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JMInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/inicio.png"))); // NOI18N
        JMInicio.setPreferredSize(new java.awt.Dimension(129, 67));

        JMISalir.setText("Salir");
        JMISalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMISalirActionPerformed(evt);
            }
        });
        JMInicio.add(JMISalir);

        jMenuBar1.add(JMInicio);

        JMMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/mantenimiento.png"))); // NOI18N
        JMMantenimiento.setPreferredSize(new java.awt.Dimension(287, 67));

        JMICategoria.setText("CATEGORIA");
        JMICategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMICategoriaActionPerformed(evt);
            }
        });
        JMMantenimiento.add(JMICategoria);

        JMIEmpleado.setText("EMPLEADO");
        JMIEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIEmpleadoActionPerformed(evt);
            }
        });
        JMMantenimiento.add(JMIEmpleado);

        JMIProducto.setText("PRODUCTO");
        JMIProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProductoActionPerformed(evt);
            }
        });
        JMMantenimiento.add(JMIProducto);

        JMIUsuario.setText("USUARIO");
        JMIUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIUsuarioActionPerformed(evt);
            }
        });
        JMMantenimiento.add(JMIUsuario);

        JMICaja.setText("CAJA");
        JMICaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMICajaActionPerformed(evt);
            }
        });
        JMMantenimiento.add(JMICaja);

        jMenuBar1.add(JMMantenimiento);

        JMVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/ventas.png"))); // NOI18N
        JMVenta.setPreferredSize(new java.awt.Dimension(144, 67));

        JMIGenerarVenta.setText("Generar Venta");
        JMIGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIGenerarVentaActionPerformed(evt);
            }
        });
        JMVenta.add(JMIGenerarVenta);

        JMIGenerarVenta1.setText("Productos en Espera");
        JMIGenerarVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIGenerarVenta1ActionPerformed(evt);
            }
        });
        JMVenta.add(JMIGenerarVenta1);

        jMenuBar1.add(JMVenta);

        JMReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/reportes.png"))); // NOI18N
        JMReporte.setPreferredSize(new java.awt.Dimension(183, 67));

        JMReporteVentas.setText("Reporte de Ventas");
        JMReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMReporteVentasActionPerformed(evt);
            }
        });
        JMReporte.add(JMReporteVentas);

        JMReporteProducto.setText("Reporte Producto Más Vendido");
        JMReporteProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMReporteProductoActionPerformed(evt);
            }
        });
        JMReporte.add(JMReporteProducto);

        JMReporteMejorVenta.setText("Reporte Mejores Ventas");
        JMReporteMejorVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMReporteMejorVentaActionPerformed(evt);
            }
        });
        JMReporte.add(JMReporteMejorVenta);

        jMenuBar1.add(JMReporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMICategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMICategoriaActionPerformed

        FormularioCategoria formularioCategoria= new FormularioCategoria();
        formularioCategoria.setVisible(true);
    }//GEN-LAST:event_JMICategoriaActionPerformed

    private void JMIEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIEmpleadoActionPerformed
        // TODO add your handling code here:
        FormularioEmpleado formularioEmpleado= new FormularioEmpleado();
        formularioEmpleado.setVisible(true);
    }//GEN-LAST:event_JMIEmpleadoActionPerformed

    private void JMIProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProductoActionPerformed
        // TODO add your handling code here:
        FormularioProducto formularioProducto= new FormularioProducto();
        formularioProducto.setVisible(true);
    }//GEN-LAST:event_JMIProductoActionPerformed

    private void JMIUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIUsuarioActionPerformed
        // TODO add your handling code here:
        FormularioUsuario formularioUsuario= new FormularioUsuario();
        formularioUsuario.setVisible(true);
    }//GEN-LAST:event_JMIUsuarioActionPerformed

    private void JMIGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIGenerarVentaActionPerformed
        // TODO add your handling code here:
        FormularioNuevaCompra formularioNuevaCompra= new FormularioNuevaCompra();
        formularioNuevaCompra.lbldatosEmp.setText(lblNombresUsuario.getText());
        formularioNuevaCompra.idEmpleado = idEmpleado;
        formularioNuevaCompra.setVisible(true);
    }//GEN-LAST:event_JMIGenerarVentaActionPerformed

    private void JMISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMISalirActionPerformed
        FormularioLogin formularioLogin = new FormularioLogin() {};
        formularioLogin.setVisible(true);
        NegocioCaja negocioCaja = new NegocioCaja();
        try {
            negocioCaja.actualizarEstadoCaja(idCaja,"Inactivo");
            productoClienteEspera.setEstadoCaja("Inactivo");
        } catch (SQLException ex) {
        }
        dispose();
    }//GEN-LAST:event_JMISalirActionPerformed

    private void JMReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMReporteVentasActionPerformed
        FormularioReporteVenta reporteVenta = new FormularioReporteVenta();
        reporteVenta.setVisible(true);
    }//GEN-LAST:event_JMReporteVentasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(!tipoUsuario.equals("Administrador")){
            lblTipoUsuarioLogeado.setText(tipoUsuario);
            JMMantenimiento.setVisible(false);
            JMReporte.setVisible(false);
        }
        else{
            lblTipoUsuarioLogeado.setText(tipoUsuario);
            JMMantenimiento.setVisible(true);
            JMReporte.setVisible(true);
        }
        lblNombreCaja.setText(nombreCaja);
        productoClienteEspera = new LecturaEsperaProductosClientes(this, idCaja);
        hiloProductoClienteEspera = new Thread(productoClienteEspera);
        productoClienteEspera.setLectorProductoEspera(hiloProductoClienteEspera);
        productoClienteEspera.setEstadoCaja(estadoCaja);
        hiloProductoClienteEspera.start();
    }//GEN-LAST:event_formWindowOpened

    private void JMICajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMICajaActionPerformed
        FormularioCaja formularioCaja= new FormularioCaja();
        formularioCaja.setVisible(true);
    }//GEN-LAST:event_JMICajaActionPerformed

    private void JMReporteProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMReporteProductoActionPerformed
        FormularioReporteProducto formularioReporteProducto = new FormularioReporteProducto();
        formularioReporteProducto.setVisible(true);
    }//GEN-LAST:event_JMReporteProductoActionPerformed

    private void JMReporteMejorVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMReporteMejorVentaActionPerformed
        FormularioReporteMejoresVentas formularioReporteMejoresVentas = new FormularioReporteMejoresVentas();
        formularioReporteMejoresVentas.setVisible(true);
    }//GEN-LAST:event_JMReporteMejorVentaActionPerformed

    private void JMIGenerarVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIGenerarVenta1ActionPerformed
        FormularioProductosEsperaCliente formularioProductosEsperaCliente = new FormularioProductosEsperaCliente();
        formularioProductosEsperaCliente.idCaja = idCaja;
        formularioProductosEsperaCliente.setVisible(true);
    }//GEN-LAST:event_JMIGenerarVenta1ActionPerformed
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioMenu() {}.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMICaja;
    private javax.swing.JMenuItem JMICategoria;
    private javax.swing.JMenuItem JMIEmpleado;
    private javax.swing.JMenuItem JMIGenerarVenta;
    private javax.swing.JMenuItem JMIGenerarVenta1;
    private javax.swing.JMenuItem JMIProducto;
    private javax.swing.JMenuItem JMISalir;
    private javax.swing.JMenuItem JMIUsuario;
    private javax.swing.JMenu JMInicio;
    private javax.swing.JMenu JMMantenimiento;
    private javax.swing.JMenu JMReporte;
    private javax.swing.JMenuItem JMReporteMejorVenta;
    private javax.swing.JMenuItem JMReporteProducto;
    private javax.swing.JMenuItem JMReporteVentas;
    private javax.swing.JMenu JMVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblNombreCaja;
    public static javax.swing.JLabel lblNombresUsuario;
    public static javax.swing.JLabel lblTipoUsuario;
    public static javax.swing.JLabel lblTipoUsuario1;
    public static javax.swing.JLabel lblTipoUsuarioLogeado;
    // End of variables declaration//GEN-END:variables

}
