/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.modelLK;

/**
 *
 * @author Dheta
 */
public class notif extends javax.swing.JFrame {

    /**
     * Creates new form notif
     */
    Connection koneksi;
    modelLK mLK;

    public notif() {

        mLK = new modelLK();
        initComponents();
    }

    public void backListener(ActionListener a) {
        kembali.addActionListener(a);
    }
    public void keluarListener(ActionListener a) {
        keluar.addActionListener(a);
    }
    public void sewaListener(ActionListener a) {
        sewa.addActionListener(a);
    }
    public void lahanListener(ActionListener a) {
        lahan.addActionListener(a);
    }

    public void setTabel(DefaultTableModel t) {
        tabel.setModel(t);
    }

    public JTable getTabel() {
        return tabel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lahan = new javax.swing.JButton();
        sewa = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lahan.setText(" ");
        lahan.setBorderPainted(false);
        lahan.setContentAreaFilled(false);
        getContentPane().add(lahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 73, 90, 30));

        sewa.setText(" ");
        sewa.setBorderPainted(false);
        sewa.setContentAreaFilled(false);
        getContentPane().add(sewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 73, 110, 30));

        keluar.setText(" ");
        keluar.setBorderPainted(false);
        keluar.setContentAreaFilled(false);
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 60, -1));

        kembali.setText(" ");
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 80, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 490, 275));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/begron/pemilik/2.0.jpg"))); // NOI18N
        jLabel9.setText(" ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(notif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(notif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(notif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(notif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new notif().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keluar;
    private javax.swing.JButton kembali;
    private javax.swing.JButton lahan;
    private javax.swing.JButton sewa;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}