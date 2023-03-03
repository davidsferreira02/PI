package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class Aca_helper {
    String url="http://localhost:11000/schemas";

    public CreateSchemaResponse createSchema(String schema_name,String schema_version,String [] attributes){

        Schema schema = new Schema();
        schema.setSchema_name(schema_name);
        schema.setSchema_version(schema_version);
        schema.setAttributes(attributes);

        HttpEntity<Schema> entity= new HttpEntity<>(schema);
        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity <CreateSchemaResponse> res=restTemplate.exchange(url, HttpMethod.POST,entity, CreateSchemaResponse.class);
        System.out.println(res.getBody().getSchema_id());
        return res.getBody();
    }


    public CreateCredentialDefinitionResponse createCredentialDefinition(String schema_id,String tag ){
        CredentialDefinitionsRequest credentialDefinitionsRequest =new CredentialDefinitionsRequest();

        credentialDefinitionsRequest.setSchema_id(schema_id);
        credentialDefinitionsRequest.setTag(tag);
        HttpEntity<CredentialDefinitionsRequest> entity= new HttpEntity<>(credentialDefinitionsRequest);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity <CreateCredentialDefinitionResponse> res=restTemplate.exchange(url, HttpMethod.POST,entity, CreateCredentialDefinitionResponse.class);

        return res.getBody();
    }
}
