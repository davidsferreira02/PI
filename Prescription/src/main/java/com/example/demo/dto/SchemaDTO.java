package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class SchemaDTO {

    private List<String> attributes;
    private String schema_name;
    private String schema_version;

}
