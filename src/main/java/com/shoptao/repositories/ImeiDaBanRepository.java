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
    
    public boolean delete(String imei) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            String hql = "DELETE ImeiDaBan where maimei = :imei";
            Query query = session.createQuery(hql);
            query.setParameter("imei", imei);
            query.executeUpdate();
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteByIdHDCT(String idHDCT) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            String hql = "DELETE ImeiDaBan where idhoadonchitiet = :idHDCT";
            Query query = session.createQuery(hql);
            query.setParameter("idHDCT", idHDCT);
            query.executeUpdate();
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
}
