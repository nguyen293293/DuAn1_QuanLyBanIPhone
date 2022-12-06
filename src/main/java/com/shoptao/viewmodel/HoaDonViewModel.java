/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.viewmodel;

import java.util.Date;

/**
 *
 * @author nguyen293
 */
public class HoaDonViewModel {
    
    private String ma;
    
    private Date ngaytao;
    
    private Date ngaythanhtoan;
    
    private int trangthai;
    
    private String tenKhachHang;
    
    private String tenNhanVien;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String ma, Date ngaytao, Date ngaythanhtoan, int trangthai, String tenKhachHang, String tenNhanVien) {
        this.ma = ma;
        this.ngaytao = ngaytao;
        this.ngaythanhtoan = ngaythanhtoan;
        this.trangthai = trangthai;
        this.tenKhachHang = tenKhachHang;
        this.tenNhanVien = tenNhanVien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(Date ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    
    
    public String getTenTrangThai() {
        if (trangthai == 0) {
            return "Chưa thanh toán";
        }else if(trangthai == 1){
            return "Đã thanh toán";
        }else{
            return "Đã huỷ";
        }
    }
    
    public Object[] toDataRow(){
        return new Object[]{ma, tenNhanVien, tenKhachHang, ngaytao, getTenTrangThai()};
    }
}
