package com.example.demo.response;

import com.example.demo.dto.SchemaDTO;

public class CreateSchemaResponse {


    public SchemaDTO getSchema() {
        return schema;
    }

    public void setSchema(SchemaDTO schema) {
        this.schema = schema;
    }

    public String getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(String schema_id) {
        this.schema_id = schema_id;
    }

    SchemaDTO schema;
    String schema_id;

}
