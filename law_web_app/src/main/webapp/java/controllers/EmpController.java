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
import service.Service_serv;

@Controller
@RequestMapping("/emp")
public class EmpController {

    DAO_client dao_client = new DAO_client();
    DAO_employee dao_emp = new DAO_employee();
    DAO_contract dao_c = new DAO_contract();
    DAO_service dao_serv = new DAO_service();
    Contract_serv cont = new Contract_serv();
    Service_serv serv = new Service_serv();

    @GetMapping("/main")
    public String Emp_Main(Model model)
    {
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
        return "emp/save";
    }

    @PostMapping()
    public String CreateEmp(@ModelAttribute("emp") Employee Emp) {

        dao_emp.save(Emp);
        return "emp/new_save";
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
        return "emp/delete";
    }

    @GetMapping("serv/{id}")
    public String ServForClient(@PathVariable("id") int id, Model model)
    {
        model.addAttribute ("services", serv.Service_client_emp(cont.Contract_emp(id)));
        model.addAttribute("emp", dao_emp.findById(id));
        return "emp/serv";
    }

}
