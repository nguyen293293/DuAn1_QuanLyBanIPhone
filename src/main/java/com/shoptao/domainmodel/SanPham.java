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
@Table(name = "SanPham")
public class SanPham implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;

    private String ma;

    private String ten;

    private String dungluong;

    private int soluongton;

    private int nambaohanh;

    private BigDecimal gianhap;

    private BigDecimal giaban;

    private String mota;
    private byte[] anhsanpham;

    private String barcode;

    private int trangthai;

    @ManyToOne
    @JoinColumn(name = "iddongsanpham")
    private DongSanPham dongsanpham;

    @ManyToOne
    @JoinColumn(name = "idmausac")
    private MauSac mausac;

}
