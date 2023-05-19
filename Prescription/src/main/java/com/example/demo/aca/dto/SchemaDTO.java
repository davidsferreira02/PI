package com.example.demo.aca.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchemaDTO {

    @JsonProperty("attributes")
    private List<Attributes> attributes;
    @JsonProperty("schema_name")
    private String schema_name;
    @JsonProperty("schema_version")
    String schema_version;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Attributes {

        String attribute;


    }
}
