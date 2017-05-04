/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import controller.Controller;
import controller.ControllerLogin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aplikasi;
import model.Pelanggan;
import model.Petugas;

/**
 *
 * @author UKI
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Aplikasi model = new Aplikasi();
        //Pelanggan
//        model.createPelanggan("pel01", "uki", "kartika 4", "laki-laki", 19, "087774878528");
//        model.createPelanggan("pel02", "jalu", "kartika 4", "laki-laki", 19, "0888888888");
//        model.createPelanggan("pel03", "ega", "kartika 4", "laki-laki", 19, "08777777777");
//        model.createPelanggan("pel04", "ama", "kartika 4", "perempuan", 19, "087123123");
        //Petugas
//        model.createPetugas("pet01", "admin", "uki", "laki-laki", "kartika 4", 19, "08888888888");
//        model.createPetugas("pet02", "admin", "jalu", "laki-laki", "kartika 4", 19, "09999999999");
//        model.createPetugas("pet03", "admin", "ega", "laki-laki", "kartika 4", 19, "08777777777");
//        //Tempat Wisata
//        model.createTW("Ancol", "Jakarta Utara", "uki", "088888888");
//        String[] daftarIdPel = null;
//        String[] daftarIdPet = null;
//        String[] daftarNamaCP = null;
//        ArrayList<Petugas> daftarPet = new ArrayList<>();
//        try {
//            daftarIdPel = model.getListIdPelanggan();
//            daftarIdPet = model.getListIdPetugas();
//            daftarNamaCP = model.getListNamaWisata();
////            daftarPet = model.getPetugas();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    //    for(Petugas p : daftarPet){
      //      System.out.println("Nama: "+p.getNama());
        //}
        
//        for(int i=0; i<daftarPet.size();i++){
//            System.out.println(daftarPet.get(i).getNama());
//        }
//        
//        for (int i = 0; i < daftarIdPel.length; i++) {
//            System.out.println(daftarIdPel[i]);
//        }
//        System.out.println("");
//        for (int i = 0; i < daftarIdPet.length; i++) {
//            System.out.println(daftarIdPet[i]);
//        }
//        System.out.println("");
//        for (int i = 0; i < daftarNamaCP.length; i++) {
//            System.out.println(daftarNamaCP[i]);
//        }
//        System.out.println("Info Pelanggan: "+model.getPelanggan("pel01").getId_pel());
//        System.out.println("Info Pegawa: "+model.getPetugas("pet04").getId());
        new ControllerLogin(model);
    }
}
