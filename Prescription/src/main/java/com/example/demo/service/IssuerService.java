package com.example.demo.service;


import com.example.demo.aca.IssuerHelper;
import com.example.demo.aca.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;


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
    public SendOfferResponseDTO sendOffer(SendOfferDTO sendOfferDTO){
        return issuerHelper.sendOffer(sendOfferDTO);
    }


    public IssueCredentialsResponseDTO issueCredentials(IssueCredentialsDTO issueCredentialsDTO){
        return issuerHelper.issueCredentials(issueCredentialsDTO);
    }








}
