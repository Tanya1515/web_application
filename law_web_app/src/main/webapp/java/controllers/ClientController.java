package controllers;

import DAO_classes.DAO_client;
import DAO_classes.DAO_contract;
import DAO_classes.DAO_employee;
import DAO_classes.DAO_service;
import entities.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.Client_serv;
import service.Contract_serv;
import service.Service_serv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/client")
public class ClientController {

    DAO_client dao_client = new DAO_client();
    DAO_employee dao_emp = new DAO_employee();
    DAO_contract dao_c = new DAO_contract();
    DAO_service dao_serv = new DAO_service();
    Contract_serv cont = new Contract_serv();
    Service_serv serv = new Service_serv();
    Client_serv cl = new Client_serv();


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
        return "redirect:/client/main";
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
        return "redirect:/client/main";
    }

    @GetMapping("del/{id}")
    public String DeleteClient(@ModelAttribute("client") Client client)
    {
        dao_client.delete(client);
        return "redirect:/client/main";
    }

    @GetMapping("serv/{id}")
    public String ServForClient(@PathVariable("id") int id, Model model)
    {
        model.addAttribute ("services", serv.Service_client_emp(cont.Contract_client(id)));
        model.addAttribute("client", dao_client.findById(id));
        return "client/serv";
    }

    @PostMapping("/select")
    public String SelectClient (@RequestParam(name = "emp") int id_emp,
                                @RequestParam(name = "serv") int id_serv,
                                @RequestParam(name = "date_of_begin") String date_of_begin,
                                @RequestParam(name = "date_of_end") String date_of_end,
                                Model model)
            throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date_of_beg = format.parse(date_of_begin);
        Date date_of_e = format.parse(date_of_end);
        model.addAttribute("clients", cl.Client_serv_emp_date(id_serv, id_emp, date_of_beg, date_of_e));
        return "client/select";
    }
}

