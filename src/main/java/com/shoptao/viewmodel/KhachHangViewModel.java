/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.viewmodel;

import java.util.Date;

/**
 *
 * @author DEll
 */
public class KhachHangViewModel {
    private String ma;
    
    private String hoten;
    
    private Date ngaysinh;
    
    private String sdt;
    
    private String diachi;
    
    private int trangthai;

    public KhachHangViewModel() {
    }

    public KhachHangViewModel(String ma, String hoten, Date ngaysinh, String sdt, String diachi, int trangthai) {
        this.ma = ma;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diachi = diachi;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    public String getTenTrangThai() {
        if (trangthai == 0 || trangthai == 2) {
            return "Đang hoạt động";
        }else{
            return "Ngừng hoạt động";
        }
    }
    
    public Object[] toDataRow(){
        return new Object[]{
            ma, hoten, ngaysinh, sdt, diachi, getTenTrangThai()
        };
    }
}
