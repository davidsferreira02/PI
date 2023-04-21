package com.example.demo.service;

import com.example.demo.Repository.PrescriptionRepository;
import com.example.demo.dto.SchemaDTO;
import com.example.demo.aca.Aca_helper;
import com.example.demo.exception.NotfoundException;
import com.example.demo.model.Schema;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hyperledger.acy_py.generated.model.InvitationRecord;
import org.hyperledger.aries.api.connection.ConnectionRecord;
import org.hyperledger.aries.api.credential_definition.CredentialDefinition;
import org.hyperledger.aries.api.did_exchange.DidExchangeAcceptInvitationFilter;
import org.hyperledger.aries.api.did_exchange.DidExchangeAcceptRequestFilter;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;
import org.hyperledger.aries.api.out_of_band.InvitationMessage;
import org.hyperledger.aries.api.out_of_band.ReceiveInvitationFilter;
import org.hyperledger.aries.api.schema.SchemaSendRequest;
import org.hyperledger.aries.api.schema.SchemaSendResponse;


import java.io.IOException;
import java.util.Optional;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    @NonNull
    private final PrescriptionRepository prescriptionRepository;
    @NonNull
    private final Aca_helper aca_helper;

    InvitationCreateRequest request;
    CreateInvitationFilter filter;


    public void createConnection() throws IOException {
        request = new InvitationCreateRequest();

        filter = CreateInvitationFilter.builder().multiUse(true).multiUse(true).build();
        Optional<InvitationRecord> createConnection = aca_helper.outOfBandCreateInvitation(request, filter);

        receiveConnection();
    }

    public void receiveConnection() throws IOException {

        InvitationMessage request = InvitationMessage.builder().build();
        ReceiveInvitationFilter filter = ReceiveInvitationFilter.builder().build();
        Optional<ConnectionRecord> receiveConnection = aca_helper.outOfBandReceiveInvitation(request, filter);
        AcceptInvitation(receiveConnection.get().getConnectionId());
    }

    public void AcceptInvitation(String connectionId) throws IOException {
        DidExchangeAcceptInvitationFilter didExchangeAcceptInvitationFilter = new DidExchangeAcceptInvitationFilter();
        aca_helper.didExchangeAcceptInvitation(connectionId, didExchangeAcceptInvitationFilter);
        AcceptConnectionRequest(connectionId);

    }

    public void AcceptConnectionRequest(String connectionId) throws IOException {

        DidExchangeAcceptRequestFilter filter = DidExchangeAcceptRequestFilter.builder().myEndpoint("").mediationId("").build();
        aca_helper.didExchangeAcceptRequest(connectionId, filter);
    }


    public Schema createSchema(SchemaDTO schemaDTO) throws IOException {
        //CreateSchemaResponse createSchemaResponse = aca_helper.createSchema(schemaDTO.getSchema_name(),schemaDTO.getSchema_version(),schemaDTO.getAttributes());
        Optional<SchemaSendResponse> createSchemaResponse = aca_helper.createSchema(SchemaSendRequest.builder().attributes(schemaDTO.getAttributes()).schemaName(schemaDTO.getSchema_name()).schemaVersion(schemaDTO.getSchema_version()).build());
        //  CreateCredentialDefinitionResponse credDefResp = aca_helper.createCredentialDefinition(createSchemaResponse.getSchema_id(), schemaDTO.getSchema_version());
        Optional<CredentialDefinition.CredentialDefinitionResponse> credDefResp = aca_helper.credentialDefinition(org.hyperledger.aries.api.credential_definition.CredentialDefinition.CredentialDefinitionRequest.builder().schemaId(createSchemaResponse.get().getSchemaId()).tag("default").build());

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
            Optional<SchemaSendResponse> createSchemaResponse = aca_helper.createSchema(SchemaSendRequest.builder().attributes(schemaDTO.getAttributes()).schemaName(schemaDTO.getSchema_name()).schemaVersion(schemaDTO.getSchema_version()).build());
            // CreateSchemaResponse createSchemaResponse = aca_helper.createSchema(schemaDTO.getSchema_name(), schemaDTO.getSchema_version(), schemaDTO.getAttributes());
            Optional<CredentialDefinition.CredentialDefinitionResponse> credDefResp = aca_helper.credentialDefinition(org.hyperledger.aries.api.credential_definition.CredentialDefinition.CredentialDefinitionRequest.builder().schemaId(createSchemaResponse.get().getSchemaId()).tag("default").build());
            //CreateCredentialDefinitionResponse credDefResp = aca_helper.createCredentialDefinition(createSchemaResponse.getSchema_id(), schemaDTO.getSchema_version());
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


}




