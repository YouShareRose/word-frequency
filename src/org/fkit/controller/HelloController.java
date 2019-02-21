package org.fkit.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("handleRequest 被调用");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Hello nerd");
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        return mv;
    }
}
