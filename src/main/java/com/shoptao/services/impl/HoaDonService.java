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
                    x.getKhachhang().getHoten(), x.getNhanvien().getHoten()));
        }
        return list;
    }

    @Override
    public String add(HoaDonViewModel t, Object ...obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(HoaDonViewModel t, Object ...obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonViewModel getOne(String ma) {
        HoaDon hoaDon = hoaDonRepository.getOne(ma);
        return new HoaDonViewModel(hoaDon.getMa(), hoaDon.getNgaytao(), hoaDon.getNgaythanhtoan(),
                hoaDon.getTrangthai(), hoaDon.getKhachhang().getHoten(), hoaDon.getNhanvien().getHoten());
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
