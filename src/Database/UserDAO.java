/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.*;
import javax.naming.NamingException;
import java.util.*;
import Database.UserObj;
//import database.ConnectionPoolSingroom;

/**
 *
 * @author dhkdw
 */
public class UserDAO {

    public int Login(String id, String pw) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<UserObj> Logins = new ArrayList<UserObj>();
        UserObj login = null;
        String sql = "SELECT PASSWD, ADMINCHK FROM Member WHERE ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();

        int A = -1;

        if (rs.next()) {
            if (rs.getString(1).equals(pw)) {
                if (rs.getInt(2) == 0) {
                    A = 0;
                } else if (rs.getInt(2) == 1) {
                    A = 1;
                }
            }
        }
        return A;
    }

    public int insertData(String id, String name, String pw, String tel, String email) throws NamingException, SQLException, ClassNotFoundException {

        int result = 0;

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        //ResultSet rs = null;

        String sql = "insert into Member (ID, NAME, PASSWD, TEL, EMAIL,ADMINCHK) values(?,?,?,?,?,1)";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, pw);
        pstmt.setString(4, tel);
        pstmt.setString(5, email);
        result = pstmt.executeUpdate();

        //rs.close();
        pstmt.close();
        DBConn.close();

        return result;
    }

    public void updateData(String id, String name, String pw, String tel, String email) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "update MEMBER set NAME=?,PASSWD=?,TEL=?,EMAIL=? where ORINO=?";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, name);
        pstmt.setString(2, pw);
        pstmt.setString(3, tel);
        pstmt.setString(4, email);
        pstmt.setString(5, id);
        int r = pstmt.executeUpdate();

    }

    public void deleteData(String id) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        //ResultSet rs = null;

        String sql = "DELETE FROM MEMBER WHERE ORINO = ?";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);

        int count = pstmt.executeUpdate();

        pstmt.close();
        DBConn.close();

    }

}
