package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvitationDTO {
    @JsonProperty("handshake_protocols")
    private List<String> handshakeProtocols = Collections.singletonList("did:sov:BzCbsNYhMrjHiqZDTUASHg;spec/didexchange/1.0");
    @JsonProperty("use_public_did")
    private boolean usePublicDid = false;
}
