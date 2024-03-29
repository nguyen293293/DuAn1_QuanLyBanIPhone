package com.shoptao.utilities;

import com.shoptao.services.ChungServices;
import com.shoptao.services.impl.KhachHangService;
import com.shoptao.services.impl.NhanVienService;
import com.shoptao.viewmodel.KhachHangViewModel;
import com.shoptao.services.impl.DongSanPhamService;
import com.shoptao.services.impl.ImeiService;
import com.shoptao.services.impl.KhachHangService;
import com.shoptao.services.impl.KhuyenMaiService;
import com.shoptao.services.impl.MauSacService;
import com.shoptao.services.impl.NhanVienService;
import com.shoptao.services.impl.SanPhamService;
import com.shoptao.viewmodel.DongSanPhamViewModle;
import com.shoptao.viewmodel.ImeiViewModel;
import com.shoptao.viewmodel.KhachHangViewModel;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import com.shoptao.viewmodel.MauSacViewModel;
import com.shoptao.viewmodel.NhanVienViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
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
        if (txtFiled.getDate() == null) {
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
    
        public static boolean checkString(JTextField filed) {
        try {
            Long so = Long.parseLong(filed.getText());
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
    
    public static boolean checkTrungMaKH(String ma){
        ChungServices<KhachHangViewModel> service = new KhachHangService();
        for (KhachHangViewModel x : service.getList()) {
            if(x.getMa().equals(ma)){
                DialogHelper.alert(null, "Mã khách hàng đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
   public static boolean checkTrungSP(String ten,String dungluong,String tendongsanpham , String tenmausac){
        ChungServices<SanPhamViewModle> service = new SanPhamService();
        for (SanPhamViewModle x : service.getList()) {
            if(x.getTen().equals(ten) && x.getTendongsanpham().equals(tendongsanpham) && x.getTenmausac().equals(tenmausac) && x.getDungluong().equals(dungluong)){
                DialogHelper.alert(null, " Sản phẩm đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    public static boolean checkTrungMaKM(String ma){
        ChungServices<KhuyenMaiViewModle> service = new KhuyenMaiService();
        for (KhuyenMaiViewModle x : service.getList()) {
            if(x.getMa().equals(ma)){
                DialogHelper.alert(null, "Mã khuyến mại đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungTenDSP(String ten){
        ChungServices<DongSanPhamViewModle> service = new DongSanPhamService();
        for (DongSanPhamViewModle x : service.getList()) {
            if(x.getTen().equals(ten)){
                DialogHelper.alert(null, "Dòng sản phẩm đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungTenMS(String ten){
        ChungServices<MauSacViewModel> service = new MauSacService();
        for (MauSacViewModel x : service.getList()) {
            if(x.getTen().equals(ten)){
                DialogHelper.alert(null, "Mã màu sắc đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
       public static boolean checkTrungTenKM(String ten){
        ChungServices<KhuyenMaiViewModle> service = new KhuyenMaiService();
        for (KhuyenMaiViewModle x : service.getList()) {
            if(x.getTen().equals(ten)){
                DialogHelper.alert(null, "Khuyến mại đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungMaIMEI(String ma){
        ChungServices<ImeiViewModel> service = new ImeiService();
        for (ImeiViewModel x : service.getList()) {
            if(x.getMaimei().equals(ma)){
                DialogHelper.alert(null, "Mã Imei đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungSDTNV(String sdt){
        ChungServices<NhanVienViewModel> service = new NhanVienService();
        for (NhanVienViewModel x : service.getList()) {
            if(x.getSdt().equals(sdt)){
                DialogHelper.alert(null, "Số điện thoại đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungSDTKH(String sdt){
        ChungServices<KhachHangViewModel> service = new KhachHangService();
        for (KhachHangViewModel x : service.getList()) {
            if(x.getSdt().equals(sdt)){
                DialogHelper.alert(null, "Số điện thoại đã tồn tại", "Lỗi!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkTrungEmail(String email){
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
