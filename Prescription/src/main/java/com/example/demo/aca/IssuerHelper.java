package com.example.demo.aca;

import com.example.demo.aca.dto.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class IssuerHelper {


    private AriesClient issuerClient;


    public IssuerHelper(@Qualifier("issuerClient") AriesClient issuerClient) {
        this.issuerClient = issuerClient;
    }


    public CreateInvitationResponseDTO outOfBandCreateInvitation() {
        return issuerClient.createInvitation(new CreateInvitationDTO());
    }

    public AcceptInvitationResponseDTO didExchangeAcceptRequest(ReceivedInvitationResponseDTO receivedInvitationResponseDTO) throws IOException {
        return issuerClient.acceptInvitation(receivedInvitationResponseDTO);
    }

    public SchemaResponseDTO schema(SchemaDTO schemaDTO) {
        return issuerClient.schema(schemaDTO);
    }

    /*

    public Optional<CredentialDefinition.CredentialDefinitionResponse> credentialDefinition(CredentialDefinition.CredentialDefinitionRequest defReq) throws IOException {
        return issuerClient.credentialDefinitionsCreate(defReq);
    }

    public Optional<V20CredExRecord> sendOffer(String credentialExchangeId, V20CredBoundOfferRequest offerRequest) throws IOException {
        return issuerClient.issueCredentialV2RecordsSendOffer(credentialExchangeId, offerRequest);

    }

    public Optional<V20CredExRecordDetail> issue(String credentialExchangeId, V20CredIssueRequest request) throws IOException {
        return issuerClient.issueCredentialV2RecordsIssue(credentialExchangeId, request);
    }*/

    //public String getConnectionId(String msgId) throws IOException {
    //Optional<List<ConnectionRecord>> connections = issuerClient.connections(ConnectionFilter.builder().build());
    //    return connections.map(connectionRecords -> connectionRecords.stream().filter(c -> c.getInvitationMsgId().equals(msgId)).map(ConnectionRecord::getConnectionId).findFirst().get()).orElse(null);
    //}


}