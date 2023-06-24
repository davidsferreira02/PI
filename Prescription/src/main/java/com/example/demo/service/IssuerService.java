package com.example.demo.service;


import com.example.demo.aca.IssuerHelper;
import com.example.demo.aca.dto.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.sendgrid.SendGridProperties;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class IssuerService  {

    @NonNull
    private final IssuerHelper issuerHelper;


    public CreateInvitationResponseDTO createConnection() {
        CreateInvitationResponseDTO createConnection = issuerHelper.outOfBandCreateInvitation();
        return createConnection;
    }

    public AcceptRequestResponseDTO acceptConnectionInvitationRequest(AcceptRequestDTO acceptRequestDTO) {

        return issuerHelper.didExchangeAcceptRequest(acceptRequestDTO);
    }


    public SchemaResponseDTO schema(SchemaDTO schemaDTO) {
        return issuerHelper.schema(schemaDTO);
    }

    public CredentialDefinitionResponseDTO credentialDefinition(CredentialDefinitionDTO credentialDefinitionDTO) {
        return issuerHelper.credentialDefinition(credentialDefinitionDTO);
    }

    public SendOfferResponseDTO sendOffer(SendOfferDTO sendOfferDTO) {
        return issuerHelper.sendOffer(sendOfferDTO);
    }


    public IssueCredentialsResponseDTO issueCredentials(IssueCredentialsDTO issueCredentialsDTO) {
        return issuerHelper.issueCredentials(issueCredentialsDTO);
    }


}
