package com.example.demo.service;


import com.example.demo.Repository.PrescriptionRepository;
import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.dto.InvitationDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hyperledger.acy_py.generated.model.V20CredRequestRequest;
import org.hyperledger.aries.api.connection.ConnectionRecord;
import org.hyperledger.aries.api.did_exchange.DidExchangeAcceptInvitationFilter;
import org.hyperledger.aries.api.issue_credential_v2.V20CredExRecord;
import org.hyperledger.aries.api.issue_credential_v2.V2CredentialExchangeFree;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;
import org.hyperledger.aries.api.out_of_band.InvitationMessage;
import org.hyperledger.aries.api.out_of_band.ReceiveInvitationFilter;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class HolderService {

  /*  @NonNull
    private final HolderHelper holderHelper;

    public Optional<ConnectionRecord> receiveAcceptConnection(@RequestBody InvitationDTO request) throws IOException {

        ReceiveInvitationFilter filter = ReceiveInvitationFilter.builder().build();
        Optional<ConnectionRecord> connectionId =  holderHelper.outOfBandReceiveInvitation(request, filter);
        return holderHelper.didExchangeAcceptInvitation(connectionId.get().getConnectionId(),new DidExchangeAcceptInvitationFilter());
    }*/






}
