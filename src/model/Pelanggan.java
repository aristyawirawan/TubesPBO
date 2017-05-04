/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pavilion
 */
public class Pelanggan extends Orang {
    private String id_pel;
    private String kode_perjalanan;
    
    public Pelanggan(){}
    public Pelanggan(String id_pel,String nama,String alamat,String jenkel,int umur,String no_hp){
        super(nama,jenkel,alamat,umur,no_hp);
        this.id_pel=id_pel;
    }

    public Pelanggan(String id_pel, String nama, String alamat,String jenkel, int umur, String no_hp,String kode_perjalanan) {
        super(nama, jenkel, alamat, umur, no_hp);
        this.id_pel = id_pel;
        this.kode_perjalanan = kode_perjalanan;
    }
    
    public void setId_pel(String x){
        id_pel=x;
    }
    public void setKode_perjalanan(String kode_perjalanan) {
        this.kode_perjalanan = kode_perjalanan;
    }
    public String getId_pel(){
        return id_pel;
    }
    public String getKode_perjalanan() {
        return kode_perjalanan;
    }
    public void printPelanggan(Perjalanan p){
        if(p != null){
            for(int i=0;i<p.getMaxpelanggan();i++){
                System.out.println(p.getPelanggan(i).getNama());
            }
        }else{
            System.out.println("Kosong");
        }
    }
}
