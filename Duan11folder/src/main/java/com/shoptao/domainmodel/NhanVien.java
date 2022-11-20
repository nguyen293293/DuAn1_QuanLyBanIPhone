package com.shoptao.domainmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
    
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;
    
    private String ma;
    
    private String hoten;
    
    private String gioitinh;
    
    private Date ngaysinh;
    
    private String sdt;
    
    private String email;
    
    private String diachi;
    
    private String matkhau;
    
    private String vaitro;
    
    private int trangthai;
}
