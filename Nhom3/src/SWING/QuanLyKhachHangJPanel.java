/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWING;

import DAO.KhachHangDAO;
import HELPER.DialogHelper;
import MODEL.KhachHang;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DuongNVPH
 */
public class QuanLyKhachHangJPanel extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyKhachHangJPanel
     */
    public QuanLyKhachHangJPanel() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtDiachi = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mã Khách hàng");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 11, -1, -1));
        jPanel1.add(txtMaKh, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 32, 290, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Ghi Chú");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 300, 90));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Điện Thoại");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        txtDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienThoaiActionPerformed(evt);
            }
        });
        jPanel1.add(txtDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Họ Và Tên");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 290, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Địa Chỉ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("Email");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 300, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Giới Tính");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        jPanel1.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoNu.setText("Nữ");
        jPanel1.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));
        jPanel1.add(txtDiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 300, 30));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel6.setToolTipText("");

        txtTimKiem.setToolTipText("");
        txtTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnTimKiem.setText("Tìm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtTimKiem))
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 650, 80));

        tblKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Kh", "Họ Tên", "Giới Tính", "Địa Chỉ", "Điện Thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 970, 430));

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa);

        btnMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        jPanel2.add(btnMoi);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 260, 130));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 691));
    }// </editor-fold>//GEN-END:initComponents

    private void txtDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDienThoaiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
            insert();
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
            update();
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timkiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblKhachHang.rowAtPoint(evt.getPoint());
            if (this.row >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKh;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    
    KhachHangDAO dao = new KhachHangDAO();
    int row = -1 ;
    

    private void timkiem() {
        this.fillTable();
        this.clearForm();
        this.row = -1;
        this.updateStatus();
    }

    void init() {
        this.fillTable();
        this.row = -1;
        this.updateStatus();
    }

    void insert() {
        if (checkKey() == 1) {
            KhachHang khachHang = getForm();
        if (khachHang == null) {
            return ;
        }
        try {
            dao.insert(khachHang);
            this.fillTable();
            this.clearForm();
            DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm mới thất bại!" + e);
        }
        }else{
            DialogHelper.alert(this, "Trùng mã khách hàng");
            return;
        }

    }

    void update() {
        KhachHang khachHang = getForm();
        if (khachHang == null) {
            return ;
        }
        try {
            dao.update(khachHang);
            this.fillTable();
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Cập nhật thất bại!");
        }

    }

    void delete() {

        String maKhachHang = txtMaKh.getText();
        if (DialogHelper.confirm(this, "Bạn có thực sự muốn xóa người học này?")) {
            try {
                dao.delete(maKhachHang);
                this.fillTable();
                this.clearForm();
                DialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thát bại!");
            }
        }

    }

    void clearForm() {
        KhachHang khachHang = new KhachHang();
        this.setForm(khachHang);
        this.row = -1;
        this.updateStatus();
    }

    void edit() {
        String maKhachHang = (String) tblKhachHang.getValueAt(this.row, 0);
        KhachHang nh = dao.selectByID(maKhachHang);
        if (nh != null) {
            this.setForm(nh);
            this.updateStatus();
        }
    }


    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0); // xoa tat ca cac hang
        try {
            String keyword = txtTimKiem.getText();
            ArrayList<KhachHang> list = dao.selectByKeyword(keyword); //truy vấn người học có tên chứa từ khóa tìm kiếm
            for (KhachHang khachHang : list) {
                Object[] row = {
                    khachHang.getMaKhachHang(),
                    khachHang.getHoTen(),
                    khachHang.getGioiTinh() ? "Nam" : "Nữ",
                    khachHang.getDiaChi(),
                    khachHang.getSoDienThoai(),
                    khachHang.getEmail()
                };
                model.addRow(row); //them 1 hang vao table
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setForm(KhachHang khachHang) {
        txtMaKh.setText(khachHang.getMaKhachHang());
        txtHoTen.setText(khachHang.getHoTen());
        rdoNam.setSelected(khachHang.getGioiTinh());
        rdoNu.setSelected(!khachHang.getGioiTinh());
        txtDiachi.setText(khachHang.getDiaChi());
        txtDienThoai.setText(khachHang.getSoDienThoai());
        txtEmail.setText(khachHang.getEmail());
        txtGhiChu.setText(khachHang.getGhiChu());
    }

    KhachHang getForm() {
        KhachHang khachHang = new KhachHang();
        if (txtMaKh.getText().length() == 0) {
            DialogHelper.alert(this, "Không được phép để trống mã KH!");
            txtMaKh.requestFocus();
            return null;
        }  else if (txtHoTen.getText().length() == 0) {
            DialogHelper.alert(this, "Không được phép để trống họ tên!");
            txtHoTen.requestFocus();
            return null;
        } else if (txtDiachi.getText().length() == 0) {
            DialogHelper.alert(this, "Không được phép để trống địa chỉ!");
            txtDiachi.requestFocus();
            return null;
        } else if (txtDienThoai.getText().length() == 0) {
            DialogHelper.alert(this, "Không được để trống số điện thoại!");
            txtDienThoai.requestFocus();
            return null;
        } else if (!txtDienThoai.getText().matches("((84)|(0))\\d{9}")) {
            DialogHelper.alert(this, "Không đúng định dạng số điện thoại!");
            txtDienThoai.requestFocus();
            return null;
        } else if (txtEmail.getText().length() == 0) {
            DialogHelper.alert(this, "Bạn chưa nhập Email!");
            txtEmail.requestFocus();
            return null;
        } else if (!txtEmail.getText().matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            DialogHelper.alert(this, "Email không đúng định dạng!");
            txtEmail.requestFocus();
            return null;
        }
        
        khachHang.setMaKhachHang(txtMaKh.getText());
        khachHang.setHoTen(txtHoTen.getText());
        khachHang.setGioiTinh(rdoNam.isSelected());
        khachHang.setDiaChi(txtDiachi.getText());
        khachHang.setSoDienThoai(txtDienThoai.getText());
        khachHang.setEmail(txtEmail.getText());
        khachHang.setGhiChu(txtGhiChu.getText());
        return khachHang;
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblKhachHang.getRowCount() - 1);
        //Trang thai form
        txtMaKh.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
;
    }
    
    

    private int checkKey(){
        int kt = 1;
        ArrayList<KhachHang> list = dao.selectAll();    
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaKhachHang().equals(txtMaKh.getText().trim())) {
                kt = 0 ;
                break ;
            }
        }
        return kt ;
    }



}
