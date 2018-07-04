package ComponentePresentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 * @author Richard
 * @version 1.0
 * 
 * @author Mamani Bedregal
 * @version 2.0
 */
public class FormularioPanelFondoLogin extends javax.swing.JPanel {

    public FormularioPanelFondoLogin() {
        initComponents();
        this.setSize(600, 450);
    }

    @Override
    public void paintComponent(Graphics graficoPanel)
    {
        final Dimension dimensionCanvas=getSize();
        final ImageIcon imagen=new ImageIcon(getClass().getResource("/ComponenteImagenes/Fondo-Visual.jpg"));
        graficoPanel.drawImage(imagen.getImage(), 0, 0, dimensionCanvas.width, dimensionCanvas.height, this);
        setOpaque(false);
        super.paintComponent(graficoPanel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
