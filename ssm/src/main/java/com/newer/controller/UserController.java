package com.newer.controller;


import com.newer.domain.User;
import com.newer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("userName") String username,
                        @RequestParam("pwd") String password,
                        ModelMap modelMap,
                        HttpSession session) {

        User user = userService.findByParam(username, password);

        if (user == null) {
            //Map,Model,ModelMap都表示模型数据集合
            modelMap.put("msg", "用户名或者密码错误");

            return "login";

        } else {
            session.setAttribute("loginer", user);
            return "redirect:/index.jsp";
        }
    }









}
