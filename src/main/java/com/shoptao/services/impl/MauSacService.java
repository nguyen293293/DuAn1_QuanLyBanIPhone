/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.MauSac;
import com.shoptao.repositories.MauSacRepository;
import com.shoptao.services.ChungService;
import com.shoptao.viewmodel.MauSacViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haih7
 */
public class MauSacService implements ChungService<MauSacViewModel>{

    public MauSacService() {
    }
    
    public MauSacRepository mauSacRepository = new MauSacRepository();
    @Override
    public List<MauSacViewModel> getList() {
         List<MauSacViewModel> list = new ArrayList<>();
        List<MauSac> listMS = mauSacRepository.getList();
        
        for (MauSac mauSac : listMS) {
            list.add(new MauSacViewModel(mauSac.getMa(), mauSac.getTen()));
        }
        return list;
          }

    @Override
    public String add(MauSacViewModel t, Object ...obj) {
        
       
         boolean isSave = mauSacRepository.add(new MauSac("", t.getMa(), t.getTen()));
       return isSave ? "Thêm thành công" : "Thêm thất bại";
    
    } 

    @Override
    public String update(MauSacViewModel t, Object ...obj) {
       MauSac mausac = new MauSac("null", t.getMa(), t.getTen());
          for (MauSac x : mauSacRepository.getList()) {
            if (x.getMa().equals(mausac.getMa())) {
                mausac.setId(x.getId());
            }
          }
            boolean isUpdate = mauSacRepository.update(mausac);
         return isUpdate ? "Sửa thành công" : "Sửa thất bại";
          
    }

    @Override
    public MauSacViewModel getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MauSacViewModel> search(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
