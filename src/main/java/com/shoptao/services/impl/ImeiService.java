/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.Imei;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.ImeiRepository;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.viewmodel.ImeiViewModel;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import com.shoptao.services.ChungServices;

/**
 *
 * @author haih7
 */
public class ImeiService implements ChungServices<ImeiViewModel> {

    public ImeiService() {
    }
    ModelMapper modelMapper = new ModelMapper();
    public ImeiRepository imeiRepository = new ImeiRepository();
    public SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<ImeiViewModel> getList() {
        List<ImeiViewModel> list = new ArrayList<>();
        List<Imei> listIm = imeiRepository.getList();

        for (Imei imei : listIm) {
            list.add(new ImeiViewModel(imei.getMaimei(), imei.getTrangthai(), imei.getSanpham().getTen()));
        }
        return list;
    }

    @Override
    public String add(ImeiViewModel t, Object... obj) {

        SanPham sp = sanPhamRepository.getList().get((int) obj[0]);
        boolean isSave = imeiRepository.add(new Imei("", t.getMaimei(), t.getTrangthai(), sp));
        return isSave ? "Thêm thành công" : "Thêm thất bại";

    }

    @Override
    public String update(ImeiViewModel t, Object... obj) {
        String id = null;
        for (Imei x : imeiRepository.getList()) {
            if (x.getMaimei().equals(t.getMaimei())) {
                id = x.getId();
            }
        }
        Imei imei = new Imei(id, t.getMaimei(), t.getTrangthai(), null);
        boolean isUpdate = imeiRepository.updateTrangThai(imei);
        return isUpdate ? "Thành công" : "Thất bại";
    }

    @Override
    public ImeiViewModel getOne(String imei) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ImeiViewModel> search(String id) {
        List<ImeiViewModel> listv = new ArrayList<>();
        for (Imei x : imeiRepository.getList()) {
            if (x.getSanpham().getId().equals(id)) {
                listv.add(new ImeiViewModel(x.getMaimei(), x.getTrangthai(), x.getSanpham().getTen()));
            }
        }
        return listv;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
