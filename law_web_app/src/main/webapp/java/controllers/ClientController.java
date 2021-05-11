package controllers;

import DAO_classes.DAO_client;
import DAO_classes.DAO_contract;
import DAO_classes.DAO_employee;
import DAO_classes.DAO_service;
import entities.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.Contract_serv;
import service.Service_serv;

@Controller
@RequestMapping("/client")
public class ClientController {

    DAO_client dao_client = new DAO_client();
    DAO_employee dao_emp = new DAO_employee();
    DAO_contract dao_c = new DAO_contract();
    DAO_service dao_serv = new DAO_service();
    Contract_serv cont = new Contract_serv();
    Service_serv serv = new Service_serv();

    @GetMapping("/main") //список всех клиентов + поля для выбора
    public String Client_Main(Model model)
    {
        model.addAttribute("clients", dao_client.ListClient());
        model.addAttribute("emps", dao_emp.ListEmp());
        model.addAttribute("contracts", dao_c.ListContract());
        model.addAttribute("services", dao_serv.ListServices());
        return "client/main";
    }

    @GetMapping("/new")
    public String Client_New(@ModelAttribute("client") Client client)
    {
        return "client/new";
    }

    @PostMapping()
    public String CreateClient(@ModelAttribute("client") Client client) {
        dao_client.save(client);
        return "client/new_save";
    }

    @GetMapping("/{id}")
    public String Client(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("client", dao_client.findById(id));
        return "client/person";
    }

    @PostMapping("/{id}")
    public String UpdateClient(@ModelAttribute("client") Client client)
    {
        dao_client.update(client);
        return "client/save";
    }

    @GetMapping("del/{id}")
    public String DeleteClient(@ModelAttribute("client") Client client)
    {
        dao_client.delete(client);
        return "client/delete";
    }

    @GetMapping("serv/{id}")
    public String ServForClient(@PathVariable("id") int id, Model model)
    {
        model.addAttribute ("services", serv.Service_client_emp(cont.Contract_client(id)));
        model.addAttribute("client", dao_client.findById(id));
        return "client/serv";
    }
}
