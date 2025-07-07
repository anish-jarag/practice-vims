package com.example.vims_backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.vims_backend.entity.Addon;
import com.example.vims_backend.entity.Proposal;
import com.example.vims_backend.entity.User;
import com.example.vims_backend.entity.Vehicle;
import com.example.vims_backend.entity.enums.ProposalStatus;
import com.example.vims_backend.service.AddonService;
import com.example.vims_backend.service.PolicyTypeService;
import com.example.vims_backend.service.ProposalAddonService;
import com.example.vims_backend.service.ProposalService;
import com.example.vims_backend.service.VehicleService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserDashboardController {

    @Autowired private VehicleService vehicleService;
    @Autowired private PolicyTypeService policyTypeService;
    @Autowired private ProposalService proposalService;
    @Autowired private ProposalAddonService proposalAddonService;
    @Autowired private AddonService addonService;

    @GetMapping("/userhome")
    public String userHome() {
        return "user/userhome"; 
    }

    @GetMapping("/viewNotifications")
    public String notifications() {
        return "user/viewNotifications"; 
    }

    @GetMapping("/myVehicles")
    public String viewVehicles(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/loginPage";

        List<Vehicle> vehicles = vehicleService.getVehiclesByUserId(user.getUserId());
        model.addAttribute("vehicles", vehicles);
        return "user/myVehicles"; 
    }

    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute Vehicle vehicle, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/loginPage"; 

        vehicle.setUser(user);
        vehicleService.addVehicle(vehicle);
        return "redirect:/user/myVehicles";
    }

    @GetMapping("/editVehicle/{id}")
    public String editVehicle(@PathVariable int id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/loginPage"; 

        model.addAttribute("vehicle", vehicleService.getVehicleById(id));
        model.addAttribute("vehicles", vehicleService.getVehiclesByUserId(user.getUserId()));
        return "user/myVehicles"; 
    }

    @PostMapping("/updateVehicle")
    public String updateVehicle(@ModelAttribute Vehicle vehicle, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/loginPage"; 

        vehicle.setUser(user);
        vehicleService.updateVehicle(vehicle.getVehicleId(), vehicle);
        return "redirect:/user/myVehicles";
    }

    @GetMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/user/myVehicles";
    }

    @GetMapping("/viewPolicies")
    public String viewPolicies(Model model) {
        model.addAttribute("policies", policyTypeService.getAllPolicyTypes());
        return "user/viewPolicies"; 
    }
    
    @GetMapping("/proposalPage")
    public String showProposalPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/loginPage";

        model.addAttribute("vehicles", vehicleService.getVehiclesByUserId(user.getUserId()));
        model.addAttribute("policyTypes", policyTypeService.getAllPolicyTypes());
        model.addAttribute("addons", addonService.getAllAddons()); 

        return "user/proposalPage";
    }
    
    @PostMapping("/submitProposal")
    public String submitProposal(
            @RequestParam int vehicleId,
            @RequestParam int policyTypeId,
            @RequestParam(required = false) List<Integer> addonIds,
            HttpSession session
    ) {
     User user = (User) session.getAttribute("user");
     if (user == null) return "redirect:/loginPage";

     Proposal proposal = new Proposal();
     proposal.setSubmissionDate(LocalDate.now());
     proposal.setStatus(ProposalStatus.SUBMITTED);
     proposal.setQuoteAmount(0); 

     proposalService.addProposal(proposal);

     double addonTotal = 0;
     if (addonIds != null) {
         for (int addonId : addonIds) {
             Addon addon = addonService.getAddonById(addonId);
             if (addon != null) {
            	 addonTotal += addon.getExtraCost();
                 proposalAddonService.addProposalAddon(proposal, addon);
             }
         }
     }

     double totalQuote = proposal.getPolicyType().getBasePremium() + addonTotal;
     proposal.setQuoteAmount(totalQuote);
     proposalService.addProposal(proposal);

        return "redirect:/user/viewProposals";
    }
    
    @GetMapping("/viewProposals")
    public String viewProposals(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/loginPage";

        List<Proposal> proposals = proposalService.getProposalsByUserId(user.getUserId());
        model.addAttribute("proposals", proposals);
        return "user/viewProposals"; 
    }


}
