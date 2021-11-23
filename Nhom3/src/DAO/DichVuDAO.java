/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.DichVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class DichVuDAO implements HairSalonDAO<DichVu, String>{
    String insert = "insert into dichvu values(?,?,?)";
    String update = "update dichvu set tendichvu=?,giatien=? where madichvu=?";
    String delete = "delete from dichvu where madichvu=?";
    String select_by_id = "select * from dichvu where madichvu=?";
    String select_all = "select * from dichvu";
    private ArrayList<DichVu> selectBySQL(String sql , Object...args){
        ArrayList<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                DichVu model = new DichVu();
                model.setMaDichVu(rs.getString("madichvu"));
                model.setTenDichVu(rs.getString("tendichvu"));
                model.setGiaTien(rs.getFloat("giatien"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }
    
    
    @Override
    public void insert(DichVu model) {
        try {
            JdbcHelper.executeUpdate(insert, model.getMaDichVu(),model.getTenDichVu(),model.getGiaTien());
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DichVu model) {
        try {
            JdbcHelper.executeUpdate(update, model.getTenDichVu(),model.getGiaTien(),model.getMaDichVu());
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete, id);
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DichVu selectByID(String id) {
        ArrayList<DichVu> list = new ArrayList<>();
        list = selectBySQL(select_by_id, id);
           return list.isEmpty() ? null : list.get(0) ;
    }

    @Override
    public ArrayList<DichVu> selectAll() {
        return selectBySQL(select_all) ;
    }
    
}
