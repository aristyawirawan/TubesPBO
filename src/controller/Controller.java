/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Database.database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Aplikasi;
import model.Pelanggan;
import model.Perjalanan;
import model.Petugas;
import model.paketWisata;
import model.tempatWisata;
import view.GUI;
import view.Login;

/**
 *
 * @author UKI
 */
public class Controller extends MouseAdapter implements ActionListener, FocusListener {

    private Aplikasi model;
    private GUI view;
    private Petugas p;
    private database con;
    private Statement st;
    private String query;
    private ResultSet rs;

    public Controller(Aplikasi model) throws SQLException {
        this.model = model;
        view = new GUI();
        view.setVisible(true);
        view.addListener(this);
        view.viewPerjalanan(model.getAllPerjalanan());
        view.viewPktWisata(model.getAllPw());
        view.viewTWisata(model.getAllTw());
        view.viewPetugas(model.getPetugas());
        view.viewPelanggan(model.getAllPelanggan());
        this.p = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        //Pegawai
        if (source.equals(view.getRefreshPegawai())) {
            try {
                view.viewPetugas(model.getPetugas());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
        else if (source.equals(view.getBtnSave1())) {
            String id = view.getpId();
            String jbt = view.getpJabatan();
            String nm = view.getpNama();
            String gn = view.getPGender();
            String alm = view.getpAlamat();
            int age = Integer.parseInt(view.getpUmur());
            String nom = view.getpNumber();
            
            model.createPetugas(id, jbt, nm, gn, alm, age, nom);
            JOptionPane.showMessageDialog(null, "Berhasil");
            
            
        }
        else if(source.equals(view.getBtnSearchPgw())){
            try {
                String id = view.getTxtIdEditPegawai();
                if(model.getPetugas(id)==null)
                    view.showMessage(null, "Data tidak ada");
                else
                    view.showMessage(null, "Data ditemukan");
            } catch (SQLException ex) {
                view.showMessage(null, "Data tidak ada");
            }
        }
        else if (source.equals(view.getBtnEditPegawai())) {
            String id = view.getTxtIdEditPegawai();
            try {
                if(model.getPetugas(id)==null)
                    view.showMessage(null, "Data tidak ada");
                else{
                    String jbt = view.getTxtJabatanEditPegawai();
                    String nm = view.getTxtNamaEditPegawai();
                    String jk = view.getTxtJenkelEditPegawai();
                    String alamat = view.getTxtAlamatEditPegawai();
                    int umur = Integer.parseInt(view.getTxtUmurEditPegawai());
                    Petugas p = new Petugas(id, jbt, nm, jk, alamat, umur, nm);
                    model.updatePetugas(p);
                    view.showMessage(null, "Edit Berhasil");
                }
            } catch (SQLException ex) {
                view.showMessage(null, "Data tidak ada");
            }
        } else if (source.equals(view.getBtnDeletePgw())) {
            try {
                String id = view.getDeleteId2();
                model.delPetugas(id);
                view.showMessage(null, "Delete berhasil");
            } catch (SQLException ex) {
                view.showMessage(null, "Error");
            }
        }
        
        //Tempat Wisata
        else if(source.equals(view.getRefreshWisata())){
            try {
                view.viewTWisata(model.getAllTw());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if(source.equals(view.getBtnSave())){
                String nmw = view.getTxtNamaWisata();
                String alamat = view.getTxtAlamat();
                String no_hp = view.getTxtNumberCp();
                String nama_cp = view.getTxtNamaCp();
                model.createTW(nmw, alamat, nama_cp, no_hp);
                view.showMessage(null, "Berhasil");
        }else if(source.equals(view.getBtnSearchWisata())){
            String nama_wisata = view.getTxtNamaEditWisata();
                try {
                    if(model.getTW(nama_wisata)==null){
                        view.showMessage(null, "Data tidak ada");
                    }else{
                        view.showMessage(null, "Data ditemukan");
                    }
                } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ditemukan");
                }
        }else if(source.equals(view.getBtnEditWisata())){
            String nama_wisata = view.getTxtNamaEditWisata();
            String alamat = view.getTxtAlamatEditWisata();
            String no_hp = view.getTxtNumberCpEditWisata();
            String nama_cp = view.getTxtNamaCpEditWisata();
                try {
                    if(model.getTW(nama_wisata)==null){
                        view.showMessage(null, "Data tidak ada");
                    }else{
                        tempatWisata tw = new tempatWisata(nama_wisata, alamat, nama_cp, no_hp);
                        model.updateTW(tw);
                        view.showMessage(null, "Edit berhasil");
                    }   } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ditemukan");
                }
        }else if(source.equals(view.getBtnDeleteWisata())){
                try {
                    String nama_wisata = view.getDeleteNamaWisata();
                    model.delTw(nama_wisata);
                    view.showMessage(null, "Delete berhasil");
                } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ada");
                }
        }
        
        //Paket Wisata
        else if(source.equals(view.getRefreshpktWisata())){
            try {
                view.viewPktWisata(model.getAllPw());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if(source.equals(view.getBtnSimpan())){
            String kode_paket = view.getTxtKodePaket();
            double harga = Double.parseDouble(view.getTxtHarga());
            int kapasitas = Integer.parseInt(view.getTxtKapasitas());
            String nama_paket = view.getTxtNamaPaket();

            model.createPw(kode_paket, harga, nama_paket, kapasitas);
            view.showMessage(null, "Berhasil");
        }else if(source.equals(view.getBtnSearchPktWisata())){
            String kode_paket = view.getTxtKodeEditPaketWisata();
                try {
                    if(model.getPw(kode_paket) == null){
                        view.showMessage(null, "Data tidak ada");
                    }else{
                        view.showMessage(null, "Data ditemukan");
                    }
                } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ada");
                }
        }else if(source.equals(view.getBtnEditPaketWisata())){
            String kode_paket = view.getTxtKodeEditPaketWisata();
            int harga = Integer.parseInt(view.getTxtHargaEditPaketWisata());
            int kapasitas = Integer.parseInt(view.getTxtKapasitasEditPaketWisata());
            String nama_paket = view.getTxtNamaEditPaketWisata();
                try {
                    if(model.getPw(kode_paket)==null){
                        view.showMessage(null, "Data tidak ada");
                    }else{
                        paketWisata pw = new paketWisata(kode_paket, harga, nama_paket, kapasitas);
                        model.updatePw(pw);
                        view.showMessage(null, "Edit berhasil");
                    }
                } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ada");
                }
        }else if(source.equals(view.getBtnDeletePaketW())){
            String kode_paket = view.getDeleteKodePaket();
                try {
                    model.delPw(kode_paket);
                    view.showMessage(null, "Delete berhasil");
                } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ada");
                }
        }
        else if(source.equals(view.getBtnSearchTmbhWisata1())){
            String tw = view.getTmpwis1();
            try {
                if(model.getTW(tw) == null){
                    view.showMessage(null, "Data tidak ditemukan");
                }else{
                    view.showMessage(null, "Data ditemukan");
                }
            } catch (SQLException ex) {
                view.showMessage(null, "Data tidak ada");
            }
        }
        else if(source.equals(view.getBtnSearchTmbhWisata())){
            String kodepkt = view.getTxtkodepkt();
            try {
                if(model.getPw(kodepkt) == null){
                    view.showMessage(null, "Data tidak ditemukan");
                }else{
                    view.showMessage(null, "Data ditemukan");
                }
            } catch (SQLException ex) {
                view.showMessage(null, "Data tidak ada");
            }
        }
        else if(source.equals(view.getBtnCariPel())){
            String kdJalan = view.getTxtkdPer();
            String kdPell =view.getTxtIdPel();
            try {
                if(model.getPer(kdJalan) == null || model.getPelanggan(kdPell)==null){
                    view.showMessage(null, "Data tidak ditemukan");
                    
                }else{
                    view.showMessage(null, "Data ditemukan");
                }
            } catch (SQLException ex) {
                view.showMessage(null, "Data tidak ada");
            }
        }
        else if(source.equals(view.getBtnTambahPel())){
            String kdjalan = view.getTxtkdPer();
            String kdPell = view.getTxtIdPel();
            try {
                model.setFkPel(kdPell, kdjalan);
                view.showMessage(null, "Add Berhasil");
            } catch (SQLException ex) {
                view.showMessage(null, "Gagal");
            }
        }
        else if(source.equals(view.getBtnAddTmptWisata())){
            String kodepkt = view.getTxtkodepkt();
            String tw = view.getTmpwis1();
            try {
                model.setFkTw(tw, kodepkt);
                view.showMessage(null, "Add Berhasil");
            } catch (SQLException ex) {
                view.showMessage(null, "Gagal");
            }
        }
        
        //Pelanggan
        else if(source.equals(view.getRefreshPelanggan())){
            try {
                view.viewPelanggan(model.getAllPelanggan());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if(source.equals(view.getBtnSimpanPelanggan())){
            String id = view.getTxtIdPelanggan();
            String nm = view.getTxtNamaPelanggan();
            String jk = view.getTxtJenkelPelanggan();
            String alamat = view.getTxtAlamatPelanggan();
            int umur = Integer.parseInt(view.getTxtUmurPelanggan());
            String no_hp = view.getTxtNoPelanggan();

            model.createPelanggan(id, nm, alamat, jk, umur, no_hp);
            view.showMessage(null, "Data berhasil ditambahkan");
        }
        else if(source.equals(view.getBtnSearchPgw1())){
            String id = view.getTxtIdPelanggan1();
                try {
                    if(model.getPelanggan(id) == null)
                        view.showMessage(null, "Data tidak ada");
                    else
                        view.showMessage(null, "Data ditemukan");
                } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ada");
                }
        }
        else if(source.equals(view.getBtnEditPegawai1())){
            String id = view.getTxtIdPelanggan1();
                try {
                    if(model.getPelanggan(id) == null){
                        view.showMessage(null, "Data tidak ada");
                    }else{
                        String nm = view.getTxtNamaPelanggan1();
                        String jk = view.getTxtJenkelPelanggan1();
                        String alamat = view.getTxtAlamatPelanggan1();
                        int umur = Integer.parseInt(view.getTxtUmurPelanggan1());
                        String no_hp = view.getTxtNoPelanggan1();
                        Pelanggan p = new Pelanggan(id, nm, alamat, jk, umur, no_hp);
                        model.updatePelanggan(p);
                    }
                } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ada");
                }
        }
        else if(source.equals(view.getBtnDeletePelanggan())){
                try {
                    String id = view.getDeleteIdPelanggan();
                    model.delPelanggan(id);
                    view.showMessage(null, "Delete berhasil");
                } catch (SQLException ex) {
                    view.showMessage(null, "Data tidak ada");
                }
        }
        // Perjalanan
        else if(source.equals(view.getRefreshPerjalanan())){
            try {
                view.viewPerjalanan(model.getAllPerjalanan());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if(source.equals(view.getBtnSavePerjalanan())){
            String kode_per = view.getTxtKodePerjalanan();
            String kode_pkt = view.getTxtKodePaketPerjalanan();
            String tgl = view.getTxtPerjalananTglKeberangatan();
            try {
                if(model.getPw(kode_pkt)==null){
                    view.showMessage(null, "Kode Paket salah");
                }else{
                    model.createPer(kode_per, tgl);
                    model.setKdPaket(kode_per, kode_pkt);
                    view.showMessage(null, "Berhasil");
                }
            } catch (SQLException ex) {
                view.showMessage(null, "Gagal");
            }
        }
        else if(source.equals(view.getBtnSearchPerjalanan())){
            String kodeper = view.getTxtKodePerjalananEdit();
            try {
                if(model.getPer(kodeper)==null){
                    view.showMessage(null, "Data tdk ditemukan");
                }
                else view.showMessage(null, "Data ditemukan");
            } catch (SQLException ex) {
                view.showMessage(null, "Data tidak ada");
            }
        }
        else if(source.equals(view.getBtnEditPerjalanan())){
            String kodeper = view.getTxtKodePerjalananEdit();
            String tgl = view.getTglBerangkatEdit();
            try {
                if(model.getPer(kodeper)==null){
                    view.showMessage(null, "Data tdk ditemukan");
                }else{
                    Perjalanan p = new Perjalanan(kodeper, tgl);
                    model.updatePer(p);
                    view.showMessage(null, "Edit berhasil");
                }
            } catch (SQLException ex) {
                view.showMessage(null, "Data tidak ada");
            }
        }
        else if(source.equals(view.getBtnDeletePerjalanan())){
            String kodeper = view.getTxtdeleteKodePerjalanan();
            try {
                model.delPer(kodeper);
                view.showMessage(null, "Delete berhasil");
            } catch (SQLException ex) {
                view.showMessage(null, "Data tidak ada");
            }
        }
        else if(source.equals(view.getBtnLogout())){
            try {
                new ControllerLogin(model);
                view.dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if(o.equals(this.view.getpId())){
            if(this.view.getpId().equals("")){
                JOptionPane.showMessageDialog(null, "jgn kosong bray");
            }
        }
    }
}
