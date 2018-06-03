/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akses
 */
public abstract class modelUser {

    private int idUser;
    protected String username = null;
    protected String password = null;
    Connection koneksi;
    private DefaultTableModel tableModel;

    public modelUser() {
        koneksi = new koneksi().getKoneksi();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int n) {
        idUser = n;
    }
    public abstract boolean cekLogin(String username, String password) throws SQLException;

    public abstract boolean cekLevel(String username, String password) throws SQLException;

    public String login(String username, String password) {
        String query = "SELECT level FROM user WHERE username=? AND password=?;";
        String tingkatan = "kosong";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                tingkatan = rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return tingkatan;
    }
    public String getId(String username ) {
        String query = "SELECT idUser FROM user WHERE username='"+username+"' ;";
        String id = "kosong";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
//            st.setString(1, username);
//            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
                System.out.println(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return id;
    }


    public boolean tambahPemilik(String nama, String noKTP, String tempatLahir, String tanggalLahir, String jenisKelamin, String noTelepon, String alamat, String username,
            String password) {

        String query = "INSERT INTO `user` (`nama`, `noKTP`, `tempatLahir`, `tanggalLahir`, `jenisKelamin`,`noTelepon`, `alamat`,`username`,`password`)VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, nama);
            st.setString(2, noKTP);
            st.setString(3, tempatLahir);
            st.setString(4, tanggalLahir);
            st.setString(5, jenisKelamin);
            st.setString(6, noTelepon);
            st.setString(7, alamat);
            st.setString(8, username);
            st.setString(9, password);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;
    }

    public String[][] jenisKelamin() throws SQLException {
        String query = "SELECT jenisKelamin, jenis FROM jeniskelamin";
        String jk[][] = null;
        try {

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.last();
            jk = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                jk[0][i] = rs.getString("idJK");
                jk[1][i] = rs.getString("jenisKelamin");

                i++;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return jk;
    }

    public String[][] desa() throws SQLException {
        String query = "SELECT desa FROM desa";
        String desa[][] = null;
        try {

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.last();
            desa = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                desa[0][0] = rs.getString("idDesa");
                desa[0][i] = rs.getString("desa");

                i++;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return desa;
    }

    public String[][] kecamatan() throws SQLException {
        String query = "SELECT kecamatan jenis FROM kecamatan";
        String kec[][] = null;
        try {

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.last();
            kec = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                kec[0][0] = rs.getString("idKecamatan");
                kec[0][i] = rs.getString("kecamatan");

                i++;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return kec;
    }
}
