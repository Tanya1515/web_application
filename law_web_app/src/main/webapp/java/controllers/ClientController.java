package controllers;

import DAO_classes.DAO_client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    DAO_client dao_client = new DAO_client();

    @GetMapping("/main") //список всех клиентов + поля для выбора
    public String Client_Main(Model model)
    {
        model.addAttribute("clients", dao_client.ListClient());
        return "client/main";
    }

    @GetMapping("/delete")
    public String Client_Del()
    {
        return "client/delete";
    }

    @GetMapping("/new")
    public String Client_New()
    {
        return "client/new";
    }

    @GetMapping("/new_save")
    public String Client_New_Save()
    {
        return "client/new_save";
    }

    @GetMapping("/{id}")
    public String Client(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("person", dao_client.findById(id));
        return "client/person";
    }

    @GetMapping("/save")
    public String Client_Save()
    {
        return "client/save";
    }

    @GetMapping("/serv")
    public String Client_Serv()
    {
        return "client/serv";
    }
}
