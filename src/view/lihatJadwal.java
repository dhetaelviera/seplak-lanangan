/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.modelLK;

/**
 *
 * @author sahriatus
 */
public class lihatJadwal extends javax.swing.JFrame {

    /**
     * Creates new form lihatJadwal
     */
    Connection koneksi;
    modelLK mLK;
    DateFormat date = DateFormat.getDateInstance();

    public lihatJadwal() {
        mLK = new modelLK();
        date = new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
    }

    public String getJadwal() {
        String tgl = date.format(tanggal.getDate());
        return tgl;
    }

    public void setTabel(DefaultTableModel t) {
        tabel.setModel(t);
    }

    public JButton getLihat() {
        return lihat;
    }

    public JButton getHapus() {
        return hapus;
    }

    public int getSelectedRow() {
        int baris = tabel.getSelectedRow();
        return baris;
    }

    public void lihatListener(ActionListener listener) {
        lihat.addActionListener(listener);
    }

    public void hapusListener(ActionListener listener) {
        hapus.addActionListener(listener);
    }

    public void tambahListener(ActionListener listener) {
        tambah.addActionListener(listener);
    }

    public void kembaliListener(ActionListener listener) {
        kembali.addActionListener(listener);
    }

    public void daftarListener(ActionListener listener) {
        daftarLK.addActionListener(listener);
    }

    public void sewaListener(ActionListener listener) {
        sewa.addActionListener(listener);
    }
    public void keluarListener(ActionListener listener) {
        keluar.addActionListener(listener);
    }

    public void tabelListener(MouseListener m) {
        tabel.addMouseListener(m);
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

        sewa = new javax.swing.JButton();
        daftarLK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        keluar = new javax.swing.JButton();
        lihat = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        tanggal = new com.toedter.calendar.JDateChooser();
        hapus = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sewa.setText(" ");
        sewa.setBorderPainted(false);
        sewa.setContentAreaFilled(false);
        getContentPane().add(sewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 100, 30));

        daftarLK.setText(" ");
        daftarLK.setBorderPainted(false);
        daftarLK.setContentAreaFilled(false);
        getContentPane().add(daftarLK, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 150, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 450, 275));

        keluar.setText(" ");
        keluar.setBorderPainted(false);
        keluar.setContentAreaFilled(false);
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 50, -1));

        lihat.setBorderPainted(false);
        lihat.setContentAreaFilled(false);
        getContentPane().add(lihat, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 160, 110, 20));

        tambah.setText(" ");
        tambah.setBorderPainted(false);
        tambah.setContentAreaFilled(false);
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 343, 160, 30));
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 150, 20));

        hapus.setText(" ");
        hapus.setBorderPainted(false);
        hapus.setContentAreaFilled(false);
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 101, -1));

        kembali.setText(" ");
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/begron/admin/2.0.jpg"))); // NOI18N
        jLabel1.setText("Jadwal survey");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 440));

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
            java.util.logging.Logger.getLogger(lihatJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihatJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihatJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihatJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihatJadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton daftarLK;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keluar;
    private javax.swing.JButton kembali;
    private javax.swing.JButton lihat;
    private javax.swing.JButton sewa;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private com.toedter.calendar.JDateChooser tanggal;
    // End of variables declaration//GEN-END:variables
}