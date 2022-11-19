/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.DongSanPham;
import com.shoptao.repositories.impl.ChungRepository;
import com.shoptao.repositories.impl.DongSanPhamRepository;
import com.shoptao.services.interfaces.ChungService;
import com.shoptao.viewmodel.DongSanPhamViewModle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haih7
 */
public class DongSanPhamService implements ChungService<DongSanPhamViewModle>{
    public DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();

    public DongSanPhamService() {
    }

    @Override
    public List<DongSanPhamViewModle> getList() {
      List<DongSanPhamViewModle> list = new ArrayList<>();
        List<DongSanPham> listDSP = dongSanPhamRepository.getList();
        
        for (DongSanPham dongSanPham : listDSP) {
            list.add(new DongSanPhamViewModle(dongSanPham.getMa(), dongSanPham.getTen()));
        }
        return list;}

    @Override
    public String add(DongSanPhamViewModle t) {
        String isSave = dongSanPhamRepository.add(new DongSanPham("", t.getMa(), t.getTen()));
        if (isSave.equals("Thanh cong")) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }  }

    @Override
    public String update(DongSanPhamViewModle t) {
     DongSanPham dongSanPham =  new DongSanPham("null", t.getMa(), t.getTen());
        for (DongSanPham x : dongSanPhamRepository.getList()) {
            if (x.getMa().equals(dongSanPham.getMa())) {
                dongSanPham.setId(x.getId());
            }
          }
         String isUpdate = dongSanPhamRepository.update(dongSanPham);
        if (isUpdate.equals("Thanh cong")) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật thất bại";
        } }

    @Override
    public DongSanPhamViewModle getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DongSanPhamViewModle> Search(String search) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
