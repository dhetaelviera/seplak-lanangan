/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.modelDinas;
import model.modelPemilik;
import model.modelUser;
import view.awal;
import view.dashboardAdmin;
import view.dashboardPemilik;
import view.listLahanKosong;
import view.login;
import view.signUp;

/**
 *
 * @author Akses
 */
public class controllerUser {

    protected modelUser muser;
    protected modelDinas mdinas;
    protected modelPemilik mpemilik;
    private signUp viewDaftar;
    private awal viewAwal;
    private login viewMasuk;
    private dashboardAdmin viewAdmin;
    private listLahanKosong viewListLK;
    String tanggalLahir;

    //tampilan awal
    public controllerUser() {
        muser = new modelUser() {
            @Override
            public boolean cekLogin(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean cekLevel(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        viewAwal = new awal();
        viewAwal.setVisible(true);
        viewAwal.daftarListener(new daftarListener());
        viewAwal.masukListener(new masukListener());

    }

    public controllerUser(int a) {
        muser = new modelUser() {
            @Override
            public boolean cekLogin(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean cekLevel(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        viewMasuk = new login();
        viewMasuk.setVisible(true);
        viewMasuk.masuk2Listener(new masuk2Listener());
    }

    //tampilan daftar
    public controllerUser(String a) {
        muser = new modelUser() {
            @Override
            public boolean cekLogin(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean cekLevel(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        viewDaftar = new signUp();
        viewDaftar.setVisible(true);
        viewDaftar.daftarPemilikListener(new daftarPemilikListener());
    }

    //buat masuk/log in
    public controllerUser(String a, String b) {
        muser = new modelUser() {
            @Override
            public boolean cekLogin(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean cekLevel(String username, String password) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        viewMasuk = new login();
        viewMasuk.setVisible(true);
    }
    
    
    private class masukListener implements ActionListener {

        public masukListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewAwal.dispose();
            new controllerUser(8);
        }
    }
    class masuk2Listener implements ActionListener {

        public masuk2Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = viewMasuk.getUsername();
            String password = viewMasuk.getPassword();
            String tingkatan = muser.login(username, password);
            System.out.println(username);
            System.out.println(password);

            if (tingkatan.equalsIgnoreCase("pemilik")) {
                dashboardPemilik v = new dashboardPemilik();
                 new controller.controllerPemilik(1,1,muser.getId(viewMasuk.getUsername()));
                 viewMasuk.setVisible(false);
                System.out.println("login di id=" + muser.getIdUser());
            } else if (tingkatan.equalsIgnoreCase("admin")) {
                try {
                    new controller.controllerDinas(1,1);
                } catch (SQLException ex) {
                    Logger.getLogger(controllerUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                viewMasuk.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(viewMasuk, "Username atau Password Salah");
            }

        }
    }

    private class daftarListener implements ActionListener {

        public daftarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewAwal.dispose();
            new controllerUser("");
        }
    }

    //fungsi buat daftar jadi member sebagai pemilik
    private class daftarPemilikListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = viewDaftar.getNama();
            String noKTP = viewDaftar.getNoKTP();
            String tempatLahir = viewDaftar.getTanggalLahir();
            String alamat = viewDaftar.getAlamat();
            String jenisKelamin = String.valueOf(viewDaftar.getNamaJK() + 1);
            tanggalLahir = viewDaftar.getTanggalLahir();
            String noTelp = viewDaftar.getNoTelp();
            String username = viewDaftar.getUsername();
            String password = viewDaftar.getPassword();
            String noKTP1 = noKTP.replaceAll("[^a-zA-Z]", "");
            String noTelp1 = noTelp.replaceAll("[^a-zA-Z]", "");
            String splitKTP[] = noKTP1.split("");
            String splitNoTelp[] = noTelp1.split("");
            System.out.println(noKTP.length());
            System.out.println(noTelp.length());
            int counterKTP = noKTP.length();
            int counterTelp = noTelp.length();

            if (nama.equalsIgnoreCase("") || noKTP.equalsIgnoreCase("") || tempatLahir.equalsIgnoreCase("") || alamat.equalsIgnoreCase("")
                    || jenisKelamin.equalsIgnoreCase("") || noTelp.equalsIgnoreCase("") || username.equalsIgnoreCase("") || password.equalsIgnoreCase("")
                    || tanggalLahir.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(viewDaftar, "Kolom tidak boleh kosong");
            } else if (counterKTP < 16) {
                JOptionPane.showMessageDialog(viewDaftar, "Nomor KTP tidak boleh kurang dari 16 karakter");
            } else if (counterKTP > 16) {
                JOptionPane.showMessageDialog(viewDaftar, "Nomor KTP tidak boleh lebih dari 16 karakter");
            } else if (counterTelp < 11) {
                JOptionPane.showMessageDialog(viewDaftar, "Nomor HP tidak boleh kurang dari 11 karakter");
            } else if (counterTelp > 13) {
                JOptionPane.showMessageDialog(viewDaftar, "Nomor HP tidak boleh lebih dari 13 karakter");
            } else {
                boolean status = muser.tambahPemilik(nama, noKTP, tempatLahir, tanggalLahir, jenisKelamin, noTelp, alamat, username, password);
                if (status) {
                    JOptionPane.showMessageDialog(viewDaftar, "Data berhasil dimasukkan");
                    muser.setIdUser(muser.getIdUser());
                    dashboardPemilik v = new dashboardPemilik();
                    new controller.controllerPemilik(1,1,muser.getId(viewDaftar.getUsername()));
                    viewDaftar.dispose();
                    System.out.println("login di id=" + muser.getIdUser());
                } else {
                    JOptionPane.showMessageDialog(viewDaftar, "Nomor KTP sudah ada");
                }


            }
        }
    }
}
