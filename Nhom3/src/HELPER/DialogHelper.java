/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author DuongNVPH
 */
public class DialogHelper {
    public static void alert(Component parent , String message){
        JOptionPane.showMessageDialog(parent, message,"Hair Salon",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean confirm(Component parent ,String message){
        int result = JOptionPane.showConfirmDialog(parent, message,"Hair Salon",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (result == 0) {
            return  result == JOptionPane.YES_OPTION ;
        }
            return result == JOptionPane.NO_OPTION;  
        
    }
    
    public static String prompt(Component parent ,String mesage){
        String result = JOptionPane.showInputDialog(parent,mesage,"Hair Salon",JOptionPane.INFORMATION_MESSAGE);
        return result ;
    }
    
}
