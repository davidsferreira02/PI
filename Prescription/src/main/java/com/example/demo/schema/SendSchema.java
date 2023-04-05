package com.example.demo.schema;

import jakarta.annotation.Nonnull;

import java.util.List;

public class SendSchema {
    @Nonnull
    private List<String> attributes;
    @Nonnull
    private String schemaName;
    @Nonnull
    private String schemaVersion;

    public SendSchema(List<String> attributes, String schemaName, String schemaVersion) {
        this.attributes = attributes;
        this.schemaName = schemaName;
        this.schemaVersion = schemaVersion;
    }
}
