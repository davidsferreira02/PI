package com.example.demo.aca.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data

@NoArgsConstructor

@AllArgsConstructor
public class GetCredentialsResponseDTO {


    @JsonProperty("results")
    private List<Results> results = new ArrayList<>();

    @Data

    @NoArgsConstructor

    @AllArgsConstructor
    public class Results {
        @JsonProperty("attrs")
        private Map<String, String> attrs;
        @JsonProperty("cred_def_id")
        private String cred_def_id;

        @JsonProperty("schema_id")
        private String schema_id;


    }
}
