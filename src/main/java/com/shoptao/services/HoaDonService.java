
package com.shoptao.services;

import com.shoptao.viewmodel.HoaDonViewModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author haih7
 */
public interface HoaDonService {

    List<HoaDonViewModel> getListHoaDonTheoNgay(Date datebd,Date datekt, int trangthai);

    List<HoaDonViewModel> getListHoaDonTheoThang(int month, int year, int trangthai);

    List<HoaDonViewModel> getListHoaDonTheoNam(int year, int trangthai);
    
    List<HoaDonViewModel> getListHoaDonTheoMaKM(String maKM);

}
