/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.controllerDinas.idLK;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import model.modelLK;
import model.modelUser;
import view.awal;
import view.dashboardPemilik;
import view.detailLahan;
import view.lahanku;
import view.notif;
import view.sewaPemilik;
import view.tambahLK;

/**
 *
 * @author sahriatus
 */
public class controllerPemilik extends controllerUser {

    private modelUser mUser;
    private awal viewAwal;
    private modelLK mLK;
    dashboardPemilik viewPemilik;
    lahanku viewLahan;
    tambahLK viewTambah;
    private notif viewNotif;
    private detailLahan viewDetail;
    private sewaPemilik viewSewa;
    private int login;
    String id;

//    public controllerPemilik(String id) {
//        mLK = new modelLK();
//        this.id = id;
//        System.out.println(id);
//        viewPemilik = new dashboardPemilik();
//        viewPemilik.setVisible(true);
//        viewPemilik.lahankuListener(new lahankuListener());
//        viewPemilik.notifListener(new notifListener());
//        viewPemilik.sewaListener(new sewaListener());
//    }

    public controllerPemilik(int y, int c, String id) {
        mLK = new modelLK();
        this.id = id;
        viewLahan = new lahanku();
        viewLahan.setVisible(true);
        viewLahan.hapus().setEnabled(false);
        viewLahan.setTableModel(mLK.bacaTabelLahanKosongUser(id));
        System.out.println("lahan nya si id" + id);
        viewLahan.tambahListener(new tambahLKListener());
        viewLahan.kembaliListener(new backListener());
        viewLahan.addTableListener(new selectedTabelLK());
        viewLahan.hapusListener(new hapusLK());
        viewLahan.notifListener(new lahankenotifListener());
        viewLahan.sewaListener(new lahankesewaListener());
        viewLahan.keluarListener(new lahankeluarListener());

    }

    public controllerPemilik(int x, String id) {
        mLK = new modelLK();
        this.id = id;
        viewTambah = new tambahLK();
        viewTambah.setVisible(true);
        viewTambah.simpanListener(new daftarPemilikListener());
        viewTambah.kembaliListener(new kembaliListener());
        viewTambah.notifListener(new tambahkenotifListener());
        viewTambah.sewaListener(new tambahkesewaListener());
        viewTambah.keluarListener(new tambahkeluarListener());
    }

    public controllerPemilik(int a, int b, int x, int c, String id) {
        mLK = new modelLK();
        this.id = id;
        viewNotif = new notif();
        viewNotif.setVisible(true);
        viewNotif.setTabel(mLK.bacaNotif(id));
        viewNotif.backListener(new back2Listener());
        viewNotif.lahanListener(new notifkelahanListener());
        viewNotif.sewaListener(new notifkesewaListener());
        viewNotif.keluarListener(new notifkeluarListener());
    }

    public controllerPemilik(int a, int b, int x, String id) {
        mLK = new modelLK();
        this.id = id;
        viewSewa = new sewaPemilik();
        viewSewa.setVisible(true);
        viewSewa.setTabel(mLK.bacaLahanSewaUser(id));
        viewSewa.kembaliListener(new back3Listener());
        viewSewa.lahanListener(new sewakelahanListener());
        viewSewa.notifListener(new sewakenotifListener());
        viewSewa.keluarListener(new sewakeluarListener());
    }

    private class lahankeluarListener implements ActionListener {

        public lahankeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {

                controllerUser u = new controllerUser();
                viewLahan.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewLahan.setVisible(true);
            }
        }
    }

    private class tambahkeluarListener implements ActionListener {

        public tambahkeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {

                controllerUser u = new controllerUser();
                viewTambah.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewTambah.setVisible(true);
            }
        }
    }

    private class notifkeluarListener implements ActionListener {

        public notifkeluarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int Pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {

                controllerUser u = new controllerUser();
                viewNotif.setVisible(false);
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewNotif.setVisible(true);
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

    private class sewakenotifListener implements ActionListener {

        public sewakenotifListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewSewa.dispose();
            new controllerPemilik(1, 1, 1, 1, id);
        }
    }

    private class sewakelahanListener implements ActionListener {

        public sewakelahanListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewSewa.dispose();
            new controllerPemilik(2, 2, id);
        }
    }

    private class notifkesewaListener implements ActionListener {

        public notifkesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewNotif.dispose();
            new controllerPemilik(2, 2, 2, id);
        }
    }

    private class notifkelahanListener implements ActionListener {

        public notifkelahanListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewNotif.dispose();
            new controllerPemilik(3, 3, id);
        }
    }

    private class tambahkesewaListener implements ActionListener {

        public tambahkesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewTambah.dispose();
            new controllerPemilik(2, 2, 2, id);
        }
    }

    private class tambahkenotifListener implements ActionListener {

        public tambahkenotifListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewTambah.dispose();
            new controllerPemilik(2, 2, 2, 2, id);
        }
    }

    private class lahankesewaListener implements ActionListener {

        public lahankesewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewLahan.dispose();
            new controllerPemilik(2, 2, 2, id);
        }
    }

    private class lahankenotifListener implements ActionListener {

        public lahankenotifListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewLahan.dispose();
            new controllerPemilik(2, 2, 2, 2, id);
        }
    }

    private class sewaListener implements ActionListener {

        public sewaListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPemilik.dispose();
            new controllerPemilik(2, 2, 2, id);
        }
    }

    private class back3Listener implements ActionListener {

        public back3Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewSewa.dispose();
            new controllerPemilik(1,1,id);
        }
    }

    private class notifListener implements ActionListener {

        public notifListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPemilik.dispose();
            new controllerPemilik(1, 2, 3, 4, id);
        }
    }

    private class hapusLK implements ActionListener {

        public hapusLK() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int Pilih = JOptionPane.showConfirmDialog(null, "Hapus data lahan?", "Pertanyaan", JOptionPane.OK_CANCEL_OPTION);
            if (Pilih == JOptionPane.OK_OPTION) {
                boolean del = mLK.hapus(idLK);
                if (del) {
                    JOptionPane.showMessageDialog(viewLahan, "Data berhasil dihapus");
                    viewLahan.dispose();
                    new controllerPemilik(1,1,id);
                }
            } else if (Pilih == JOptionPane.CANCEL_OPTION) {
                viewLahan.setVisible(true);
            }
        }
    }

    private class kembaliDetailListener implements ActionListener {

        public kembaliDetailListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewDetail.dispose();
            new controllerPemilik(1,1,id);
        }
    }

    private class selectedTabelLK implements MouseListener {

        public selectedTabelLK() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            viewLahan.hapus().setEnabled(true);
            int baris = viewLahan.getBarisTerpilih();
            idLK = viewLahan.tabell().getValueAt(baris, 0).toString();
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

    private class back2Listener implements ActionListener {

        public back2Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewNotif.dispose();
            new controllerPemilik(1,1,id);
        }
    }

    private class backListener implements ActionListener {

        public backListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewLahan.dispose();
            new controllerPemilik(1,1,id);
        }
    }

    private class kembaliListener implements ActionListener {

        public kembaliListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewTambah.dispose();
            new controllerPemilik(1,1,id);
        }
    }

    //fungsi buat daftar jadi member sebagai pemilik
    private class daftarPemilikListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String notanah = viewTambah.getNoTanah();
            String alamat = viewTambah.getAlamat();
            String desa = viewTambah.getDesa();
            String kecamatan = viewTambah.getKecamatan();
            String luas = viewTambah.getLuas();
            String notanah1 = notanah.replaceAll("[^a-zA-Z]", "");
            String luas1 = luas.replaceAll("[^a-zA-Z]", "");
            String splitKTP[] = notanah1.split("");
            String splitLuas[] = luas1.split("");
            System.out.println(notanah.length());
            int counternotanah = notanah.length();

            if (notanah.equalsIgnoreCase("") || alamat.equalsIgnoreCase("") || luas.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(viewTambah, "Kolom tidak boleh kosong");
            } else if (counternotanah < 13) {
                JOptionPane.showMessageDialog(viewTambah, "Nomor tanah tidak boleh kurang dari 13 karakter");
            } else if (counternotanah > 13) {
                JOptionPane.showMessageDialog(viewTambah, "Nomor tanah tidak boleh lebih dari 13 karakter");
            } else {
                boolean add = mLK.tambahLK(id, notanah, alamat, kecamatan, desa, luas);
                if (add) {
                    JOptionPane.showMessageDialog(viewTambah, "Data berhasil dimasukkan");
                    viewTambah.dispose();
                    new controllerPemilik(1,1,id);
                }

            }

        }
    }

    private class tambahLKListener implements ActionListener {

        public tambahLKListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewLahan.dispose();
            new controllerPemilik(9, id);

        }
    }

    private class lahankuListener implements ActionListener {

        public lahankuListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPemilik.dispose();
            new controllerPemilik(8, 9, id);
        }
    }

}
