package com.example.demo.aca;

import com.example.demo.aca.dto.*;
import kotlin.collections.ArrayDeque;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class AriesClient {
    @NonNull
    private final String acapyHost;
    @NonNull
    private final RestTemplate restTemplate;
    private static final String OUTBAND_CREATE_INVITATION_PATH = "/out-of-band/create-invitation";


    private static final String OUTBAND_RECEIVED_INVITATION_PATH = "/out-of-band/receive-invitation";
    private static final String DIDEXCHANGE_ACCEPT_INVITATION = "/didexchange/<CONNECTION_ID>/accept-invitation";

    private static final String DIDEXCHANGE_ACCEPT_REQUEST = "/didexchange/<CONNECTION_ID>/accept-request";

    private static final String SCHEMAS = "/schemas";

    private static String CONNECTIONS = "/connections";


    private static final String CREDENTIAL_DEFINITIONS = "/credential-definitions";

    private static final String ISSUE_CREDENTIAL_SEND_PROPOSAL = "/issue-credential-2.0/send-proposal";

    private static final String ISSUE_CREDENTIAL_RECORDS_SEND_OFFER = "issue-credential-2.0/records/<CONNECTION_ID>/send-offer";

    private static final String ISSUE_CREDENTIAL_RECORDS_SEND_REQUEST = "issue-credential-2.0/records/<CONNECTION_ID>/send-request";

    private static final String ISSUE_CREDENTIAL_RECORDS_ISSUE = "issue-credential-2.0/records/<CONNECTION_ID>/issue";

    private static final String ISSUE_CREDENTIAL_RECORDS_STORE = "issue-credential-2.0/records/<CONNECTION_ID>/store";

    public AriesClient(String acapyHost, RestTemplate restTemplate) {
        this.acapyHost = acapyHost;
        this.restTemplate = restTemplate;
    }


    public CreateInvitationResponseDTO createInvitation(CreateInvitationDTO createInvitationDTO) {
        String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(OUTBAND_CREATE_INVITATION_PATH).build().toUriString();
        return restTemplate.postForObject(url, createInvitationDTO, CreateInvitationResponseDTO.class);
    }

    public ReceivedInvitationResponseDTO receivedInvitation(@NonNull InvitationDTO invitationDTO) {
        String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(OUTBAND_RECEIVED_INVITATION_PATH).build().toUriString();
        return restTemplate.postForObject(url, invitationDTO, ReceivedInvitationResponseDTO.class);

    }


    public AcceptInvitationResponseDTO acceptInvitation(@NonNull ReceivedInvitationResponseDTO receivedInvitationResponseDTO) {
        String connection = getConnectionByMessageId(receivedInvitationResponseDTO.getInvitation_msg_id());
        String url = "";


        if (acapyHost.equals("localhost:11001")) {
            receivedInvitationResponseDTO.setConnection_id(connection);
            url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(DIDEXCHANGE_ACCEPT_INVITATION.replace("<CONNECTION_ID>", connection)).build().toUriString();
        } else if (acapyHost.equals("localhost:11000")) {
            url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(DIDEXCHANGE_ACCEPT_REQUEST.replace("<CONNECTION_ID>", receivedInvitationResponseDTO.getConnection_id())).build().toUriString();

        }

        return restTemplate.postForObject(url, null, AcceptInvitationResponseDTO.class);

    }

    public String getConnectionByMessageId(String invitationMessageId) {

        List<ReceivedInvitationResponseDTO> connectionsList = getConnections().getResults();
        for (ReceivedInvitationResponseDTO i : connectionsList) {
            if (i.getInvitation_msg_id().equals(invitationMessageId))
                return i.getConnection_id();
        }

        return null;
    }

    public ConnectionsResponseDTO getConnections() {
        String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(CONNECTIONS).build().toUriString();
        return restTemplate.getForObject(url, ConnectionsResponseDTO.class);
    }


    public SchemaResponseDTO schema(SchemaDTO schemaDTO) {
        String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(SCHEMAS).build().toUriString();
        return restTemplate.postForObject(url, schemaDTO, SchemaResponseDTO.class);


    }


    public CredentialDefinitionDTO credentialDefinitions(CredentialDefinitionDTO credentialDefinitionDTO) {
        String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(CREDENTIAL_DEFINITIONS).build().toUriString();
        return restTemplate.postForObject(url, credentialDefinitionDTO, CredentialDefinitionDTO.class);
    }


    public void sendProposal() {

    }

    public void sendOffer() { //@NonNull String cred_ex_id

    }

    public void sendRequest() { //@NonNull String cred_ex_id

    }

    public void issue() { // String Comment

    }

    public void store() { // String credential_id

    }


}