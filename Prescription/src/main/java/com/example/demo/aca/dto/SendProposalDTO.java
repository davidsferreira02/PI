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


    @JsonProperty("comment")
    private String comment;

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
        private List<Attributes> attributes;

    }

    @Data

    @NoArgsConstructor

    @AllArgsConstructor
    public class Attributes{

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
        List <String> dif;
        @JsonProperty("indy")
        List <String> indy;
    }




}
