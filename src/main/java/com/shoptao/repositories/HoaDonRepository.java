package com.shoptao.repositories;

import com.shoptao.domainmodel.HoaDon;
import com.shoptao.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nguyen293
 */
public class HoaDonRepository {
    
    public List<HoaDon> getList(){
        List<HoaDon> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDon order by ma asc");
            list = query.getResultList();
        }
        return list;
    }
    
    public HoaDon getOne(String mahd) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From HoaDon n where n.ma = :mahd order by n.ma asc");
            query.setParameter("mahd", mahd);
            System.out.println("HoaDonrepo : " + query.getResultList().size());
            return (HoaDon) query.getResultList().get(0);
        }
    }
    
    public boolean save(HoaDon hoaDon) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.save(hoaDon);
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(HoaDon hoaDon) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.update(hoaDon);
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
}
