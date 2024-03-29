package com.shoptao.services.impl;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.domainmodel.SanPham;
import com.shoptao.repositories.HoaDonChiTietRepository;
import com.shoptao.repositories.HoaDonRepository;
import com.shoptao.repositories.SanPhamRepository;
import com.shoptao.services.InterfaceHoaDonChiTietService;
import com.shoptao.viewmodel.HDCTBanHangViewModel;
import com.shoptao.viewmodel.HoaDonChiTietViewModel;
import com.shoptao.viewmodel.KhuyenMaiViewModle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nguyen293
 */
public class HoaDonChiTietService implements InterfaceHoaDonChiTietService {

    private final HoaDonChiTietRepository repository;
    private final HoaDonRepository hoaDonRepository;
    private final SanPhamRepository sanPhamRepository;

    public HoaDonChiTietService() {
        this.repository = new HoaDonChiTietRepository();
        this.hoaDonRepository = new HoaDonRepository();
        this.sanPhamRepository = new SanPhamRepository();
    }

    @Override
    public List<HoaDonChiTietViewModel> getList(String maHD) {
        List<HoaDonChiTietViewModel> list = new ArrayList<>();
        for (HoaDonChiTiet x : repository.getListbyMaHD(maHD)) {
            HoaDonChiTietViewModel hd = new HoaDonChiTietViewModel(null, x.getHoadon().getMa(), x.getSanpham().getMa(), x.getSanpham().getTen(), x.getHoadon().getNgaytao(), x.getSoluong(), x.getSanpham().getGianhap(), x.getSanpham().getGiaban(), null);
            list.add(hd);
        }
        return list;
    }

    @Override
    public boolean add(HoaDonChiTietViewModel t, Object... obj) {
        HoaDon hoaDon = hoaDonRepository.getOne((String) obj[0]);
        SanPham sanPham = sanPhamRepository.getOne((String) obj[1]);
        HoaDonChiTiet hdct = new HoaDonChiTiet(null, hoaDon, sanPham, t.getSoluong(), t.getDongia());
        return repository.add(hdct);
    }

    @Override
    public boolean update(HoaDonChiTietViewModel t, Object... obj) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setSoluong(t.getSoluong());
        return repository.update(hdct);
    }

    @Override
    public boolean delete(int index, String maHD) {
        HoaDonChiTiet hdct = repository.getListbyMaHD(maHD).get(index);
        return repository.delete(hdct);
    }

    @Override
    public boolean delete(String idHDCT) {
        return repository.delete(idHDCT);
    }

    @Override
    public boolean checkSPisEmpty(String maHoaDon, int indexSanPham) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonChiTietViewModel getOne(String id) {
        HoaDonChiTiet x = repository.getOne(id);
        HoaDonChiTietViewModel hd = new HoaDonChiTietViewModel(null, x.getHoadon().getMa(), x.getSanpham().getMa(), x.getSanpham().getTen(), x.getHoadon().getNgaytao(), x.getSoluong(), x.getSanpham().getGianhap(), x.getSanpham().getGiaban(), null);
        return hd;
    }

    @Override
    public List<Object[]> getListThongKeSP() {
        return repository.getListThongKeSP();
    }

    @Override
    public List<Object[]> getListThongKeSPDay(Date datebd, Date datekt, int trangthai) {

        return repository.getListThongKeSPDay(datebd, datekt, trangthai);

    }

    @Override
    public List<Object[]> getListThongKeSPMonth(int month, int year, int trangthai) {
        return repository.getListThongKeSPMonth(month, year, trangthai);

    }

    @Override
    public List<Object[]> getListThongKeSPYear(int year, int trangthai) {
        return repository.getListThongKeSPYear(year, trangthai);

    }

    @Override
    public List<HDCTBanHangViewModel> getListBH(String maHD, String maKhuyenMai) {
        return null;
    }

    @Override
    public List<HDCTBanHangViewModel> getAllList() {
        List<HDCTBanHangViewModel> list = new ArrayList<>();
        for (HoaDonChiTiet x : repository.getListHDCT()) {
            HDCTBanHangViewModel hd = new HDCTBanHangViewModel(x.getId(), x.getSanpham().getMa(), x.getSanpham().getTen(),
                    x.getDongia(), x.getSoluong());
            list.add(hd);
        }
        return list;
    }

}
