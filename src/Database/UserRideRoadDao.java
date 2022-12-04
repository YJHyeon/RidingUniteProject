/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.*;
import javax.naming.NamingException;
import java.util.*;

/**
 *
 * @author asde4
 */
public class UserRideRoadDao {

    public ArrayList<UserRideRoadObj> inquiry(String gugunNm) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<UserRideRoadObj> users = new ArrayList<UserRideRoadObj>();
        UserRideRoadObj user = null;
        String sql = "SELECT * FROM rideroad WHERE gugunNm like ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + gugunNm + "%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            user = new UserRideRoadObj();
            user.setGugunNm(rs.getString("gugunNm"));
            user.setStartSpot(rs.getString("startSpot"));
            user.setEndSpot(rs.getString("endSpot"));
            user.setTotal(rs.getString("total"));
            users.add(user);
        }

        return users;

    }

    public ArrayList<UserRideRoadObj> inquiry2(String gugunNm) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<UserRideRoadObj> users = new ArrayList<UserRideRoadObj>();
        UserRideRoadObj user = null;
        String sql = "SELECT * FROM rideroad";

        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            user = new UserRideRoadObj();
            user.setGugunNm(rs.getString("gugunNm"));
            user.setStartSpot(rs.getString("startSpot"));
            user.setEndSpot(rs.getString("endSpot"));
            user.setTotal(rs.getString("total"));
            users.add(user);
        }

        return users;

    }

    public int insertData(String gugunNm, String startSpot, String endSpot, String total) throws NamingException, SQLException, ClassNotFoundException {

        int result = 0;

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        //ResultSet rs = null;

        String sql = "insert into rideroad (gugunNm, startSpot, endSpot, total) values (?,?,?,?)";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, gugunNm);
        pstmt.setString(2, startSpot);
        pstmt.setString(3, endSpot);
        pstmt.setString(4, total);
        result = pstmt.executeUpdate();

        //rs.close();
        pstmt.close();
        DBConn.close();

        return result;
    }

    public void deleteData(String gugunNm, String startSpot, String endSpot, String total) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        //ResultSet rs = null;

        String sql = "DELETE FROM rideroad WHERE gugunNm=? AND startSpot=? AND endSpot = ? AND total =?;";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, gugunNm);
        pstmt.setString(2, startSpot);
        pstmt.setString(3, endSpot);
        pstmt.setString(4, total);

        //pstmt.setString(4, spot);
        int count = pstmt.executeUpdate();

        pstmt.close();
        DBConn.close();

    }

    public void updateData(String gugunNm, String startSpot, String endSpot, String total, String gugunNm2, String startSpot2, String endSpot2, String total2) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "update rideroad SET gugunNm =?, startSpot=? , endSpot = ? , total =?  WHERE gugunNm=? AND startSpot=? AND endSpot =? AND total =? ";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, gugunNm2);
        pstmt.setString(2, startSpot2);
        pstmt.setString(3, endSpot2);
        pstmt.setString(4, total2);
        pstmt.setString(5, gugunNm);
        pstmt.setString(6, startSpot);
        pstmt.setString(7, endSpot);
        pstmt.setString(8, total);

        //pstmt.setString(4, spot);
        int count = pstmt.executeUpdate();

    }

}
