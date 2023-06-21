package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.User;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services.RoleService;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services.UserService;

import java.security.Principal;

@Controller
public class PeopleController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public PeopleController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "user/user";
    }

    @GetMapping(value = "/admin")
    public String getAdminPage(Model model, Principal principal) {
        model.addAttribute("listUsers", userService.findAll());
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        model.addAttribute("newUser", new User());
        model.addAttribute("listAllRoles", roleService.getListRole());
        return "admin/admin";
    }

    @PutMapping(value = "/admin/users")
    public String addUser(@ModelAttribute(value = "newUser") User newUser) {
        userService.save(newUser);
        return "redirect:/admin";
    }

    @PutMapping(value = "/admin/users/{id}")
    public String updateUser(@ModelAttribute(value = "user") User user) {
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
