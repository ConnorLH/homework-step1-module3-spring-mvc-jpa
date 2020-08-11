package cn.corner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @company: yzw
 * @author: connor.h.liu
 * @version: V1.0
 * date: 2020-08-11 10:20
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, ModelAndView modelAndView, HttpServletRequest request) {
        if (!"admin".equals(username) || !"admin".equals(password)) {
            modelAndView.setViewName("login");
            modelAndView.addObject("message", "用户名密码错误");
            return modelAndView;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", "admin");
        modelAndView.setViewName("redirect:/resume/list");
        return modelAndView;
    }
}
