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
public class tempatWisata {
    private String namaWisata;
    private String alamatWisata;
    private String cp_wisata;
    private String nama_cp;
    private String kode_paket;
   
    public tempatWisata(){}
    public tempatWisata(String namaWisata,String alamatWisata,String nama_cp,String cp_wisata){
       this.namaWisata = namaWisata;
       this.alamatWisata = alamatWisata;
       this.cp_wisata = cp_wisata;
       this.nama_cp = nama_cp;
    }
    public tempatWisata(String namaWisata, String alamatWisata, String nama_cp,String cp_wisata, String kode_paket) {
        this.namaWisata = namaWisata;
        this.alamatWisata = alamatWisata;
        this.cp_wisata = cp_wisata;
        this.nama_cp = nama_cp;
        this.kode_paket = kode_paket;
    }
    public void setKode_paket(String kode_paket) {
        this.kode_paket = kode_paket;
    }
    public void setNamaWisata(String namaWisata){
       this.namaWisata = namaWisata;
    }
    public String getNamaWisata(){
       return namaWisata;
    }
    public void setAlamatWisata(String alamatWisata){
       this.alamatWisata = alamatWisata;
    }
    public String getKode_paket() {
        return kode_paket;
    }
    public String getAlamatWisata(){
       return alamatWisata;
    }
    public void setCp_wisata(String cp_wisata){
       this.cp_wisata = cp_wisata;
    }
    public String getCp_wisata(){
       return cp_wisata;
    }
    public void setNama_cp(String nama_cp){
       this.nama_cp = nama_cp;
    }
    public String getNama_cp(){
       return nama_cp;
    }
    public void printWisata(paketWisata paket){
        int i = 0;
        if(paket != null){
            while(i<paket.getJumlahWisata()){
                if(paket.getTempatWisata(i)==null){
                    i++;
                }else{
                    System.out.println(paket.getTempatWisata(i).getNamaWisata());
                    i++;
                }
            }
        }else{
            System.out.println("Kosong");
        }
   }
}
