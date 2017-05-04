/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aplikasi;
import view.GUI;
import view.Login;

/**
 *
 * @author UKI
 */
public class ControllerLogin implements ActionListener {

    Aplikasi model;
    Login view;
    GUI gui;
    public ControllerLogin(Aplikasi model) throws SQLException {
        this.model = model;
        view = new Login();
        view.setVisible(true);
        view.addListener(this);
//        gui.viewPerjalanan(model.getAllPerjalanan());
//        gui.viewPktWisata(model.getAllPw());
//        gui.viewTWisata(model.getAllTw());
//        gui.viewPetugas(model.getPetugas());
//        gui.viewPelanggan(model.getAllPelanggan());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnLogin())){
            try {
                String user = view.getUsername();
                String pw = view.getPassword();
                if(user.equals("admin") && pw.equals("admin123")){
                    new Controller(model);
                    view.dispose();
                }else view.showMessage(null, "Username atau Password Salah");
            } catch (SQLException ex) {
                view.showMessage(null, "Login gagal");
            }
        }else if(source.equals(view.getBtnCancel())){
            view.setUsername("");
            view.setPassword("");
        }
    }
    
}
