package service;

import entities.Employee;
import DAO_classes.DAO_employee;
import entities.Contract;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

public class Employee_serv {

    private DAO_employee dao_cl = new DAO_employee();
    public boolean check;
    public Employee_serv() {
    }

    //информация о сотруднике по id
    public Employee findEmployee(int id) {
        return dao_cl.findById(id);
    }

    //удаление сотрудника
    public boolean DeleteEmployee(int id)
    {
            Employee emp_1 = dao_cl.findById(id);
            check = dao_cl.delete(emp_1);
            return check;
    }

    //создание сотрудника
    public boolean CreateEmployee(Employee emp_1)
    {
            check = dao_cl.save(emp_1);
            return check;
    }

    //обновление информации о сотруднике
    public boolean UpdateEmployee(int id, String name, String surname, String phone, String e_mail, String education,  String home_address, String position,  int work_experience )
    {
            Employee emp_1 = dao_cl.findById(id);
            emp_1.setName(name);
            emp_1.setSurname(surname);
            emp_1.setPhone(phone);
            emp_1.setE_mail(e_mail);
            emp_1.setEducation(education);
            emp_1.setHome_address(home_address);
            emp_1.setPosition(position);
            emp_1.setWork_experience(work_experience);
            check = dao_cl.update(emp_1);
            return check;
    }

    //список сотрудников по заданной услуге, клиентам и дате
    public List Emp_serv_client_date (int id_service, int id_cl, Date date_of_beginning, Date date_of_end)
    {
        Contract_serv serv = new Contract_serv();
        List <Employee> emps = new ArrayList<>();
        List<Contract> contracts = serv.Contract_serv_client_date(id_service, id_cl, date_of_beginning, date_of_end);
        for (Contract c:contracts)
        {
            emps.add(findEmployee(c.getId_employee()));
        }
        return emps;
    }

    public boolean EmployeeEqual(Employee new_emp)
    {
        Employee_serv serv = new Employee_serv();
        Employee check_emp = serv.findEmployee(new_emp.getId_employee());

        return ((new_emp.getId_employee() == check_emp.getId_employee()) &
                (new_emp.getName().equals(check_emp.getName())) &
                (new_emp.getSurname().equals(check_emp.getSurname())) &
                (new_emp.getE_mail().equals(check_emp.getE_mail())) &
                (new_emp.getPhone().equals(check_emp.getPhone())) &
                (new_emp.getEducation().equals(check_emp.getEducation())) &
                (new_emp.getHome_address().equals(check_emp.getHome_address())) &
                (new_emp.getPosition().equals(check_emp.getPosition())) &
                (new_emp.getWork_experience() == check_emp.getWork_experience()));
    }

}
