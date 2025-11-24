package com.financialProject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/template"})
public class TemplateController {

    @GetMapping("")
    public String pageHome(){

        return "Template";
    }

}
