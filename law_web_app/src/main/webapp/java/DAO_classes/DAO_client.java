package DAO_classes;

import entities.Client;
import entities.Contract;
import entities.Employee;
import entities.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class DAO_client {

    //удаление клиента
    public boolean delete(Client client) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(client);
            tx1.commit();
            session.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return false;
        }
    }

    //чтение информации о клиенте по id
    public Client findById(int id) {
        try {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

    //создание нового клиента
    public boolean save(Client client) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(client);
            tx1.commit();
            session.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return false;
        }
    }
    //редактирование информации о клиенте
    public boolean update(Client client) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(client);
            tx1.commit();
            session.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return false;
        }
    }
}
