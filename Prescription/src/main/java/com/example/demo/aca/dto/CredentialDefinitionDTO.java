package com.example.demo.aca.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CredentialDefinitionDTO {

@JsonProperty("schema_id")
    private String schema_id;

@JsonProperty("tag")
    private String tag;


}
