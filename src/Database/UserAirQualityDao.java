/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import AirQulity.UserAirQualityObj;
import java.sql.*;
import javax.naming.NamingException;
import java.util.*;
/**
 *
 * @author kiano
 */
public class UserAirQualityDao {
    public ArrayList<UserAirQualityObj> AirQuality(String site) throws NamingException, SQLException, ClassNotFoundException {

        Connection conn = DBConn.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<UserAirQualityObj> users = new ArrayList<UserAirQualityObj>();
        UserAirQualityObj user = null;
        String sql = "SELECT * FROM RideAirquality WHERE site = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,site);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            user = new UserAirQualityObj();
            user.setSite(rs.getString("site"));
            user.setControlnumber(rs.getString("controlnumber"));
            user.setPm10(rs.getString("pm10"));
            user.setPm25(rs.getString("pm25"));
            users.add(user);
        }

        return users;

    }
}
