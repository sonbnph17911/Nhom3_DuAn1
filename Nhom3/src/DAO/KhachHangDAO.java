/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class KhachHangDAO implements HairSalonDAO<KhachHang, String>{
    String insert = "insert into khachhang values(?,?,?,?,?,?,?)";
    String update = "update khachhang set hoten=?,sodienthoai=?,email=?,gioitinh=? ,diachi=?"
            + " ,ghichu = ? where makhachhang=?";
    String delete = "delete from khachhang where makhachhang=?";
    String select_by_id = "select * from khachhang where makhachhang=?";
    String select_all = "select * from khachhang";

    
    private ArrayList<KhachHang> selectBySQL(String sql , Object...args){
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                KhachHang model = new KhachHang();
                model.setMaKhachHang(rs.getString("makhachhang"));
                model.setHoTen(rs.getString("hoten"));
                model.setSoDienThoai(rs.getString("sodienthoai"));
                model.setEmail(rs.getString("email"));
                model.setGioiTinh(rs.getBoolean("gioitinh"));
                model.setDiaChi(rs.getString("diachi"));
                model.setGhiChu(rs.getString("ghichu"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }
    public ArrayList<KhachHang> selectByKeyword(String keyword){
        String sql = "SELECT * FROM KhachHang WHERE HoTen LIKE ?";
        return this.selectBySQL(sql, "%" + keyword + "%");
    }

    @Override
    public void insert(KhachHang model) {
        try {
            JdbcHelper.executeUpdate(insert, model.getMaKhachHang(),model.getHoTen(),model.getSoDienThoai(),model.getEmail()
                    ,model.getGioiTinh(),model.getDiaChi(),model.getGhiChu());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhachHang model) {
      try {
            JdbcHelper.executeUpdate(update,model.getHoTen(),model.getSoDienThoai(),model.getEmail()
                    ,model.getGioiTinh(),model.getDiaChi(),model.getGhiChu(), model.getMaKhachHang());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete,id);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public KhachHang selectByID(String id) {
        ArrayList<KhachHang> list = new ArrayList<>();
        list = selectBySQL(select_by_id, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        return selectBySQL(select_all) ;
    }
    
    
}
