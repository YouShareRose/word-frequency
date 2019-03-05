package org.fkit.controller;

import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {
    private static List<User> userList;
    public UserController(){
        super();
        userList=new ArrayList<>();
    }

    @GetMapping(value = "/register")
    public String registerFrom(){
        System.out.println("register GET方法被调用...");
        // 跳转到注册页面
        return "registerForm";
    }

    @PostMapping(value="/register")
    // 将请求中的loginname参数的值赋给loginname变量,password和username同样处理
    public String register(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            @RequestParam("username") String username) {
        System.out.println("register POST方法被调用...");
        // 创建User对象
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername(username);
        System.out.println("add "+user);
        // 模拟数据库存储User信息
        userList.add(user);
        // 跳转到登录页面
        return "loginForm";
    }

    @RequestMapping("/login")
    public String login(
            // 将请求中的loginname参数的值赋给loginname变量,password同样处理
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model) {
        System.out.println("登录名:"+loginname + " 密码:" + password);
        // 到集合中查找用户是否存在，此处用来模拟数据库验证
        for(User user : userList){
            if(user.getLoginname().equals(loginname)
                    && user.getPassword().equals(password)){
                model.addAttribute("user",user);
                return "welcomelogin";
            }
        }
        return "loginForm";
    }

}
