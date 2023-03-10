package com.example.Prescription.Schema;

public class CreateSchemaResponse {



    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    Schema schema;
    String schema_id;

}
