package com.example.demo.service;


import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.dto.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HolderService {

    @NonNull
    private final HolderHelper holderHelper;



    public ReceivedInvitationResponseDTO receivedConnection(InvitationDTO invitationDTO) {

        ReceivedInvitationResponseDTO receivedInvitationResponseDTO = holderHelper.outOfBandReceiveInvitation(invitationDTO);
        holderHelper.didExchangeAcceptInvitation(receivedInvitationResponseDTO.getConnection_id());
        return receivedInvitationResponseDTO;
    }



    public SendProposalResponseDTO sendProposal(SendProposalDTO sendProposalDTO) {
        return holderHelper.sendProposal(sendProposalDTO);
    }

    public SendRequestResponseDTO sendRequest(SendRequestDTO sendRequestDTO) {
        return holderHelper.sendRequest(sendRequestDTO);
    }

    public GetCredentialsResponseDTO getCredentials() {
        return holderHelper.getCredentials();
    }

    public StoreCredentialsResponseDTO storeCredentials(StoreCredentialsDTO storeCredentialsDTO) {
        return holderHelper.storeCredentials(storeCredentialsDTO);
    }




}
