package ru.svetlanaagaeva.pp_3_1_1_spring_boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.svetlanaagaeva.pp_3_1_1_spring_boot.entity.User;
import ru.svetlanaagaeva.pp_3_1_1_spring_boot.service.UserService;

@Controller
@RequestMapping("/api")
public class PeopleController {

    private final UserService userService;

    @Autowired
    public PeopleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/people")
    public String ListOfPeople(Model model) {
        model.addAttribute("people", userService.getAllUsers());
        return "list";
    }


    @GetMapping("/people/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/people")
    public String createNewUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);
        return "redirect:/api/people";
    }

    @GetMapping("/people/edit")
    public String editUserForm(@RequestParam int id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "error";
        }
        model.addAttribute("user", user); //
        return "edit";

    }

    @PostMapping("/people/update")
    public String updateUser(@RequestParam int id, @ModelAttribute("user") User newUser) {

        userService.updateUser(id, newUser);
        return "redirect:/api/people";
    }

    @GetMapping("/people/delete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUserById(id);
        return "redirect:/api/people";
    }
}