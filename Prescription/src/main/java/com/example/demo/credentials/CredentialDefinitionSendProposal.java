package com.example.demo.credentials;

import io.micrometer.common.lang.Nullable;

public class CredentialDefinitionSendProposal {

    @Deprecated @Nullable private String credentialDefinitionId;
    @Nullable
    private String credDefId;

    @Nullable private String issuerDid;
    @Nullable private String schemaId;
    @Nullable private String schemaIssuerDid;
    @Nullable private String schemaName;
    @Nullable private String schemaVersion;

    public CredentialDefinitionSendProposal(String credentialDefinitionId, String credDefId, String issuerDid, String schemaId, String schemaIssuerDid, String schemaName, String schemaVersion) {
        this.credentialDefinitionId = credentialDefinitionId;
        this.credDefId = credDefId;
        this.issuerDid = issuerDid;
        this.schemaId = schemaId;
        this.schemaIssuerDid = schemaIssuerDid;
        this.schemaName = schemaName;
        this.schemaVersion = schemaVersion;
    }
}
