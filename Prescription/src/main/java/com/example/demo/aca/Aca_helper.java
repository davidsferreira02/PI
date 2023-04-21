package com.example.demo.aca;

import org.hyperledger.acy_py.generated.model.*;
import org.hyperledger.aries.AriesClient;

import org.hyperledger.aries.api.connection.ConnectionRecord;

import org.hyperledger.aries.api.credential_definition.CredentialDefinition;
import org.hyperledger.aries.api.did_exchange.DidExchangeAcceptInvitationFilter;
import org.hyperledger.aries.api.did_exchange.DidExchangeAcceptRequestFilter;
import org.hyperledger.aries.api.issue_credential_v2.V20CredBoundOfferRequest;
import org.hyperledger.aries.api.issue_credential_v2.V20CredExRecord;
import org.hyperledger.aries.api.issue_credential_v2.V2CredentialExchangeFree;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;
import org.hyperledger.aries.api.out_of_band.InvitationMessage;
import org.hyperledger.aries.api.out_of_band.ReceiveInvitationFilter;
import org.hyperledger.aries.api.schema.SchemaSendRequest;
import org.hyperledger.aries.api.schema.SchemaSendResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;


@Service
public class Aca_helper {
    AriesClient client;

    //Alice

    public Optional<InvitationRecord> outOfBandCreateInvitation(InvitationCreateRequest request, CreateInvitationFilter filter) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.outOfBandCreateInvitation(request, filter);


    }


    public Optional<ConnectionRecord> didExchangeAcceptRequest(String connectionId, DidExchangeAcceptRequestFilter filter) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.didExchangeAcceptRequest(connectionId, filter);


    }

    public Optional<SchemaSendResponse> createSchema(SchemaSendRequest schema) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.schemas(schema);
    }

    public Optional<CredentialDefinition.CredentialDefinitionResponse> credentialDefinition(CredentialDefinition.CredentialDefinitionRequest defReq) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.credentialDefinitionsCreate(defReq);
    }

    public Optional<V20CredExRecord> SendOffer(String credentialExchangeId, V20CredBoundOfferRequest offerRequest) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.issueCredentialV2RecordsSendOffer(credentialExchangeId, offerRequest);

    }

    public Optional<V20CredExRecordDetail> Issue(String credentialExchangeId, V20CredIssueRequest request) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.issueCredentialV2RecordsIssue(credentialExchangeId, request);
    }


    // Bob


    public <T> Optional<ConnectionRecord> outOfBandReceiveInvitation(InvitationMessage<T> request, ReceiveInvitationFilter filter) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.outOfBandReceiveInvitation(request, filter);
    }


    public Optional<ConnectionRecord> didExchangeAcceptInvitation(String connectionId, DidExchangeAcceptInvitationFilter filter) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.didExchangeAcceptInvitation(connectionId, filter);
    }

    public Optional<V20CredExRecord> v20sendProposal(V2CredentialExchangeFree request) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.issueCredentialV2SendProposal(request);
    }

    public Optional<V20CredExRecord> v20sendRequest(String credentialExchangeId, V20CredRequestRequest request) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.issueCredentialV2RecordsSendRequest(credentialExchangeId, request);

    }

    public Optional<V20CredExRecordDetail> v20Store(String credentialExchangeId, V20CredStoreRequest request) throws IOException {
        client = new AriesClient("http://localhost:11000", null, null, null);
        return client.issueCredentialV2RecordsStore(credentialExchangeId, request);
    }


}
