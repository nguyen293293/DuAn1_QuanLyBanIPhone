/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.services.impl;

import com.shoptao.domainmodel.DongSanPham;
import com.shoptao.domainmodel.KhuyenMai;
import com.shoptao.domainmodel.MauSac;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.DongSanPhamRepository;
import com.shoptao.repositories.MauSacRepository;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.services.ChungService;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
        List<SanPhamViewModle> list = new ArrayList<>();
        List<SanPham> listSP = sanPhamRepository.getList();

        for (SanPham sanPham : listSP) {
            list.add(new SanPhamViewModle(sanPham.getMa(), sanPham.getTen(), sanPham.getDungluong(), sanPham.getSoluongton(), sanPham.getGianhap(), sanPham.getGiaban(), sanPham.getMota(), sanPham.getAnhsanpham(), sanPham.getBarcode(), sanPham.getTrangthai(), sanPham.getDongsanpham().getTen(), null, sanPham.getMausac().getTen()));
        }
        return list;
    }

    @Override
    public String add(SanPhamViewModle t) {
        DongSanPham dongSanPham = dongSanPhamRepository.getOneByTen(t.getTendongsanpham());
        MauSac mauSac = mauSacRepository.getOneByTen(t.getTenmausac());
        Date date = new java.sql.Date(2002);
//        KhuyenMai khuyenMai = new KhuyenMai(null, "km1", "km 29/11 ", 100, date, date, 1);

        SanPham sanPham = new SanPham(null, t.getMa(), t.getTen(), t.getDungluong(), t.getSoluongton(), t.getGianhap(), t.getGiaban(), t.getMota(), t.getAnhsanpham(),t.getBarcode(), t.getTrangthai(), dongSanPham, null, mauSac);
//        SanPham sanPham = new SanPham(null, t.getMa(), t.getTen(), null, 0x1, null, null, null, "0", null, 1, null, null, null);
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
        SanPhamViewModle sanPhamViewModle = new SanPhamViewModle(x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getGiaban(), x.getGianhap(), x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getKhuyenmai().getTen(), x.getMausac().getTen());
        return sanPhamViewModle;
    }

    @Override
    public List<SanPhamViewModle> search(String search) {
        List<SanPhamViewModle> listSPVM = new ArrayList<>();
//        for (SanPham x : sanPhamRepository.getList()) {
////            || x.getTen().contains(search.toUpperCase()) || x.getDungluong().contains(search.toUpperCase())
//            if (x.getMa().equals(search.toUpperCase()) ) {
//                listSPVM.add(new SanPhamViewModle(x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getGianhap(), x.getGiaban(), x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getKhuyenmai().getTen(), x.getMausac().getTen()));
//            }
//        }
   List<SanPham> listSP = sanPhamRepository.search(search);
        for (SanPham x : listSP) {
            listSPVM.add(new SanPhamViewModle(x.getMa(), x.getTen(), x.getDungluong(), x.getSoluongton(), x.getGianhap(), x.getGiaban(), x.getMota(), x.getAnhsanpham(), x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(), x.getKhuyenmai().getTen(), x.getMausac().getTen()));
        }
        return listSPVM;

    }

}
