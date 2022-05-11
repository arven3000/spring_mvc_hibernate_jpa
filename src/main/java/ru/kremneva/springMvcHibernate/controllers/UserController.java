package ru.kremneva.springMvcHibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kremneva.springMvcHibernate.entity.User;
import ru.kremneva.springMvcHibernate.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> users = userService.listUsers();

        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new-user";
    }

    @PostMapping
    private String create(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new-user";
        }
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    private String edit(@Valid @ModelAttribute("user") User user,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
