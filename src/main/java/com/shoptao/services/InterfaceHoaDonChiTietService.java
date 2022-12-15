package com.shoptao.services;

import com.shoptao.viewmodel.HDCTBanHangViewModel;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public interface InterfaceHoaDonChiTietService {

    List<HoaDonChiTietViewModel> getList(String maHD);
    
    HoaDonChiTietViewModel getOne(String id);

    boolean add(HoaDonChiTietViewModel t, Object... obj);

    boolean update(HoaDonChiTietViewModel t, Object... obj);

    boolean delete(int index, String maHD);

    boolean delete(String idHDCT);
    
    List<HDCTBanHangViewModel> getListBH(String maHD, String maKhuyenMai);

    boolean checkSPisEmpty(String maHoaDon, int indexSanPham);

    List<Object[]> getListThongKeSP();

    List<Object[]> getListThongKeSPDay(Date datebd, Date datekt,int trangthai);

    List<Object[]> getListThongKeSPMonth(int month, int year, int trangthai);

    List<Object[]> getListThongKeSPYear(int year, int trangthai);

}
