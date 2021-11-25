/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWING;

import DAO.LichDatDAO;
import HELPER.DateHelper;
import HELPER.DialogHelper;
import HELPER.ShareHelper;
import MODEL.LichDat;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author levan
 */
public class DatLich extends javax.swing.JPanel {

    /**
     * Creates new form DatLich
     */
    public DatLich() {
        initComponents();
        load();
    }
    int index=0;
    LichDatDAO dao=new LichDatDAO();
    
    void load(){
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        ArrayList<LichDat> list = dao.selectAll();
        try {
            
             for(LichDat l:list){
            Object[] row={
                l.getMaLichDat(),
                DateHelper.toString(l.getNgayBatDau()),
                DateHelper.toString(l.getNgayKeyThuc()),
                l.getGhiChu(),
                l.getMaKhachHang(),
                l.getMaNhanVien(),
            };
            model.addRow(row);
        }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
       
    }
    public void setTrang() {
        txtMadatlich.setBackground(white);
        txtNgaybatdau.setBackground(white);
        txtNgayketthuc.setBackground(white);
        txtGhichu.setBackground(white);
        txtMakhachhang.setBackground(white);
         txtManhanvien.setBackground(white);
    }
    void clear() {
        setTrang();
        LichDat model = new LichDat();
        model.setMaNhanVien(ShareHelper.user.getMaNhanVien());
        
        this.setModel(model);
        setStatus(true);
    }
    void setModel(LichDat model) {
        txtMadatlich.setText(String.valueOf(model.getMaLichDat()));
        txtNgaybatdau.setText(DateHelper.toString(model.getNgayBatDau()));
        txtNgayketthuc.setText(DateHelper.toString(model.getNgayKeyThuc()));
         txtGhichu.setText(model.getGhiChu());
        txtMakhachhang.setText(model.getMaKhachHang());
        txtManhanvien.setText(model.getMaNhanVien());
    }
    LichDat getModel() {
        LichDat model = new LichDat();
        model.setMaLichDat(Integer.valueOf(model.getMaLichDat()));
        model.setNgayBatDau(DateHelper.toDate(txtNgaybatdau.getText()));
        model.setNgayKeyThuc(DateHelper.toDate(txtNgayketthuc.getText()));
        model.setGhiChu(txtGhichu.getText());
        model.setMaKhachHang(txtMakhachhang.getText());
        model.setMaNhanVien(txtManhanvien.getText());
        return model;
    }
     void setStatus(boolean insertable) {
        txtMadatlich.setEditable(insertable);
        btnDatlich.setEnabled(insertable);
        btnHuylich.setEnabled(!insertable);
        btnDoilich.setEnabled(!insertable);
     }
     void update() {
        LichDat model = getModel(); //lấy thông tin form gán cho đt nguoiHoc
        try {
            dao.update(model);   //chỉnh sửa bản ghi theo tt từ nguoiHoc 
            this.load();         //đổ tt mới từ CSDL vào bảng
            DialogHelper.alert(this, "Đổi lịch thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Đổi lịch thất bại!");
            e.printStackTrace();
        }
     }
     void delete() {
        if (DialogHelper.confirm(this, "Bạn có muốn hủy lịch không?")) {
            int viTri = tb.getSelectedRow();
            if (viTri ==-1 ) {
                return ;
            }
             int manh = (int) tb.getValueAt(viTri, 0);
            try {
                dao.delete(manh);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Hủy thành công!");
            } catch (HeadlessException e) {
                DialogHelper.alert(this, "Hủy thất bại!");
            }
        }}
        
     void insert() {
        LichDat model = getModel();   //lấy thông tin trên form gán cho đt nguoiHoc
        try {
            dao.insert(model);    //thêm bản ghi mới vào CSDL theo tt từ nguoiHoc
            this.load();            //đổ thông tin mới vào bảng
            this.clear();           //xóa trằng form và vẫn để ở chế độ insertable
            DialogHelper.alert(this, "Đặt lịch thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Đặt lịch thất bại!");
        }
    }
      public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            DialogHelper.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
    public static boolean checkMoTaCD(JTextArea txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,255}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " phải từ 3-255 kí tự.");
            return false;
        }}
     void edit() {
        setTrang();
        try {
            int manh = (int) tb.getValueAt(this.index, 0); 
            LichDat model = dao.selectByID(manh);    
            if (model != null) {
                this.setModel(model);   
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
     public static boolean isValidDate(String inDate) {

        if (inDate == null) {
            return false;
        }

        //set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }

        dateFormat.setLenient(false);

        try {
            //parse the inDate parameter
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
     public static boolean checkDate(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
//        String rgx = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//        if (id.matches(rgx)) {
//            return true;
//        } else {
//            txt.setBackground(pink);
//            dialogHelper.alert(txt.getRootPane(), txt.getName() + " không đúng định dạng Date.");
//            return false;
//        }
        if (isValidDate(id)) {
            return true;
        } else {
            txt.setBackground(pink);
            DialogHelper.alert(txt.getRootPane(), txt.getName() + " không đúng định dạng dd/MM/yyyy");
            return false;
        }
    }
    public boolean checkTrungMa(JTextField txt) {
        txt.setBackground(white);
        if (dao.selectByID(Integer.valueOf(txt.getText())) == null) {
            return true;
        } else {
            txt.setBackground(pink);
            DialogHelper.alert(this, txt.getName() + " đã bị tồn tại.");
            return false;
        }
    }
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {                                         
        // TODO add your handling code here:
        this.load();
        this.setStatus(true);
    }  
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMadatlich = new javax.swing.JTextField();
        txtNgaybatdau = new javax.swing.JTextField();
        txtNgayketthuc = new javax.swing.JTextField();
        txtGhichu = new javax.swing.JTextField();
        txtMakhachhang = new javax.swing.JTextField();
        txtManhanvien = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnDatlich = new javax.swing.JButton();
        btnDoilich = new javax.swing.JButton();
        btnHuylich = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("QUẢN LÝ ĐẶT LỊCH");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 11, 233, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã Đặt Lịch");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Ngày Bắt ĐẦU");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, 34));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Ngày Kết Thúc");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Ghi Chú");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Mã Khách Hàng");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Mã Nhân Viên");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));
        add(txtMadatlich, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 303, 40));

        txtNgaybatdau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaybatdauActionPerformed(evt);
            }
        });
        add(txtNgaybatdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 303, 40));
        add(txtNgayketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 303, 40));
        add(txtGhichu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 303, 40));
        add(txtMakhachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 303, 40));
        add(txtManhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 303, 40));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, 1340, 10));

        tb.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "TT", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Ghi Chú", "Mã Khách Hàng", " Mã Nhân Viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);
        if (tb.getColumnModel().getColumnCount() > 0) {
            tb.getColumnModel().getColumn(0).setResizable(false);
            tb.getColumnModel().getColumn(1).setResizable(false);
            tb.getColumnModel().getColumn(2).setResizable(false);
            tb.getColumnModel().getColumn(3).setResizable(false);
            tb.getColumnModel().getColumn(5).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 322, 1340, 370));

        jPanel1.setLayout(new java.awt.GridLayout(1, 1));

        btnDatlich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Add.png"))); // NOI18N
        btnDatlich.setText("ĐẶT LỊCH");
        btnDatlich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatlichActionPerformed(evt);
            }
        });
        jPanel1.add(btnDatlich);

        btnDoilich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Notes.png"))); // NOI18N
        btnDoilich.setText("ĐỔI LỊCH");
        btnDoilich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoilichActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoilich);

        btnHuylich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Delete.png"))); // NOI18N
        btnHuylich.setText("HỦY LỊCH");
        btnHuylich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuylichActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuylich);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Refresh.png"))); // NOI18N
        jButton1.setText("TẠO MỚI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 470, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaybatdauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaybatdauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaybatdauActionPerformed

    private void btnDatlichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatlichActionPerformed
        if (checkNullText(txtMadatlich)
                && checkNullText(txtNgaybatdau)
                 &&checkNullText(txtNgayketthuc)
                && checkNullText(txtGhichu)
                && checkNullText(txtMakhachhang)
                && checkNullText(txtManhanvien) ) {
            if(checkDate(txtNgaybatdau)
                &&checkDate(txtNgayketthuc))
            {
                if (checkTrungMa(txtMadatlich)) {                  
                        insert();                   
                }
            }
        }
    }//GEN-LAST:event_btnDatlichActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        if (evt.getClickCount() == 2) {
            this.index = tb.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            if (this.index >= 0) {
                this.edit();
            }
        }

    }//GEN-LAST:event_tbMouseClicked

    private void btnDoilichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoilichActionPerformed
        if (checkNullText(txtMadatlich)
                && checkNullText(txtNgaybatdau)
                && checkNullText(txtNgayketthuc)
                && checkNullText(txtGhichu)
                && checkNullText(txtMakhachhang)
                && checkNullText(txtManhanvien) ) {
            if(checkDate(txtNgaybatdau)
               &&checkDate(txtNgayketthuc))
            {
                if (checkTrungMa(txtMadatlich)) {                  
                        update();                   
                }
            }
        }

    }//GEN-LAST:event_btnDoilichActionPerformed

    private void btnHuylichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuylichActionPerformed
        delete();
    }//GEN-LAST:event_btnHuylichActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatlich;
    private javax.swing.JButton btnDoilich;
    private javax.swing.JButton btnHuylich;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txtGhichu;
    private javax.swing.JTextField txtMadatlich;
    private javax.swing.JTextField txtMakhachhang;
    private javax.swing.JTextField txtManhanvien;
    private javax.swing.JTextField txtNgaybatdau;
    private javax.swing.JTextField txtNgayketthuc;
    // End of variables declaration//GEN-END:variables

   }
