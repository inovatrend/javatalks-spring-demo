package com.example.javatalks;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user/rest")
public class UserRestController {

    private UserManager userManager;

    public UserRestController(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping("/list")
    public List<User> listUsers(){
        return userManager.getAllUsers();
    }



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Long processUserForm(@RequestBody User user){
        try {
            return userManager.saveUser(user).getId();
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @RequestMapping("/delete")
    public Boolean deleteUser(Long userId){
        try {
            userManager.deleteUser(userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
