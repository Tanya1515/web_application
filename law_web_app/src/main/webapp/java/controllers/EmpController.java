package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @GetMapping("/main")
    public String Emp_Main()
    {
        return "emp/main";
    }

    @GetMapping("/delete")
    public String Emp_Del()
    {
        return "emp/delete";
    }

    @GetMapping("/new")
    public String Emp_New()
    {
        return "emp/new";
    }

    @GetMapping("/new_save")
    public String Emp_New_Save()
    {
        return "emp/new_save";
    }

    @GetMapping("/person")
    public String Emp()
    {
        return "emp/person";
    }

    @GetMapping("/save")
    public String Emp_Save()
    {
        return "emp/save";
    }

    @GetMapping("/serv")
    public String Emp_Serv()
    {
        return "emp/serv";
    }

}
