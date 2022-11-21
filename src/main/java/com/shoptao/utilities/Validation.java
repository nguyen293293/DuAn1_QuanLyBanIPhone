package com.shoptao.utilities;

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
        int count = 0;
        for (int i = 0; i < txtFiled.length; i++) {
            JTextField txt = txtFiled[i];
            if (txt.getText().isEmpty()) {
                count++;
            }
        }
        if (count != 0) {
            DialogHelper.warring(null, "Không được để trống dữ liệu", "Lỗi");
            return false;
        }else{
            return true;
        }
    }

    public static boolean CheckTrongTextArea(JTextArea txtFiled) {
        if (txtFiled.getText().isEmpty()) {
            DialogHelper.warring(null, "Không được để trống dữ liệu", "Lỗi");
            txtFiled.requestFocus();
            txtFiled.setBorder(new LineBorder(Color.red));
            return false;
        } else {
            txtFiled.setBorder(new LineBorder(Color.green));
            return true;
        }

    }

    public static boolean CheckTrongJDate(JDateChooser txtFiled) {
        if (txtFiled.getDate().equals("")) {
            DialogHelper.warring(null, "Không được để trống dữu liệu", "Lỗi");
            txtFiled.requestFocus();
            txtFiled.setBorder(new LineBorder(Color.red));
            return false;
        } else {
            txtFiled.setBorder(new LineBorder(Color.green));
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
            DialogHelper.warring(filed, "Sai định dạng", "Lỗi!!!");
            filed.setBorder(new LineBorder(Color.red));
            checkl = false;
        }
        return checkl;
    }

    public static boolean checkNumberSo(JTextField filed, int so2, String mess) {
        boolean checkl = true;
        try {
            double so = Double.parseDouble(filed.getText());
            so2 = 0;
            if (so < 0 || so > so2) {
                DialogHelper.warring(null, mess, "Lỗi!");
                filed.requestFocus();
                filed.setBorder(new LineBorder(Color.red));
                checkl = false;
            } else {
                filed.setBorder(new LineBorder(Color.green));
                checkl = true;
            }
        } catch (Exception e) {
            DialogHelper.warring(filed, "Sai định dạng", "Lỗi!!!");
            filed.setBorder(new LineBorder(Color.red));
            checkl = false;
        }
        return checkl;
    }

    public static boolean checkEmail(JTextField filed) {
        boolean flag = true;
        Pattern pt = Pattern.compile("\\w+@\\w+(\\.\\w+){1,2}");
        Matcher mt = pt.matcher(filed.getText());
        if (!mt.find()) {
            DialogHelper.warring(null, "Email không đúng định dạng", "Lỗi!");
            filed.requestFocus();
            filed.setBorder(new LineBorder(Color.red));
            flag = false;
        } else {
            filed.setBorder(new LineBorder(Color.green));
            flag = true;
        }
        return flag;
    }
//   public static boolean checkDate( JTextField txtString){
//       boolean flag = true;
//       try {
//           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//           String fmadate = sdf.format(sdf.parse(txtString.getText()));
//           if(fmadate.equals(txtString.getText())){
//               flag = true;
//               txtString.setBorder(new LineBorder(Color.white));
//           }else{
//               DialogHelper.warring(null, "Dữ liệu không đúng định dạng", "Lỗi!");
//               txtString.requestFocus();
//               txtString.setBorder(new LineBorder(Color.red));
//               flag = false;
//           }
//       } catch (Exception e) {
//            DialogHelper.warring(null, "Dữ liệu không đúng định dạng", "Lỗi!");
//               txtString.setBorder(new LineBorder(Color.red));
//               flag = false;
//       }
//       return flag;
//   }

    public static boolean checkSoDT(JTextField filed) {
        Pattern pt = Pattern.compile("^0[3,9,8]\\d{8}");
        Matcher mt = pt.matcher(filed.getText());
        boolean flag = true;
        if (!mt.find()) {
            DialogHelper.warring(null, "SDT không đúng định dạng (10 số và bắt đầu 03, 08, 09)", "Lỗi!");
            filed.requestFocus();
            filed.setBorder(new LineBorder(Color.red));
            flag = false;
        } else {
            filed.setBorder(new LineBorder(Color.green));
            flag = true;
        }
        return flag;
    }

    public static boolean checkNumber1(Component parent, JTextField filed, String messenger, String titel) {
        boolean checkl = true;
        try {
            double so = Double.parseDouble(filed.getText());
            if (so < 0) {
                DialogHelper.warring(parent, messenger, titel);
                filed.setBorder(new LineBorder(Color.red));
                checkl = false;
            } else {
                filed.setBorder(new LineBorder(Color.green));
                checkl = true;
            }
        } catch (Exception e) {
            DialogHelper.warring(filed, "Giá phải là số!!", "Lỗi!!!");
            filed.setBorder(new LineBorder(Color.red));
            checkl = false;
        }
        return checkl;
    }

//    public static boolean checkTrungSDTNV(String sdt) {
//        UserDAO dao = new UserDAO();
//        List<UserModel> list = dao.select();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getSdt().trim().equals(sdt)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public static boolean checkTrungEmailNV(String email) {
//        UserDAO dao = new UserDAO();
//        List<UserModel> list = dao.select();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getEmail().trim().equals(email)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
