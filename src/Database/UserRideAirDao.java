/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RideAir;

import Database.DBConn;
import java.sql.*;
import javax.naming.NamingException;
import java.util.*;
/**
 *
 * @author pc
 */
public class UserRideAirDao {
        public ArrayList<UserRideAirObj> Air(String gugun) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<UserRideAirObj> users = new ArrayList<UserRideAirObj>();
        UserRideAirObj user = null;
        String sql = "SELECT * FROM Rideair WHERE gugun like ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"%"+ gugun+"%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            user = new UserRideAirObj();
            user.setGugun(rs.getString("gugun"));
            user.setPumpGubun(rs.getString("pumpGubun"));
            user.setPumpCnt(rs.getString("pumpCnt"));
            user.setSpot(rs.getString("spot"));
            users.add(user);
        }

        return users;

    }
    public int insertData(String gugun, String pumpGubun, String pumpCnt, String spot) throws NamingException, SQLException, ClassNotFoundException {

        int result = 0;

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        //ResultSet rs = null;

        String sql = "insert into RideAir (gugun, pumpGubun, pumpCnt, spot) values (?,?,?,?)";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, gugun);
        pstmt.setString(2, pumpGubun);
        pstmt.setString(3, pumpCnt);
        pstmt.setString(4, spot);
        result = pstmt.executeUpdate();

        //rs.close();
        pstmt.close();
        DBConn.close();

        return result;
    }
    
}

