package com.example.Prescription.Schema;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schema {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String[] attributes;
    private String schema_name;
    private String schema_version;

    public Schema( String schema_name ,String[] attributes, String schema_version) {
        this.schema_name = schema_name;
        this.attributes = attributes;
        this.schema_version = schema_version;
    }
    protected Schema(){}



    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    public String getSchema_name() {
        return schema_name;
    }

    public void setSchema_name(String schema_name) {
        this.schema_name = schema_name;
    }

    public String getSchema_version() {
        return schema_version;
    }

    public void setSchema_version(String schema_version) {
        this.schema_version = schema_version;
    }
}
