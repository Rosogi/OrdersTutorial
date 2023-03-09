package com.rosogisoft.loginverification.controllers;

import com.rosogisoft.loginverification.models.LoginModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/")
    public String displayLoginForm(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "login_page.html";
    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("loginModel", loginModel);
            return "login_page.html";
        }

        model.addAttribute("loginModel", loginModel);
        return "loginResult_page.html";
    }

}
