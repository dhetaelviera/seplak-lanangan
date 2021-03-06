/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.modelLK;
import model.modelUser;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author Akses
 */
public class listLahanKosong extends javax.swing.JFrame {

    /**
     * Creates new form listLahanKosong
     */
    Connection koneksi;
    modelLK mLK;
    String[][] jadwalsurvey;

    public listLahanKosong() throws SQLException {
        mLK = new modelLK();
        jadwalsurvey=mLK.jadwal();
        initComponents();
    }
    
     public JTable getTabel() {
        return tabel;
    }
    
    public int getSelectedRow() {
        int baris = tabel.getSelectedRow();
        return baris;
    }
    
    
    public void addTableListener(MouseListener listener) {
        tabel.addMouseListener(listener);
    }
    
    public JButton lihat(){
        return detail;
    }
 

    public void setTabelLK(DefaultTableModel t) {
        tabel.setModel(t);
    }

    public void kembaliListener(ActionListener a) {
        kembali.addActionListener(a);
    }
    public void keluarListener(ActionListener a) {
        keluar.addActionListener(a);
    }
     
    public void jadwalListener(ActionListener a) {
        jadwal.addActionListener(a);
    }
     
    public void sewaListener(ActionListener a) {
        sewa.addActionListener(a);
    }
     
    public void tabelListener(MouseListener m) {
        tabel.addMouseListener(m);
    }
    
      public void detailListener(ActionListener listener) {
        detail.addActionListener(listener);
    }

    //buat ambil data dari baris yg diklik
    public int getBarisTerpilih() {
        return tabel.getSelectedRow();
    }
    
    public JTable tabelll(){
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

        sewa = new javax.swing.JButton();
        jadwal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        kembali = new javax.swing.JButton();
        detail = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sewa.setText(" ");
        sewa.setBorderPainted(false);
        sewa.setContentAreaFilled(false);
        getContentPane().add(sewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 110, 30));

        jadwal.setText(" ");
        jadwal.setBorderPainted(false);
        jadwal.setContentAreaFilled(false);
        getContentPane().add(jadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 110, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 710, 240));

        kembali.setText(" ");
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 90, 30));

        detail.setText(" ");
        detail.setBorderPainted(false);
        detail.setContentAreaFilled(false);
        getContentPane().add(detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 120, 30));

        keluar.setText(" ");
        keluar.setBorderPainted(false);
        keluar.setContentAreaFilled(false);
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 70, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/begron/admin/1.0.jpg"))); // NOI18N
        jLabel3.setText("username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 450));

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
            java.util.logging.Logger.getLogger(listLahanKosong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listLahanKosong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listLahanKosong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listLahanKosong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new listLahanKosong().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(listLahanKosong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detail;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jadwal;
    private javax.swing.JButton keluar;
    private javax.swing.JButton kembali;
    private javax.swing.JButton sewa;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables


}
