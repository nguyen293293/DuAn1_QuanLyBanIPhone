package com.shoptao.services.impl;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.domainmodel.KhachHang;
import com.shoptao.domainmodel.NhanVien;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.HoaDonChiTietRepository;
import com.shoptao.repositories.HoaDonRepository;
import com.shoptao.repositories.KhachHangRepository;
import com.shoptao.repositories.NhanVienRepository;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.services.BanHangService;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public class BanHangServiceImpl implements BanHangService {

    private final HoaDonRepository hoaDonRepository;
    private final SanPhamRepository sanPhamRepository;
    private final HoaDonChiTietRepository hoaDonChiTietRepository;
    private final NhanVienRepository nhanVienRepository;
    private final KhachHangRepository khachHangRepository;

    public BanHangServiceImpl() {
        this.hoaDonRepository = new HoaDonRepository();
        this.sanPhamRepository = new SanPhamRepository();
        this.hoaDonChiTietRepository = new HoaDonChiTietRepository();
        this.nhanVienRepository = new NhanVienRepository();
        this.khachHangRepository = new KhachHangRepository();
    }

    @Override
    public List<HoaDonViewModel> getListHoaDon() {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon hoaDon : hoaDonRepository.getList()) {
            if (hoaDon.getTrangthai() == 0) {
                list.add(new HoaDonViewModel(hoaDon.getMa(), hoaDon.getNgaytao(),
                        hoaDon.getNgaythanhtoan(), hoaDon.getTrangthai(),
                        hoaDon.getKhachhang().getHoten(), hoaDon.getNhanvien().getHoten()));
            }
        }
        return list;
    }

    @Override
    public boolean addHoaDon(HoaDonViewModel hd, String maNhanVien, String maKhachHang) {
        NhanVien nhanVien = this.nhanVienRepository.getOne(maNhanVien);
        KhachHang khachHang = this.khachHangRepository.getOne(maKhachHang);
        HoaDon hoaDon = new HoaDon(null, genmahd(), hd.getNgaytao(),
                hd.getNgaythanhtoan(), 0, khachHang, nhanVien);
        return this.hoaDonRepository.save(hoaDon);
    }

    private String genmahd() {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon hoaDon : hoaDonRepository.getList()) {
            list.add(new HoaDonViewModel(hoaDon.getMa(), hoaDon.getNgaytao(),
                    hoaDon.getNgaythanhtoan(), hoaDon.getTrangthai(),
                    hoaDon.getKhachhang().getHoten(),
                    hoaDon.getNhanvien().getHoten()));
        }
        if (list.size() == 0) {
            return "HD0001";
        } else {
            int num = Integer.valueOf(list.get(list.size() - 1).getMa().substring(2)) + 1;
            return "HD" + (String.format("%04d", num));
        }
    }

    @Override
    public boolean updateHoaDon(HoaDonViewModel hd, String maKhachHang) {
        KhachHang khachHang = khachHangRepository.getOne(maKhachHang);

        HoaDon hoaDon = hoaDonRepository.getOne(hd.getMa());
        hoaDon.setKhachhang(khachHang);
        hoaDon.setTrangthai(hd.getTrangthai());

        return hoaDonRepository.update(hoaDon);
    }

    @Override
    public List<SanPhamViewModle> getListSanPham() {
        List<SanPhamViewModle> listSPVM = new ArrayList<>();

        for (SanPham x : sanPhamRepository.getList()) {
            if (x.getTrangthai() == 1) {
                listSPVM.add(new SanPhamViewModle(x.getId(), x.getMa(), x.getTen(),
                        x.getDungluong(), x.getSoluongton(), x.getNambaohanh(),
                        x.getGianhap(), x.getGiaban(), x.getMota(), x.getAnhsanpham(),
                        x.getBarcode(), x.getTrangthai(), x.getDongsanpham().getTen(),
                        x.getMausac().getTen()));
            }
        }
        return listSPVM;
    }

    @Override
    public boolean updateSanPham(SanPhamViewModle sanPhamVM) {
        SanPham sanPham = sanPhamRepository.getOne(sanPhamVM.getMa());
        sanPham.setSoluongton(sanPhamVM.getSoluongton());
        
        return sanPhamRepository.update(sanPham).equals("Thanh cong");
    }

    @Override
    public List<HoaDonChiTietViewModel> getListHDCT(String maHD) {
        List<HoaDonChiTietViewModel> list = new ArrayList<>();
        for (HoaDonChiTiet x : hoaDonChiTietRepository.getListbyMaHD(maHD)) {
            list.add(new HoaDonChiTietViewModel(x.getId(), x.getSanpham().getMa(),
                    x.getSanpham().getTen(), x.getSoluong(),
                    x.getDongia(), null));
        }
        return list;
    }

    @Override
    public boolean addHDCT(String maHD, HoaDonChiTietViewModel hdctVM) {
        HoaDon hoaDon = hoaDonRepository.getOne(maHD);
        SanPham sanPham = sanPhamRepository.getOne(hdctVM.getMaSanPham());

        HoaDonChiTiet hdct = new HoaDonChiTiet(hdctVM.getId(), hoaDon, sanPham, hdctVM.getSoluong(), hdctVM.getDongia());

        return hoaDonChiTietRepository.add(hdct);
    }

    @Override
    public boolean updateHDCT(int index, int soLuong) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setSoluong(soLuong);

        return hoaDonChiTietRepository.update(hdct);
    }
    
    @Override
    public boolean updateHDCT(String id, int soLuong) {
        HoaDonChiTiet hdct = hoaDonChiTietRepository.getOne(id);
        hdct.setSoluong(soLuong);

        return hoaDonChiTietRepository.update(hdct);
    }

    @Override
    public boolean deleteHDCT(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteAllHDCT(String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String checkSPisEmpty(String maHoaDon, int indexSanPham) {
        SanPhamViewModle sanPham = getListSanPham().get(indexSanPham);
        for (HoaDonChiTietViewModel x : getListHDCT(maHoaDon)) {
            if(sanPham.getMa().equals(x.getMaSanPham())){
                return x.getId();
            }
        }
        return null;
    }

    @Override
    public List<SanPhamViewModle> searchSanPham(String ma) {
        List<SanPhamViewModle> list = new ArrayList<>();
        for (SanPhamViewModle x : getListSanPham()) {
            if(x.getTen().substring(7).toLowerCase().startsWith(ma.toLowerCase())){
                list.add(x);
            }
        }
        return list;
    }

    @Override
    public int getSanPhambyBarcode(String barcode) {
        for (int i = 0; i < getListSanPham().size(); i++) {
            Object sp = getListSanPham().get(i);
            if(getListSanPham().get(i).getBarcode().equalsIgnoreCase(barcode)){
                return i;
            }
            
        }
        return -1;
    }

}
