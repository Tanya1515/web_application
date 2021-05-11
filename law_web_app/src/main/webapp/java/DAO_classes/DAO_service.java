package DAO_classes;

import entities.Service;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DAO_service {

    public List ListServices ()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List <Service> l = session.createQuery("from Service").list();
        return l;
    }

    public Service findById(int id) {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Service.class, id);
    }

}
