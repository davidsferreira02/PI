package com.example.demo.service;


import com.example.demo.aca.IssuerHelper;
import com.example.demo.aca.dto.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class IssuerService {

    @NonNull
    private final IssuerHelper issuerHelper;


    public InvitationDTO createConnection() {
        CreateInvitationResponseDTO createConnection = issuerHelper.outOfBandCreateInvitation();
        return createConnection.getInvitation();
    }

    public AcceptInvitationResponseDTO acceptConnectionInvitationRequest(ReceivedInvitationResponseDTO receivedInvitationResponseDTO) throws IOException {

        return issuerHelper.didExchangeAcceptRequest(receivedInvitationResponseDTO);
    }


    public SchemaResponseDTO schema(SchemaDTO schemaDTO) {
        return issuerHelper.schema(schemaDTO);
    }


}
