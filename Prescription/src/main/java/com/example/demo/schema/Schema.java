package com.example.demo.schema;

import com.google.gson.annotations.SerializedName;
import jakarta.annotation.Nonnull;

import java.util.List;

public class Schema {


        @Nonnull
        private List<String> attributes;
        @Nonnull
        private String schemaName;
        @Nonnull
        private String schemaVersion;

    public Schema(List<String> attributes, String schemaName, String schemaVersion) {
        this.attributes = attributes;
        this.schemaName = schemaName;
        this.schemaVersion = schemaVersion;
    }
}
