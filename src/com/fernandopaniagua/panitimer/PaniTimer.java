/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandopaniagua.panitimer;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author fpaniagua
 */
public class PaniTimer extends javax.swing.JFrame {
    Timer t;
    private void changeConfig(){
        // TODO add your handling code here:
        int horas = jsHoras.getValue();
        String sHoras = String.valueOf(horas);
        int minutos = jsMinutos.getValue();
        String sMinutos = String.valueOf(minutos);
        if (horas<10) {
            sHoras="0"+sHoras;
        }
        if (minutos<10) {
            sMinutos="0"+sMinutos;
        }
        jlTiempo.setText(sHoras + ":" + sMinutos);
    }

    /**
     * Creates new form PaniTimer
     */
    public PaniTimer() {
        initComponents();
        setResizable(false);
        setTitle("PaniTimer v1.0 by F.Paniagua (2018)");
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/images/icono.png"));
        setIconImage(image);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpSuperior = new javax.swing.JPanel();
        jsHoras = new javax.swing.JSlider();
        jsMinutos = new javax.swing.JSlider();
        jlTiempo = new javax.swing.JLabel();
        jbStart = new javax.swing.JButton();
        jbStop = new javax.swing.JButton();
        jpCentral = new javax.swing.JPanel();
        jlTimeToGoal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jsHoras.setMaximum(10);
        jsHoras.setMinorTickSpacing(1);
        jsHoras.setPaintTicks(true);
        jsHoras.setValue(0);
        jsHoras.setMaximumSize(new java.awt.Dimension(1000, 26));
        jsHoras.setPreferredSize(new java.awt.Dimension(100, 26));
        jsHoras.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsHorasStateChanged(evt);
            }
        });
        jpSuperior.add(jsHoras);

        jsMinutos.setMaximum(59);
        jsMinutos.setMinorTickSpacing(10);
        jsMinutos.setPaintTicks(true);
        jsMinutos.setValue(0);
        jsMinutos.setPreferredSize(new java.awt.Dimension(100, 26));
        jsMinutos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsMinutosStateChanged(evt);
            }
        });
        jpSuperior.add(jsMinutos);

        jlTiempo.setText("00:00");
        jpSuperior.add(jlTiempo);

        jbStart.setText("Start");
        jbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStartActionPerformed(evt);
            }
        });
        jpSuperior.add(jbStart);

        jbStop.setText("Stop");
        jbStop.setEnabled(false);
        jbStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStopActionPerformed(evt);
            }
        });
        jpSuperior.add(jbStop);

        getContentPane().add(jpSuperior, java.awt.BorderLayout.PAGE_START);

        jlTimeToGoal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlTimeToGoal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTimeToGoal.setText("HH:MM");

        javax.swing.GroupLayout jpCentralLayout = new javax.swing.GroupLayout(jpCentral);
        jpCentral.setLayout(jpCentralLayout);
        jpCentralLayout.setHorizontalGroup(
            jpCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCentralLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jlTimeToGoal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        jpCentralLayout.setVerticalGroup(
            jpCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCentralLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jlTimeToGoal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        getContentPane().add(jpCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jsHorasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsHorasStateChanged
        changeConfig();
    }//GEN-LAST:event_jsHorasStateChanged

    private void jsMinutosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsMinutosStateChanged
        changeConfig();
    }//GEN-LAST:event_jsMinutosStateChanged

    private void jbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStartActionPerformed
        jsHoras.setEnabled(false);
        jsMinutos.setEnabled(false);
        jbStart.setEnabled(false);
        jbStop.setEnabled(true);
        t = new Timer(jsHoras.getValue(),jsMinutos.getValue(),jlTimeToGoal);
        t.start();
    }//GEN-LAST:event_jbStartActionPerformed

    private void jbStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStopActionPerformed
        jsHoras.setEnabled(true);
        jsMinutos.setEnabled(true);
        jbStart.setEnabled(true);
        jbStop.setEnabled(false);
        changeConfig();
        t.stopTimer();
    }//GEN-LAST:event_jbStopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaniTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaniTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaniTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaniTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaniTimer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbStart;
    private javax.swing.JButton jbStop;
    private javax.swing.JLabel jlTiempo;
    private javax.swing.JLabel jlTimeToGoal;
    private javax.swing.JPanel jpCentral;
    private javax.swing.JPanel jpSuperior;
    private javax.swing.JSlider jsHoras;
    private javax.swing.JSlider jsMinutos;
    // End of variables declaration//GEN-END:variables
}
