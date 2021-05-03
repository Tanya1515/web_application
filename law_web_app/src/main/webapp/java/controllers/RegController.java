package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reg")
public class RegController {

    @GetMapping("/main")
    public String Reg_Main()
    {
        return "reg/main";
    }

    @GetMapping("/save")
    public String Reg_Save()
    {
        return "reg/save";
    }
}
