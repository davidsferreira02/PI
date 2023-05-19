package com.example.demo.controller;

import com.example.demo.aca.dto.*;

import com.example.demo.service.IssuerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/issuer")
@RequiredArgsConstructor
public class IssuerController {


    @NonNull
    private final IssuerService issuerService;

    @PostMapping("/create-invitation")
    public InvitationDTO createConnection() throws IOException {
        return issuerService.createConnection();
    }

    @PostMapping("/accept-request")
    public AcceptInvitationResponseDTO acceptConnectionRequest(@RequestBody ReceivedInvitationResponseDTO receivedInvitationResponseDTO) throws IOException {

        return issuerService.acceptConnectionInvitationRequest(receivedInvitationResponseDTO);

    }


    @PostMapping("/schemas")
    public SchemaResponseDTO schema(@RequestBody() SchemaDTO schemaDTO) {


        return issuerService.schema(schemaDTO);
    }
    @PostMapping("/credential-definitions")
    public CredentialDefinitionResponseDTO credentialDefinitions(@RequestBody() CredentialDefinitionDTO credentialDefinitionDTO){
        return issuerService.credentialDefinition(credentialDefinitionDTO);
    }


}
