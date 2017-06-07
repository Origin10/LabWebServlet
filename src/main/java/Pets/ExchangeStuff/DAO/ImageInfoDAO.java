package Pets.ExchangeStuff.DAO;


import Pets.ExchangeStuff.DAO.DAOinterface.ImageIF;
import Pets.ExchangeStuff.model.ImageInfo;
import Pets.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Student on 2017/6/1.
 */

@Repository
public class ImageInfoDAO implements ImageIF {
    @Resource
    private SessionFactory sessionFactory;

    private static final String GET_ALL_STMT = "from ImageInfo order by id";

    @Override
    public void insert(ImageInfo ImageInfo) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(ImageInfo);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }

    }

    @Override
    public void update(ImageInfo ImageInfo) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(ImageInfo);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }

    }

    @Override
    public void delete(Integer id) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            ImageInfo ImageInfo = (ImageInfo) session.get(ImageInfo.class, id);
            session.delete(ImageInfo);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }

    }

    @Override
    public ImageInfo findByPrimaryKey(Integer id) {
        ImageInfo ImageInfo = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            ImageInfo = (ImageInfo) session.get(ImageInfo.class, id);
            session.getTransaction().commit();
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            throw ex;
        }
        return ImageInfo;
    }

    @Override
    public List<ImageInfo> getAll() {
        List<ImageInfo> list = null;
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
