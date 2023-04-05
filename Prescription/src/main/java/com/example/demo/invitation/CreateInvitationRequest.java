package com.example.demo.invitation;

import com.google.gson.JsonObject;

import java.util.List;

public class CreateInvitationRequest {
    private String mediationId;
    private JsonObject metadata;
    private String myLabel;
    private List<String> recipientKeys;
    private List<String> routingKeys;
    private String serviceEndpoint;

    public CreateInvitationRequest(String mediationId, JsonObject metadata, String myLabel, List<String> recipientKeys, List<String> routingKeys, String serviceEndpoint) {
        this.mediationId = mediationId;
        this.metadata = metadata;
        this.myLabel = myLabel;
        this.recipientKeys = recipientKeys;
        this.routingKeys = routingKeys;
        this.serviceEndpoint = serviceEndpoint;
    }
}

