package com.example.demo.aca;


import com.example.demo.aca.dto.CreateInvitationDTO;
import com.example.demo.aca.dto.CreateInvitationResponseDTO;
import com.example.demo.aca.dto.ReceiveInvitationDTO;
import com.example.demo.aca.dto.ReceivedInvitationResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class HolderHelper {


    private AriesClient holderClient;


    public HolderHelper(@Qualifier("holderClient") AriesClient holderClient) {
        this.holderClient = holderClient;
    }



    public ReceivedInvitationResponseDTO outOfBandReceiveInvitation() throws IOException {
        return holderClient.receivedInvitation(new ReceiveInvitationDTO());
    }

/*
    public Optional<ConnectionRecord> didExchangeAcceptInvitation(String connectionId, DidExchangeAcceptInvitationFilter filter) throws IOException {
        return holderClient.didExchangeAcceptInvitation(connectionId, filter);
    }

    public Optional<V20CredExRecord> v20sendProposal(V2CredentialExchangeFree request) throws IOException {
        return holderClient.issueCredentialV2SendProposal(request);
    }

    public Optional<V20CredExRecord> v20sendRequest(String credentialExchangeId, V20CredRequestRequest request) throws IOException {
        return holderClient.issueCredentialV2RecordsSendRequest(credentialExchangeId, request);

    }

    public Optional<V20CredExRecordDetail> v20Store(String credentialExchangeId, V20CredStoreRequest request) throws IOException {
        return holderClient.issueCredentialV2RecordsStore(credentialExchangeId, request);
    }

*/
}
