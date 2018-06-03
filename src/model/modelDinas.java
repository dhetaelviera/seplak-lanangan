/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sahriatus
 */
public class modelDinas extends modelUser{
 private String nama;
    private int tingkatan;
    private int idUser;

    public modelDinas() {
        super();
    }

    public void setUname(String un) {
        this.username = un;
    }

    public void setPass(String pwd) {
        this.password = pwd;
    }

    public String getUname() {
        return this.username;
    }

    public String getPwd() {
        return this.password;
    }
    @Override
    public boolean cekLogin(String username, String password) throws SQLException {
     String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
        Statement st = koneksi.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs.last();
    }

    @Override
    public boolean cekLevel(String username, String password) throws SQLException {
     String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
        Statement st = koneksi.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        return rs.getString("level") =="admin" ;
    }
    
}
