package Pets.ExchangeStuff.DAO;

import Pets.ExchangeStuff.model.Stuff;
import Pets.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public abstract class ObjectDAO  {

    private static final String GET_ALL_STMT = "";
    protected Object object;

    public void insert(Object ob) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(ob);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }

    }

    public void update(Object ob) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(ob);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }

    }

    public void delete(Integer id) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Stuff stuff = (Stuff) session.get(Stuff.class, id);
            session.delete(stuff);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }

    }

    public Object findByPrimaryKey(Integer id) {
        Object ob = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            ob = (Stuff) session.get(Stuff.class, id);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
        return ob;
    }


    public List<Object> getAll() {
        List<Object> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery(GET_ALL_STMT);
            list = query.list();
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
        return list;
    }


}
