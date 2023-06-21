package com.example.demo.controller;

import com.example.demo.aca.dto.PrescriptionDTO;

import com.example.demo.aca.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.PrescriptionService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("prescription")
public class PatientController {
    PrescriptionService prescriptionService;
    UserService userService;

    public PatientController(PrescriptionService prescriptionService, UserService userService){
        this.prescriptionService=prescriptionService;
        this.userService=userService;

    }

/*    @GetMapping("/create")
    public String showPrescriptionForm(Model model){
        // create model object to store form data
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findUserByEmail(currentPrincipalName);
        if(user.getRole().equals("doctor")) {
            PrescriptionDTO prescription = new PrescriptionDTO();
            model.addAttribute("prescription", prescription);
            return "createPrescription";
        }
        return null;
    }*/

    // handler method to handle user registration form submit request
    @PostMapping("/save")
    public String Prescription(@Valid @ModelAttribute("prescription") PrescriptionDTO prescriptionDTO, UserDTO userDto,
                               BindingResult result,
                               Model model){

        User existingUser = userService.findUserByEmail(userDto.getEmail());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findUserByEmail(currentPrincipalName);



        if (user != null && !user.getName().equals(prescriptionDTO.getDoctorName())) {
            result.rejectValue("doctorName", null,
                    "You aren´t this doctor");
        }

        if (existingUser != null && !existingUser.getName().equals(prescriptionDTO.getPatientName())) {
            result.rejectValue("patientName", null,
                    "Doesn't exist this patient");
        }

        if (result.hasErrors()) {
            model.addAttribute("prescription", prescriptionDTO);
            return "createPrescription";
        }


        prescriptionService.savePrescription(prescriptionDTO);
        return "redirect:/users";
    }

   /* @GetMapping("")
    public String getPrescription(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findUserByEmail(currentPrincipalName);
        if (user.getRole().equals("patient")) {
            List<PrescriptionDTO> prescription = prescriptionService.findAllPrescriptionByPacientName(user.getName());
            if(!prescription.isEmpty()) {
                model.addAttribute("prescription", prescription);
                return "prescription";
            }

        }
        return null;
    }*/


}