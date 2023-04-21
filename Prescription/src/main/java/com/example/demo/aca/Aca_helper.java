package com.example.demo.aca;

import com.example.demo.dto.AcceptRequestDTO;
import com.example.demo.out_of_band.CreateConnection;
import com.example.demo.response.*;
import com.example.demo.dto.SchemaDTO;
import lombok.NonNull;
import org.hyperledger.acy_py.generated.model.InvitationMessage;
import org.hyperledger.acy_py.generated.model.InvitationRecord;
import org.hyperledger.acy_py.generated.model.V20CredExRecordDetail;
import org.hyperledger.acy_py.generated.model.V20CredIssueRequest;
import org.hyperledger.aries.AriesClient;
import org.hyperledger.aries.api.connection.ConnectionAcceptance;
import org.hyperledger.aries.api.connection.ConnectionRecord;
import org.hyperledger.aries.api.connection.ConnectionState;
import org.hyperledger.aries.api.connection.ConnectionTheirRole;
import org.hyperledger.aries.api.credential_definition.CredentialDefinition;
import org.hyperledger.aries.api.did_exchange.DidExchangeAcceptRequestFilter;
import org.hyperledger.aries.api.issue_credential_v2.V20CredBoundOfferRequest;
import org.hyperledger.aries.api.issue_credential_v2.V20CredExRecord;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;
import org.hyperledger.aries.api.schema.SchemaSendRequest;
import org.hyperledger.aries.api.schema.SchemaSendResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Optional;


@Service
public class Aca_helper {
    String schema_url="http://localhost:11000/schemas";
    String cred_defUrl="http://localhost:11000/credential-definitions";
    String create_invitationUrl="http://localhost:11000/out-of-band/create-invitation";

    String acceptRequestUrl;

    AriesClient client;

    InvitationCreateRequest request;
    CreateInvitationFilter filter;

    CreateConnection createConnection;



    Aca_helper()throws IOException{
        client=new AriesClient("http://localhost:11000", null, null, null);

        request=new InvitationCreateRequest();
        filter=CreateInvitationFilter.builder().autoAccept(true).multiUse(true).build();

         OutOfBandCreateInvitation(request,filter);
    }

    public Optional<InvitationRecord> OutOfBandCreateInvitation(InvitationCreateRequest request, CreateInvitationFilter filter) throws IOException {

        return client.outOfBandCreateInvitation(request,filter);


    }

    public Optional<ConnectionRecord> DidExchangeAcceptRequest(String connectionId,DidExchangeAcceptRequestFilter filter) throws IOException {
       return client.didExchangeAcceptRequest(connectionId,filter);



    }

    public Optional<SchemaSendResponse> CreateSchema(SchemaSendRequest schema) throws IOException {
        return client.schemas(schema);
    }

    public Optional<CredentialDefinition.CredentialDefinitionResponse> CredentialDefinition(CredentialDefinition.CredentialDefinitionRequest defReq) throws IOException {
       return client.credentialDefinitionsCreate(defReq);
    }

    public Optional<V20CredExRecord> SendOffer(String credentialExchangeId, V20CredBoundOfferRequest offerRequest) throws IOException{
        return client.issueCredentialV2RecordsSendOffer(credentialExchangeId,offerRequest);

    }

    public Optional<V20CredExRecordDetail> Issue(String credentialExchangeId, V20CredIssueRequest request) throws IOException {
       return  client.issueCredentialV2RecordsIssue(credentialExchangeId,request);
    }






}
