package com.example.demo.aca;
import com.example.demo.aca.dto.CreateInvitationDTO;
import com.example.demo.aca.dto.CreateInvitationResponseDTO;
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


    public CreateInvitationResponseDTO outOfBandCreateInvitation() throws IOException {
        return issuerClient.createInvitation(new CreateInvitationDTO());
    }

/*
    public Optional<ConnectionRecord> didExchangeAcceptRequest(String connectionId, DidExchangeAcceptRequestFilter filter) throws IOException {
        return issuerClient.didExchangeAcceptRequest(connectionId, filter);
    }

    public Optional<SchemaSendResponse> createSchema(SchemaSendRequest schema) throws IOException {
        return issuerClient.schemas(schema);
    }

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
