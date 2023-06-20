package com.example.demo.controller;

import com.example.demo.aca.dto.*;
import com.example.demo.model.User;
import com.example.demo.service.HolderService;
import com.example.demo.service.IssuerService;
import com.example.demo.service.PrescriptionService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/holder")
@RequiredArgsConstructor
public class HolderController {


    @NonNull
    private final HolderService holderService;
    @NonNull
    private final UserService userService;

    private PrescriptionService prescriptionService;

    @PostMapping("/receive-invitation")
    public ReceivedInvitationResponseDTO receivedConnection(@RequestBody InvitationDTO invitationDTO) throws IOException {
        return holderService.receivedConnection(invitationDTO);
    }

    @GetMapping("/connections")
    public ConnectionsResponseDTO connections() {

        return holderService.connections();

    }

    @PostMapping("/send-proposal")
    public SendProposalResponseDTO sendProposal(@RequestBody SendProposalDTO sendProposalDTO){
        return holderService.sendProposal(sendProposalDTO);
    }

    @PostMapping("/send-request")
            public SendRequestResponseDTO sendRequest(@RequestBody SendRequestDTO sendRequestDTO){
            return holderService.sendRequest(sendRequestDTO);
            }

    @GetMapping("/prescription")
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
    }










}
