package com.example.demo.service;


import com.example.demo.aca.IssuerHelper;
import com.example.demo.aca.dto.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class IssuerService {

    @NonNull
    private final IssuerHelper issuerHelper;


    public CreateInvitationResponseDTO createConnection() {
        CreateInvitationResponseDTO createConnection = issuerHelper.outOfBandCreateInvitation();
        return createConnection;
    }

    public AcceptRequestResponseDTO acceptConnectionInvitationRequest(AcceptRequestDTO acceptRequestDTO)  {

        return issuerHelper.didExchangeAcceptRequest(acceptRequestDTO);
    }


    public SchemaResponseDTO schema(SchemaDTO schemaDTO) {
        return issuerHelper.schema(schemaDTO);
    }

    public CredentialDefinitionResponseDTO credentialDefinition(CredentialDefinitionDTO credentialDefinitionDTO){
        return issuerHelper.credentialDefinition(credentialDefinitionDTO);
    }


}
