package ru.alexpolkin.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alexpolkin.springcourse.dao.UserDAO;
import ru.alexpolkin.springcourse.model.User;

    /*
    CRUD
    POST add() -
    GET get()
    GET getAll()
    set()
    delete()
    clear()

    */

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return "users/list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.get(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") User user) {
        userDAO.add(user);
        return "redirect:/users";
    }

    @GetMapping("/clear")
    public String clear() {
        userDAO.clear();
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.get(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDAO.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/users";
    }
}
