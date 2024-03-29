package com.example.demo.aca;


import com.example.demo.aca.dto.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class HolderHelper {


    @NonNull
    private AriesClient holderClient;


    public HolderHelper(@Qualifier("holderClient") AriesClient holderClient) {
        this.holderClient = holderClient;
    }


    public ReceivedInvitationResponseDTO outOfBandReceiveInvitation(InvitationDTO invitationDTO) {
        return holderClient.receivedInvitation(invitationDTO);
    }

    public AcceptInvitationResponseDTO didExchangeAcceptInvitation(String connectionId) {
        return holderClient.acceptInvitation(connectionId);
    }



    public SendProposalResponseDTO sendProposal(SendProposalDTO sendProposalDTO) {
        return holderClient.sendProposal(sendProposalDTO);
    }

    public SendRequestResponseDTO sendRequest(SendRequestDTO sendRequestDTO){
        return holderClient.sendRequest((sendRequestDTO));
    }



    public GetCredentialsResponseDTO getCredentials(){
        return holderClient.getCredentials();
    }

    public StoreCredentialsResponseDTO storeCredentials(StoreCredentialsDTO storeCredentialsDTO){
        return holderClient.storeCredentials(storeCredentialsDTO);
    }



}
