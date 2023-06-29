package com.example.demo.controller;

import com.example.demo.aca.dto.*;
import com.example.demo.model.User;
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


@Controller
@RequestMapping("/holder")
@RequiredArgsConstructor
public class HolderController {


    @NonNull
    private final HolderService holderService;
    @NonNull
    private final UserService userService;





    @PostMapping("/receive-invitation")
    public ReceivedInvitationResponseDTO receivedConnection(@RequestBody InvitationDTO invitationDTO) throws IOException {
        return holderService.receivedConnection(invitationDTO);
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
    public StoreCredentialsResponseDTO storeCredentials(@RequestBody StoreCredentialsDTO storeCredentialsDTO) {
        return holderService.storeCredentials(storeCredentialsDTO);
    }


    // I don´t need to call here send-Proposal and storeCredentials here?,if yes how to call sendProposal with sendProposalDTO argument?

    @GetMapping("/prescription")
    public String getPrescription(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findUserByEmail(currentPrincipalName);

        if (user.getRole().equals("patient")) {
            GetCredentialsResponseDTO getCredentialResponse = holderService.getCredentials();
            if (!getCredentialResponse.getResults().isEmpty()) {
                model.addAttribute("prescription", getCredentialResponse.getResults());
            }


        }
        return "prescription";


    }
}



