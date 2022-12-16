package com.shoptao.domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author nguyen293
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;

    private String ma;

    private Date ngaytao;

    private Date ngaythanhtoan;

    private int trangthai;
    
    private BigDecimal tongtien;
    
    private BigDecimal tienkhachdua;

    @ManyToOne
    @JoinColumn(name = "idkhachhang")
    private KhachHang khachhang;

    @ManyToOne
    @JoinColumn(name = "idnhanvien")
    private NhanVien nhanvien;
    
    @ManyToOne
    @JoinColumn(name = "idkhuyenmai")
    private KhuyenMai khuyenmai;

    private BigDecimal giamgia;
    
    public HoaDon(String id, String ma, Date ngaytao, Date ngaythanhtoan, int trangthai, BigDecimal tongtien, BigDecimal tienkhachdua, KhachHang khachhang, NhanVien nhanvien, KhuyenMai khuyenmai) {
        this.id = id;
        this.ma = ma;
        this.ngaytao = ngaytao;
        this.ngaythanhtoan = ngaythanhtoan;
        this.trangthai = trangthai;
        this.tongtien = tongtien;
        this.tienkhachdua = tienkhachdua;
        this.khachhang = khachhang;
        this.nhanvien = nhanvien;
        this.khuyenmai = khuyenmai;
    }
    
    
}
