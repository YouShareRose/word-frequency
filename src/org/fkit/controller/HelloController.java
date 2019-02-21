package org.fkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController  {

    @RequestMapping(value = "/hello")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("handleRequest 被调用");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Hello nerd");
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        return mv;
    }
}
