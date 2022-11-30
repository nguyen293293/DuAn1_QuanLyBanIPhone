package com.shoptao.utilities;

import com.shoptao.services.ChungServices;
import com.shoptao.services.impl.KhachHangService;
import com.shoptao.services.impl.NhanVienService;
import com.shoptao.viewmodel.KhachHangViewModel;
import com.shoptao.viewmodel.NhanVienViewModel;
import java.awt.Component;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Validation {

    public static boolean checkisEmtty(Component parent, JTextField txtFiled, String messenger, String titel) {
        if (txtFiled.getText().isEmpty()) {
            DialogHelper.warring(parent, messenger, titel);
            txtFiled.setBorder(new LineBorder(Color.red));
            return false;
        }
        txtFiled.setBorder(new LineBorder(Color.green));
        return true;
    }

    public static boolean CheckTrongText(JTextField... txtFiled) {
        for (int i = 0; i < txtFiled.length; i++) {
            JTextField txt = txtFiled[i];
            if (txt.getText().isEmpty()) {
                DialogHelper.warring(null, "Không được để trống dữ liệu", "Lỗi");
                return false;
            }
        }
        return true;
    }

    public static boolean CheckTrongTextArea(JTextArea txtFiled) {
        if (txtFiled.getText().isEmpty()) {
            DialogHelper.warring(null, "Không được để trống dữ liệu", "Lỗi");
            return false;
        } else {
            return true;
        }

    }

    public static boolean CheckTrongJDate(JDateChooser txtFiled) {
        if (txtFiled.getDate().equals("")) {
            DialogHelper.warring(null, "Không được để trống dữ liệu", "Lỗi");
            return false;
        } else {
            return true;
        }

    }

    public static boolean CheckTrongLable(JLabel lblFiled) {
        if (lblFiled.getText().isEmpty()) {
            DialogHelper.warring(null, "Không được để trống dữ liệu", "Lỗi");
            return false;
        } else {
            return true;
        }

    }

    public static boolean checkPassTrong(JPasswordField pass) {
        if (pass.getPassword().equals("")) {
            DialogHelper.warring(null, "Không được để trống dữ liệu", "Lỗi!");
            pass.requestFocus();
            pass.requestFocus();
            pass.setBorder(new LineBorder(Color.red));
            return false;
        } else {
            pass.setBorder(new LineBorder(Color.green));
            return true;
        }
    }

    public static boolean CheckRePass(JPasswordField pass, JPasswordField repass) {
        if (pass.getPassword().equals(repass.getPassword())) {
            DialogHelper.warring(null, "Nhập lại! Mật khẩu không khớp", "Lỗi!");
            pass.requestFocus();
            pass.requestFocus();
            pass.setBorder(new LineBorder(Color.red));
            return false;
        } else {
            pass.setBorder(new LineBorder(Color.green));
            return true;
        }
    }

    public static boolean checkNumber(JPasswordField filed, String mess) {
        boolean checkl = true;
        try {
            double so = Double.parseDouble(filed.getText());
            if (so < 6) {
                DialogHelper.warring(null, mess, "Lỗi!");
                filed.requestFocus();
                filed.setBorder(new LineBorder(Color.red));
                checkl = false;
            } else {
                filed.setBorder(new LineBorder(Color.green));
                checkl = true;
            }
        } catch (Exception e) {
            DialogHelper.warring(null, "Sai định dạng", "Lỗi!!!");
            filed.setBorder(new LineBorder(Color.red));
            checkl = false;
        }
        return checkl;
    }

    public static boolean checkNumberSo(JTextField filed) {
        try {
            double so = Double.parseDouble(filed.getText());
            return true;
        } catch (Exception e) {
            DialogHelper.warring(null, "Nhập số", "Lỗi!!!");
            return false;
        }
    }

    public static boolean checkEmail(JTextField filed) {
        Pattern pt = Pattern.compile("\\w+@\\w+(\\.\\w+){1,2}");
        Matcher mt = pt.matcher(filed.getText());
        if (!mt.find()) {
            DialogHelper.warring(null, "Email không đúng định dạng", "Lỗi!");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkSoDT(JTextField filed) {
        Pattern pt = Pattern.compile("^0[3,9,8]\\d{8}");
        Matcher mt = pt.matcher(filed.getText());
        if (!mt.find()) {
            DialogHelper.warring(null, "SDT không đúng định dạng (10 số và bắt đầu 03, 08, 09)", "Lỗi!");
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean checkTrungMaNhanVien(String ma){
        ChungServices<NhanVienViewModel> service = new NhanVienService();
        for (NhanVienViewModel x : service.getList()) {
            if(x.getMa().equals(ma)){
                DialogHelper.alert(null, "Mã nhân viên đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungSDTNhanVien(String sdt){
        ChungServices<NhanVienViewModel> service = new NhanVienService();
        for (NhanVienViewModel x : service.getList()) {
            if(x.getSdt().equals(sdt)){
                DialogHelper.alert(null, "Số điện thoại đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungEmailNhanVien(String email){
        ChungServices<NhanVienViewModel> service = new NhanVienService();
        for (NhanVienViewModel x : service.getList()) {
            if(x.getEmail().equals(email)){
                DialogHelper.alert(null, "Email đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }

    public static boolean checkTrungMaKhachHang(String ma){
        ChungServices<KhachHangViewModel> service = new KhachHangService();
        for (KhachHangViewModel x : service.getList()) {
            if(x.getMa().equals(ma)){
                DialogHelper.alert(null, "Mã khách hàng đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungSDTKhachHang(String sdt){
        ChungServices<KhachHangViewModel> service = new KhachHangService();
        for (KhachHangViewModel x : service.getList()) {
            if(x.getSdt().equals(sdt)){
                DialogHelper.alert(null, "Số điện thoại đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
}
