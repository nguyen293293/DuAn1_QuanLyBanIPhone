package com.shoptao.repositories;

import com.shoptao.domainmodel.NhanVien;
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
public class NhanVienRepository {
    
    public List<NhanVien> getList(){
        List<NhanVien> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From NhanVien order by ma");
            list = query.getResultList();
        }
        return list;
    }
    
    public NhanVien getOne(String manv) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("From NhanVien n where n.ma = :manv");
            query.setParameter("manv", manv);
            return (NhanVien) query.getSingleResult();
        }
    }
    
    public boolean save(NhanVien nhanVien) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.save(nhanVien);
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(NhanVien nhanVien) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            session.update(nhanVien);
            trans.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
