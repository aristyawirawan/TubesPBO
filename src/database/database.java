/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Pavilion
 */
public class database {
    private String server = "jdbc:mysql://localhost:3306/biro_perjalanan", dbuser = "root", dbpass = "";
    private Statement st;
    private Connection con;
    
    public void connect() throws SQLException {
            con = DriverManager.getConnection(server, dbuser, dbpass);
            st = con.createStatement();
    }
    
    //Pelanggan
    public void savePelanggan(Pelanggan p) throws SQLException {
            String query = "INSERT INTO pelanggan(id_pel, nama, alamat, jk, umur, no_hp) VALUES ('"
                            +p.getId_pel()+"','"+p.getNama()+"','"+p.getAlamat()+"','"
                            +p.getJenkel()+"',"+p.getUmur()+",'"+p.getNo_hp()+"')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys(); 
    }
    public Pelanggan getPelanggan(String idPelanggan) throws SQLException {
        Pelanggan p = null;
            String query = "SELECT * FROM pelanggan WHERE id_pel = '" + idPelanggan+"'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pelanggan(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
            }
        return p;
    } 
    public void updatePelanggan(Pelanggan p) throws SQLException {
        
            String query = "update pelanggan set nama ='"
                    + p.getNama() + "', alamat= '"
                    + p.getAlamat()+"',jk='"
                    +p.getJenkel()+"',umur="
                    +p.getUmur()+",no_hp='"
                    +p.getNo_hp()+"' where id_pel = '"
                    + p.getId_pel()+"'";
            st.executeUpdate(query);
        
    }     
    public String[] getListIDPelanggan() throws SQLException {
        ArrayList<String> listId = new ArrayList<>();
        
            //Query?
            String query = "SELECT id_pel FROM pelanggan";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
        

        return listId.toArray(new String[0]);
    }
    public void DelPelanggan(String idp) throws SQLException {
        String query= "Delete from pelanggan where id_pel='"+idp+"'";
        st.execute(query);
    }
    public void setFKPel(String p,String fk) throws SQLException {
        String query= "update pelanggan set kode_perjalanan='"+fk+
                "' where id_pel='"+p+"'";
        st.executeUpdate(query);
    }
    public ArrayList<Pelanggan> getAllPelanggan() throws SQLException{
        ArrayList<Pelanggan> dataPelanggan = new ArrayList<>();
        
        String query = "SELECT * FROM Pelanggan";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
              Pelanggan p = new Pelanggan(rs.getString("id_pel"), rs.getString("nama"), rs.getString("alamat"), rs.getString("jk"), rs.getInt("umur"), rs.getString("no_hp"),rs.getString("kode_perjalanan"));
              dataPelanggan.add(p);
        }
        return dataPelanggan;  
    }

    //Petugas
    public void savePetugas(Petugas p) throws SQLException {
            String query = "INSERT INTO petugas(id, jabatan, nama,alamat, jk, umur, no_hp) VALUES ('"
                            +p.getId()+"','"+p.getJabatan()+"','"+p.getNama()+"','"
                            +p.getAlamat()+"','"+p.getJenkel()+"',"+p.getUmur()+",'"+p.getNo_hp()+"')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            
        
    }
    public Petugas getpetugas(String idPetugas) throws SQLException {
        Petugas p = null;
        
            String query = "SELECT * FROM petugas WHERE id = '" + idPetugas+"'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Petugas(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
            }
         
        return p;
    } 
    public void updatePetugas(Petugas p) throws SQLException {
        
            String query = "update petugas set jabatan= '"
                    + p.getJabatan()+"',nama='"
                    +p.getNama()+"',jk='"
                    +p.getJenkel()+"',alamat='"
                    +p.getAlamat()+"',umur="
                    +p.getUmur()+",no_hp='"
                    +p.getNo_hp()+"' where id = '"
                    + p.getId()+"'";
            st.executeUpdate(query);
            
    }
    public String[] getListIDPetugas() throws SQLException {
        ArrayList<String> listId = new ArrayList<>();
        
            //Query?
            String query = "SELECT id FROM petugas";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
        

        return listId.toArray(new String[0]);
    }
    public void DelPetugas(String idp) throws SQLException {
        String query= "Delete from petugas where id='"+idp+"'";
        st.execute(query);
    }
    public ArrayList<Petugas> getPetugas() throws SQLException{
        ArrayList<Petugas> dataPetugas = new ArrayList<>();
        
        String query = "SELECT * FROM petugas";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
              Petugas p = new Petugas(rs.getString("id"), rs.getString("jabatan"), rs.getString("nama"), rs.getString("jk"), rs.getString("alamat"), rs.getInt("umur"), rs.getString("no_hp"));
              dataPetugas.add(p);
        }
        return dataPetugas;  
    }
    
    //Tempat_wisata
    public void saveTw(tempatWisata t) throws SQLException {
        String query = "INSERT INTO tempat_wisata(nama_wisata,alamat,nama_cp,no_hp) VALUES ('"
                            +t.getNamaWisata()+"','"+t.getAlamatWisata()+"','"+t.getNama_cp()+"','"
                            +t.getCp_wisata()+"')";
        st.execute(query,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs= st.getGeneratedKeys();
    }
    public tempatWisata getTw(String nmTw) throws SQLException {
        tempatWisata tw= null;
                
                String query="select * from tempat_wisata where nama_wisata= '"+nmTw+"'";
                ResultSet rs= st.executeQuery(query);
                while (rs.next()){
                    tw = new tempatWisata(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                }
                return tw;
    }
    public void updateTw(tempatWisata t) throws SQLException {
        String query= "UPDATE tempat_wisata SET alamat='"
                +t.getAlamatWisata()+"',nama_cp='"
                +t.getNama_cp()+"',no_hp='"
                +t.getCp_wisata()+"' WHERE nama_wisata= '"
                +t.getNamaWisata()+"'";
        st.execute(query);
    }
    public String[] getListNamaWisata() throws SQLException{
        ArrayList<String> listNm = new ArrayList<>();
        
            String query="select nama_wisata from tempat_wisata";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                listNm.add(rs.getString(1));
            }
        return listNm.toArray(new String[0]);
    }
    public void DelTw(String idp) throws SQLException {
        String query= "Delete from tempat_wisata where nama_wisata='"+idp+"'";
        st.execute(query);
    }
    public void setFKTw(String tw,String fk) throws SQLException {
       String query= "update tempat_wisata set kode_paket='"+fk+
                "' where nama_wisata='"+tw+"'";
        st.executeUpdate(query); 
    }
    public ArrayList<tempatWisata> getAllTw() throws SQLException{
        ArrayList<tempatWisata> dataTw = new ArrayList<>();
        
        String query = "SELECT * FROM tempat_wisata";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
              tempatWisata tw = new tempatWisata(rs.getString("nama_wisata"), rs.getString("alamat"), rs.getString("nama_cp"), rs.getString("no_hp"),rs.getString("kode_paket"));
              dataTw.add(tw);
        }
        return dataTw;  
    }
    
    
    //PaketWisata
    public void savePw(paketWisata p) throws SQLException {
        String query = "INSERT INTO paket_wisata(kode_paket,nama_paket,harga,kapasitas) VALUES ('"
                            +p.getKodePaket()+"','"+p.getNmPaket()+"',"+p.getHarga()+","
                            +p.getKapasitas()+")";
        st.execute(query,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs= st.getGeneratedKeys();
    }
    public paketWisata getPw(String id) throws SQLException {
        paketWisata pw= null;
                
                String query="select * from paket_wisata where kode_paket= '"+id+"'";
                ResultSet rs= st.executeQuery(query);
                while (rs.next()){
                    pw = new paketWisata(rs.getString(1),rs.getDouble(2), rs.getString(3), rs.getInt(4));
                }
                return pw;
    }
    public void updatePw(paketWisata p) throws SQLException {
        String query= "UPDATE paket_wisata SET nama_paket='"
                +p.getNmPaket()+"',harga="
                +p.getHarga()+",kapasitas="
                +p.getKapasitas()+" WHERE kode_paket= '"
                +p.getKodePaket()+"'";
        st.execute(query);
    }
    public String[] getListKodePaket() throws SQLException{
        ArrayList<String> listkode = new ArrayList<>();
        
            String query="select kode_paket from paket_wisata";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                listkode.add(rs.getString(1));
            }
        return listkode.toArray(new String[0]);
    }
    public void DelPw(String idp) throws SQLException {
        String query= "Delete from paket_wisata where kode_paket='"+idp+"'";
        st.execute(query);
    }
    public ArrayList<paketWisata> getAllPw() throws SQLException{
        ArrayList<paketWisata> dataPw = new ArrayList<>();
        
        String query = "SELECT * FROM paket_wisata";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
              paketWisata pw = new paketWisata(rs.getString("kode_paket"), rs.getDouble("harga"), rs.getString("nama_paket"), rs.getInt("kapasitas"));
              dataPw.add(pw);
        }
        return dataPw;  
    }
    
    
    //Perjalanan
    public void savePer(Perjalanan p) throws SQLException {
        String query = "INSERT INTO perjalanan(kode_perjalanan,tgl_berangkat) VALUES ('"
                            +p.getKodeperjalanan()+"','"+p.getTglperjalanan()+"')";
        st.execute(query,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs= st.getGeneratedKeys();
    }
    public Perjalanan getPer(String id) throws SQLException {
        Perjalanan per= null;
                
                String query="select * from perjalanan where kode_perjalanan= '"+id+"'";
                ResultSet rs= st.executeQuery(query);
                while (rs.next()){
                  per = new Perjalanan(rs.getString("kode_perjalanan"), rs.getString("tgl_berangkat"));
                }
                return per;
    }
    public void updatePer(Perjalanan p) throws SQLException {
        String query= "UPDATE perjalanan SET tgl_berangkat='"
                +p.getTglperjalanan()+"' WHERE kode_perjalanan= '"
                +p.getKodeperjalanan()+"'";
        st.execute(query);
    }
    public void DelPer(String idp) throws SQLException {
        String query= "Delete from perjalanan where kode_perjalanan='"+idp+"'";
        st.execute(query);
    }
    public ArrayList<Perjalanan> getAllPer() throws SQLException{
        ArrayList<Perjalanan> dataPer = new ArrayList<>();
        
        String query = "SELECT * FROM perjalanan";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
              Perjalanan per = new Perjalanan(rs.getString("kode_perjalanan"),rs.getString("kode_paket"),rs.getString("tgl_berangkat"));
              dataPer.add(per);
        }
        return dataPer;  
    }
     public void setKodePaket(String pk,String fk) throws SQLException {
       String query= "update perjalanan set kode_paket='"+fk+
                "' where kode_perjalanan='"+pk+"'";
        st.executeUpdate(query); 
    }
    
    
    
    
}

