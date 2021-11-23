/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class HoaDonDAO implements HairSalonDAO<HoaDon, String>{
    String insert = "insert into hoadon values(?,?,?,?,?,?)";
    String update = "update hoadon set ngaylaphoadon=?,ngaythanhtoan=?,makhachhang=?,manhanvien=?,trangthai=? where mahoadon=?";
    String delete = "delete from hoadon where mahoadon=?";
    String select_by_id = "select * from hoadon where mahoadon=?";
    String select_all = "select * from hoadon";
    private ArrayList<HoaDon> selectBySQL(String sql , Object...args){
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                HoaDon model = new HoaDon();
                model.setMaHoaDon(rs.getString("mahoadon"));
                model.setNgayLapHoaDon(rs.getDate("ngaylaphoadon"));
                model.setNgayThanhToan(rs.getDate("ngaythanhtoan"));
                model.setMaKhachHang(rs.getString("makhachhang"));
                model.setMaNhanVien(rs.getString("manhanvien"));
                model.setTrangThai(rs.getBoolean("trangthai"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }
    
    
    
    
    
    public ArrayList<HoaDon> selectByKeyword(String keyword){
        String sql = "select * from hoadon where makhachhang LIKE ?";
        return selectBySQL(sql, "%"+keyword+"%");
    }
    @Override
    public void insert(HoaDon model) {
        try {
            JdbcHelper.executeUpdate(insert, model.getMaHoaDon(),model.getNgayLapHoaDon(),model.getNgayThanhToan(),
                    model.getMaKhachHang(),model.getMaNhanVien(),model.getTrangThai());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HoaDon model) {
        try {
            JdbcHelper.executeUpdate(update,model.getNgayLapHoaDon(),model.getNgayThanhToan(),
                    model.getMaKhachHang(),model.getMaNhanVien(),model.getTrangThai(), model.getMaHoaDon());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete, id);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HoaDon selectByID(String id) {
        ArrayList<HoaDon> list = new ArrayList<>();
        list= selectBySQL(select_by_id, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public ArrayList<HoaDon> selectAll() {
        return selectBySQL(select_all) ;
    }
    
    
}
