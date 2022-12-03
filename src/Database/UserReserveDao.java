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
 * @author asde4
 */
public class UserReserveDao {

    public ArrayList<UserReserveObj> inquiry(String id) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<UserReserveObj> users = new ArrayList<UserReserveObj>();
        UserReserveObj user = null;
        String sql = "SELECT * FROM RidingReservation WHERE ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            user = new UserReserveObj();
            user.setId(rs.getString("id"));
            user.setGugun(rs.getString("gugun"));
            user.setStart(rs.getString("start"));
            user.setEnd(rs.getString("end"));
            user.setNumber(rs.getString("number"));
            user.setDate(rs.getString("date"));
            if (rs.getString("chk").equals("0")) {
                user.setChk("미승인");
            } else if (rs.getString("chk").equals("1")) {
                user.setChk("승인");
            }
            users.add(user);
        }

        rs.close();
        pstmt.close();
        DBConn.close();

        return users;

    }

    public void reserve2(String id, String gugun, String start, String end, String number, String date) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        //ResultSet rs = null;

        String sql = "INSERT INTO RidingReservation(ID, Gugun, Start, End, Number, Date, CHK) VALUES(?, ?, ?, ?, ? ,? , 0)";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);
        pstmt.setString(2, gugun);
        pstmt.setString(3, start);
        pstmt.setString(4, end);
        pstmt.setString(5, number);
        pstmt.setString(6, date);

        int r = pstmt.executeUpdate();

        //rs.close();
        pstmt.close();
        DBConn.close();
    }

}
