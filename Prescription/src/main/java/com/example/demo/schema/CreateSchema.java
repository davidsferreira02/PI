package com.example.demo.schema;

public class CreateSchema {
    private String schemaId;
    private String schemaIssuerDid;
    private String schemaName;
    private String schemaVersion;

    public CreateSchema(String schemaId, String schemaIssuerDid, String schemaName, String schemaVersion) {
        this.schemaId = schemaId;
        this.schemaIssuerDid = schemaIssuerDid;
        this.schemaName = schemaName;
        this.schemaVersion = schemaVersion;
    }
}
