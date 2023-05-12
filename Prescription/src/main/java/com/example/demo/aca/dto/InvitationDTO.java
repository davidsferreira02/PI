package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDTO {


    @JsonProperty("handshake_protocols")
    private List<String> handshakeProtocols;
    @JsonProperty("label")
    private String label;
    @JsonProperty("service")
    private List<InvitationMessageService> invitationMessageService;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InvitationMessageService {

        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("recipientKeys")
        private List<String> recipientKeys;
        @JsonProperty("serviceEndpoint")
        private String serviceEndpoint;
    }
}
