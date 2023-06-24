package com.example.demo.controller;

import com.example.demo.aca.dto.*;

import com.example.demo.model.User;
import com.example.demo.service.IssuerService;
import com.example.demo.service.PrescriptionService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/issuer")
@RequiredArgsConstructor
public class IssuerController {


    @NonNull
    private final IssuerService issuerService;
    @NonNull
    private final UserService userService;

    @NonNull

    private final PrescriptionService prescriptionService;

    @PostMapping("/create-invitation")
    public CreateInvitationResponseDTO createConnection() {
        return issuerService.createConnection();
    }


    @PostMapping("/accept-request")
    public AcceptRequestResponseDTO acceptConnectionRequest(@RequestBody AcceptRequestDTO acceptRequestDTO) {

        return issuerService.acceptConnectionInvitationRequest(acceptRequestDTO);

    }


    @PostMapping("/schemas")
    public SchemaResponseDTO schema(@RequestBody() SchemaDTO schemaDTO) {


        return issuerService.schema(schemaDTO);
    }

    @PostMapping("/credential-definitions")
    public CredentialDefinitionResponseDTO credentialDefinitions(@RequestBody() CredentialDefinitionDTO credentialDefinitionDTO) {
        return issuerService.credentialDefinition(credentialDefinitionDTO);
    }

    @PostMapping("/send-offer")
    public SendOfferResponseDTO sendOffer(@RequestBody() SendOfferDTO sendOfferDTO) {
        return issuerService.sendOffer(sendOfferDTO);
    }

    @PostMapping("issue-credentials")
    public IssueCredentialsResponseDTO issueCredentials(IssueCredentialsDTO issueCredentialsDTO) {
        return issuerService.issueCredentials(issueCredentialsDTO);
    }


    @GetMapping("/prescription/create")
    public String showPrescriptionForm(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findUserByEmail(currentPrincipalName);
        if (user.getRole().equals("doctor")) {

          //  IssueCredentialsResponseDTO issueCredentialsResponseDTO = issuerService.issueCredentials(IssueCredentia);// what I put here ?? Instead, using database i need to implement getCredentials on both sides holder and issuer?
            model.addAttribute("prescription", issueCredentialsResponseDTO);
            return "createPrescription";
        }
        return null;
    }
//  i need to call send-offer and send-request if yes where in function showPrescriptionform or Prescription?
    @PostMapping("/save")
    public String Prescription(@Valid @ModelAttribute("prescription") PrescriptionDTO prescriptionDTO) {


        prescriptionService.savePrescription(prescriptionDTO);
        return "redirect:/users";
    }


}


