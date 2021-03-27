package DAO_classes;

import entities.Contract;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DAO_contract {

    //удаление контракта
    public boolean delete(Contract cont) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(cont);
            tx1.commit();
            session.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    // чтение информации о контракте по id
    public Contract findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contract.class, id);
    }

    //список контракотов
    public List ListContract ()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List <Contract> l = session.createQuery("from Contract").list();
        return l;
    }

    //создание контракта
    public boolean save(Contract cont) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(cont);
            tx1.commit();
            session.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
