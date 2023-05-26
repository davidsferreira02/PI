package com.example.demo.controller;

import com.example.demo.aca.dto.*;
import com.example.demo.service.HolderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


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
