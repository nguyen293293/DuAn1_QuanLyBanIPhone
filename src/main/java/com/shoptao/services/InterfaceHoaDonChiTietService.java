package com.shoptao.services;

import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public interface InterfaceHoaDonChiTietService {

    List<HoaDonChiTietViewModel> getList(String maHD);

    boolean add(HoaDonChiTietViewModel t, Object... obj);
    
    boolean update(HoaDonChiTietViewModel t, Object... obj);
    
    boolean delete(int index, String maHD);
    
    boolean deleteAll(String maHD);
}
