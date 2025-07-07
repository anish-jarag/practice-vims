package com.example.vims_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vims_backend.entity.PolicyType;
import com.example.vims_backend.service.PolicyTypeService;
import com.example.vims_backend.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired private UserService userService;
    @Autowired private PolicyTypeService policyTypeService;

    @GetMapping("/adminhome")
    public String adminHome() { return "admin/adminhome"; }

    @GetMapping("/viewUsers")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/viewUsers";
    }

    @GetMapping("/managePolicies")
    public String managePolicies(Model model) {
        model.addAttribute("policyTypes", policyTypeService.getAllPolicyTypes());
        return "admin/managePolicies";
    }

    @PostMapping("/addPolicyType")
    public String addPolicyType(@ModelAttribute PolicyType policyType) {
        policyTypeService.addPolicyType(policyType);
        return "redirect:/admin/managePolicies";
    }

    @GetMapping("/deletePolicyType/{id}")
    public String deletePolicyType(@PathVariable int id) {
        policyTypeService.deletePolicyType(id);
        return "redirect:/admin/managePolicies";
    }
}

