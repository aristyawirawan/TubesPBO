/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UKI
 */
public class Aplikasi {
    private ArrayList<Pelanggan> dataPelanggan;
    private ArrayList<Petugas> dataPetugas;
    private ArrayList<tempatWisata> dataTW;
    private ArrayList<paketWisata> dataPW; 
    private ArrayList<Perjalanan> dataPer;
    private database con;
    private int index = -1;
    
    public Aplikasi() {
        this.dataPelanggan = new ArrayList<>();
        this.dataPetugas = new ArrayList<>();
        this.dataTW = new ArrayList<>();
        this.con = new database();
        try {
            con.connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //Pelanggan
    public String createPelanggan(String id_pel,String nama,String alamat,String jenkel,int umur,String no_hp){
        Pelanggan p = new Pelanggan(id_pel,nama,alamat,jenkel,umur,no_hp);
        try {
            dataPelanggan.add(p);
            con.savePelanggan(p);
        } catch (SQLException ex) {
        }
        return p.getId_pel();
    }
    public void updatePelanggan(Pelanggan p){
        try {
            con.updatePelanggan(p);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Pelanggan getPelanggan(String idP) throws SQLException {
//        for (Pelanggan p : dataPelanggan) {
//            if (p.getId_pel() == idP) {
//                return p;
//            }
//        }
        Pelanggan p = con.getPelanggan(idP);
//        dataPelanggan.add(p);
        return p;
    }
    public String[] getListIdPelanggan() throws SQLException {
        return con.getListIDPelanggan();
    }
    public void delPelanggan(String idp) throws SQLException {
        for (Pelanggan p : dataPelanggan){
            if (p.getId_pel().equals(idp)){
                con.DelPelanggan(idp);
                
            }
        }
        
        
    }
    public ArrayList<Pelanggan> getAllPelanggan() throws SQLException{
        return con.getAllPelanggan();
    }
    public void setFkPel(String pel,String fk) throws SQLException{
        con.setFKPel(pel, fk);
    }
    
    //Petugas
    public String createPetugas(String id, String jabatan, String nama, String jenkel, String alamat,int umur, String no_hp){
        Petugas p = new Petugas(id,jabatan,nama,jenkel,alamat,umur,no_hp);
        try {
            dataPetugas.add(p);
            con.savePetugas(p);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p.getId();
    }
    public void updatePetugas(Petugas p){
        try {
            con.updatePetugas(p);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Petugas getPetugas(String idP) throws SQLException {
//        for (Petugas p : dataPetugas) {
//            if (p.getId().equals(idP)) {
//                return p;
//            }
//        }
        Petugas p = con.getpetugas(idP);
//        dataPetugas.add(p);
        return p;
    }
    public ArrayList<Petugas> getPetugas() throws SQLException{
        return con.getPetugas();
    }
    public String[] getListIdPetugas() throws SQLException {
        return con.getListIDPetugas();
    }
    public void delPetugas(String idp) throws SQLException {
//        for (Petugas p : dataPetugas){
//            if (p.getId().equals(idp)){
//                con.DelPetugas(idp);
//                
//            }
//        }
        con.DelPetugas(idp);
        
        
    }
    
    //Tempat Wisata
    public String createTW(String namaWisata,String alamatWisata,String nama_cp,String cp_wisata){
        tempatWisata tw = new tempatWisata(namaWisata,alamatWisata,nama_cp,cp_wisata);
        try {
            dataTW.add(tw);
            con.saveTw(tw);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tw.getNamaWisata();
    }
    public void updateTW(tempatWisata tw){
        try {
            con.updateTw(tw);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public tempatWisata getTW(String nama_wisata) throws SQLException {
//        for (tempatWisata tw : dataTW) {
//            if (tw.getNamaWisata().equals(nama_wisata)) {
//                return tw;
//            }
//        }
        tempatWisata tw = con.getTw(nama_wisata);
//        dataTW.add(tw);
        return tw;
    }
    public String[] getListNamaWisata() throws SQLException {
        return con.getListNamaWisata();
    }
    public void delTw(String idp) throws SQLException {
//        for (tempatWisata tw: dataTW){
//            if (tw.getNama_cp().equals(idp)){
//                con.DelTw(idp);
//                
//            }
//        }
        con.DelTw(idp);
        
    }
    public ArrayList<tempatWisata> getAllTw() throws SQLException{
        return con.getAllTw();
    }
    public void setFkTw(String tw,String fk) throws SQLException{
        con.setFKTw(tw, fk);
    }
    
    //Paket Wisata
    public String createPw(String Kode_paket,double harga,String nm_paket,int kapasitas){
        paketWisata pw = new paketWisata(Kode_paket, harga, nm_paket, kapasitas);
        try {
//            dataPW.add(pw);
            con.savePw(pw);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pw.getKodePaket();
    }
    public void updatePw(paketWisata pw){
        try {
            con.updatePw(pw);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public paketWisata getPw(String id_pkt) throws SQLException {
//        for (paketWisata pw : dataPW) {
//            if (pw.getKodePaket().equals(id_pkt)) {
//                return pw;
//            }
//        }
        paketWisata pw = con.getPw(id_pkt);
//        dataPW.add(pw);
        return pw;
    }
    public void delPw(String idp) throws SQLException {
//        for (paketWisata pw: dataPW){
//            if (pw.getKodePaket().equals(idp)){
//                con.DelPw(idp);
//                
//            }
//        }
        con.DelPw(idp);
        
    }
    public ArrayList<paketWisata> getAllPw() throws SQLException{
        return con.getAllPw();
    }
    
    
    //Perjalanan
    public String createPer(String Kode_perjalanan,String tgl_berangkat){
        Perjalanan per = new Perjalanan(Kode_perjalanan,tgl_berangkat);
        try {
//            dataPer.add(per);
            con.savePer(per);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return per.getKodeperjalanan();
    }
    public void updatePer(Perjalanan per){
        try {
            con.updatePer(per);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Perjalanan getPer(String id) throws SQLException {
        Perjalanan per=con.getPer(id);
        return per;
    }
    public void delPer(String id) throws SQLException {
        con.DelPer(id);
    }
    public ArrayList<Perjalanan> getAllPerjalanan() throws SQLException{
        return con.getAllPer();
    }
    public void setKdPaket(String pk,String fk) throws SQLException{
        con.setKodePaket(pk, fk);
    }
    
    
    
}
