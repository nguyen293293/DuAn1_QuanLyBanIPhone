/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.DongSanPham;
import com.shoptao.domainmodel.MauSac;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.impl.DongSanPhamRepository;
import com.shoptao.repositories.impl.MauSacRepository;
import com.shoptao.repositories.impl.SanPhamRepository;
import com.shoptao.services.interfaces.ChungService;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haih7
 */
public class SanPhamService implements ChungService<SanPhamViewModle>{
public SanPhamRepository sanPhamRepository = new SanPhamRepository();
public DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();
public MauSacRepository mauSacRepository = new MauSacRepository();
//public Khuye sanPhamRepository = new SanPhamRepository();
//public SanPhamRepository sanPhamRepository = new SanPhamRepository();

    public SanPhamService() {
    }

    @Override
    public List<SanPhamViewModle> getList() {
        List<SanPhamViewModle> list = new ArrayList<>();
        List<SanPham> listSP = sanPhamRepository.getList();
            
        for (SanPham sanPham : listSP) {
            list.add(new SanPhamViewModle(sanPham.getMa(), sanPham.getTen(), sanPham.getDungluong(), sanPham.getSoluongton(), sanPham.getGianhap(), sanPham.getGiaban(),sanPham.getMota(), sanPham.getAnhsanpham(), sanPham.getBarcode(), sanPham.getTrangthai(), sanPham.getDongsanpham().getTen(), sanPham.getKhuyenmai().getTen(), sanPham.getMausac().getTen()));
        }
        return list;  
    }

    @Override
    public String add(SanPhamViewModle t) {
//        DongSanPham dongSanPham = dongSanPhamRepository.getOne(t.getTendongsanpham());
//        MauSac mauSac = mauSacRepository.getOne(t.getTenmausac());
//        SanPham sanPham = new SanPham(null, t.getMa(), t.getTen(), t.getDungluong(), t.getSoluongton(), t.getGianhap(), t.getGiaban(), "null", t.getAnhsanpham(),t.getBarcode(), t.getTrangthai(), null, null, null);
        SanPham sanPham = new SanPham(null, t.getMa(), t.getTen(), null, 0x1, null, null, null, "0",null, 1, null, null, null);
         System.out.println(t.getMa());
        String isSave = sanPhamRepository.add(sanPham);
         if (isSave.equals("Thanh cong")) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
                
         }
    @Override
    public String update(SanPhamViewModle t) {
         
        return "Thêm thất bại";
        }

    @Override
    public SanPhamViewModle getOne(String ma) {
        SanPham x = sanPhamRepository.getOne(ma);
        SanPhamViewModle sanPhamViewModle = new SanPhamViewModle(x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getGiaban(),x.getGianhap(),x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getKhuyenmai().getTen(), x.getMausac().getTen());
        return sanPhamViewModle;
       }

    @Override
    public List<SanPhamViewModle> Search(String search) {
       List<SanPhamViewModle> listSPVM = new ArrayList<>();
        for (SanPham x : sanPhamRepository.getList()) {
            if (x.getMa().contains(search.toUpperCase()) || x.getTen().contains(search.toUpperCase()) || x.getDungluong().contains(search.toUpperCase()) ) {
                listSPVM.add(new SanPhamViewModle(x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getGianhap(),x.getGiaban(),x.getMota(),x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getKhuyenmai().getTen(), x.getMausac().getTen()));
            }
        }
        return listSPVM; 


    }
    
}
