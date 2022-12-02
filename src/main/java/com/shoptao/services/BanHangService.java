package com.shoptao.services;

import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public interface BanHangService {
    
    List<HoaDonViewModel> getListHoaDon();
    
    boolean addHoaDon(HoaDonViewModel hoaDon, String maNhanVien, String maKhachHang);
    
    boolean updateHoaDon(HoaDonViewModel hoaDon, String maKhachHang);
    
    List<SanPhamViewModle> getListSanPham();
    
    boolean updateSanPham(SanPhamViewModle sanPham);
    
    List<HoaDonChiTietViewModel> getListHDCT(String maHD);
    
    boolean addHDCT(String maHD, HoaDonChiTietViewModel hdct);
    
    boolean updateHDCT(int index, int soLuong);
    
    boolean updateHDCT(String id, int soLuong);
    
    boolean deleteHDCT(int index);
    
    boolean deleteAllHDCT(String maHD);
    
    String checkSPisEmpty(String maHoaDon, int indexSanPham);
}
