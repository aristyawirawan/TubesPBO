/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author UKI
 */
public abstract class Orang {
    private String nama;
    private String jenkel;
    private String alamat;
    private int umur;
    private String no_hp;
    
    public Orang(){}
    public Orang (String nama, String jenkel,String alamat, int umur,String no_hp){
        this.nama = "lalalala"+nama;
        this.jenkel = jenkel;
        this.alamat = alamat;
        this.umur = umur;
        this.no_hp = no_hp;
    }
    public String getNama(){
        return this.nama;
    }
    public void setNama(String a){
        nama = a;
    }
    public String getJenkel(){
        return this.jenkel;
    }
    public void setJenkel(String a){
        jenkel = a;
    }
    public String getAlamat(){
        return this.alamat;
    }
    public void setAlamat(String a){
        alamat = a;
    }
    public int getUmur(){
        return this.umur;
    }
    public void setUmur(int a){
        umur = a;
    }
    public String getNo_hp(){
        return this.no_hp;
    }
    public void setNo_hp(String a){
        no_hp = a;
    }
}
