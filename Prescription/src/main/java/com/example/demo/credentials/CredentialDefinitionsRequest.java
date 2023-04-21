/*package com.example.demo.credentials;

import lombok.NonNull;
import okhttp3.HttpUrl;
import org.hyperledger.aries.api.endorser.EndorserInfoFilter;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;

public class CredentialDefinitionsRequest extends @NonNull EndorserInfoFilter {


    private Integer revocationRegistrySize;





    private String schemaId;
    private Boolean supportRevocation;
    private String tag;

    public CredentialDefinitionsRequest(Integer revocationRegistrySize, String schemaId, Boolean supportRevocation, String tag) {
        //super(endorserInfoFilter)
        this.revocationRegistrySize = revocationRegistrySize;
        this.schemaId = schemaId;
        this.supportRevocation = supportRevocation;
        this.tag = tag;
    }

    public Integer getRevocationRegistrySize() {
        return revocationRegistrySize;
    }

    public void setRevocationRegistrySize(Integer revocationRegistrySize) {
        this.revocationRegistrySize = revocationRegistrySize;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public Boolean getSupportRevocation() {
        return supportRevocation;
    }

    public void setSupportRevocation(Boolean supportRevocation) {
        this.supportRevocation = supportRevocation;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public HttpUrl.Builder buildParams(HttpUrl.@NonNull Builder b) {
        return super.buildParams(b);
    }
}
*/