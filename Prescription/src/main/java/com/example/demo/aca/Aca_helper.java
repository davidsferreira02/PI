package com.example.demo.aca;

import com.example.demo.response.CreateCredentialDefinitionResponse;
import com.example.demo.response.CreateSchemaResponse;
import com.example.demo.credentials.CredentialDefinitionsRequest;
import com.example.demo.dto.SchemaDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class Aca_helper {
    String url="http://localhost:11000/schemas";
    String cred_defUrl="http://localhost:11000/credential-definitions";

    public CreateSchemaResponse createSchema(String schema_name, String schema_version, String[] attributes){

        SchemaDTO schema = new SchemaDTO();
        schema.setSchema_name(schema_name);
        schema.setSchema_version(schema_version);
        schema.setAttributes(attributes);

        HttpEntity<SchemaDTO> entity= new HttpEntity<>(schema);
        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity <CreateSchemaResponse> res=restTemplate.exchange(url, HttpMethod.POST,entity, CreateSchemaResponse.class);
        return res.getBody();
    }


    public CreateCredentialDefinitionResponse createCredentialDefinition(String schema_id, String tag ){
        CredentialDefinitionsRequest credentialDefinitionsRequest =new CredentialDefinitionsRequest();

        credentialDefinitionsRequest.setSchema_id(schema_id);
        credentialDefinitionsRequest.setTag(tag);
        HttpEntity<CredentialDefinitionsRequest> entity= new HttpEntity<>(credentialDefinitionsRequest);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity <CreateCredentialDefinitionResponse> res=restTemplate.exchange(cred_defUrl, HttpMethod.POST,entity, CreateCredentialDefinitionResponse.class);

        return res.getBody();
    }
}
