package com.example.demo.service;

import com.example.demo.Repository.PrescriptionRepository;
import com.example.demo.aca.AriesClient;
import com.example.demo.aca.IssuerHelper;
import com.example.demo.aca.dto.AcceptInvitationResponseDTO;
import com.example.demo.aca.dto.CreateInvitationResponseDTO;
import com.example.demo.aca.dto.InvitationDTO;
import com.example.demo.aca.dto.ReceivedInvitationResponseDTO;
import com.example.demo.dto.SchemaDTO;
import com.example.demo.exception.NotfoundException;
import com.example.demo.model.Schema;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hyperledger.acy_py.generated.model.InvitationMessage;
import org.hyperledger.acy_py.generated.model.InvitationRecord;
import org.hyperledger.aries.api.connection.ConnectionRecord;
import org.hyperledger.aries.api.credential_definition.CredentialDefinition;
import org.hyperledger.aries.api.did_exchange.DidExchangeAcceptRequestFilter;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;
import org.hyperledger.aries.api.schema.SchemaSendRequest;
import org.hyperledger.aries.api.schema.SchemaSendResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class IssuerService {
    @NonNull
    private final PrescriptionRepository prescriptionRepository;
    @NonNull
    private final IssuerHelper issuerHelper;



    public InvitationDTO createConnection() throws IOException {
        CreateInvitationResponseDTO createConnection = issuerHelper.outOfBandCreateInvitation();
        return createConnection.getInvitation();
    }



    public AcceptInvitationResponseDTO acceptConnectionRequest(ReceivedInvitationResponseDTO receivedInvitationResponseDTO) throws IOException {

        return issuerHelper.didExchangeAcceptRequest(receivedInvitationResponseDTO);
    }
/*

    public Schema createSchema(SchemaDTO schemaDTO) throws IOException {
        Optional<SchemaSendResponse> createSchemaResponse = issuerHelper.createSchema(SchemaSendRequest.builder().attributes(schemaDTO.getAttributes()).schemaName(schemaDTO.getSchema_name()).schemaVersion(schemaDTO.getSchema_version()).build());
        Optional<CredentialDefinition.CredentialDefinitionResponse> credDefResp = issuerHelper.credentialDefinition(org.hyperledger.aries.api.credential_definition.CredentialDefinition.CredentialDefinitionRequest.builder().schemaId(createSchemaResponse.get().getSchemaId()).tag("default").build());
        Schema schema = Schema.builder()
                .schemaName(schemaDTO.getSchema_name())
                .schema_version(schemaDTO.getSchema_version())
                .attributes(String.join(",", schemaDTO.getAttributes()))
                .schema_id(createSchemaResponse.get().getSchemaId())
                .credential_definition_id(credDefResp.get().getCredentialDefinitionId())
                .build();
        return prescriptionRepository.save(schema);
    }


    public void deleteSchema(Long id) {
        Schema schema = prescriptionRepository.findById(id).orElseThrow(() -> new NotfoundException("Schema with id " + id + " not found"));
        prescriptionRepository.delete(schema);


    }


    public Schema updateSchema(Long id, SchemaDTO schemaDTO) throws IOException {

        String schemaDtoAttribute;
        Schema schema = prescriptionRepository.findById(id).orElseThrow(() -> new NotfoundException("Schema with id " + id + " not found"));
        schemaDtoAttribute = (String.join(",", schemaDTO.getAttributes()));
        if (schema.getAttributes().equals(schemaDtoAttribute)) {
            Optional<SchemaSendResponse> createSchemaResponse = issuerHelper.createSchema(SchemaSendRequest.builder().attributes(schemaDTO.getAttributes()).schemaName(schemaDTO.getSchema_name()).schemaVersion(schemaDTO.getSchema_version()).build());

            Optional<CredentialDefinition.CredentialDefinitionResponse> credDefResp = issuerHelper.credentialDefinition(org.hyperledger.aries.api.credential_definition.CredentialDefinition.CredentialDefinitionRequest.builder().schemaId(createSchemaResponse.get().getSchemaId()).tag("default").build());
            schema.setCredential_definition_id(credDefResp.get().getCredentialDefinitionId());
            schema.setSchema_id(createSchemaResponse.get().getSchemaId());
        }
        schema.setSchema_version(schemaDTO.getSchema_version());
        schema.setAttributes(String.join(",", schemaDTO.getAttributes()));
        schema.setSchemaName(schemaDTO.getSchema_name());


        return prescriptionRepository.save(schema);


    }

    public Iterable<Schema> allSchemas() {
        return prescriptionRepository.findAll();
    }

*/


}
