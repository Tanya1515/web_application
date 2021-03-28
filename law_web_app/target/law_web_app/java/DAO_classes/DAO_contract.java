package DAO_classes;

import entities.Client;
import entities.Contract;
import entities.Employee;
import entities.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class DAO_contract {

    public void delete(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(contract);
        tx1.commit();
        session.close();
    }

    public Contract findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contract.class, id);
    }

}
