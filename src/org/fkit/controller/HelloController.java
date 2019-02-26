package org.fkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController  {

    @RequestMapping("helloController")
    public String helloController(Model model){
        model.addAttribute("message","use @Controller");
        return "welcome";
    }
}
