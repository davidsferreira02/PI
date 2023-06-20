package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendRequestResponseDTO {


    @JsonProperty("conn_id")
    private String conn_id;
    @JsonProperty("cred_ex_id")
    private String cred_ex_id;



}
