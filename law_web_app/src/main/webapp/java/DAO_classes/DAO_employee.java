package DAO_classes;


import entities.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;


public class DAO_employee {

    //удаление сотрудника
    public boolean delete(Employee emp) {
        if (findById(emp.getId_employee()) != null) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(emp);
            tx1.commit();
            session.close();
            return true;
        }
            return false;
    }

    //чтение информации о сотруднике по id
    public Employee findById(int id) {
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
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
            return false;
        }
    }

    public List ListEmp ()
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List <Employee> l = session.createQuery("from Employee").list();
        return l;
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
            return false;
        }
    }
}

