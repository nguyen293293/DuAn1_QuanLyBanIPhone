package com.shoptao.services.impl;

import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.repositories.HoaDonChiTietRepository;
import com.shoptao.services.ChungService;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public class HoaDonChiTietService implements ChungService<HoaDonChiTietViewModel> {

    private final HoaDonChiTietRepository repository;

    public HoaDonChiTietService() {
        this.repository = new HoaDonChiTietRepository();
    }

    @Override
    public List<HoaDonChiTietViewModel> getList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(HoaDonChiTietViewModel t, Object... obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(HoaDonChiTietViewModel t, Object... obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonChiTietViewModel getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonChiTietViewModel> search(String ma) {
        List<HoaDonChiTietViewModel> list = new ArrayList<>();
        for (HoaDonChiTiet x : repository.getListbyMaHD(ma)) {
            list.add(new HoaDonChiTietViewModel(x.getSanpham().getMa(),
                    x.getSanpham().getTen(), x.getSoluong(),
                    x.getDongia(), null));
        }
        return list;
    }

}
