package controllers;

import DAO_classes.DAO_client;
import DAO_classes.DAO_contract;
import DAO_classes.DAO_employee;
import DAO_classes.DAO_service;
import entities.Contract;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/reg")
public class RegController {

    DAO_client dao_client = new DAO_client();
    DAO_employee dao_emp = new DAO_employee();
    DAO_service dao_serv = new DAO_service();
    DAO_contract dao_cont = new DAO_contract();

    @GetMapping("/main")
    public String Reg_Main(Model model)
    {
        model.addAttribute("clients", dao_client.ListClient());
        model.addAttribute("emps", dao_emp.ListEmp());
        model.addAttribute("services", dao_serv.ListServices());
        return "reg/main";
    }

    @PostMapping ("/save")
    public String Reg_Save(
            @RequestParam(name = "emp") int id_emp,
            @RequestParam(name = "client") int id_client,
            @RequestParam(name = "serv") int id_serv,
            @RequestParam(name = "date_of_begin") String date_of_begin,
            @RequestParam(name = "date_of_end") String date_of_end)
            throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date_of_beg = format.parse(date_of_begin);
        Date date_of_e = format.parse(date_of_end);
        Contract c = new Contract(id_emp, id_serv, id_client, date_of_beg, date_of_e);
        dao_cont.save(c);
        return "reg/save";
    }
}
