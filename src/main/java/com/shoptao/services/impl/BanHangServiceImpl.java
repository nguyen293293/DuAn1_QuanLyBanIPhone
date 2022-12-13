package com.shoptao.services.impl;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.domainmodel.KhachHang;
import com.shoptao.domainmodel.KhuyenMai;
import com.shoptao.domainmodel.NhanVien;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.HoaDonChiTietRepository;
import com.shoptao.repositories.HoaDonRepository;
import com.shoptao.repositories.KhachHangRepository;
import com.shoptao.repositories.KhuyenMaiRepository;
import com.shoptao.repositories.NhanVienRepository;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.services.BanHangService;
import com.shoptao.viewmodel.HDCTBanHangViewModel;
import com.shoptao.viewmodel.HoaDonBanHangViewModel;
import com.shoptao.viewmodel.HoaDonViewModel;
import com.shoptao.viewmodel.SanPhamBanHangViewModel;
import com.shoptao.viewmodel.SanPhamViewModle;
import java.util.ArrayList;
import java.util.Date;
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
    public List<HoaDonBanHangViewModel> getListHoaDon() {
        List<HoaDonBanHangViewModel> list = new ArrayList<>();
        for (HoaDon hoaDon : hoaDonRepository.getList()) {
            if (hoaDon.getTrangthai() == 0) {
                list.add(new HoaDonBanHangViewModel(hoaDon.getMa(), hoaDon.getNhanvien().getHoten(),
                        hoaDon.getNgaytao(), hoaDon.getTrangthai()));
            }
        }
        return list;
    }

    @Override
    public boolean addHoaDon(HoaDonBanHangViewModel hd, String maNhanVien, String maKhachHang) {
        NhanVien nhanVien = this.nhanVienRepository.getOne(maNhanVien);
        KhachHang khachHang = this.khachHangRepository.getOne(maKhachHang);
        HoaDon hoaDon = new HoaDon(null, genmahd(), hd.getNgaytao(),
                new Date(), 0, hd.getTongtien(), hd.getTienkhachdua(), khachHang, nhanVien, null);
        return this.hoaDonRepository.save(hoaDon);
    }

    private String genmahd() {
        List<HoaDonBanHangViewModel> list = new ArrayList<>();
        for (HoaDon hoaDon : hoaDonRepository.getList()) {
            list.add(new HoaDonBanHangViewModel(hoaDon.getMa(), hoaDon.getNhanvien().getHoten(),
                    hoaDon.getNgaytao(), hoaDon.getTrangthai()));
        }
        if (list.size() == 0) {
            return "HD0001";
        } else {
            int num = Integer.valueOf(list.get(0).getMahoadon().substring(2)) + 1;
            return "HD" + (String.format("%04d", num));
        }
    }

    @Override
    public boolean updateHoaDon(HoaDonBanHangViewModel hd, String maKhachHang, String maKhuyenMai) {
        KhachHang khachHang = khachHangRepository.getOne(maKhachHang);
        KhuyenMai khuyenMai = null;
        if(maKhachHang != null){
            khuyenMai = new KhuyenMaiRepository().getOne(maKhuyenMai);
        }
        
        HoaDon hoaDon = hoaDonRepository.getOne(hd.getMahoadon());
        hoaDon.setKhachhang(khachHang);
        hoaDon.setTrangthai(hd.getTrangthai());
        hoaDon.setTongtien(hd.getTongtien());
        hoaDon.setTienkhachdua(hd.getTienkhachdua());
        hoaDon.setKhuyenmai(khuyenMai);
        
        return hoaDonRepository.update(hoaDon);
    }

    @Override
    public List<SanPhamBanHangViewModel> getListSanPham() {
        List<SanPhamBanHangViewModel> listSPVM = new ArrayList<>();

        for (SanPham x : sanPhamRepository.getList()) {
            if (x.getTrangthai() == 1) {
                listSPVM.add(new SanPhamBanHangViewModel(x.getMa(),
                        x.getTen(), x.getMausac().getTen(), x.getDungluong(),
                        x.getNambaohanh(), x.getSoluongton(), x.getGiaban(), x.getBarcode()));
            }
        }
        return listSPVM;
    }

    @Override
    public SanPhamBanHangViewModel getOneSanPham(String ma) {
        SanPham sanPham = sanPhamRepository.getOne(ma);
        return new SanPhamBanHangViewModel(sanPham.getMa(),
                sanPham.getTen(), sanPham.getMausac().getTen(), sanPham.getDungluong(),
                sanPham.getNambaohanh(), sanPham.getSoluongton(), sanPham.getGiaban(), sanPham.getBarcode());
    }

    @Override
    public List<SanPhamBanHangViewModel> searchSanPham(String ma) {
        List<SanPhamBanHangViewModel> list = new ArrayList<>();
        for (SanPhamBanHangViewModel x : getListSanPham()) {
            if (x.getTensanpham().substring(7).toLowerCase().startsWith(ma.toLowerCase())) {
                list.add(x);
            }
        }
        return list;
    }

    @Override
    public boolean updateSanPham(SanPhamBanHangViewModel sanPhamVM) {
        SanPham sanPham = sanPhamRepository.getOne(sanPhamVM.getMasanpham());
        sanPham.setSoluongton(sanPhamVM.getSoluong());

        return sanPhamRepository.update(sanPham).equals("Thanh cong");
    }

    @Override
    public List<HDCTBanHangViewModel> getListHDCT(String maHD) {
        List<HDCTBanHangViewModel> list = new ArrayList<>();
        for (HoaDonChiTiet x : hoaDonChiTietRepository.getListbyMaHD(maHD)) {
            HDCTBanHangViewModel hd = new HDCTBanHangViewModel(x.getId(), x.getSanpham().getMa(), x.getSanpham().getTen(),
                    x.getDongia(), x.getSoluong());
            list.add(hd);
        }
        return list;
    }

    @Override
    public boolean addHDCT(String maHD, HDCTBanHangViewModel hdctVM) {
        HoaDon hoaDon = hoaDonRepository.getOne(maHD);
        SanPham sanPham = sanPhamRepository.getOne(hdctVM.getMasanpham());

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
    public String checkSPisEmpty(String maHoaDon, String maSanPham) {
//        SanPhamBanHangViewModel sanPham = getOneSanPham(maSanPham);
        for (HDCTBanHangViewModel x : getListHDCT(maHoaDon)) {
            if (maSanPham.equals(x.getMasanpham())) {
                return x.getId();
            }
        }
        return null;
    }

    @Override
    public SanPhamBanHangViewModel getSanPhambyBarcode(String barcode) {
        for (SanPhamBanHangViewModel x : getListSanPham()) {
            if (x.getBarcode().equals(barcode) && x.getSoluong() > 0) {
                return x;
            }
        }
        return null;
    }

    @Override
    public HDCTBanHangViewModel getOne(String id) {
        HoaDonChiTiet hdct = hoaDonChiTietRepository.getOne(id);
        return new HDCTBanHangViewModel(hdct.getId(), hdct.getSanpham().getMa(), hdct.getSanpham().getTen(),
                hdct.getDongia(), hdct.getSoluong());
    }

}
