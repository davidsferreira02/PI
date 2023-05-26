package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcceptRequestResponseDTO {


        @JsonProperty("connection_id")
        private String connection_id;

        @JsonProperty("invitation_msg_id")
        private String invitation_msg_id;

}
