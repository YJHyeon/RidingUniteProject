/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Database.UserDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author dhkdw
 */
public class SignIn {

    public int Login(String id, String pw) {
        int chk = 0;
        UserDAO dao = new UserDAO();
        try {
            chk = dao.Login(id, pw);
        } catch (NamingException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
}

