package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@AllArgsConstructor
public class CredentialDefinitionResponseDTO {


    @JsonProperty("credential_definition_id")

    private String credential_definition_id;
}
