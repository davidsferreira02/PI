package com.example.demo.service;

import com.example.demo.response.CreateSchemaResponse;
import com.example.demo.Repository.PrescriptionRepository;
import com.example.demo.dto.SchemaDTO;
import com.example.demo.aca.Aca_helper;
import com.example.demo.response.CreateCredentialDefinitionResponse;
import com.example.demo.exception.NotfoundException;
import com.example.demo.model.Schema;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    @NonNull
    private final PrescriptionRepository prescriptionRepository;
    @NonNull
    private final Aca_helper aca_helper;

    public Schema createSchema(SchemaDTO schemaDTO){
        CreateSchemaResponse createSchemaResponse = aca_helper.createSchema(schemaDTO.getSchema_name(),schemaDTO.getSchema_version(),schemaDTO.getAttributes());
        CreateCredentialDefinitionResponse credDefResp = aca_helper.createCredentialDefinition(createSchemaResponse.getSchema_id(), schemaDTO.getSchema_version());
        Schema schema = Schema.builder()
                .schemaName(schemaDTO.getSchema_name())
                .schema_version(schemaDTO.getSchema_version())
                .attributes(String.join(",", schemaDTO.getAttributes()))
                .schema_id(createSchemaResponse.getSchema_id())
                .credential_definition_id(credDefResp.getCredential_definition_id())
                .build();
        return prescriptionRepository.save(schema);
    }



    public void deleteSchema(Long id){
        Schema schema=prescriptionRepository.findById(id).orElseThrow(()->new NotfoundException("Schema with id " + id + " not found"));
        prescriptionRepository.delete(schema);


    }




    public Schema updateSchema(Long id,SchemaDTO schemaDTO) {

     String schemaDtoAttribute;
        Schema schema=prescriptionRepository.findById(id).orElseThrow(()->new NotfoundException("Schema with id " + id + " not found"));
        schemaDtoAttribute= (String.join(",", schemaDTO.getAttributes()));
        if(schema.getAttributes().equals(schemaDtoAttribute)) {
            CreateSchemaResponse createSchemaResponse = aca_helper.createSchema(schemaDTO.getSchema_name(), schemaDTO.getSchema_version(), schemaDTO.getAttributes());
            CreateCredentialDefinitionResponse credDefResp = aca_helper.createCredentialDefinition(createSchemaResponse.getSchema_id(), schemaDTO.getSchema_version());
            schema.setCredential_definition_id(credDefResp.getCredential_definition_id());
            schema.setSchema_id(createSchemaResponse.getSchema_id());
        }
            schema.setSchema_version(schemaDTO.getSchema_version());
            schema.setAttributes(String.join(",", schemaDTO.getAttributes()));
            schema.setSchemaName(schemaDTO.getSchema_name());


        return prescriptionRepository.save(schema);


    }
    public Iterable<Schema> allSchemas(){
        return prescriptionRepository.findAll();
    }
}