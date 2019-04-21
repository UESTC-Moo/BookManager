package com.nowcoder.project.controllers;

import com.nowcoder.project.biz.LoginBiz;
import com.nowcoder.project.model.User;
import com.nowcoder.project.service.HostHolder;
import com.nowcoder.project.service.TicketService;
import com.nowcoder.project.service.UserService;
import com.nowcoder.project.utils.CookieUtils;
import com.nowcoder.project.utils.TicketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private LoginBiz loginBiz;

    @RequestMapping(path = "/users/register",method = RequestMethod.GET)
    public String register(){
        return "login/register";
    }

    @RequestMapping(path = "users/register/do",method = RequestMethod.POST)
    public String doRegister(Model model, HttpServletResponse response,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        try {
            String ticket = loginBiz.register(user);
            CookieUtils.writeCookie("ticket",ticket,response);
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            return "404";
        }
    }

    @RequestMapping(path = "users/login",method = RequestMethod.GET)
    public String login(){
        return "login/login";
    }

    @RequestMapping(path = "users/login/do",method = RequestMethod.POST)
    public String doLogin(Model model, HttpServletResponse response,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password){
        try{
            String ticket = loginBiz.login(email,password);
            CookieUtils.writeCookie("ticket",ticket,response);
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            return "404";
        }
    }

    @RequestMapping(path = "users/logout/do",method = RequestMethod.GET)
    public String doLogout(@CookieValue("ticket") String ticket){
        loginBiz.logout(ticket);
        return "redirect:/index";
    }
}
