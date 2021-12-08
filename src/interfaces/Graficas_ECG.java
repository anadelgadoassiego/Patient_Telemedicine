/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.jfree.chart.*;

import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author delga
 */
public class Graficas_ECG extends javax.swing.JFrame {

    public java.util.List<ArrayList<Integer>> datos_grafica = new ArrayList();
    public java.util.List<Integer> datos_EMG = new ArrayList();
    public java.util.List<Integer> indice = new ArrayList();
    /**
     * Creates new form Graficas
     */
    public Graficas_ECG() {
        initComponents();
        //java.util.List<Integer> datos_EMG = new ArrayList();
        datos_EMG = DoctorMenu.values_int_public;
       
        
        int length = datos_EMG.size();
        for(int i=1; i<=length; i++){
            indice.add(i);
        }
        
        //datos_grafica.add((ArrayList<Integer>) indice);
        //datos_grafica.add((ArrayList<Integer>) datos_EMG);

        this.setLocationRelativeTo(null);
        //this.lineas.setVisible(false);

        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        capas = new javax.swing.JLayeredPane();
        lineas = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lineas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout lineasLayout = new javax.swing.GroupLayout(lineas);
        lineas.setLayout(lineasLayout);
        lineasLayout.setHorizontalGroup(
            lineasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        lineasLayout.setVerticalGroup(
            lineasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );

        jButton1.setText("Graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Press to see your graph");

        capas.setLayer(lineas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout capasLayout = new javax.swing.GroupLayout(capas);
        capas.setLayout(capasLayout);
        capasLayout.setHorizontalGroup(
            capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capasLayout.createSequentialGroup()
                .addGroup(capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(capasLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton1)
                        .addGap(93, 93, 93)
                        .addComponent(lineas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(capasLayout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(jLabel1)))
                .addContainerGap(521, Short.MAX_VALUE))
        );
        capasLayout.setVerticalGroup(
            capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capasLayout.createSequentialGroup()
                .addGroup(capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(capasLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jButton1))
                    .addGroup(capasLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(lineas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jButton2.setText("Go Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(capas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(448, 448, 448))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(capas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ChartPanel panel;
        JFreeChart chart = null;

        //Grafico de lineas
        int validar = 1;
        XYSplineRenderer renderer = new XYSplineRenderer();
        XYSeriesCollection dataset = new XYSeriesCollection();

        ValueAxis x = new NumberAxis();
        ValueAxis y = new NumberAxis();

        XYSeries serie = new XYSeries("Datos");

        XYPlot plot;
        lineas.removeAll();

        try {
            for (int i = 1; i<datos_EMG.size(); i++) {
                serie.add(indice.get(i),datos_EMG.get(i));
            }
        } catch (Exception ex) {
            validar = 0;
        }

        if (validar == 1) {
            dataset.addSeries(serie);
            x.setLabel("Eje X");
            y.setLabel("Eje Y");
            plot = new XYPlot(dataset, x, y, renderer);
            chart = new JFreeChart(plot);
            chart.setTitle("Grafico de Lineas");
        } else {
            JOptionPane.showMessageDialog(this, "Debe llenar la tabla");
        }

        panel = new ChartPanel(chart);
        panel.setBounds(5, 19, 410, 400);

        lineas.add(panel);
        lineas.repaint();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane capas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel lineas;
    // End of variables declaration//GEN-END:variables
}
