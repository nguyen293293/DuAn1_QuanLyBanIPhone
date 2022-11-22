/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.DongSanPham;
import com.shoptao.domainmodel.MauSac;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.DongSanPhamRepository;
import com.shoptao.repositories.MauSacRepository;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.services.ChungService;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haih7
 */ 
public class SanPhamService implements ChungService<SanPhamViewModle> {

    public SanPhamRepository sanPhamRepository = new SanPhamRepository();
    public DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();
    public MauSacRepository mauSacRepository = new MauSacRepository();

    public SanPhamService() {
        
    }

    @Override
    public List<SanPhamViewModle> getList() {
        List<SanPhamViewModle> listSPVM = new ArrayList<>();

        for (SanPham sanPham : sanPhamRepository.getList()) {
            listSPVM.add(new SanPhamViewModle(sanPham.getMa(), sanPham.getTen(), sanPham.getDungluong(), sanPham.getSoluongton(), sanPham.getGianhap(), sanPham.getGiaban(), sanPham.getMota(), sanPham.getAnhsanpham(), sanPham.getBarcode(), sanPham.getTrangthai(), sanPham.getDongsanpham().getTen(), null, sanPham.getMausac().getTen()));
        }
        return listSPVM;
    }

    @Override
    public String add(SanPhamViewModle t, Object... ob) {
       DongSanPham ds = dongSanPhamRepository.getList().get((int) ob[0]);
        MauSac ms = mauSacRepository.getList().get((int) ob[1]);

        SanPham sanPham = new SanPham(null, t.getMa(), t.getTen(), t.getDungluong(), t.getSoluongton(), t.getGianhap(), t.getGiaban(), "null", t.getAnhsanpham(), t.getBarcode(), t.getTrangthai(), ds, null, ms);
//        SanPham sanPham = new SanPham(null, t.getMa(), t.getTen(), null, 0x1, null, null, null, "0", null, 1, null, null, null);
        System.out.println(t.getMa());
        String isSave = sanPhamRepository.add(sanPham);
        if (isSave.equals("Thanh cong")) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    @Override
    public String update(SanPhamViewModle t, Object... ob) {
          DongSanPham ds = dongSanPhamRepository.getList().get((int) ob[0]);
        MauSac ms = mauSacRepository.getList().get((int) ob[1]);
SanPham sanPham = new SanPham();
sanPham.setMa(t.getMa());
sanPham.setTen(t.getTen());
sanPham.setDungluong(t.getDungluong());
sanPham.setSoluongton(t.getSoluongton());
sanPham.setGianhap(t.getGianhap());
sanPham.setGiaban(t.getGiaban());
sanPham.setBarcode(t.getBarcode());
sanPham.setAnhsanpham(t.getAnhsanpham());
sanPham.setMota(t.getMota());
sanPham.setTrangthai(t.getTrangthai());
sanPham.setDongsanpham(ds);
sanPham.setKhuyenmai(null);
sanPham.setMausac(ms);



          for (SanPham x : sanPhamRepository.getList()) {
            if (x.getMa().equals(sanPham.getMa())) {
                sanPham.setId(x.getId());
            }
          }
            String isUpdate = sanPhamRepository.update(sanPham);
        if (isUpdate.equals("Thanh cong")) {
            return "Cap nhat thành công";
        } else {
            return "Cap nhat thất bại";
        }
          
    }

    @Override
    public SanPhamViewModle getOne(String ma) {
        SanPham x = sanPhamRepository.getOne(ma);
        SanPhamViewModle sanPhamViewModle = new SanPhamViewModle(x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getGiaban(), x.getGianhap(), x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getKhuyenmai().getTen(), x.getMausac().getTen());
        return sanPhamViewModle;
    }

    @Override
    public List<SanPhamViewModle> search(String ma) {
        List<SanPhamViewModle> listSPVM = new ArrayList<>();
      List<SanPham> listSP = sanPhamRepository.search(ma);
        for (SanPham x : listSP) {
            listSPVM.add(new SanPhamViewModle(x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getGiaban(), x.getGianhap(), x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getKhuyenmai().getTen(), x.getMausac().getTen()));
        }
        return listSPVM;

//   List<SanPhamViewModle> listSPVM = new ArrayList<>();
//
//        for (SanPham x : sanPhamRepository.getList()) {
//            if (x.getMa().startsWith(ma)) {
//                listSPVM.add(new SanPhamViewModle(x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getGiaban(), x.getGianhap(), x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getKhuyenmai().getTen(), x.getMausac().getTen()));
////        }
//            }
//        }
//        return listSPVM;
    }

}
