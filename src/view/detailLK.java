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
import model.modelLK;

/**
 *
 * @author Akses
 */
public class detailLK extends javax.swing.JFrame {

    /**
     * Creates new form detailLK
     */
    Connection koneksi;
    modelLK mLK;
    String[][] jadwalsurvey;

    public detailLK() throws SQLException {
        mLK = new modelLK();
        jadwal = new JComboBox();
        jadwalsurvey = mLK.jadwal();
        initComponents();
    }

    public String getJadwal() {
        int indeks = jadwal.getSelectedIndex();
        return jadwalsurvey[0][indeks];
    }

    public void setID(String id) {
        this.id.setText(id);
    }

    public void setStatus(String status) {
        this.status.setText(status);
    }

    public void setNoTanah(String noTanah) {
        this.notanah.setText(noTanah);
    }

    public JButton masukinJadwal() {
        return masukinjadwal;
    }

    public String getID() {
        return id.getText();
    }

    public void setAlamat(String alamat) {
        this.alamat.setText(alamat);
    }

    public void setLuas(String luas) {
        this.luas.setText(luas);
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan.setText(kecamatan);
    }

    public void setDesa(String desa) {
        this.desa.setText(desa);
    }

    public void setNama(String nama) {
        this.nama.setText(nama);
    }

    public void setNoTelp(String noTelp) {
        this.noTelp.setText(noTelp);
    }

    public void setAlamatPemilik(String alamatP) {
        this.alamatPemilik.setText(alamatP);
    }

    public void tambahKeJadwalListener(ActionListener a) {
        masukinjadwal.addActionListener(a);
    }

    public void kembaliListener(ActionListener a) {
        kembali.addActionListener(a);
    }
    public void keluarListener(ActionListener a) {
        keluar.addActionListener(a);
    }
    public void jadwalListener(ActionListener a) {
        jadwalbutton.addActionListener(a);
    }
    public void sewaListener(ActionListener a) {
        sewa.addActionListener(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        sewa = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        masukinjadwal = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        notanah = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        kecamatan = new javax.swing.JLabel();
        desa = new javax.swing.JLabel();
        luas = new javax.swing.JLabel();
        jadwalbutton = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        keluar = new javax.swing.JButton();
        jadwal = new javax.swing.JComboBox<>(jadwalsurvey[1]);
        nama = new javax.swing.JLabel();
        noTelp = new javax.swing.JLabel();
        alamatPemilik = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sewa.setText(" ");
        sewa.setBorderPainted(false);
        sewa.setContentAreaFilled(false);
        getContentPane().add(sewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 100, 30));

        kembali.setText(" ");
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 100, 30));

        masukinjadwal.setText(" ");
        masukinjadwal.setBorderPainted(false);
        masukinjadwal.setContentAreaFilled(false);
        masukinjadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukinjadwalActionPerformed(evt);
            }
        });
        getContentPane().add(masukinjadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 180, 30));

        id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 30, 27));

        notanah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(notanah, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 170, 22));

        alamat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 190, 26));

        kecamatan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(kecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 180, 26));

        desa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(desa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 170, 26));

        luas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(luas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 170, 26));

        jadwalbutton.setText(" ");
        jadwalbutton.setBorderPainted(false);
        jadwalbutton.setContentAreaFilled(false);
        getContentPane().add(jadwalbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 100, 30));

        status.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 170, 26));

        keluar.setText(" ");
        keluar.setBorderPainted(false);
        keluar.setContentAreaFilled(false);
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 70, 30));

        jadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jadwalActionPerformed(evt);
            }
        });
        getContentPane().add(jadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 136, 30));

        nama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 170, 27));

        noTelp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 160, 28));

        alamatPemilik.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(alamatPemilik, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 170, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/begron/admin/1.1.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void masukinjadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukinjadwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masukinjadwalActionPerformed

    private void jadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jadwalActionPerformed

    }//GEN-LAST:event_jadwalActionPerformed

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
            java.util.logging.Logger.getLogger(detailLK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detailLK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detailLK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detailLK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new detailLK().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(detailLK.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel alamatPemilik;
    private javax.swing.JLabel desa;
    private javax.swing.JLabel id;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JComboBox<String> jadwal;
    private javax.swing.JButton jadwalbutton;
    private javax.swing.JLabel kecamatan;
    private javax.swing.JButton keluar;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel luas;
    private javax.swing.JButton masukinjadwal;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel noTelp;
    private javax.swing.JLabel notanah;
    private javax.swing.JButton sewa;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
