package DAO_classes;

import entities.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DAO_client {

    //удаление клиента
    public boolean delete(Client client) {
        if (findById(client.getId()) != null){
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(client);
            tx1.commit();
            session.close();
            return true;
        }
        return false;
    }

    public List ListClient ()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List <Client> l = session.createQuery("from Client").list();
        return l;
    }

    //чтение информации о клиенте по id
    public Client findById(int id) {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
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
            return false; }
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
            return false; }
    }
 }
