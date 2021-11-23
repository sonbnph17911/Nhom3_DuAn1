/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.ChiTietHoaDon;
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
public class ChiTietHoaDonDAO implements HairSalonDAO<ChiTietHoaDon, Integer>{
    String insert = "insert into hoadonchitiet(giamgia,tongtien,thanhtien,mahoadon,madichvu) values(?,?,?,?,?)";
    String update = "update hoadonchitiet set giamgia=? ,tongtien=?,thanhtien=?,mahoadon=?,madichvu=? where machitiethoadon=?";
    String delete = "delete from hoadonchitiet where machitiethoadon=?";
    String select_by_id = "select * from hoadonchitiet where machitiethoadon=?";
    String select_all = "select * from hoadonchitiet";
    private ArrayList<ChiTietHoaDon> selectBySQL(String sql , Object...args){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                ChiTietHoaDon model = new ChiTietHoaDon();
                model.setMaChiTietHoaDon(rs.getInt("machitiethoadon"));
                model.setGiamGia(rs.getFloat("giamgia"));
                model.setTongTien(rs.getFloat("tongtien"));
                model.setThanhTien(rs.getFloat("thanhtien"));
                model.setMaHoaDon(rs.getString("mahoadon"));
                model.setMaDichVu(rs.getString("madichvu"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }
     
    public ArrayList<ChiTietHoaDon> xemChiTietHoaDon(String mahd){
        String sql = "select * from hoadonchitiet where mahoadon=?" ;
        return selectBySQL(sql,mahd);
    }
    @Override
    public void insert(ChiTietHoaDon model) {
        try {
            JdbcHelper.executeUpdate(insert, model.getGiamGia(),model.getTongTien(),model.getThanhTien(),
                    model.getMaHoaDon(),model.getMaDichVu());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ChiTietHoaDon model) {
        try {
            JdbcHelper.executeUpdate(update, model.getGiamGia(),model.getTongTien(),model.getThanhTien(),
                    model.getMaHoaDon(),model.getMaDichVu(),model.getMaChiTietHoaDon());

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            JdbcHelper.executeUpdate(delete, id);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ChiTietHoaDon selectByID(Integer id) {
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        list = selectBySQL(select_by_id, id);
        return list.isEmpty() ? null : list.get(0) ;
    }

    @Override
    public ArrayList<ChiTietHoaDon> selectAll() {
        return selectBySQL(select_all);
    }

    
}
