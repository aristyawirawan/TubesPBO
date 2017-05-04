/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author UKI
 */
public class Perjalanan {
    private Pelanggan[] pelanggan;
    private paketWisata paket;
    private String kode_paket;
    private String kode_perjalanan;
    private String tgl_perjalanan;
    private int maxPelanggan;
    
    public Perjalanan(){}
    public Perjalanan(String kode_perjalanan,int n){
        this.kode_perjalanan = kode_perjalanan;
        pelanggan = new Pelanggan[n];
    }

    public Perjalanan(String kode_perjalanan, String kode_paket, String tgl_perjalanan) {
        this.kode_paket = kode_paket;
        this.kode_perjalanan = kode_perjalanan;
        this.tgl_perjalanan = tgl_perjalanan;
    }
    
    public Perjalanan(String kode_perjalanan, String tgl_perjalanan) {
        this.kode_perjalanan = kode_perjalanan;
        this.tgl_perjalanan = tgl_perjalanan;
    }
    
    public void addPelanggan(Pelanggan p){
        if(pelanggan.length < maxPelanggan){
            System.out.println("Maaf sudah penuh!");
        }else{
            pelanggan[maxPelanggan] = p;
            maxPelanggan++;
        }
    }

    public void setPaket(paketWisata p){
        paket = p;
    }
    public paketWisata getPaket(){
        return paket;
    }
    public void removePaket(){
        paket = null;
    }
    public void setKodeperjalanan(String kode_perjalanan){
        this.kode_perjalanan = kode_perjalanan;
    }
    public String getKodeperjalanan(){
        return kode_perjalanan;
    }
    public void setTglperjalanan(Date date){
        this.tgl_perjalanan = tgl_perjalanan;
    }
    public String getTglperjalanan(){
        return tgl_perjalanan;
    }
    public String getKode_paket() {
        return kode_paket;
    }
    public int getMaxpelanggan(){
        return maxPelanggan;
    }
    public Pelanggan getPelanggan(int n){
        return pelanggan[n];
    }
}
