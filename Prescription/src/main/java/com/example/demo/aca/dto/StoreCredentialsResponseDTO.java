package com.example.demo.aca.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreCredentialsResponseDTO {

    @JsonProperty("cred_ex_record")
    private IssueCredentialsResponseDTO.Cred_ex_record cred_ex_record;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Cred_ex_record {
        @JsonProperty("cred_ex_id")
        private String cred_ex_id;
        @JsonProperty("conn_id")
        private String conn_id;

    }
}
