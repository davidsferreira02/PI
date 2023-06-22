package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendProposalDTO {




    @JsonProperty("connection_id")
    private String connection_id;


    @JsonProperty("credential_preview")
    private CredentialPreview credentialPreview;

    @JsonProperty("filter")
    private Filter filter;


    @Data

    @NoArgsConstructor

    @AllArgsConstructor
    public class CredentialPreview {
        @JsonProperty("type")
        private String type;

        @JsonProperty("attributes")
        private List<Attribute> attributes;

    }

    @Data

    @NoArgsConstructor

    @AllArgsConstructor
    public class Attribute {

        @JsonProperty("mine-type")
        private String mine_type;

        @JsonProperty("name")
        private String name;

        @JsonProperty("value")
        private String value;


    }

    @Data

    @NoArgsConstructor

    @AllArgsConstructor
    public class Filter {

        @JsonProperty("dif")
        List<String> dif;
        @JsonProperty("indy")
        List<String> indy;
    }


}
