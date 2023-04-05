package com.example.demo.credentials;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import org.hyperledger.aries.config.CredDefId;

import java.util.List;

public class CredentialDefinition {

    private String ver;

    private String id;

    @SerializedName("schemaId")
    private String schemaId;

    private String type;

    private String tag;


    private JsonObject value;


    public static final class CredentialDefinitionRequest {
        private Integer revocationRegistrySize;
        private String schemaId;
        private Boolean supportRevocation;
        private String tag;
    }


    public static final class CredentialDefinitionsCreated{
        private List<String> credentialDefinitionsIds;
    }
    public static final class CredentialDefinitionResponse {
        @SerializedName(value = CredDefId.CREDENTIAL_DEFINITION_ID, alternate = CredDefId.CRED_DEF_ID)
        private String credentialDefinitionId;
    }
}
