/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.modelLK;
import model.modelUser;
import view.awal;
import view.dashboardAdmin;
import view.detailLK;
import view.isiParam;
import view.lihatHasil;
import view.lihatIsiJadwal;
import view.lihatJadwal;
import view.listLahanKosong;
import view.login;
import view.sewaDinas;
import view.signUp;
import view.targetLahan;

/**
 *
 * @author sahriatus
 */
public class controllerDinas extends controllerUser {

    private modelUser muser;
    private modelLK mLK;
    private signUp viewDaftar;
    private awal viewAwal;
    private login viewMasuk;
    private dashboardAdmin viewAdmin;
    private listLahanKosong viewListLK;
    private detailLK viewDetail;
    private lihatJadwal viewJadwal;
    private lihatIsiJadwal viewIsiJadwal;
    private isiParam viewIsiParam;
    private targetLahan viewTarget;
    String jadwal;
    public static String idLK;
    public static String notanah;
    public static String id;
    public static String jenislahan;
    private lihatHasil viewLihatHasil;
    private sewaDinas viewSewa;

    double luas, suhu, hujan, ketinggian; // buat ngubah dari yg dimasukkan dr V ke tipe int
    double fluassempit, fluasnormal, fluasluas; // buat ngitung rumus
    double fsuhusedang, fsuhupanas;// buat ngitung rumus
    double fhujanringan, fhujansed, fhujanlebat, fhujansangatleb;// buat ngitung rumus
    double ftinggirendah, ftinggisedang, ftinggitinggi;// buat ngitung rumus
    double fluas, fsuhu, fhujan, fketinggian;// buat hasil akhirnya tiap parameter
    String hluas1 = "";
    String hluas, hsuhu, htinggi, hhujan;
    int fluas1, fluas2, fsuhu1, fsuhu2, fketinggian1, fketinggian2;

    //tampilan dashboardAdmin
//    public controllerDinas() {
//        viewAdmin = new dashboardAdmin();
//        viewAdmin.setVisible(true);
//        viewAdmin.lihatLKListener(new controllerDinas.lihatLKListener());
//        viewAdmin.jadwalSurveyListener(new jadwalSurveyListener());
//        viewAdmin.sewaListener(new listSewaListener());
//    }
    
    public controllerDinas(int s, int v, int k, int w, int d, String b, String j) {
        mLK = new modelLK();
        viewSewa = new sewaDinas();
        viewSewa.setVisible(true);
        viewSewa.setTabel(mLK.bacaLahanSewaDinas());
        viewSewa.kembaliListener(new kembaliSewaListener());
        viewSewa.daftarLKListener(new sewakedaftarListener());
        viewSewa.jadwalListener(new sewakejadwalListener());
        viewSewa.keluarListener(new sewakeluarListener());
    }

    //tampilan liat list lahan kosong
    public controllerDinas(int a, int b) throws SQLException {
        mLK = new modelLK();
        viewListLK = new listLahanKosong();
        viewListLK.setVisible(true);
        //bacaTabelLK();
        viewListLK.setTabelLK(mLK.bacaTabelLahanKosong());
        viewListLK.addTableListener(new selectedTabelLK());
        viewListLK.detailListener(new DetailListener());
        viewListLK.kembaliListener(new kembaliListener());
        viewListLK.jadwalListener(new lkkejadwalListener());
        viewListLK.sewaListener(new lkkesewaListener());
        viewListLK.keluarListener(new lkkeluarListener());
    }

    public controllerDinas(int x, int y, String j) {
        mLK = new modelLK();
        viewLihatHasil = new lihatHasil();
        viewLihatHasil.setVisible(true);
        viewLihatHasil.setID(idLK);
        viewLihatHasil.setTinggi(mLK.tinggi(idLK));
        viewLihatHasil.setLuasP(mLK.luaspengairan(idLK));
        viewLihatHasil.setSuhu(mLK.suhu(idLK));
        viewLihatHasil.setLuasT(mLK.luasLK(idLK));
        viewLihatHasil.setHujan(mLK.hujan(idLK));
        viewLihatHasil.setAlamat(mLK.alamatLK(idLK));
        viewLihatHasil.setPemilik(mLK.pemilik(idLK));
        viewLihatHasil.setNoTanah(mLK.noTanah(idLK));
        viewLihatHasil.setHasil(mLK.hasil(idLK));
        viewLihatHasil.sewaListener(new sewaListener());
        viewLihatHasil.keluarListener(new hasilkeluarListener());
        viewLihatHasil.lahanListener(new hasilkelahanListener());
        viewLihatHasil.sewamenuListener(new hasilkesewaListener());

    }

    private class hasilkesewaListener implements ActionListener {

        public hasilkesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewLihatHasil.dispose();
            new controllerDinas(1, 1, 1, 1, 1, "Pertanyaan", "Pertanyaan");
        }
    }

    private class hasilkelahanListener implements ActionListener {

        public hasilkelahanListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewLihatHasil.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class hasilkeluarListener implements ActionListener {

        public hasilkeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {
                controllerUser u = new controllerUser();
                viewLihatHasil.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewLihatHasil.setVisible(true);
            }
        }
    }

    private class paramkeluarListener implements ActionListener {

        public paramkeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {
                controllerUser u = new controllerUser();
                viewIsiParam.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewIsiParam.setVisible(true);
            }
        }
    }

    private class isikeluarListener implements ActionListener {

        public isikeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {
                controllerUser u = new controllerUser();
                viewIsiJadwal.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewIsiJadwal.setVisible(true);
            }
        }
    }

    private class jadwalkeluarListener implements ActionListener {

        public jadwalkeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {
                controllerUser u = new controllerUser();
                viewJadwal.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewJadwal.setVisible(true);
            }
        }
    }

    private class detailkeluarListener implements ActionListener {

        public detailkeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {
                controllerUser u = new controllerUser();
                viewDetail.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewDetail.setVisible(true);
            }
        }
    }

    private class lkkeluarListener implements ActionListener {

        public lkkeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {
                controllerUser u = new controllerUser();
                viewListLK.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewListLK.setVisible(true);
            }
        }
    }

    private class sewakeluarListener implements ActionListener {

        public sewakeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {
                controllerUser u = new controllerUser();
                viewSewa.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewSewa.setVisible(true);
            }
        }
    }

    private class paramkedaftarListener implements ActionListener {

        public paramkedaftarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewIsiParam.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class paramkesewaListener implements ActionListener {

        public paramkesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewIsiParam.dispose();
            new controllerDinas(1, 2, 1, 2, 1, "hah", "hah");
        }
    }

    private class isijadwalkesewaListener implements ActionListener {

        public isijadwalkesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewIsiJadwal.dispose();
            new controllerDinas(1, 2, 1, 2, 1, "hah", "hah");
        }
    }

    private class isijadwalkedaftarListener implements ActionListener {

        public isijadwalkedaftarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewIsiJadwal.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class jadwalkesewaListener implements ActionListener {

        public jadwalkesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewJadwal.dispose();
            new controllerDinas(1, 1, 1, 1, 1, "hah", "hah");
        }
    }

    private class jadwalkedaftarListener implements ActionListener {

        public jadwalkedaftarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewJadwal.dispose();
            try {
                new controllerDinas(2, 2);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class lkkesewaListener implements ActionListener {

        public lkkesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewListLK.dispose();
            new controllerDinas(1, 1, 1, 1, 1, "hah", "hah");
        }
    }

    private class lkkejadwalListener implements ActionListener {

        public lkkejadwalListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewListLK.dispose();
            new controllerDinas("hah", "hah");
        }
    }

    private class detailkesewaListener implements ActionListener {

        public detailkesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewDetail.dispose();
            new controllerDinas(1, 1, 3, 3, 2, "hah", "hah");
        }
    }

    private class detailkejadwalListener implements ActionListener {

        public detailkejadwalListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewDetail.dispose();
            new controllerDinas("hah", "hah");
        }
    }

    private class sewakejadwalListener implements ActionListener {

        public sewakejadwalListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewSewa.dispose();
            new controllerDinas("hah", "hah");
        }
    }

    private class sewakedaftarListener implements ActionListener {

        public sewakedaftarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewSewa.dispose();
            try {
                new controllerDinas(9, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliSewaListener implements ActionListener {

        public kembaliSewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewSewa.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class listSewaListener implements ActionListener {

        public listSewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewAdmin.dispose();
            new controllerDinas(9, 9, 0, 17, 9, "jj", "nn");
        }
    }

    private class sewaListener implements ActionListener {

        public sewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean sew = mLK.sewa(idLK);
            if (sew) {
                JOptionPane.showMessageDialog(viewDetail, "Lahan akan diproses untuk disewa ");
                viewLihatHasil.dispose();
                try {
                    new controllerDinas(1, 1);
                } catch (SQLException ex) {
                    Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(viewDetail, "Terjadi Kesalahan");
            }
        }
    }

    private class tolakListener implements ActionListener {

        public tolakListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean tol = mLK.tolak(idLK);
            if (tol) {
                JOptionPane.showMessageDialog(viewDetail, "Lahan ditolak ");
                viewLihatHasil.dispose();
                try {
                    new controllerDinas(1, 1);
                } catch (SQLException ex) {
                    Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(viewDetail, "Terjadi Kesalahan");
            }
        }
    }

    private class kembaliHasilListener implements ActionListener {

        public kembaliHasilListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewLihatHasil.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class cekHitungListener implements ActionListener {

        public cekHitungListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            luas = Double.valueOf(viewIsiParam.getLuas());
            String lahankosong = viewIsiParam.getID();
            ketinggian = Double.valueOf(viewIsiParam.getKetinggian());
            suhu = Double.valueOf(viewIsiParam.getSuhu());
            hujan = Double.valueOf(viewIsiParam.getCurahHujan());
            if (luas < 21043) {
                fluassempit = 1;
                fluas = fluassempit;
                hluas = "sempit";
            } else if (luas >= 21043 && luas <= 30539) {
                if (luas <= 25791) {
                    fluasnormal = (luas - 21043) / (30539 - 21043);
                    fluas = fluasnormal;
                    hluas = "normal";
                } else {
                    fluassempit = -(luas - 30539) / (30539 - 21043);
                    fluas = fluassempit;
                    hluas = "sempit";
                }
            } else if (luas > 30539 && luas < 40035) {
                if (luas <= 35287) {
                    fluasnormal = -(luas - 40035) / (40035 - 30539);
                    fluas = fluasnormal;
                    hluas = "normal";
                } else {
                    fluasluas = (luas - 30539) / (40035 - 30539);
                    fluas = fluasluas;
                    hluas = "luas";
                }
            } else {
                fluasluas = 1;
                fluas = fluasluas;
                hluas = "luas";
            }
            if (hujan < 20) {
                fhujanringan = 1;
                fhujan = fhujanringan;
                hhujan = "ringan";
            } else if (hujan >= 50 && hujan <= 400) {
                if (hujan <= 225) {
                    fhujanringan = -(hujan - 400) / (400 - 50);
                    fhujan = fhujanringan;
                    hhujan = "ringan";
                } else {
                    fhujansed = (hujan - 50) / (400 - 50);
                    fhujan = fhujansed;
                    hhujan = "sedang";
                }
            } else if (hujan > 400 && hujan <= 1000) {
                if (hujan <= 700) {
                    fhujansed = -(hujan - 1000) / (1000 - 400);
                    fhujan = fhujansed;
                    hhujan = "sedang";
                } else {
                    fhujanlebat = (hujan - 400) / (1000 - 400);
                    fhujan = fhujanlebat;
                    hhujan = "lebat";
                }
            } else if (hujan > 1000 && hujan < 2500) {
                if (hujan <= 1750) {
                    fhujanlebat = -(hujan - 2500) / (2500 - 1000);
                    fhujan = fhujanlebat;
                    hhujan = "lebat";
                } else {
                    fhujansangatleb = (hujan - 1000) / (2500 - 1000);
                    fhujan = fhujansangatleb;
                    hhujan = "sangat lebat";
                }
            } else {
                fhujansangatleb = 1;
                fhujan = fhujansangatleb;
                hhujan = "sangat lebat";
            }
            if (ketinggian < 400) {
                ftinggirendah = 1;
                fketinggian = ftinggirendah;
                htinggi = "rendah";
            } else if (ketinggian >= 400 && ketinggian <= 1550) {
                if (ketinggian <= 975) {
                    ftinggirendah = -(ketinggian - 1550) / (1550 - 400);
                    fketinggian = ftinggirendah;
                    htinggi = "rendah";
                } else {
                    ftinggisedang = (ketinggian - 400) / (1550 - 400);
                    fketinggian = ftinggisedang;
                    htinggi = "sedang";
                }
            } else if (ketinggian > 2300 && ketinggian < 2500) {
                ftinggitinggi = (ketinggian - 2500) / (2500 - 2300);
                fketinggian = ftinggitinggi;
                htinggi = "tinggi";
            } else {
                ftinggitinggi = 1;
                fketinggian = ftinggitinggi;
                htinggi = "tinggi";
            }
            if (suhu <= 20) {
                fsuhusedang = 1;
                fsuhu = fsuhusedang;
                hsuhu = "sedang";
            } else if (suhu > 20 && suhu <= 45) {
                fsuhupanas = 1;
                fsuhu = fsuhupanas;
                hsuhu = "panas";
            }

            System.out.println(hluas + fluas);
            System.out.println(hsuhu + fsuhu);
            System.out.println(htinggi + fketinggian);
            System.out.println(hhujan + fhujan);

            boolean y = mLK.fuzzifikasi(lahankosong, ftinggirendah, ftinggisedang, ftinggitinggi, fsuhupanas, fsuhusedang, fhujanringan, fhujansed, fhujanlebat, fhujansangatleb, fluassempit, fluasnormal, fluasluas);

            String x = mLK.hasilnya(htinggi, hluas, hhujan, hsuhu);
            System.out.println(x);

            boolean k = mLK.masukinData(idLK, ketinggian, luas, hujan, suhu, x);
            viewIsiParam.dispose();
            new controllerDinas(1, 2, x);

        }
    }

    private class selectedTabelLK implements MouseListener {

        public selectedTabelLK() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            viewListLK.lihat().setEnabled(true);
            int baris = viewListLK.getBarisTerpilih();
            idLK = viewListLK.tabelll().getValueAt(baris, 0).toString();
        }

        //<editor-fold defaultstate="collapsed" desc="comment">
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
//</editor-fold>
    }

    public controllerDinas(int a, int m, int s, int p) throws SQLException {
        mLK = new modelLK();
        viewDetail = new detailLK();
        viewDetail.setVisible(true);
        viewDetail.setID(idLK);
        viewDetail.setNoTanah(mLK.noTanah(idLK));
        viewDetail.setDesa(mLK.desa(idLK));
        viewDetail.setKecamatan(mLK.kecamatan(idLK));
        viewDetail.setNoTanah(mLK.noTanah(idLK));
        viewDetail.setLuas(mLK.luasLK(idLK));
        viewDetail.setStatus(mLK.statusLK(idLK));
        viewDetail.setAlamat(mLK.alamatLK(idLK));
        viewDetail.setNama(mLK.pemilik(idLK));
        viewDetail.setNoTelp(mLK.noTelepon(idLK));
        viewDetail.setAlamatPemilik(mLK.alamatPemilik(idLK));
        viewDetail.getJadwal();
        viewDetail.tambahKeJadwalListener(new masukinJadwalListener());
        viewDetail.kembaliListener(new kembaliListener5());
        viewDetail.jadwalListener(new detailkejadwalListener());
        viewDetail.sewaListener(new detailkesewaListener());
        viewDetail.keluarListener(new detailkeluarListener());
    }

    //tampilan liat jadwal
    public controllerDinas(String a, String b) {
        mLK = new modelLK();
        viewJadwal = new lihatJadwal();
        viewJadwal.setVisible(true);
        bacaTabelJadwal();
        viewJadwal.getLihat().setEnabled(false);
        viewJadwal.getHapus().setEnabled(false);
        viewJadwal.lihatListener(new lihatListener());
        viewJadwal.tabelListener(new selectedTabelJadwal());
        viewJadwal.tambahListener(new tambahJadwalListener());
        viewJadwal.hapusListener(new hapusJadwalListener());
        viewJadwal.kembaliListener(new kembaliListener2());
        viewJadwal.daftarListener(new jadwalkedaftarListener());
        viewJadwal.sewaListener(new jadwalkesewaListener());
        viewJadwal.keluarListener(new jadwalkeluarListener());
    }

//    tampilan lihat isi lahan mana aja yg ada di jadwal yg dipilih
    public controllerDinas(String jadwal, int k, int j) {
        mLK = new modelLK();
        viewIsiJadwal = new lihatIsiJadwal();
        viewIsiJadwal.setVisible(true);
        viewIsiJadwal.getJadwal().setText(jadwal);
        viewIsiJadwal.getTabel().setModel(mLK.bacaIsiJadwal(jadwal));
        viewIsiJadwal.tabelListener(new selectedLahan());
        viewIsiJadwal.isiParamListener(new isiParamListener());
        viewIsiJadwal.kembaliListener(new kembaliListener3());
        viewIsiJadwal.daftarListener(new isijadwalkedaftarListener());
        viewIsiJadwal.sewaListener(new isijadwalkesewaListener());
        viewIsiJadwal.keluarListener(new isikeluarListener());

    }

    //tampilan buat ngisi parameter lahan setelah survey
    public controllerDinas(String id, int a, int b, int c, int d) {
        mLK = new modelLK();
        viewIsiParam = new isiParam();
        viewIsiParam.setVisible(true);
        viewIsiParam.getIDLK().setText(id);
        viewIsiParam.cekListener(new cekHitungListener());
        viewIsiParam.sewaListener(new paramkesewaListener());
        viewIsiParam.daftarListener(new paramkedaftarListener());
        viewIsiParam.keluarListener(new paramkeluarListener());

    }

    private class kembaliListener2 implements ActionListener {

        public kembaliListener2() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewJadwal.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliListener3 implements ActionListener {

        public kembaliListener3() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewIsiJadwal.dispose();
            new controllerDinas("Data berhasil dihapus", "Data berhasil dihapus");
        }
    }

    private class kembaliListener implements ActionListener {

        public kembaliListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewListLK.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliListener4 implements ActionListener {

        public kembaliListener4() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewTarget.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliListener5 implements ActionListener {

        public kembaliListener5() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewDetail.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class simpanParamListener implements ActionListener {

        public simpanParamListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String luastanah = viewIsiParam.getLuas();
            String lahankosong = viewIsiParam.getID();
            String ketinggian = viewIsiParam.getKetinggian();
            String suhu = viewIsiParam.getSuhu();
            String curahhujan = viewIsiParam.getCurahHujan();
            boolean status = mLK.tambahParam(lahankosong, luastanah, curahhujan, suhu, ketinggian);
            viewIsiParam.dispose();
            new controllerDinas(jadwal, 9, 0);
        }
    }

    private class isiParamListener implements ActionListener {

        public isiParamListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = viewIsiJadwal.getTabel().getSelectedRow();
            viewIsiJadwal.dispose();
            new controllerDinas(idLK, 4, 4, 4, 4);
        }
    }

    private class hapusJadwalListener implements ActionListener {

        public hapusJadwalListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                int baris = viewJadwal.getTabel().getSelectedRow();
                boolean status = mLK.hapusJadwal(jadwal);
                System.out.println(jadwal);
                if (status) {
                    JOptionPane.showMessageDialog(viewListLK, "Data berhasil dihapus");
                    viewJadwal.dispose();
                    new controllerDinas(1, 1);
                } else {
                    JOptionPane.showMessageDialog(viewListLK, "Terjadi Kesalahan");

                }
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class tambahJadwalListener implements ActionListener {

        public tambahJadwalListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            String abc = viewJadwal.getJadwal();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            boolean status = mLK.tambahJadwal(abc);
            viewJadwal.dispose();
            try {
                new controllerDinas(1, 1);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //buat ngeset jadwalnyalalu dilihat isinya
    private class selectedTabelJadwal implements MouseListener {

        public selectedTabelJadwal() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            viewJadwal.getLihat().setEnabled(true);
            viewJadwal.getHapus().setEnabled(true);
            int baris = viewJadwal.getTabel().getSelectedRow();
            jadwal = viewJadwal.getTabel().getValueAt(baris, 0).toString();

        }

        //<editor-fold defaultstate="collapsed" desc="comment">
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
//</editor-fold>

    }

    private class selectedTabelTaret implements MouseListener {

        public selectedTabelTaret() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            viewTarget.getUbah().setEnabled(true);
            int baris = viewTarget.getTabel().getSelectedRow();
            id = viewTarget.getTabel().getValueAt(baris, 0).toString();
            jenislahan = viewTarget.getTabel().getValueAt(baris, 1).toString();
        }

        //<editor-fold defaultstate="collapsed" desc="comment">
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
//</editor-fold>

    }

    private class selectedLahan implements MouseListener {

        public selectedLahan() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            viewIsiJadwal.getParameter().setEnabled(true);
            int baris = viewIsiJadwal.getTabel().getSelectedRow();
            idLK = viewIsiJadwal.getTabel().getValueAt(baris, 0).toString();
            notanah = viewIsiJadwal.getTabel().getValueAt(baris, 1).toString();

        }

        //<editor-fold defaultstate="collapsed" desc="comment">
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
//</editor-fold>

    }

    //buat ngambil data dari v.jadwal, buat dilihat ada lahan apa aja di dalemnya
    private class selectedTabelLihat implements MouseListener {

        public selectedTabelLihat() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            viewJadwal.getLihat().setEnabled(true);
            int baris = viewJadwal.getTabel().getSelectedRow();
            jadwal = viewJadwal.getTabel().getValueAt(baris, 0).toString();
        }

        //<editor-fold defaultstate="collapsed" desc="comment">
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
//</editor-fold>
    }

    //tombol buat lihat isi dari jadwal survey
    private class lihatListener implements ActionListener {

        public lihatListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = viewJadwal.getTabel().getSelectedRow();
            viewJadwal.dispose();
            new controllerDinas(jadwal, 3, 3);
        }
    }

    class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    class TableListener2 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            viewTarget.enableEdit();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    //fungsi lihat detail lahan
    class DetailListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                viewListLK.dispose();
                new controllerDinas(2, 2, 2, 2);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //fungsi lihat mau ubah target
    class ubahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mLK.setSelectedRowTarget(viewTarget.getSelectedRow());
            viewTarget.getUbah().setEnabled(true);
            viewTarget.setID(mLK.getIDTaret());
            viewTarget.setJumlah(mLK.getJumlahLahan());
            viewTarget.setLahan(mLK.getJenisLahan());
        }
    }

    //fungsi lihat daftar lahan kosong
    private class lihatLKListener implements ActionListener {

        public lihatLKListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                viewAdmin.dispose();
                new controllerDinas(3, 4);
            } catch (SQLException ex) {
                Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//fungsi lihat jadwal survey
    private class jadwalSurveyListener implements ActionListener {

        public jadwalSurveyListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewAdmin.dispose();
            new controllerDinas("", "");
        }
    }

    //fungsi buat baca tabel lahan kosong oleh admin dinas
    private void bacaTabelLK() {
        viewListLK.setTabelLK(mLK.bacaTabelLahanKosong());
    }

    //fungsi buat baca tabel target
    private void bacaTarget() {
        viewTarget.setTabel(mLK.bacaTarget());
    }

    //fungsi buat baca tabel jadwal
    private void bacaTabelJadwal() {
        viewJadwal.setTabel(mLK.bacaTabelJadwal());
    }

    private class masukinJadwalListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = viewDetail.getID();
            String jadwal = viewDetail.getJadwal();
            System.out.println(jadwal);
            System.out.println(id);
            boolean status = mLK.masukinJadwal(jadwal, id);
            if (status) {
                JOptionPane.showMessageDialog(viewDetail, "Data berhasil dimasukkan ke jadwal");
                viewDetail.dispose();
                try {
                    new controllerDinas(1, 1);
                } catch (SQLException ex) {
                    Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(viewDetail, "Terjadi Kesalahan dalam update");
            }
        }
    }

    private class simpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = viewTarget.getID();
            String jumlah = viewTarget.getJumlah();
            System.out.println(jumlah);

            boolean status = mLK.ubahTarget(jumlah);
            if (status) {

                JOptionPane.showMessageDialog(viewTarget, "Data berhasil dimasukkan");
                viewTarget.dispose();
                try {
                    new controllerDinas(1, 1);
                } catch (SQLException ex) {
                    Logger.getLogger(controllerDinas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(viewTarget, "Terjadi Kesalahan dalam update");

            }
        }
    }
}
