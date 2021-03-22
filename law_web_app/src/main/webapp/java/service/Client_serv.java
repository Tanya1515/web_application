package service;

import entities.Client;
import DAO_classes.DAO_client;
import entities.Contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Client_serv {

    private DAO_client dao_cl = new DAO_client();
    public boolean check;

    public Client_serv() {
    }

    //поиск клиента по id
    public Client findClient(int id) {
        return dao_cl.findById(id);
    }

    //удаление клиента
    public boolean DeleteClient(int id)
    {
        try {
            Client cl_1 = dao_cl.findById(id);
            check = dao_cl.delete(cl_1);
            return true;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return false;

        }
    }

    //создание клиента
    public boolean CreateClient(Client cl_1)
    {
        try {
            check = dao_cl.save(cl_1);
            return check;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return check;

        }
    }

    //обновление информации о клиенте
    public boolean UpdateClient(int id, String name, String surname, String phone, String e_mail )
    {
        try {
            Client cl_1 = dao_cl.findById(id);
            cl_1.setName(name);
            cl_1.setSurname(surname);
            cl_1.setPhone(phone);
            cl_1.setE_mail(e_mail);
            check = dao_cl.update(cl_1);
            return check;
        }
        catch (Exception e) {
            System.out.println("Исключение!" + e);
            return check;

        }
    }

    //список клиентов по услуге, сотруднику и дате
    public List Client_serv_emp_date (int id_service, int id_emp, Date date_of_beginning, Date date_of_end)
    {
        Contract_serv serv = new Contract_serv();
        List <Client> clients = new ArrayList<>();
        List<Contract> contracts = serv.Contract_serv_emp_date(id_service, id_emp, date_of_beginning, date_of_end);
        for (Contract c:contracts)
        {
            clients.add(findClient(c.getId_client()));
        }
        return clients;
    }

}
