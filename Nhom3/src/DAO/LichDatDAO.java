/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.LichDat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class LichDatDAO implements HairSalonDAO<LichDat, Integer>{
    String insert = "insert into lichdat(ngaybatdau,ngayketthuc,ghichu,makhachhang,manhanvien) values(?,?,?,?,?)";
    String update = "update lichdat set ngaybatdau=?,ngayketthuc=?,ghichu=?,makhachhang=?,manhanvien=? where malichdat=?";
    String delete = "delete from lichdat where malichdat=?";
    String select_by_id = "select * from lichdat where malichdat=?";
    String select_all = "select * from lichdat";
    
    public ArrayList<Integer> selectYears(){
        String sql = "select  distinct year(ngaybatdau) from lichdat order by year(ngaybatdau) desc ";
        ArrayList<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while(rs.next()){
                Integer nam = rs.getInt(1);
                list.add(nam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list ;
    }
    
    
    private ArrayList<LichDat> selectBySQL(String sql , Object...args){
        ArrayList<LichDat> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                LichDat model = new LichDat();
                model.setMaLichDat(rs.getInt("malichdat"));
                model.setNgayBatDau(rs.getDate("ngaybatdau"));
                model.setNgayKeyThuc(rs.getDate("ngayketthuc"));
                model.setGhiChu(rs.getString("ghichu"));
                model.setMaKhachHang(rs.getString("makhachhang"));
                model.setMaNhanVien(rs.getString("manhanvien"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }

    @Override
    public void insert(LichDat model) {
        try {
            JdbcHelper.executeUpdate(insert, model.getNgayBatDau(),model.getNgayKeyThuc()
                    ,model.getGhiChu(),model.getMaKhachHang(),model.getMaNhanVien());
        } catch (SQLException ex) {
            Logger.getLogger(LichDatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(LichDat model) {
        try {
            JdbcHelper.executeUpdate(update, model.getNgayBatDau(),model.getNgayKeyThuc()
                    ,model.getGhiChu(),model.getMaKhachHang(),model.getMaNhanVien(),model.getMaLichDat());
        } catch (SQLException ex) {
            Logger.getLogger(LichDatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            JdbcHelper.executeUpdate(delete, id);
        } catch (SQLException ex) {
            Logger.getLogger(LichDatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public LichDat selectByID(Integer id) {
        ArrayList<LichDat> list = new ArrayList<>();
        list = selectBySQL(select_by_id, id);
        return list.isEmpty() ? null : list.get(0) ;
    }

    @Override
    public ArrayList<LichDat> selectAll() {
        return selectBySQL(select_all);
    }
}
