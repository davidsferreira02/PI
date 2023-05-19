package com.example.demo.controller;

import com.example.demo.aca.dto.*;

import com.example.demo.service.IssuerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/issuer")
@RequiredArgsConstructor
public class IssuerController {


    @NonNull
    private final IssuerService issuerService;

    @PostMapping("/create-invitation")
    public InvitationDTO createConnection() throws IOException {
        return issuerService.createConnection();
    }

    @PostMapping("/accept-request")
    public AcceptInvitationResponseDTO acceptConnectionRequest(@RequestBody ReceivedInvitationResponseDTO receivedInvitationResponseDTO) throws IOException {

        return issuerService.acceptConnectionInvitationRequest(receivedInvitationResponseDTO);

    }


    @PostMapping("/schemas")
    public SchemaResponseDTO schema(@RequestBody() SchemaDTO schemaDTO) {


        return issuerService.schema(schemaDTO);
    }
/*
    @GetMapping("/all")
    public Iterable<Schema> allPrescrpitions() {


        return issuerService.allSchemas();


    }

    @DeleteMapping(value = "/{id}")
    public void deleteSchema(@PathVariable Long id) {
        issuerService.deleteSchema(id);
    }

    @PutMapping(value = "/{id}")
    public Schema updateSchema(@PathVariable Long id, @RequestBody SchemaDTO schemaDTO) throws IOException {

        return issuerService.updateSchema(id, schemaDTO);
    }

*/
}
