package com.shoptao.services.impl;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.repositories.HoaDonRepository;
import com.shoptao.services.ChungService;
import com.shoptao.viewmodel.HoaDonViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public class HoaDonService implements ChungService<HoaDonViewModel> {

    private final HoaDonRepository hoaDonRepository;

    public HoaDonService() {
        this.hoaDonRepository = new HoaDonRepository();
    }

    @Override
    public List<HoaDonViewModel> getList() {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon x : hoaDonRepository.getList()) {
            list.add(new HoaDonViewModel(x.getMa(), x.getNgaytao(), x.getNgaythanhtoan(), x.getTrangthai(),
                    x.getKhachhang().getHoten(), x.getKhachhang().getHoten()));
        }
        return list;
    }

    @Override
    public String add(HoaDonViewModel t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(HoaDonViewModel t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonViewModel getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonViewModel> search(String ma) {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDonViewModel x : getList()) {
            list.add(x);
        }
        return list;
    }

}