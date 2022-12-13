package com.shoptao.utilities;

import com.shoptao.domainmodel.NhanVien;
import com.shoptao.repositories.NhanVienRepository;

/**
 *
 * @author nguyen293
 */
public class LoginHelper {

    public static boolean checkLogin(String maNhanVien, String matKhau) {
        NhanVienRepository repository = new NhanVienRepository();
        for (NhanVien nv : repository.getList()) {
            if (nv.getMa().equals(maNhanVien) && nv.getMatkhau().equals(matKhau)) {
                if (nv.getTrangthai() == 1) {
                    DialogHelper.alert(null, "Nhân viên đã nghỉ làm", "Login error");
                    return false;
                }
                UserHelper.USER = nv;
                return true;
            }
        }
        DialogHelper.alert(null, "Sai tên đăng nhập hoặc mât khẩu", "Login error");
        return false;
    }
}
