package com.shoptao.services.impl;

import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.domainmodel.ImeiDaBan;
import com.shoptao.repositories.HoaDonChiTietRepository;
import com.shoptao.repositories.ImeiDaBanRepository;
import com.shoptao.services.ChungServices;
import com.shoptao.viewmodel.ImeiDaBanViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public class ImeiDaBanService implements ChungServices<ImeiDaBanViewModel>{

    private final ImeiDaBanRepository imeiDaBanRepository;
    private final HoaDonChiTietRepository hDCTRepository;

    public ImeiDaBanService() {
        this.imeiDaBanRepository = new ImeiDaBanRepository();
        this.hDCTRepository = new HoaDonChiTietRepository();
    }
    
    @Override
    public List<ImeiDaBanViewModel> getList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(ImeiDaBanViewModel t, Object... obj) {
        HoaDonChiTiet hdct = hDCTRepository.getOne(t.getIdHDCT());
        ImeiDaBan imeiDaBan = new ImeiDaBan(null,
                t.getMaimei(), 0, hdct);
        
        return imeiDaBanRepository.add(imeiDaBan) ? "Thành công" : "Thất bại";
    }

    @Override
    public String update(ImeiDaBanViewModel t, Object... obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ImeiDaBanViewModel getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ImeiDaBanViewModel> search(String idHDCT) {     
        List<ImeiDaBanViewModel> list = new ArrayList<>();
        for (ImeiDaBan x : imeiDaBanRepository.getList(idHDCT)) {
            list.add(new ImeiDaBanViewModel(x.getMaimei(), idHDCT, 0));
        }
        return list;
    }

    @Override
    public String delete(String imei) {
        return imeiDaBanRepository.delete(imei) ? "Thành công" : "Thất bại";
    }
    
}
