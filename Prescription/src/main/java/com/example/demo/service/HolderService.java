package com.example.demo.service;


import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.dto.AcceptInvitationResponseDTO;
import com.example.demo.aca.dto.ConnectionsResponseDTO;
import com.example.demo.aca.dto.InvitationDTO;
import com.example.demo.aca.dto.ReceivedInvitationResponseDTO;
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

        return receivedInvitationResponseDTO;
    }

    public AcceptInvitationResponseDTO acceptConnectionInvitation(ReceivedInvitationResponseDTO receivedInvitationResponseDTO) throws IOException {

        return holderHelper.didExchangeAcceptInvitation(receivedInvitationResponseDTO);
    }

    public ConnectionsResponseDTO connections() {
        return holderHelper.connections();

    }


}
