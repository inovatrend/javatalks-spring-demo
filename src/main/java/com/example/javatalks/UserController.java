package com.example.javatalks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping(value = "/user")
public class UserController {

    private UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping("/list")
    public String listUsers(Model model){

        List<User> users = userManager.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showUserForm(Model model,  @RequestParam(required = false) Long userId){
        User user = userId != null ? userManager.getUser(userId) : new User();
        model.addAttribute("user", user);
        return "user-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String processUserForm(@ModelAttribute User user){
        userManager.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String deleteUser(Long userId){
        userManager.deleteUser(userId);
        return "redirect:/user/list";
    }
}
