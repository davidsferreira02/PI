package com.example.demo.controller;

import com.example.demo.aca.dto.PrescriptionDTO;
import com.example.demo.aca.dto.UserDTO;
import com.example.demo.model.Prescription;
import com.example.demo.model.User;
import com.example.demo.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class PrescriptionController {
    PrescriptionService prescriptionService;

    @GetMapping("/Prescription/")
    public String showPrescriptionForm(Model model){
        // create model object to store form data
       PrescriptionDTO prescription = new PrescriptionDTO();
        model.addAttribute("prescription", prescription);
        return "createPrescription";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/Prescription/save")
    public String Prescription(@Valid @ModelAttribute("prescription") PrescriptionDTO prescriptionDTO,
                               BindingResult result,
                               Model model){


       /* if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

     /*   if(result.hasErrors()){
            model.addAttribute("prescripton", prescriptionDTO);
            return "/Prescription";
        }
*/
        prescriptionService.savePrescription(prescriptionDTO);
        return "redirect:/Prescription?success";
    }
}