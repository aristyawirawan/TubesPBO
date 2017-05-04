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
public class paketWisata {
    private tempatWisata[] daftarTujuanWisata = new tempatWisata[5];
    private String kodePaket;
    private double harga;
    private int kapasitas;
    private String nmPaket;
    private int jumlahWisata=0;//<-- maksutnya index terakhir yg ada isinya(males ganti nama)

    public String getNmPaket() {
        return nmPaket;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setNmPaket(String nmPaket) {
        this.nmPaket = nmPaket;
    }
    

    public paketWisata(String kodePaket, double harga, String nmPaket, int kapasitas) {
        this.kodePaket = kodePaket;
        this.harga = harga;
        this.nmPaket = nmPaket;
        this.kapasitas = kapasitas;
    }
    
    public paketWisata(){} 
    public paketWisata(String kodePaket,double harga){
        this.kodePaket=kodePaket;
        this.harga=harga;
    }    
    public void setKodePaket(String kdp){
        kodePaket=kdp;
    }  
    public String getKodePaket(){
        return kodePaket; 
    }
    
    public void setHarga(double hrg){
        harga=hrg;
    }
    public double getHarga(){
        return harga;
    }
    
    private static int idxpkt=0;
    public void addTempatWisata(tempatWisata w){
        for(int a=0;a<daftarTujuanWisata.length;a++){
            if(daftarTujuanWisata[a]==null){
                this.daftarTujuanWisata[a]=w;
                jumlahWisata++;
                break;
            }
            
        }
    }
    
    public void removeTempatWisata(tempatWisata w){
        for(int i=0;i<=daftarTujuanWisata.length;i++){
            if(w.getNamaWisata()==daftarTujuanWisata[i].getNamaWisata()){
                daftarTujuanWisata[i]=null;
                //jumlahWisata--;
                break;
            }
        }
    }
    
    public tempatWisata getTempatWisata(int x){
        return daftarTujuanWisata[x];
    }
    public int getJumlahWisata(){
        return jumlahWisata;
    }
    public void printPaket(Perjalanan pl){
        if(pl != null){
            System.out.println("Paket");
            System.out.println(pl.getPaket().getKodePaket());
        }else{
            System.out.println("Kosong");
        }
    }
}
