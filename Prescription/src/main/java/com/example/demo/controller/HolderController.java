package com.example.demo.controller;

import com.example.demo.aca.AriesClient;
import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.dto.*;
import com.example.demo.service.HolderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hyperledger.aries.api.connection.ConnectionRecord;
import org.hyperledger.aries.api.out_of_band.InvitationMessage;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping("/holder")
@RequiredArgsConstructor
public class HolderController {


    @NonNull
    private final HolderService holderService;


    @PostMapping("/receive-invitation")
    public ReceivedInvitationResponseDTO receivedConnection(@RequestBody InvitationDTO invitationDTO) throws IOException {
        return holderService.receivedConnection(invitationDTO);
    }

    @GetMapping("/connections")
    public ConnectionsResponseDTO connections() {

        return holderService.connections();

    }

    @PostMapping("/send-proposal")
    public SendProposalResponseDTO sendProposal(@RequestBody SendProposalDTO sendProposalDTO){
        return holderService.sendProposal(sendProposalDTO);
    }


}
