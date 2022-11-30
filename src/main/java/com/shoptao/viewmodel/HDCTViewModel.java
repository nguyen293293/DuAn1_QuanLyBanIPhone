package com.shoptao.viewmodel;

import java.math.BigDecimal;
import lombok.NoArgsConstructor;

/**
 *
 * @author nguyen293
 */
@NoArgsConstructor
public class HDCTViewModel {
    
    private String maSanPham;
    
    private String tenSanPham;
    
    private int soLuong;
    
    private BigDecimal donGia;
    
    private BigDecimal thanhTien;

    public HDCTViewModel(String maSanPham, String tenSanPham, int soLuong, BigDecimal donGia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getThanhTien() {
        return donGia.multiply(BigDecimal.valueOf(soLuong));
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
