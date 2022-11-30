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
            if (rs.getString("chk").equals(0)) {
                user.setChk("미승인");
            } else {
                user.setChk("승인");
            }
        }
        users.add(user);

        return users;

    }

}
