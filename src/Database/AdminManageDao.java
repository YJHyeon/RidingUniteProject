/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;


/**
 *
 * @author cyc53
 */
public class AdminManageDao {
    public ArrayList<AdminManageObj> Manage(String ID) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<AdminManageObj> users = new ArrayList<AdminManageObj>();
        AdminManageObj user = null;
        String sql = "SELECT * FROM Member";

        pstmt = conn.prepareStatement(sql);
        
        rs = pstmt.executeQuery();
        while (rs.next()) {
            user = new AdminManageObj();
            user.setId(rs.getString("ID"));
            user.setPw(rs.getString("PASSWD"));
            user.setName(rs.getString("NAME"));
            user.setTel(rs.getString("TEL"));
            user.setEmail(rs.getString("EMAIL"));
            user.setAdminchk(rs.getString("ADMINCHK"));
            users.add(user);
        }

        return users;

    }
    
   public void deleteData(String ID, String NAME, String PASSWD, String TEL, String EMAIL, String ADMINCHK) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        //ResultSet rs = null;

        String sql = "DELETE FROM Member WHERE ID=? AND NAME=? AND PASSWD = ? AND TEL =? AND EMAIL = ? AND ADMINCHK =?;";

        pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, ID);
        pstmt.setString(2, NAME);
        pstmt.setString(3, PASSWD);
        pstmt.setString(4, TEL);
        pstmt.setString(5, EMAIL);
        pstmt.setString(6, ADMINCHK);

        //pstmt.setString(4, spot);

        int count = pstmt.executeUpdate();

        pstmt.close();
        DBConn.close();

    }
   public void updateData(String ID, String NAME, String PASSWD, String TEL, String EMAIL, String ADMINCHK,String ID1, String NAME1, String PASSWD1, String TEL1, String EMAIL1, String ADMINCHK1) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "update Member SET ID=?, NAME=?, PASSWD = ? , TEL =? , EMAIL =?, ADMINCHK =? Where ID=? and NAME=? and PASSWD = ? and TEL =? and EMAIL =? and ADMINCHK =?;";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(7, ID);
        pstmt.setString(8, NAME);
        pstmt.setString(9, PASSWD);
        pstmt.setString(10, TEL);
        pstmt.setString(11, EMAIL);
        pstmt.setString(12, ADMINCHK);
        pstmt.setString(1, ID1);
        pstmt.setString(2, NAME1);
        pstmt.setString(3, PASSWD1);
        pstmt.setString(4, TEL1);
        pstmt.setString(5, EMAIL1);
        pstmt.setString(6, ADMINCHK1);

        int r = pstmt.executeUpdate();

    }

    
}
