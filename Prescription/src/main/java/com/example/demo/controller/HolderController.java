package com.example.demo.controller;

import com.example.demo.aca.AriesClient;
import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.dto.CreateInvitationResponseDTO;
import com.example.demo.aca.dto.InvitationDTO;
import com.example.demo.aca.dto.ReceivedInvitationResponseDTO;
import com.example.demo.service.HolderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hyperledger.aries.api.connection.ConnectionRecord;
import org.hyperledger.aries.api.out_of_band.InvitationMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping("/holder")
@RequiredArgsConstructor
public class HolderController {


    @NonNull
    private final HolderService holderService;



@PostMapping("/ReceivedConnection")
    public ReceivedInvitationResponseDTO receivedConnection(@RequestBody InvitationDTO invitationDTO) throws IOException {
    return holderService.receivedConnection(invitationDTO);
    }





}
