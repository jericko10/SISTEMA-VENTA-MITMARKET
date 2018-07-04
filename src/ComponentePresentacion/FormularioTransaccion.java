package ComponentePresentacion;

import ComponenteClase.*;
import ComponenteNegocio.NegocioCompra;
import ComponenteNegocio.NegocioProducto;
import ComponenteNegocio.NegocioTransaccion;
import ComponenteOtros.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FormularioTransaccion extends javax.swing.JFrame {
    public DefaultTableModel tablaTransaccion = new DefaultTableModel();
    Imagen imagen = new Imagen() {};
    private Double importe = 0.0;
    private Double montoSubTotal = 0.0;
    private NegocioTransaccion transaccionNegocio = new NegocioTransaccion();
    private NegocioCompra compraNegocio = new NegocioCompra();
    private boolean comprobadorCompraRealizada = false;
    static String tipoCambio =  "";
    static String dniCliente = "";
    private volatile Thread hiloCodigoBarra;
    private LecturaEsperaProductosClientes codigoBarra;
    private ArrayList<String> codigoBarraCliente;
    static int nroCompra = 0;
    static int idEspera = 0;
    public FormularioNuevaCompra formularioNuevaCompra;

    /*
    *
    *Clase donde se realiza la compra
    *
    */
    public FormularioTransaccion(FormularioNuevaCompra formularioNuevaCompra) throws SQLException{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        this.formularioNuevaCompra = formularioNuevaCompra;
        final String camposTituloTabla[] = {"ID","CODIGO BARRA","CANTIDAD", "PRODUCTO", "PRECIO UND.", "TOTAL"};
        tablaTransaccion.setColumnIdentifiers(camposTituloTabla);       
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
 
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarFormulario();
            }
        });
        jtTransacProd.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                final int fila = jtTransacProd.rowAtPoint(e.getPoint());
                final int columna = jtTransacProd.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    FormularioBuscarProducto formularioBuscarProducto = null;
                    formularioBuscarProducto = new FormularioBuscarProducto(FormularioTransaccion.this,tipoCambio,true);
                    formularioBuscarProducto.idListaProducto = Integer.parseInt(String.valueOf(jtTransacProd.getValueAt(fila,0)));
                    formularioBuscarProducto.codigoBarraProducto = String.valueOf(jtTransacProd.getValueAt(fila,1));
                    formularioBuscarProducto.cantidadProducto = Integer.parseInt(String.valueOf(jtTransacProd.getValueAt(fila,2)));
                    formularioBuscarProducto.dniCliente = dniCliente;
                    formularioBuscarProducto.idEspera = idEspera;;
                    formularioBuscarProducto.setVisible(true);
                }
            }
        });
    }

    /**
    * Metodo que valida si se ha completado la compra, 
    * de no haberse realizado, lanza un mensaje de alerta  
    */ 
    private void cerrarFormulario(){
        if(!comprobadorCompraRealizada){
            int respuesta = JOptionPane.showConfirmDialog(rootPane, "¡Aún no ha realizado la compra! ¿Estás seguro de cancelar la operación?");
            if(respuesta==0){
                comprobadorCompraRealizada=true;
                this.dispose();
            }
            else{
                comprobadorCompraRealizada = false;
            }
        }
        else{
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTransacProd = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSubTotalT = new javax.swing.JFormattedTextField();
        txtIGVT = new javax.swing.JFormattedTextField();
        txtTotalApagar = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtImporteT = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        txtVuelto = new javax.swing.JFormattedTextField();
        lblNombreTipoComp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNroCompT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtDNICliente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnListarProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTipoCambio = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnBuscarProducto = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnImporte = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnCalcular = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnimprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jPanel4.setBackground(new java.awt.Color(247, 254, 255));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtTransacProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtTransacProd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtTransacProd.setModel(tablaTransaccion);
        jScrollPane2.setViewportView(jtTransacProd);

        jPanel7.setBackground(new java.awt.Color(247, 254, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("SUB. TOT:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("I.G.V:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("TOT. A PAGAR:");

        txtSubTotalT.setEditable(false);

        txtIGVT.setEditable(false);
        txtIGVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIGVTActionPerformed(evt);
            }
        });

        txtTotalApagar.setEditable(false);
        txtTotalApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalApagarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("IMPORTE:");

        txtImporteT.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("VUELTO:");

        txtVuelto.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIGVT)
                            .addComponent(txtSubTotalT, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTotalApagar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtImporteT, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtVuelto)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTotalT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIGVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTotalApagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImporteT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(16, 16, 16))
        );

        lblNombreTipoComp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNombreTipoComp.setText("BOLETA DE VENTA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nro :");

        txtNroCompT.setEditable(false);
        txtNroCompT.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtNroCompT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("FECHA:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        txtDNICliente.setEditable(false);

        jLabel17.setText("DNI:");

        btnListarProducto.setText("Listar Productos");
        btnListarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProductoActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Cambio:");

        lblTipoCambio.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnListarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNroCompT, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoCambio)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNombreTipoComp)
                                .addGap(129, 129, 129))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroCompT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnListarProducto))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(7, 7, 7)
                .addComponent(jSeparator1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreTipoComp)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel1)
                    .addComponent(lblTipoCambio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToolBar1.setBackground(new java.awt.Color(247, 254, 255));
        jToolBar1.setRollover(true);

        btnBuscarProducto.setBackground(new java.awt.Color(247, 254, 255));
        btnBuscarProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarProducto.setText("Buscar Producto");
        btnBuscarProducto.setEnabled(false);
        btnBuscarProducto.setFocusable(false);
        btnBuscarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscarProducto);
        jToolBar1.add(jSeparator3);

        btnEliminar.setBackground(new java.awt.Color(247, 254, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar Producto al Carrito");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);
        jToolBar1.add(jSeparator4);

        btnImporte.setBackground(new java.awt.Color(247, 254, 255));
        btnImporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnImporte.setText("Importe");
        btnImporte.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImporteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImporte);
        jToolBar1.add(jSeparator5);

        btnCalcular.setBackground(new java.awt.Color(247, 254, 255));
        btnCalcular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCalcular.setText("Realizar Compra");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCalcular);
        jToolBar1.add(jSeparator6);

        btnimprimir.setBackground(new java.awt.Color(247, 254, 255));
        btnimprimir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.setEnabled(false);
        btnimprimir.setFocusable(false);
        btnimprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnimprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnimprimir);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
    * Método que genera el subtotal y total de compra solo si se 
    * ha completado el proceso de compra
    */ 
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        montoSubTotal = 0.0;
        ArrayList<Transaccion> listaTransaccion = new ArrayList();
        if(jtTransacProd.getRowCount()<=0 || importe == 0){
            JOptionPane.showMessageDialog(this, "¡Debe completar el proceso de compra, o falta ingresar el importe!");
            return;
        }
        for (int i = 0; i < jtTransacProd.getRowCount(); i++) {
            Producto producto =  new Producto(0,"","",null,0,"",String.valueOf(jtTransacProd.getModel().getValueAt(i, 1)),Integer.parseInt(String.valueOf(jtTransacProd.getModel().getValueAt(i, 2)))){};
            Compra compra = new Compra(Integer.parseInt(txtNroCompT.getText()),"",null,"","",0.0,"") {};
            listaTransaccion.add(new Transaccion(producto,compra,Integer.parseInt(String.valueOf(jtTransacProd.getModel().getValueAt(i, 2)))));
            double total = Double.parseDouble(String.valueOf(jtTransacProd.getModel().getValueAt(i, 5)));
            montoSubTotal += total;
        }
        
        final Double totalPagar = compraNegocio.calcularCompra(montoSubTotal);
        
        if(totalPagar>importe)
        {
            JOptionPane.showMessageDialog(this,"El importe es menor al monto total. El monto total es '" + totalPagar + "' (incluído IGV), y falta '" + (Math.round((totalPagar-importe)*100d)/100d) + "' del importe para completar el total de pago.");
        }
        else
        {
            txtSubTotalT.setText(String.valueOf(montoSubTotal));
            txtIGVT.setText(String.valueOf(Math.round((montoSubTotal * 0.18)*100d)/100d));
            txtTotalApagar.setText(String.valueOf(Math.round((totalPagar)*100d)/100d));
            final double vueltoTotalPago = Math.round((importe- totalPagar)*100d)/100d;
            txtVuelto.setText(String.valueOf(vueltoTotalPago));
            try{
                compraNegocio.insertarMontoTotal(Integer.parseInt(txtNroCompT.getText().trim()),Double.parseDouble(txtTotalApagar.getText().trim()));
                for(Transaccion transaccion : listaTransaccion){
                    transaccionNegocio.insertarTransaccion(transaccion);
                }
                compraNegocio.eliminarEsperaProductoCliente(idEspera);
                JOptionPane.showMessageDialog(null, "¡Compra realizada con éxito!");
                btnBuscarProducto.setEnabled(false);
                btnCalcular.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnImporte.setEnabled(false);
                jtTransacProd.setEnabled(false);
                btnListarProducto.setEnabled(false);
                btnimprimir.setEnabled(true);
                comprobadorCompraRealizada = true;
                this.formularioNuevaCompra.verificarCompraRealizada = comprobadorCompraRealizada;
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, "Error BD: " + error.getMessage());
                JOptionPane.showMessageDialog(null, "¡Hubo un problema al insertar la compra!");
                comprobadorCompraRealizada = false;
                return;
            }
        }
}//GEN-LAST:event_btnCalcularActionPerformed

    
    private void btnImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImporteActionPerformed
        importe = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Importe"));
        txtImporteT.setText(String.valueOf(importe));
    }//GEN-LAST:event_btnImporteActionPerformed
    
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = jtTransacProd.getSelectedRow();
        if(filaSeleccionada>=0){
            int idProductoCliente = Integer.parseInt(String.valueOf(tablaTransaccion.getValueAt(filaSeleccionada, 0)));
            int cantidadProducto = Integer.parseInt(String.valueOf(tablaTransaccion.getValueAt(filaSeleccionada, 2)));
            String codigoBarraProducto = String.valueOf(tablaTransaccion.getValueAt(filaSeleccionada, 1));
            try {
                compraNegocio.eliminarFilaEsperaProductoCliente(idProductoCliente,cantidadProducto,codigoBarraProducto);
            } catch (SQLException ex) {
            }
            tablaTransaccion.removeRow(filaSeleccionada);
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione un producto del carrito!");
        }
}//GEN-LAST:event_btnEliminarActionPerformed

    private void txtIGVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIGVTActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtIGVTActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        // TODO add your handling code here:
        FormularioBuscarProducto frmBP = new FormularioBuscarProducto(this,tipoCambio,false) {
        };
        frmBP.dniCliente = dniCliente;
        frmBP.idEspera = idEspera;
        frmBP.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtTotalApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalApagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalApagarActionPerformed

    private void btnListarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProductoActionPerformed
        for (int i = 0;jtTransacProd.getRowCount()>i; i++) {
            tablaTransaccion.removeRow(i);
        }
        ArrayList<ProductoCliente> listaProductoCliente = new ArrayList<ProductoCliente>();
        try {
            listaProductoCliente = compraNegocio.listarProductoCliente(dniCliente);
        } catch (SQLException ex) {
        }
        for(ProductoCliente productoCliente : listaProductoCliente){
            idEspera = productoCliente.getIdGeneral();
            NegocioProducto productoNegocio = new NegocioProducto();
            Producto producto = new Producto(0,"","",null,0,"","",0){};
            try {
                producto = productoNegocio.buscarProductoCodigoBarra(productoCliente.getCodigoBarraProducto());
            } catch (SQLException ex) {

            }
            if(producto.getIdProducto() != 0){
                double precioUnidadProductoDivisa = 0.0;
                if(tipoCambio.equals("DOLAR")){
                    precioUnidadProductoDivisa = producto.getPrecioUnidad()*0.31;
                }
                else if(tipoCambio.equals("EURO")){
                    precioUnidadProductoDivisa = producto.getPrecioUnidad()*0.25;
                }
                else{
                    precioUnidadProductoDivisa = producto.getPrecioUnidad();
                }
                final String datosProducto[] = {String.valueOf(productoCliente.getIdProductoCliente()), producto.getCodigoBarra(), String.valueOf(productoCliente.getCantidadProducto()), producto.getNombre() , String.valueOf(Math.round((precioUnidadProductoDivisa)*100d)/100d), String.valueOf(Math.round((precioUnidadProductoDivisa*productoCliente.getCantidadProducto())*100d)/100d)};
                tablaTransaccion.addRow(datosProducto);
            }
        }
        btnBuscarProducto.setEnabled(true);
    }//GEN-LAST:event_btnListarProductoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtDNICliente.setText(dniCliente);
        lblTipoCambio.setText(tipoCambio);
        txtNroCompT.setText(String.valueOf(nroCompra));
    }//GEN-LAST:event_formWindowOpened

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        FormularioBoletaVenta formularioBoletaVenta = null;
        try {
            formularioBoletaVenta = new FormularioBoletaVenta(Integer.parseInt(txtNroCompT.getText()));
        } catch (SQLException ex) {
        }
        formularioBoletaVenta.setVisible(true);
    }//GEN-LAST:event_btnimprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new FormularioTransaccion(null).setVisible(true);
                } catch (SQLException ex) {
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImporte;
    private javax.swing.JButton btnListarProducto;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JTable jtTransacProd;
    public javax.swing.JLabel lblNombreTipoComp;
    private javax.swing.JLabel lblTipoCambio;
    public javax.swing.JTextField txtDNICliente;
    public javax.swing.JFormattedTextField txtIGVT;
    private javax.swing.JFormattedTextField txtImporteT;
    private javax.swing.JTextField txtNroCompT;
    public javax.swing.JFormattedTextField txtSubTotalT;
    private javax.swing.JFormattedTextField txtTotalApagar;
    private javax.swing.JFormattedTextField txtVuelto;
    // End of variables declaration//GEN-END:variables
}
