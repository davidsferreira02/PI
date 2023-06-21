package com.example.demo.controller;

import com.example.demo.aca.dto.*;
import com.example.demo.model.Prescription;
import com.example.demo.model.User;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.service.HolderService;
import com.example.demo.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/holder")
@RequiredArgsConstructor
public class HolderController {


    @NonNull
    private final HolderService holderService;
    @NonNull
    private final UserService userService;

    //private PrescriptionService prescriptionService;

    @NonNull
    private PrescriptionRepository prescriptionRepository;

    @PostMapping("/receive-invitation")
    public ReceivedInvitationResponseDTO receivedConnection(@RequestBody InvitationDTO invitationDTO) throws IOException {
        return holderService.receivedConnection(invitationDTO);
    }

    @GetMapping("/connections")
    public ConnectionsResponseDTO connections() {

        return holderService.connections();

    }

    @PostMapping("/send-proposal")
    public SendProposalResponseDTO sendProposal(@RequestBody SendProposalDTO sendProposalDTO) {
        return holderService.sendProposal(sendProposalDTO);
    }

    @PostMapping("/send-request")
    public SendRequestResponseDTO sendRequest(@RequestBody SendRequestDTO sendRequestDTO) {
        return holderService.sendRequest(sendRequestDTO);
    }

    @PostMapping("/store-credentials")
    public StoreCredentialsResponseDTO storeCredentials(@RequestBody StoreCredentialsDTO storeCredentialsDTO){
        return holderService.storeCredentials(storeCredentialsDTO);
    }



    @GetMapping("/prescription")
    public String getPrescription(Model model,GetCredentialsDTO getCredentialsDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findUserByEmail(currentPrincipalName);
        if (user.getRole().equals("patient")) {
         GetCredentialsResponseDTO getCredentialResponse=holderService.getCredentials();

           //prescription=prescriptionService.findAllByPacient(USER.GETname());
            List<Prescription> prescription = prescriptionRepository.findAll();
            List<Prescription> prescriptionsPacients=new ArrayList<>();
            for(Prescription prescription1:prescription) {

              if(  prescription1.getPatientName().equals(user.getName())){
                  prescriptionsPacients.add(prescription1);
              }

                  model.addAttribute("prescription",prescriptionsPacients);

            }
            return "prescription";
            /*
            if(!getCredentialResponse.getAttrs().isEmpty()) {
                model.addAttribute("prescription",getCredentialResponse.getAttrs());
                return "prescription";
            }*/

        }
        return null;
    }


}
