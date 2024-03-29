package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvitationResponseDTO {

    @JsonProperty("invi_msg_id")
    private String inviMsgId;


    @JsonProperty("invitation")
    private InvitationDTO invitation;




}
