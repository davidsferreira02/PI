package com.example.demo.aca;

import com.example.demo.aca.dto.*;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class AriesClient {
    @NonNull
    private final String acapyHost;

    @NonNull
    private final RestTemplate restTemplate;
    private static final String OUTBAND_CREATE_INVITATION_PATH = "/out-of-band/create-invitation";

    private static final String OUTBAND_RECEIVED_INVITATION_PATH="/out-of-band/receive-invitation";

    private static final String DIDEXCHANGE_ACCEPT_INVITATION="/didexchange/";

    private static final String DIDEXCHANGE_ACCEPT_REQUEST="/didexchange/9ebac177-a3d4-4a74-be42-82f4e0cafefa/accept-request";

    private static final String SCHEMAS="/schemas";

    private static final String CONNECTIONS="/connections";

    private static final String CREDENTIAL_DEFINITIONS="/credential-definitions";

    private static final String ISSUE_CREDENTIAL_SEND_PROPOSAL= "/issue-credential-2.0/send-proposal";

    private static final String ISSUE_CREDENTIAL_RECORDS_SEND_OFFER = "issue-credential-2.0/records/bac31f8c-660d-4ac4-b9a1-4ed7de47746a/send-offer";

    private static final String ISSUE_CREDENTIAL_RECORDS_SEND_REQUEST = "issue-credential-2.0/records/bac31f8c-660d-4ac4-b9a1-4ed7de47746a/send-request";

    private static final String ISSUE_CREDENTIAL_RECORDS_ISSUE = "issue-credential-2.0/records/bac31f8c-660d-4ac4-b9a1-4ed7de47746a/issue";

    private static final String ISSUE_CREDENTIAL_RECORDS_STORE = "issue-credential-2.0/records/0ea86878-4369-41e8-8212-e4af42304f3d/store";

    public AriesClient(String acapyHost, RestTemplate restTemplate) {
        this.acapyHost = acapyHost;
        this.restTemplate = restTemplate;
    }


    public CreateInvitationResponseDTO createInvitation(CreateInvitationDTO createInvitationDTO) {
        String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(OUTBAND_CREATE_INVITATION_PATH).build().toUriString();
        return restTemplate.postForObject(url, createInvitationDTO, CreateInvitationResponseDTO.class);
    }

   public ReceivedInvitationResponseDTO receivedInvitation(@NonNull InvitationDTO invitationDTO){
       String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(OUTBAND_RECEIVED_INVITATION_PATH).build().toUriString();
       return restTemplate.postForObject(url, invitationDTO, ReceivedInvitationResponseDTO.class);

   }

   public AcceptInvitationResponseDTO acceptInvitation(@NonNull ReceivedInvitationResponseDTO receivedInvitationResponseDTO){

        String url=UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(DIDEXCHANGE_ACCEPT_INVITATION +receivedInvitationResponseDTO.getConnection_id()+ "/accept-invitation").build().toUriString();
       return restTemplate.postForObject(url, receivedInvitationResponseDTO, AcceptInvitationResponseDTO.class);

   }

   public void AcceptConnectionRequest(){

   }

   public SchemaResponseDTO schema(SchemaDTO schemaDTO){
       String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(SCHEMAS).build().toUriString();
       return restTemplate.postForObject(url, schemaDTO, SchemaResponseDTO.class);


   }


   public CredentialDefinitionDTO credentialDefinitions(CredentialDefinitionDTO credentialDefinitionDTO){
       String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(CREDENTIAL_DEFINITIONS).build().toUriString();
       return restTemplate.postForObject(url, credentialDefinitionDTO, CredentialDefinitionDTO.class);
   }


   public void sendProposal(){

   }

   public void sendOffer(){ //@NonNull String cred_ex_id

   }

   public void sendRequest(){ //@NonNull String cred_ex_id

   }

   public void issue(){ // String Comment

   }

   public void store(){ // String credential_id

   }

   public String  getConnectionByMessageId(String invitationMessageId) {

       String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(CONNECTIONS).build().toUriString();
       return restTemplate.postForObject(url, credentialDefinitionDTO, CredentialDefinitionDTO.class);






   }

}
