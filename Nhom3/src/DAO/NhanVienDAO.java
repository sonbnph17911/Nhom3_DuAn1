/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class NhanVienDAO implements HairSalonDAO<NhanVien, String>{
    String insert = "insert into nhanvien values(?,?,?,?,?,?,?,?,?)";
    String update ="update nhanvien set matkhau=?,vaitro=?,hoten=?,"
            + " ngaysinh=?,ngaynhanviec=?,diachi=?,sodienthoai=?,ghichu=? where manhanvien=?";
    String delete = "delete from nhanvien where manhanvien=?";
    String select_by_id = "select * from nhanvien where manhanvien=?";
    String select_all = "select * from nhanvien ";
    
    private ArrayList<NhanVien> selectBySQL(String sql , Object...args){
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                NhanVien model = new NhanVien();
                model.setMaNhanVien(rs.getString("manhanvien"));
                model.setMatKhau(rs.getString("matkhau"));
                model.setVaiTro(rs.getBoolean("vaitro"));
                model.setHoTen(rs.getString("hoten"));
                model.setNgaySinh(rs.getDate("ngaysinh"));
                model.setNgayNhanVien(rs.getDate("ngaynhanviec"));
                model.setDiaChi(rs.getString("diachi"));
                model.setSoDienThoai(rs.getString("sodienthoai"));
                model.setGhiChu(rs.getString("ghiChu"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }
    public ArrayList<NhanVien> selectByKeyWord(String keyword){
        String sql = "select * from nhanvien where hoten LIKE ?";
        return selectBySQL(sql, "%"+keyword+"%");
    }
    @Override
    public void insert(NhanVien model) {
        try {
            JdbcHelper.executeUpdate(insert, model.getMaNhanVien(),model.getMatKhau(),model.isVaiTro(),
                    model.getHoTen(),model.getNgaySinh(),model.getNgayNhanVien(),
                    model.getDiaChi(),model.getSoDienThoai(),model.getGhiChu());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhanVien model) {
        try {
            JdbcHelper.executeUpdate(update,model.getMatKhau(),model.isVaiTro(),
                    model.getHoTen(),model.getNgaySinh(),model.getNgayNhanVien(),
                    model.getDiaChi(),model.getSoDienThoai(),model.getGhiChu(), model.getMaNhanVien());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete, id);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public NhanVien selectByID(String id) {
        ArrayList<NhanVien> list = new ArrayList<>();
        list = selectBySQL(select_by_id, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public ArrayList<NhanVien> selectAll() {
        return  selectBySQL(select_all);
    }
    
}
