package com.shoptao.domainmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;

    private String ma;

    private String ten;

    private float giatri;
    
    private int hinhthucgiamgia;

    private float dieukiengiamgia;

    private Date ngaybatdau;

    private Date ngayketthuc;

    private int trangthai;

    
    
    
    
    @Override
    public String toString() {
        if(hinhthucgiamgia == 0){
            return "Giảm " + giatri + " VND" + " (Tổng tiền >= " + dieukiengiamgia + ")";
        }else{
            return "Giảm " + giatri + "%" + " (Tổng tiền >= " + dieukiengiamgia + ")";
        }
        
    }
}
