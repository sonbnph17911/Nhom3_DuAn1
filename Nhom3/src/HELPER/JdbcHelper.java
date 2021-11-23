/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;
import java.sql.*;

/**
 *
 * @author DuongNVPH
 */
public class JdbcHelper {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    private static String url = "jdbc:sqlserver://localhost\\DESKTOP-IB717UB\\SQLEXPRESS:1433;databaseName=DuAnNhom3";
    private static String username = "sa";
    private static String password = "123";
    
    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static PreparedStatement prepareStatement(String sql , Object... args) throws SQLException{
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement pts = null ;
        try {
            if (sql.trim().startsWith("{")) {
             pts = con.prepareCall(sql);
        }else{
             pts = con.prepareStatement(sql);
        }
            System.out.println("----------"+sql);
        for (int i = 0; i < args.length; i++){
            System.out.println("------------"+args[i]+"------");
            pts.setObject(i+1,args[i]);
            
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pts ;
    }
    
    public static void executeUpdate(String sql ,Object... args) throws SQLException{
        PreparedStatement pts = JdbcHelper.prepareStatement(sql, args);
        try {
            try{
            pts.executeUpdate();
            }finally{
                pts.getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ResultSet executeQuery(String sql ,Object... args) throws SQLException{
        PreparedStatement pts = JdbcHelper.prepareStatement(sql, args);
        return pts.executeQuery();
    }
    
    
}
