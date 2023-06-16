package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.User;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services.UserServiceImpl;

import java.security.Principal;
import java.util.List;

@Controller
public class PeopleController {
    private final UserServiceImpl userService;

    @Autowired
    public PeopleController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String getUserInfoPage(Model model, Principal principal) {
        model.addAttribute("user", userService.findUserByUsername(principal.getName()));
        return "user/user";
    }

    @GetMapping(value = "/admin")
    public String getAllUsers(Model model, Principal principal) {
        model.addAttribute("listUsers", userService.findAll());
        model.addAttribute("user", userService.findUserByUsername(principal.getName()));
        model.addAttribute("newUser", new User());
        model.addAttribute("listAllRoles", userService.getListRole());
        return "admin/admin";
    }

    @PutMapping(value = "/admin/users")
    public String putUser(@ModelAttribute(value = "newUser") User newUser) {
        userService.save(newUser);
        return "redirect:/admin";
    }

    @PatchMapping(value = "/admin/users/{id}")
    public String patchUser(@ModelAttribute(value = "user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/admin/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return "redirect:/admin";
    }

}
