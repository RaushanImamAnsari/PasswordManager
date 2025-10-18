package com.example.passwordmanager.controller;

import com.example.passwordmanager.model.PasswordEntry;
import com.example.passwordmanager.service.PasswordEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final PasswordEntryService service;

    public MainController(PasswordEntryService service) {
        this.service = service;
    }

    // Login page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Handle login
    @PostMapping("/login")
    public String login(@RequestParam("role") String role,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {

        System.out.println("Login attempt: " + role + " / " + username);

        if ("admin".equals(role) && "admin".equals(username) && "admin123".equals(password)) {
            return "redirect:/admin";
        } else if ("user".equals(role) && "user".equals(username) && "user123".equals(password)) {
            return "redirect:/user";
        }

        return "redirect:/?error=true";
    }

    // Admin dashboard
    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("entries", service.getAll());
        return "admin";
    }

    // User dashboard
    @GetMapping("/user")
    public String userPage(Model model) {
        model.addAttribute("entries", service.getAll());
        return "user";
    }

    // Admin CRUD
    @PostMapping("/admin/add")
    public String addEntry(@ModelAttribute PasswordEntry entry) {
        service.save(entry);
        return "redirect:/admin";
    }

    @PostMapping("/admin/update/{id}")
    public String updateEntry(@PathVariable Long id, @ModelAttribute PasswordEntry entry) {
        PasswordEntry existing = service.getById(id).orElse(null);
        if (existing != null) {
            existing.setSystem(entry.getSystem());
            existing.setEnvironment(entry.getEnvironment());
            existing.setUrl(entry.getUrl());
            existing.setUsername(entry.getUsername());
            existing.setPassword(entry.getPassword());
            service.save(existing);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteEntry(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin";
    }
}
