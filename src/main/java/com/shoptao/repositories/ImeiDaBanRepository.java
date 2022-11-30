package com.shoptao.repositories;

import com.shoptao.domainmodel.ImeiDaBan;
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
public class ImeiDaBanRepository {
    
    public List<ImeiDaBan> getList(String idHDCT){
        List<ImeiDaBan> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From ImeiDaBan where idhoadonchitiet = :id");
            query.setParameter("id", idHDCT);
            list = query.getResultList();
        }
        return list;
    }
    
    public boolean add(ImeiDaBan imeiDaBan){
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.save(imeiDaBan);
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(ImeiDaBan imeiDaBan) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.delete(imeiDaBan);
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
