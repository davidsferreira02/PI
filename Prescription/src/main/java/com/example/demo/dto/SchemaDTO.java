package com.example.demo.dto;

import lombok.Data;

@Data
public class SchemaDTO {

    private String[] attributes;
    private String schema_name;
    private String schema_version;

}
