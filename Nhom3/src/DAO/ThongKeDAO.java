/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DuongNVPH
 */
public class ThongKeDAO {
    private ArrayList<Object[]> getListOfArray(String sql ,String[] cols,Object... args){
        try {
            ArrayList<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }
    
    public ArrayList<Object[]> getThongKeDatLich(Integer nam){
        String sql = "{CALL sp_thongkelichdattheonam (?)}";
        String[] cols = {"lichdat","nhanvien"};
        return this.getListOfArray(sql, cols, nam);
    }
    
    
}
