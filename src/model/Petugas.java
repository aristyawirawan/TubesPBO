/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Orang;

/**
 *
 * @author UKI
 */
public class Petugas extends Orang {
    private String id;
    private String jabatan;
      
    public Petugas(String id, String jabatan, String nama, String jenkel, String alamat,int umur, String no_hp){
        super(nama,jenkel,alamat,umur,no_hp);
        this.id = id;
        this.jabatan = jabatan;
    }
    public Petugas(){}
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setJabatan(String jabatan){
        this.jabatan = jabatan;
    }
    public String getJabatan(){
        return jabatan;
    }
}
