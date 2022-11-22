/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author dhkdw
 */
public class DBConnectInfo {
    private String jdbcDriver="jdbc:mysql://118.67.133.117:3306/RidingDB?serverTimezone=UTC";
    private String dbUser = "riding";
    private String dbPass = "1111";

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    
}
