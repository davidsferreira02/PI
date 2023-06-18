package com.example.demo.controller;

import com.example.demo.aca.dto.*;

import com.example.demo.service.IssuerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@RestController
@RequestMapping("/issuer")
@RequiredArgsConstructor
public class IssuerController {


    @NonNull
    private final IssuerService issuerService;

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




}
