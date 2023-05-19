package com.example.demo.service;


import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.dto.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class HolderService {

    @NonNull
    private final HolderHelper holderHelper;

    public ReceivedInvitationResponseDTO receivedConnection(InvitationDTO invitationDTO) throws IOException {

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


}
