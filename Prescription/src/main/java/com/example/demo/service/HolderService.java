package com.example.demo.service;


import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.dto.*;
import com.example.demo.model.Prescription;
import com.example.demo.repository.PrescriptionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class HolderService {

    @NonNull
    private final HolderHelper holderHelper;



    public ReceivedInvitationResponseDTO receivedConnection(InvitationDTO invitationDTO)  {

        ReceivedInvitationResponseDTO receivedInvitationResponseDTO = holderHelper.outOfBandReceiveInvitation(invitationDTO);
        holderHelper.didExchangeAcceptInvitation(receivedInvitationResponseDTO.getConnection_id());
        return receivedInvitationResponseDTO;
    }

    public ConnectionsResponseDTO connections() {
        return holderHelper.connections();

    }

    public SendProposalResponseDTO sendProposal(SendProposalDTO sendProposalDTO){
        return holderHelper.sendProposal(sendProposalDTO);
    }

    public SendRequestResponseDTO sendRequest(SendRequestDTO sendRequestDTO){
        return holderHelper.sendRequest(sendRequestDTO);
    }

    public GetCredentialsResponseDTO getCredentials(){
        return holderHelper.getCredentials();
    }
    public StoreCredentialsResponseDTO storeCredentials(StoreCredentialsDTO storeCredentialsDTO){
        return holderHelper.storeCredentials(storeCredentialsDTO);
    }



}
