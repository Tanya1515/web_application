package controllers;

import DAO_classes.DAO_client;
import DAO_classes.DAO_contract;
import DAO_classes.DAO_employee;
import DAO_classes.DAO_service;
import entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.Contract_serv;
import service.Employee_serv;
import service.Service_serv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/emp")
public class EmpController {

    DAO_client dao_client = new DAO_client();
    DAO_employee dao_emp = new DAO_employee();
    DAO_contract dao_c = new DAO_contract();
    DAO_service dao_serv = new DAO_service();
    Contract_serv cont = new Contract_serv();
    Service_serv serv = new Service_serv();
    Employee_serv em = new Employee_serv();

    @GetMapping("/main")
    public String Emp_Main(Model model)
    {
        model.addAttribute("clients", dao_client.ListClient());
        model.addAttribute("emps", dao_emp.ListEmp());
        model.addAttribute("contracts", dao_c.ListContract());
        model.addAttribute("services", dao_serv.ListServices());
        model.addAttribute("emps", dao_emp.ListEmp());
        return "emp/main";
    }

    @GetMapping("/new")
    public String Emp_New(@ModelAttribute("emp") Employee Emp)
    {
        return "emp/new";
    }

    @PostMapping("/{id}")
    public String UpdateEmp(@ModelAttribute("emp") Employee emp, @PathVariable int id)
    {
        emp.setId_employee(id);
        dao_emp.update(emp);
        return "redirect:/emp/main";
    }

    @PostMapping()
    public String CreateEmp(@ModelAttribute("emp") Employee Emp) {

        dao_emp.save(Emp);
        return "redirect:/emp/main";
    }

    @GetMapping("/{id}")
    public String Emp(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("emp", dao_emp.findById(id));
        return "emp/person";
    }

    @GetMapping("del/{id}")
    public String DeleteEmp(@ModelAttribute("emp") Employee emp, @PathVariable int id)
    {
        emp.setId_employee(id);
        dao_emp.delete(emp);
        return "redirect:/emp/main";
    }

    @GetMapping("serv/{id}")
    public String ServForClient(@PathVariable("id") int id, Model model)
    {
        model.addAttribute ("services", serv.Service_client_emp(cont.Contract_emp(id)));
        model.addAttribute("emp", dao_emp.findById(id));
        return "emp/serv";
    }

    @PostMapping("/select")
    public String SelectClient (@RequestParam(name = "client") int id_cl,
                                @RequestParam(name = "serv") int id_serv,
                                @RequestParam(name = "date_of_begin") String date_of_begin,
                                @RequestParam(name = "date_of_end") String date_of_end,
                                Model model)
            throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date_of_beg = format.parse(date_of_begin);
        Date date_of_e = format.parse(date_of_end);
        model.addAttribute("emps", em.Emp_serv_client_date(id_serv, id_cl, date_of_beg, date_of_e));
        return "client/select";
    }

}
