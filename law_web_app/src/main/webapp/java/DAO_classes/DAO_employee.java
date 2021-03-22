package DAO_classes;

import entities.Contract;
import entities.Employee;
import entities.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class DAO_employee {

    //удаление сотрудника
    public boolean delete(Employee emp) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(emp);
            tx1.commit();
            session.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return false;
        }
    }

    //чтение информации о сотруднике по id
    public Employee findById(int id) {
        try {
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return null;
        }
    }

    //создание нового сотрудника
    public boolean save(Employee emp) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(emp);
            tx1.commit();
            session.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return false;
        }
    }

    //редактирование информации о сотруднике
    public boolean update (Employee emp) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(emp);
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

