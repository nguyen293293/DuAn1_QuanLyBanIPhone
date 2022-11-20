package com.shoptao.domainmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    
    @ManyToOne
    @JoinColumn(name = "idkhachhang")
    private KhachHang khachhang;
    
    @ManyToOne
    @JoinColumn(name = "idnhanvien")
    private NhanVien nhanvien;
}
