package com.example.demo.aca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@NoArgsConstructor

@AllArgsConstructor

public class ReceiveInvitationDTO {

    @JsonProperty("type")

    private String type;

    @JsonProperty("id")

    private String id;

    @JsonProperty("label")

    private String label;

    @JsonProperty("handshake_protocols")

    private List<String> handshakeProtocols;

    @JsonProperty("service")

    private ReceiveInvitationService receiveInvitationService;

    @Data

    @NoArgsConstructor

    @AllArgsConstructor

    public static class ReceiveInvitationService {

        @JsonProperty("id")

        private String id;

        @JsonProperty("type")

        private String type;

        @JsonProperty("recipientKeys")

        private List<String> recipientKeys;

        @JsonProperty("serviceEndPoint")

        private String serviceEndPoint;

    }

}
