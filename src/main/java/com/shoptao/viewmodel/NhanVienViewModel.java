package com.shoptao.viewmodel;

import java.util.Date;

/**
 *
 * @author nguyen293
 */
public class NhanVienViewModel {
    
    private String ma;
    
    private String hoten;
    
    private String gioitinh;
    
    private Date ngaysinh;
    
    private String sdt;
    
    private String email;
    
    private String diachi;
    
    private String matkhau;
    
    private String vaitro;
    
    private int trangthai;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(String ma, String hoten, String gioitinh, Date ngaysinh, String sdt, String email, String diachi, String matkhau, String vaitro, int trangthai) {
        this.ma = ma;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
        this.trangthai = trangthai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    public String getTenTrangThai() {
        if (trangthai == 0) {
            return "Đang làm";
        }else {
            return "Nghỉ làm";
        }
    }
    
    public Object[] toDataRow(){
        return new Object[]{ma, hoten, gioitinh, ngaysinh,
            sdt, email, diachi, matkhau, vaitro, getTenTrangThai()};
    }
}
