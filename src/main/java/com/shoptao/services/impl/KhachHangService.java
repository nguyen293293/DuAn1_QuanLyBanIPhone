/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.KhachHang;
import com.shoptao.repositories.KhachHangRepository;
import com.shoptao.services.ChungService;
import com.shoptao.viewmodel.KhachHangViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haih7
 */
public class KhachHangService implements ChungService<KhachHangViewModel>{
    private final KhachHangRepository khachHangRepository;

    public KhachHangService() {
        this.khachHangRepository = new KhachHangRepository();
    }

    @Override
    public List<KhachHangViewModel> getList() {
        
        List<KhachHangViewModel> listKhachHangVM = new ArrayList<>();
        
        for (KhachHang x : khachHangRepository.getList()) {
            listKhachHangVM.add(new KhachHangViewModel(x.getMa(), x.getHoten(), 
                    x.getNgaysinh(), x.getSdt(), x.getDiachi(), x.getTrangthai()));
        }
        
        return listKhachHangVM;
    }

    @Override
    public String add(KhachHangViewModel t, Object ...obj) {
        KhachHang khachHang = new KhachHang(null, t.getMa(), t.getHoten(),
                t.getNgaysinh(), t.getSdt(), t.getDiachi(), t.getTrangthai());
        boolean isAdd = khachHangRepository.save(khachHang);
        return isAdd ? "Thêm thành công" : "Thêm thất bại";
    }

    @Override
    public String update(KhachHangViewModel t, Object ...obj) {
        KhachHang khachHang = new KhachHang(null, t.getMa(), t.getHoten(),
                t.getNgaysinh(), t.getSdt(), t.getDiachi(), t.getTrangthai());
        for (KhachHang x : khachHangRepository.getList()) {
            if (x.getMa().equals(khachHang.getMa())) {
                khachHang.setId(x.getId());
            }
        }
        boolean isUpdate = khachHangRepository.update(khachHang);
        return isUpdate ? "Sửa thành công" : "Sửa thất bại";
    }

    @Override
    public KhachHangViewModel getOne(String ma) {
        KhachHang x = khachHangRepository.getOne(ma);
        return new KhachHangViewModel(x.getMa(), x.getHoten(), x.getNgaysinh(), 
                x.getSdt(), x.getDiachi(), x.getTrangthai());
    }

    @Override
    public List<KhachHangViewModel> search(String ma) {
        List<KhachHangViewModel> listKhachHangVM = new ArrayList<>();
        
        for (KhachHang x : khachHangRepository.getList()) {
            if (x.getMa().startsWith(ma)) {
                listKhachHangVM.add(new KhachHangViewModel(x.getMa(), x.getHoten(),
                    x.getNgaysinh(), x.getSdt(), x.getDiachi(), x.getTrangthai()));
            }
        }
        
        return listKhachHangVM;
    }
    
    
}
