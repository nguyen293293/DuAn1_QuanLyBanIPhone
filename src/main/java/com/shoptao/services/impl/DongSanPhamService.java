package com.shoptao.services.impl;

import com.shoptao.domainmodel.DongSanPham;
import com.shoptao.repositories.DongSanPhamRepository;
import com.shoptao.viewmodel.DongSanPhamViewModle;
import java.util.ArrayList;
import java.util.List;
import com.shoptao.services.ChungServices;

/**
 *
 * @author haih7
 */
public class DongSanPhamService implements ChungServices<DongSanPhamViewModle>{
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
    public String add(DongSanPhamViewModle t, Object ...obj) {
        boolean isSave = dongSanPhamRepository.add(new DongSanPham("", t.getMa(), t.getTen()));
        return isSave ? "Thêm thành công" : "Thêm thất bại";
    }

    @Override
    public String update(DongSanPhamViewModle t, Object ...obj) {
     DongSanPham dongSanPham =  new DongSanPham("null", t.getMa(), t.getTen());
        for (DongSanPham x : dongSanPhamRepository.getList()) {
            if (x.getMa().equals(dongSanPham.getMa())) {
                dongSanPham.setId(x.getId());
            }
          }
         boolean isUpdate = dongSanPhamRepository.update(dongSanPham);
        return isUpdate ? "Sửa thành công" : "Sửa thất bại";
         }

    @Override
    public DongSanPhamViewModle getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DongSanPhamViewModle> search(String ten) {
         List<DongSanPhamViewModle> listDSPVM = new ArrayList<>();

        for (DongSanPhamViewModle x : getList()) {
            if (x.getTen().startsWith(ten)) {
                listDSPVM.add(x);
            }
        }
        return listDSPVM;   }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
