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
        pstmt.setString(1,"%"+ gugunNm+"%");
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
}
