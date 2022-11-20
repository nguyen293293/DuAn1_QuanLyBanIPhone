package com.shoptao.repositories;

import com.shoptao.domainmodel.HoaDonChiTiet;
import com.shoptao.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author nguyen293
 */
public class HoaDonChiTietRepository {
    
    public List<HoaDonChiTiet> getListbyMaHD(String maHD){
        List<HoaDonChiTiet> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDonChiTiet where ma = :mahd");
            query.setParameter("mahd", maHD);
            list = query.getResultList();
        }
        return list;
    }
    
    
}
