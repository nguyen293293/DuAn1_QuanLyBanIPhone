package com.shoptao.services.impl;

import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.domainmodel.ImeiDaBan;
import com.shoptao.repositories.HoaDonChiTietRepository;
import com.shoptao.repositories.ImeiDaBanRepository;
import com.shoptao.services.ChungServices;
import com.shoptao.services.InterfaceImeiDaBanService;
import com.shoptao.viewmodel.ImeiDaBanViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public class ImeiDaBanService implements InterfaceImeiDaBanService {

    private final ImeiDaBanRepository imeiDaBanRepository;
    private final HoaDonChiTietRepository hDCTRepository;

    public ImeiDaBanService() {
        this.imeiDaBanRepository = new ImeiDaBanRepository();
        this.hDCTRepository = new HoaDonChiTietRepository();
    }

    @Override
    public boolean add(ImeiDaBanViewModel t) {
        HoaDonChiTiet hdct = hDCTRepository.getOne(t.getIdHDCT());
        ImeiDaBan imeiDaBan = new ImeiDaBan(null,
                t.getMaimei(), t.getTrangthai(), hdct);

        return imeiDaBanRepository.add(imeiDaBan);
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
    public boolean deleteByImei(String maImei) {
        return imeiDaBanRepository.delete(maImei);
    }

    @Override
    public boolean deleteByIdHDCT(String idHDCT) {
        return imeiDaBanRepository.deleteByIdHDCT(idHDCT);
    }

}
