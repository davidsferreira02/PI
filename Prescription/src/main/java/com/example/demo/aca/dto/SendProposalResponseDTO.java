package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendProposalResponseDTO {


    @JsonProperty("cred_preview")
    private CredentialPreview credPreview;

    @JsonProperty("conn_id")
    private String connectionId;

    @JsonProperty("cred_ex_id")
    private String credExId;

    @JsonProperty("thread_id")
    private String thread_id;


    @JsonProperty("created_at")
    private String createdAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CredentialPreview {


        @JsonProperty("attributes")
        private List<Attribute> attributes;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Attribute {

        @JsonProperty("name")
        private String name;

        @JsonProperty("mime-type")
        private String mimeType;

        @JsonProperty("value")
        private String value;

    }








}
