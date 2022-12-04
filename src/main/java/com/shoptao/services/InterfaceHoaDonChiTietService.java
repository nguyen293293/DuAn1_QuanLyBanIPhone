package com.shoptao.services;

import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public interface InterfaceHoaDonChiTietService {

    List<HoaDonChiTietViewModel> getList(String maHD);
    
            List<HoaDonChiTietViewModel> getListHDCT();

    
    HoaDonChiTietViewModel getOne(String id);

    boolean add(HoaDonChiTietViewModel t, Object... obj);
    
    boolean update(HoaDonChiTietViewModel t, Object... obj);
    
    boolean delete(int index, String maHD);
    
    boolean delete(String idHDCT);
    
    boolean checkSPisEmpty(String maHoaDon, int indexSanPham);
}
