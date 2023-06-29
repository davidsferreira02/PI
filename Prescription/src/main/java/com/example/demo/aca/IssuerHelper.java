package com.example.demo.aca;

import com.example.demo.aca.dto.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class IssuerHelper {


    private AriesClient issuerClient;


    public IssuerHelper(@Qualifier("issuerClient") AriesClient issuerClient) {
        this.issuerClient = issuerClient;
    }


    public CreateInvitationResponseDTO outOfBandCreateInvitation() {
        return issuerClient.createInvitation(new CreateInvitationDTO());
    }

    public AcceptRequestResponseDTO didExchangeAcceptRequest(AcceptRequestDTO acceptRequestDTO){
        return issuerClient.acceptRequest(acceptRequestDTO);
    }

    public SchemaResponseDTO schema(SchemaDTO schemaDTO) {
        return issuerClient.schema(schemaDTO);
    }


    public CredentialDefinitionResponseDTO credentialDefinition(CredentialDefinitionDTO credentialDefinitionDTO) {
        return issuerClient.credentialDefinitions(credentialDefinitionDTO);
    }

    public GetOfferResponseDTO getOffer(GetOfferDTO getOfferDTO){
        return issuerClient.getOffer(getOfferDTO);
    }

    public ConnectionsResponseDTO connections() {
        return issuerClient.getConnections();
    }

    public SendOfferResponseDTO sendOffer (SendOfferDTO sendOfferDTO){
        return issuerClient.sendOffer(sendOfferDTO);
    }

    public IssueCredentialsResponseDTO issueCredentials (IssueCredentialsDTO issueCredentialsDTO){
        return issuerClient.issueCredentials(issueCredentialsDTO);
    }







}
