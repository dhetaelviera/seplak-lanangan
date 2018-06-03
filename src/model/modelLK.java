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
 * @author sahriatus
 */
public class modelLK {

    Connection koneksi;
    private String noTanah;
    private String alamat;
    private String luas;
    private String kecamatan;
    private String desa;
    private String statusTanah;
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModel2;
    private String idLK;
    private String jadwalsurvey;
    private String jumlah;
    private String idt;
    private String jenislahan;
    private String jadwal;
    String iduser = null;

    public modelLK() {
        koneksi = new koneksi().getKoneksi();
        String header[] = {"idLK", "pemilik", "noTanah", "alamatLK", "kecamatanLK", "desaLK", "luas","statusTanah", "jadwalSurvey"};
        String header2[] = {"id", "jenis", "jumlah"};
        tableModel = new DefaultTableModel(null, header);
        tableModel2 = new DefaultTableModel(null, header2);
    }

    public String getID() {
        return idLK;
    }

    public String getNama(int idLK) {
        String query = "SELECT u.nama from lahankosong lk join user u on lk.pemilik=u.iduser WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("pemilik");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
    public String getDesa(int idLK) {
        String query = "SELECT d.desa from lahankosong lk join desa s on lk.desa=d.desa WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("desa");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
    public String getStatus(int idLK) {
        String query = "SELECT s.status from lahankosong lk join status s on lk.statustanah=s.status WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("desa");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
    
    public String getKecamatan(int idLK) {
        String query = "SELECT k.kecamatan from lahankosong lk join kecamatan k on lk.kecamatan=k.kecamatan WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("kecamatan");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }

    public String getIDTaret() {
        return idt;
    }

    public String getJenisLahan() {
        return jenislahan;
    }

    public String getJumlahLahan() {
        return jumlah;
    }

    public String getNoTanah() {
        return noTanah;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getLuas() {
        return luas;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public String getDesa() {
        return desa;
    }

    public String getIDJadwal() {
        return jadwal;
    }

    public DefaultTableModel getTableModel() throws SQLException {
        String sql = "select * from lahankosong";

        PreparedStatement st = koneksi.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String kolom[] = new String[10];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

            tableModel.addRow(kolom);

        }

        return tableModel;
    }

    public DefaultTableModel getTarget() throws SQLException {
        String sql = "select * from targetlahan";

        PreparedStatement st = koneksi.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String kolom[] = new String[3];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

            tableModel2.addRow(kolom);

        }

        return tableModel2;
    }

    public void setSelectedRow(int baris) {
        this.idLK = tableModel.getValueAt(baris, 0).toString();
        System.out.println(idLK);
        this.noTanah = tableModel.getValueAt(baris, 1).toString();
        this.kecamatan = tableModel.getValueAt(baris, 4).toString();
        this.desa = tableModel.getValueAt(baris, 5).toString();
        this.luas = tableModel.getValueAt(baris, 6).toString();
        this.alamat = tableModel.getValueAt(baris, 3).toString();

    }

    public void setSelectedRowTarget(int baris) {
        this.idt = tableModel2.getValueAt(baris, 0).toString();
        System.out.println(idt);
        this.jenislahan = tableModel2.getValueAt(baris, 1).toString();
        this.jumlah = tableModel2.getValueAt(baris, 2).toString();

    }
    
      public boolean tambahLK(String id, String notanah, String alamat, String kecamatan,String desa, String luas) {

        String query = "INSERT INTO `lahankosong` (`pemilik`,`notanah`,`alamatLK`,`kecamatanLK`,`desaLK`,"
                + "`luas`)VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, id);
            st.setString(2, notanah);
            st.setString(3, alamat);
            st.setString(4, kecamatan);
            st.setString(5, desa);
            st.setString(6, luas);
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

    public DefaultTableModel bacaTabelLahanKosong() {
        String namaKolom[] = {"ID", "pemilik", "no tanah", "Alamat", "Kecamatan", "Desa", "luas", "status"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        for (int i = tabel.getRowCount() - 1; i >= 0; i--) {
            tabel.removeRow(i);
        }
        String query = "SELECT lk.idlk, u.nama,lk.noTanah, lk.alamatLK, k.kecamatan, d.desa, lk.luas, s.status "
                + "from lahankosong lk join kecamatan k on lk.kecamatanLK=k.idKecamatan join desa d on d.idDesa=lk.desaLK "
                + "join statusTanah s on s.idStatus=lk.statusTanah join user u on lk.pemilik=u.idUser where lk.statustanah=1";
        try {
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String kolom[] = new String[8];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                //    kolom[0] = Integer.toString(n);
                tabel.addRow(kolom);
                //   n++;
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    
    public boolean hapus(String idLK) {
        String query = "delete from lahankosong WHERE idLK=?";
        System.out.println(query);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
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

    public DefaultTableModel bacaTabelLahanKosongUser(String id) {
        String namaKolom[] = {"no tanah", "Alamat", "Kecamatan", "Desa", "luas","status"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        for (int i = tabel.getRowCount() - 1; i >= 0; i--) {
            tabel.removeRow(i);
        }
        String query = "SELECT lk.noTanah, lk.alamatLK, k.kecamatan, d.desa, lk.luas, s.status "
                + "from lahankosong lk join kecamatan k on lk.kecamatanLK=k.idKecamatan join desa d on d.idDesa=lk.desaLK "
                + "join statusTanah s on s.idStatus=lk.statusTanah join user u on lk.pemilik=u.idUser WHERE lk.pemilik='"+id+"'";
        try {
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String kolom[] = new String[6];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                //    kolom[0] = Integer.toString(n);
                tabel.addRow(kolom);
                //   n++;
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    
     public DefaultTableModel bacaNotif(String id) {
        String namaKolom[] = {"no tanah", "Alamat", "Kecamatan", "Desa", "jadwal survey", "status"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        for (int i = tabel.getRowCount() - 1; i >= 0; i--) {
            tabel.removeRow(i);
        }
        String query = "SELECT lk.noTanah, lk.alamatLK, k.kecamatan, d.desa, j.jadwalsurvey, s.status "
                + "from lahankosong lk join kecamatan k on lk.kecamatanLK=k.idKecamatan join desa d on d.idDesa=lk.desaLK "
                + "join statusTanah s on s.idStatus=lk.statusTanah join user u on lk.pemilik=u.idUser join jadwalsurvey j on lk.jadwalsurvey=j.idJadwal WHERE (lk.statustanah=4 or "
                + "lk.statustanah=2) and lk.pemilik='"+id+"'";
        try {
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String kolom[] = new String[6];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                //    kolom[0] = Integer.toString(n);
                tabel.addRow(kolom);
                //   n++;
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
     
      public DefaultTableModel bacaLahanSewaUser(String id) {
        String namaKolom[] = {"no tanah", "Alamat", "Kecamatan", "Desa", "jadwal surve", "status"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        for (int i = tabel.getRowCount() - 1; i >= 0; i--) {
            tabel.removeRow(i);
        }
        String query = "SELECT lk.noTanah, lk.alamatLK, k.kecamatan, d.desa, j.jadwalsurvey, s.status "
                + "from lahankosong lk join kecamatan k on lk.kecamatanLK=k.idKecamatan join desa d on d.idDesa=lk.desaLK "
                + "join statusTanah s on s.idStatus=lk.statusTanah join user u on lk.pemilik=u.idUser join jadwalsurvey j on lk.jadwalsurvey=j.idJadwal "
                + "WHERE lk.statustanah=5 and lk.pemilik='"+id+"'";
        try {
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String kolom[] = new String[6];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                //    kolom[0] = Integer.toString(n);
                tabel.addRow(kolom);
                //   n++;
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
      
      public DefaultTableModel bacaLahanSewaDinas() {
        String namaKolom[] = {"no tanah", "Alamat", "Kecamatan", "Desa","status"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        for (int i = tabel.getRowCount() - 1; i >= 0; i--) {
            tabel.removeRow(i);
        }
        String query = "SELECT lk.noTanah, lk.alamatLK, k.kecamatan, d.desa, s.status "
                + "from lahankosong lk join kecamatan k on lk.kecamatanLK=k.idKecamatan join desa d on d.idDesa=lk.desaLK "
                + "join statusTanah s on s.idStatus=lk.statusTanah join user u on lk.pemilik=u.idUser join jadwalsurvey j on lk.jadwalsurvey=j.idJadwal "
                + "WHERE lk.statustanah=5";
        try {
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String kolom[] = new String[5];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                //    kolom[0] = Integer.toString(n);
                tabel.addRow(kolom);
                //   n++;
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelJadwal() {
        String query = "SELECT idJadwal, jadwalsurvey from jadwalsurvey ";
        String namaKolom[] = {"ID", "jadwal"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[2];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    
//    public DefaultTableModel bacaData(String jadwal) {
//        String query = "SELECT s.luaslahan from spk s join lahankosong lk on lk.idlk=s.lahankosong join jadwal j on j.idjadwal=lk.jadwalsurvey"
//                + "where id.jadwal=?";
//        String namaKolom[] = {"luas lahan","lk"};
//        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
//        try {
//            PreparedStatement st = koneksi.prepareStatement(query);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Object data[] = new Object[2];
//
//                data[0] = rs.getString(1);
//                data[1] = rs.getString(2);
//                tabel.addRow(data);
//            }
//
//        } catch (SQLException e) {
//            e.getMessage();
//            e.printStackTrace();
//        }
//        return tabel;
//    }
    
     public String noTanah(String idLK) {
        String query = "SELECT noTanah FROM lahankosong WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("notanah");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     
     public String tinggi(String idLK) {
        String query = "SELECT ketinggian FROM lahankosong WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("ketinggian");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     
     public String luaspengairan(String idLK) {
        String query = "SELECT luaspengairan FROM lahankosong WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("luaspengairan");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     
     public String suhu(String idLK) {
        String query = "SELECT suhu FROM lahankosong WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("suhu");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
    
     public String hujan(String idLK) {
        String query = "SELECT curahhujan FROM lahankosong WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("curahhujan");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     
     public String pemilik(String idLK) {
        String query = "SELECT u.nama FROM lahankosong lk join user u on u.iduser=lk.pemilik WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("nama");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
    
     public String noTelepon(String idLK) {
        String query = "SELECT u.noTelepon FROM user u join lahankosong lk  on u.iduser=lk.pemilik WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("noTelepon");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
    
     public String alamatLK(String idLK) {
        String query = "SELECT alamatLK FROM lahankosong WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("alamatLK");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     
     

     public String alamatPemilik(String idLK) {
        String query = "SELECT u.alamat FROM user u join lahankosong lk on lk.pemilik=u.iduser WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("alamat");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
    
     public String desa(String idLK) {
        String query = "SELECT d.desa FROM lahankosong lk join desa d on d.idDesa=lk.desaLK WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("desa");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     public String kecamatan(String idLK) {
        String query = "SELECT k.kecamatan FROM lahankosong lk join kecamatan k on k.idKecamatan=lk.kecamatanLK WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("kecamatan");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
    
     public String luasLK(String idLK) {
        String query = "SELECT luas FROM lahankosong WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("luas");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     
     public String hasil(String idLK) {
        String query = "SELECT hasil FROM lahankosong WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("hasil");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     
     public String statusLK(String idLK) {
        String query = "SELECT s.status FROM lahankosong lk join statustanah s on s.idstatus=lk.statustanah WHERE idLK=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("status");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
     
     

    public DefaultTableModel bacaTarget() {
        String query = "SELECT id, lahan,jumlah from targetlahan ";
        String namaKolom[] = {"ID", "jenis lahan", "targetlahan"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[3];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaIsiJadwal(String jadwal) {
        String query = "SELECT lk.idlk, j.jadwalsurvey, lk.notanah from lahankosong lk join jadwalsurvey j on lk.jadwalsurvey=j.idjadwal WHERE lk.statustanah=2 and lk.jadwalsurvey='"+jadwal+"'";
        String namaKolom[] = {"id lahan", "tanggal", "notanah"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        for (int i = tabel.getRowCount() - 1; i >= 0; i--) {
            tabel.removeRow(i);
        }
        try {
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String kolom[] = new String[3];
                for (int i = 0; i < kolom.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                //    kolom[0] = Integer.toString(n);
                tabel.addRow(kolom);
                //   n++;
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public boolean tambahJadwal(String jadwal) {

        String query = "INSERT INTO `jadwalsurvey` (`jadwalsurvey`)VALUES(?)";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, jadwal);
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
    public boolean fuzzifikasi(String idLK, double ftinggirendah, double ftinggisedang, double ftinggitinggi, double fsuhupanas, double fsuhusedang,
            double fhujanringan, double fhujansedang, double fhujanlebat, double fhujansangatlebat, double fluassempit, double fluasnormal,
            double fluasluas) {

        String query = "INSERT INTO `fuzzifikasi` (`idLK`,`ftinggirendah`,`ftinggisedang`,`ftinggitinggi`,"
                + "`fsuhupanas`,`fsuhusedang`,`fhujanringan`,`fhujansedang`,`fhujanlebat`,`fhujansangatlebat`,"
                + "`fluassempit`,`fluasnormal`,`fluasluas`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            st.setDouble(2, ftinggirendah);
            st.setDouble(3, ftinggisedang);
            st.setDouble(4, ftinggitinggi);
            st.setDouble(5, fsuhupanas);
            st.setDouble(6, fsuhusedang);
            st.setDouble(7, fhujanringan);
            st.setDouble(8, fhujansedang);
            st.setDouble(9, fhujanlebat);
            st.setDouble(10, fhujansangatlebat);
            st.setDouble(11, fluassempit);
            st.setDouble(12, fluasnormal);
            st.setDouble(13, fluasluas);
            
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
    
        public boolean masukindata(String idLK, double ftinggirendah, double ftinggisedang, double ftinggitinggi, double fsuhupanas, double fsuhusedang,
            double fhujanringan, double fhujansedang, double fhujanlebat, double fhujansangatlebat, double fluassempit, double fluasnormal,
            double fluasluas) {

        String query = "INSERT INTO `fuzzifikasi` (`idLK`,`ftinggirendah`,`ftinggisedang`,`ftinggitinggi`,"
                + "`fsuhupanas`,`fsuhusedang`,`fhujanringan`,`fhujansedang`,`fhujanlebat`,`fhujansangatlebat`,"
                + "`fluassempit`,`fluasnormal`,`fluasluas`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
            st.setDouble(2, ftinggirendah);
            st.setDouble(3, ftinggisedang);
            st.setDouble(4, ftinggitinggi);
            st.setDouble(5, fsuhupanas);
            st.setDouble(6, fsuhusedang);
            st.setDouble(7, fhujanringan);
            st.setDouble(8, fhujansedang);
            st.setDouble(9, fhujanlebat);
            st.setDouble(10, fhujansangatlebat);
            st.setDouble(11, fluassempit);
            st.setDouble(12, fluasnormal);
            st.setDouble(13, fluasluas);
            
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
        
         
          public boolean masukinData(String idLK, double htinggi,double hluas,double hhujan, double hsuhu, String hasil) {
        String query = "UPDATE lahankosong SET ketinggian=?, luaspengairan=?,curahhujan=?,suhu=?, hasil=? WHERE idLK=?";
        System.out.println(query);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setDouble(1, htinggi);
            st.setDouble(2, hluas);
            st.setDouble(3, hhujan);
            st.setDouble(4, hsuhu);
            st.setString(5, hasil);
            st.setString(6, idLK);
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
          
          public boolean sewa(String idLK) {
        String query = "UPDATE lahankosong SET statustanah=5 WHERE idLK=?";
        System.out.println(query);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
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
          
          public boolean tolak(String idLK) {
        String query = "UPDATE lahankosong SET statustanah=4 WHERE idLK=?";
        System.out.println(query);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, idLK);
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
          
    public String hasilnya(String htinggi, String hluas, String hhujan, String hsuhu) {
        String query = "SELECT hasil FROM rule WHERE ketinggian=? and luas=? and curahhujan=? and suhu=?";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, htinggi);
            st.setString(2, hluas);
            st.setString(3, hhujan);
            st.setString(4, hsuhu);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("hasil");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }
 
    
    public boolean tambahParam(String lahankosong, String luaslahan, String debitcurahhujan, String sinarmatahari,
            String ketinggian) {

        String query = "INSERT INTO `spk` (`lahankosong`,`luaslahan`,`debitcurahhujan`,`sinarmatahari`,`ketinggian`)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, lahankosong);
            st.setString(2, luaslahan);
            st.setString(3, debitcurahhujan);
            st.setString(4, sinarmatahari);
            st.setString(5, ketinggian);
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

    public void setJadwal(String jadwal) {
        this.jadwalsurvey = jadwal;
    }

    public void setIDLK(String id) {
        this.idLK = id;
    }

    public String[][] getTanah(String id) {
        String query = "SELECT idLK, notanah from lahankosong WHERE idLK=?";
        String identitas[][] = null;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.last();
            identitas = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                identitas[0][i] = rs.getString("idlk");
                identitas[1][i] = rs.getString("notanah");
                i++;
            }

        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return identitas;
    }

    public boolean masukinJadwal(String jadwalsurvey, String idLK) {
        String query = "UPDATE lahankosong SET jadwalSurvey=?, statustanah=2 WHERE idLK=?";
        System.out.println(query);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, jadwalsurvey);
            st.setString(2, idLK);
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

    public boolean ubahTarget(String jumlah) {
        String query = "UPDATE targetlahan SET jumlah=? WHERE id=?";
        System.out.println(query);
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setString(1, jumlah);
            st.setString(2, idt);
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

    public boolean hapusJadwal(String jadwal) throws SQLException {
        String query = "DELETE from jadwalsurvey WHERE idJadwal=?";
        System.out.println(query);
        PreparedStatement st = koneksi.prepareStatement(query);
        st.setString(1, jadwal);
        st.executeUpdate();
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
                jk[0][0] = rs.getString("idJK");
                jk[0][i] = rs.getString("jenisKelamin");

                i++;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return jk;
    }
   
    
     public String[][] desa(int idKecamatan) {
        String query = "SELECT idDesa, desa, kc.kecamatan from desa ds join kecamatan kc on kc.idKecamatan = ds.kecamatan WHERE idKecamatan=?";
        String ds[][] = null;

        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.setInt(1, idKecamatan);
            ResultSet rs = st.executeQuery();
            rs.last();
            ds = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                ds[0][i] = rs.getString("idDesa");
                ds[1][i] = rs.getString("desa");

                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return ds;

    }
    
    public String[][] kecamatan(){
        String query = "SELECT idKecamatan, kecamatan FROM kecamatan";
        String jk[][] = null;
        try {

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.last();
            jk = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                jk[0][i] = rs.getString("idKecamatan");
                jk[1][i] = rs.getString("kecamatan");

                i++;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return jk;
    }
//    public String[][] desa(int idKecamatan){
//        String query = "SELECT d.idDesa, d.desa, k.kecamatan  FROM d.desa join k.kecamatan where k.idKecamatan=?";
//        String ds[][] = null;
//        try {
//
//            PreparedStatement st = koneksi.prepareStatement(query);
//            st.setInt(1, idKecamatan);
//            ResultSet rs = st.executeQuery();
//            rs.last();
//            ds = new String[2][rs.getRow()];
//            rs.beforeFirst();
//            int i = 0;
//            while (rs.next()) {
//                ds[0][i] = rs.getString("idDesa");
//                ds[1][i] = rs.getString("desa");
//
//                i++;
//            }
//        } catch (SQLException ex) {
//            ex.getMessage();
//            ex.printStackTrace();
//        }
//        return ds;
//    }

    public String[][] jenistanah() {
        String query = "SELECT id, jenistanah from jenistanah";
        String pt[][] = null;

        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            rs.last();
            pt = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                pt[0][i] = rs.getString("id");
                pt[1][i] = rs.getString("jenistanah");

                i++;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return pt;
    }

    public String[][] jadwal() throws SQLException {
        String query = "SELECT idJadwal,jadwalsurvey FROM jadwalsurvey";
        String js[][] = null;
        try {

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.last();
            js = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                js[0][i] = rs.getString("idJadwal");
                js[1][i] = rs.getString("jadwalsurvey");

                i++;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return js;
    }

}
