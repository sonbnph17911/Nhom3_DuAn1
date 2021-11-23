/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author DuongNVPH
 */
public class DichVu {
    private String maDichVu;
    private String tenDichVu;
    private float giaTien ;

    public DichVu() {
    }

    public DichVu(String maDichVu, String tenDichVu, float giaTien) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.giaTien = giaTien;
    }

    

    

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    

    
    
    
}
