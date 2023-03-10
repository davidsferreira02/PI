package com.example.demo.credentials;

public class CredentialDefinitionsRequest {
    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String schema_id;
    private String tag;
}
