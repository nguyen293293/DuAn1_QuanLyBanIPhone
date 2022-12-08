package com.shoptao.services;

import com.shoptao.viewmodel.HDCTBanHangViewModel;
import com.shoptao.viewmodel.HoaDonBanHangViewModel;
import com.shoptao.viewmodel.SanPhamBanHangViewModel;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public interface BanHangService {

    List<HoaDonBanHangViewModel> getListHoaDon();

    boolean addHoaDon(HoaDonBanHangViewModel hoaDon, String maNhanVien, String maKhachHang);

    boolean updateHoaDon(HoaDonBanHangViewModel hoaDon, String maKhachHang);

    List<SanPhamBanHangViewModel> getListSanPham();
    
    SanPhamBanHangViewModel getOneSanPham(String ma);

    List<SanPhamBanHangViewModel> searchSanPham(String ma);

    SanPhamBanHangViewModel getSanPhambyBarcode(String barcode);

    boolean updateSanPham(SanPhamBanHangViewModel sanPham);

    List<HDCTBanHangViewModel> getListHDCT(String maHD);

    boolean addHDCT(String maHD, HDCTBanHangViewModel hdct);

    boolean updateHDCT(int index, int soLuong);

    boolean updateHDCT(String id, int soLuong);

    boolean deleteHDCT(int index);

    boolean deleteAllHDCT(String maHD);

    String checkSPisEmpty(String maHoaDon, String maSanPham);
}
