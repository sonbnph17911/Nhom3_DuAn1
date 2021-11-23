/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

import MODEL.NhanVien;


/**
 *
 * @author DuongNVPH
 */
public class ShareHelper {
    public static NhanVien user = null ;
    
    public static void clear(){
        ShareHelper.user = null ;
    }
    
    public static boolean isLogin(){
        return ShareHelper.user != null ;
    }
    
    public static boolean isManager(){
        return ShareHelper.isLogin() && user.isVaiTro();
    }
}
