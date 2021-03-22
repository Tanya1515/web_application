package service;

import entities.Contract;
import DAO_classes.DAO_contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Contract_serv {

    private DAO_contract dao_cont = new DAO_contract();
    public boolean check;

    public Contract_serv() {
    }

    //поиск контракта по id
    public Contract findContract(int id) {
        return dao_cont.findById(id);
    }

    //удаление контракта
    public boolean DeleteContract(int id)
    {
        try {
            Contract cont_1 = dao_cont.findById(id);
            check = dao_cont.delete(cont_1);
            return true;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return false;

        }
    }

    //список контрактов по услуге, сотруднику и дате
    public List Contract_serv_emp_date (int id_service, int id_employee, Date date_of_beginning, Date date_of_end)
    {
       List<Contract> l = dao_cont.ListContract ();
       List <Contract> contracts = new ArrayList<Contract>();
        for (Contract cont : l)
        {
            if ((cont.getId_employee() == id_employee) & (cont.getId_service() == id_service) & (date_of_beginning.after(cont.getDate_of_begining())) & (date_of_end.before(cont.getDate_of_end())))
            {
                contracts.add(cont);
            }
        }
        return contracts;
    }

    //список контрактов по услуге, клиенту и дате
    public List Contract_serv_client_date (int id_service, int id_client, Date date_of_beginning, Date date_of_end)
    {
        List<Contract> l = dao_cont.ListContract ();
        List <Contract> contracts = new ArrayList<Contract>();
        for (Contract cont : l)
        {
            if ((cont.getId_client() == id_client) & (cont.getId_service() == id_service) & (date_of_beginning.after(cont.getDate_of_begining())) & (date_of_end.before(cont.getDate_of_end())))
            {
                contracts.add(cont);
            }
        }
        return contracts;
    }

    //создание контракта
    public boolean CreateContract(Contract cont_1)
    {
        try {
            check = dao_cont.save(cont_1);
            return check;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return check;

        }
    }
}
