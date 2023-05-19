package com.example.demo.controller;

import com.example.demo.aca.dto.AcceptInvitationResponseDTO;
import com.example.demo.aca.dto.CreateInvitationResponseDTO;
import com.example.demo.aca.dto.InvitationDTO;
import com.example.demo.aca.dto.ReceivedInvitationResponseDTO;
import com.example.demo.dto.SchemaDTO;
import com.example.demo.model.Schema;
import com.example.demo.service.IssuerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hyperledger.acy_py.generated.model.InvitationMessage;
import org.hyperledger.aries.api.connection.ConnectionRecord;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping("/issuer")
@RequiredArgsConstructor
public class IssuerController {


    @NonNull
    private final IssuerService issuerService;

@PostMapping("/Create")
    public InvitationDTO createConnection() throws IOException {
        return issuerService.createConnection();
    }

@PostMapping("/Accept")
    public AcceptInvitationResponseDTO acceptConnection(@RequestBody ReceivedInvitationResponseDTO receivedInvitationResponseDTO) throws IOException {

        return issuerService.acceptConnectionRequest(receivedInvitationResponseDTO);

    }
/*

    @PostMapping("/CreateSchema")
    public Schema createSchema(@RequestBody() SchemaDTO schemaDTO) throws IOException {


        return issuerService.createSchema(schemaDTO);
    }

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
