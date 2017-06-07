package Pets.ExchangeStuff.DAO;

import Pets.ExchangeStuff.DAO.DAOinterface.StuffIF;
import Pets.ExchangeStuff.model.Stuff;
import Pets.ExchangeStuff.model.StuffDetail;
import Pets.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by Student on 2017/6/1.
 */

@Repository
public class StuffDAO implements StuffIF {

    @Resource private SessionFactory sessionFactory;

    private static final String GET_ALL_STMT = "from Stuff order by id";

    @Override
    public void insert(Stuff stuff) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(stuff);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }

    }

    @Override
    public void update(Stuff stuff) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(stuff);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }

    }

    @Override
    public void deleteByID(Integer id) {

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

    @Override
    public Stuff findByPrimaryKey(Integer id) {
        Stuff stuff = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            stuff = (Stuff) session.get(Stuff.class, id);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
        return stuff;
    }

    @Override
    public List<Stuff> getAll() {
        List<Stuff> list = null;
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

    @Override
    public Set<StuffDetail> getDetailsByStuffID(Integer id) {
        Set<StuffDetail>set = findByPrimaryKey(id).getStuffDetails();
        return set;
    }
}
