//package com.example.vims_backend.controller;
//
//import com.example.vims_backend.entity.PolicyType;
//import com.example.vims_backend.entity.User;
//import com.example.vims_backend.entity.Vehicle;
//import com.example.vims_backend.service.PolicyTypeService;
//import com.example.vims_backend.service.UserService;
//import com.example.vims_backend.service.VehicleService;
//
//import jakarta.servlet.http.HttpSession;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//    
//    @Autowired
//    private VehicleService vehicleService;
//    
//    @Autowired
//    PolicyTypeService policyTypeService;
//
//    @GetMapping("/")
//    public String home() {
//        return "index.jsp";
//    }
//
//    @GetMapping("/registerPage")
//    public String registerPage() {
//        return "register.jsp";
//    }
//
//    @GetMapping("/loginPage")
//    public String loginPage() {
//        return "login.jsp";
//    }
//
//    @PostMapping("/register")
//    public String handleRegister(@ModelAttribute User user, Model model) {
//        if (userService.emailExists(user.getEmail())) {
//            model.addAttribute("error", "Email already exists!");
//            return "register.jsp";
//        }
//        userService.registerUser(user);
//        model.addAttribute("message", "Registered successfully.");
//        return "redirect:/login";
//    }
//
//    @PostMapping("/login")
//    public String handleLogin(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
//        User user = userService.authenticate(email, password);
//        session.setAttribute("user", user);
//
//        if (user == null) {
//            model.addAttribute("error", "Invalid credentials");
//            return "login.jsp";
//        } else {
//            model.addAttribute("user", user);
//
//            if (user.getRole().toString().equals("OFFICER")) {
//                return "redirect:/adminhome";
//            } else {
//                return "redirect:/userhome";
//            }
//        }
//    }
//
//    @GetMapping("/adminhome")
//    public String adminHome() {
//        return "admin/adminhome.jsp";
//    }
//
//    @GetMapping("/userhome")
//    public String userHome() {
//        return "user/userhome.jsp";
//    }
//    
//    @GetMapping("/viewUsers")
//    public String viewUsers(Model model) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "admin/viewUsers.jsp";
//    }
//    
//    @GetMapping("/viewNotifications")
//    public String notificationsPage() {
//        return "viewNotifications.jsp";
//    }
//    
//    @GetMapping("/myVehicles")
//    public String showVehicles(HttpSession session, Model model) {
//        User user = (User) session.getAttribute("user");
//        List<Vehicle> vehicles = vehicleService.getVehiclesByUserId(user.getUserId());
//        model.addAttribute("vehicles", vehicles);
//        return "user/myVehicles.jsp";
//    }
//    
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate(); 
//        return "redirect:/login.jsp";
//    }
//    
//    @PostMapping("/addVehicle")
//    public String addVehicleFromForm(@ModelAttribute Vehicle vehicle, HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return "redirect:/loginPage";
//        }
//
//        vehicle.setUser(user);
//        vehicleService.addVehicle(vehicle);
//
//        return "redirect:/myVehicles"; 
//    }
//    
//    @GetMapping("/editVehicle/{id}")
//    public String editVehicle(@PathVariable int id, Model model, HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return "redirect:/loginPage";
//        }
//
//        Vehicle vehicle = vehicleService.getVehicleById(id);
//        model.addAttribute("vehicle", vehicle);
//        model.addAttribute("vehicles", vehicleService.getVehiclesByUserId(user.getUserId()));
//        return "myVehicles.jsp";
//    }
//    
//    @PostMapping("/updateVehicle")
//    public String updateVehicle(@ModelAttribute Vehicle vehicle, HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return "redirect:/loginPage";
//        }
//
//        vehicle.setUser(user);
//        vehicleService.updateVehicle(vehicle.getVehicleId(), vehicle);
//        return "redirect:/myVehicles";
//    }
//    
//    @GetMapping("/deleteVehicle/{id}")
//    public String deleteVehicle(@PathVariable int id) {
//        vehicleService.deleteVehicle(id);
//        return "redirect:/myVehicles";
//    }
//    
//    @GetMapping("/viewPolicies")
//    public String viewPolicies(Model model) {
//        model.addAttribute("policies", policyTypeService.getAllPolicyTypes());
//        return "user/viewPolicies.jsp";
//    }
//    
//    @GetMapping("/managePolicies")
//    public String managePolicies(Model model) {
//        List<PolicyType> policies = policyTypeService.getAllPolicyTypes();
//        model.addAttribute("policyTypes", policies);
//        return "admin/managePolicies.jsp";
//    }
//
//    @PostMapping("/addPolicyType")
//    public String addPolicyType(@ModelAttribute PolicyType policyType) {
//        policyTypeService.addPolicyType(policyType);
//        return "redirect:/managePolicies";
//    }
//
//    @GetMapping("/deletePolicyType/{id}")
//    public String deletePolicyType(@PathVariable int id) {
//        policyTypeService.deletePolicyType(id);
//        return "redirect:/managePolicies";
//    }
//
//}
