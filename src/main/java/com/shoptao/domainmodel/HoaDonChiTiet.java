package com.shoptao.domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {
    
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "idhoadon")
    private HoaDon hoadon;
    
    @ManyToOne
    @JoinColumn(name = "idsanpham")
    private SanPham sanpham;
    
    private int soluong;
    
    private BigDecimal dongia;
}
