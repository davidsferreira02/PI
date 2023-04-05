package com.example.demo.connection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public enum ConnectionTheirRole {
    @JsonProperty("invitee")
    @SerializedName("invitee")
    INVITEE,

    @JsonProperty("requester")
    @SerializedName("requester")
    REQUESTER,

    @JsonProperty("inviter")
    @SerializedName("inviter")
    INVITER,

    @JsonProperty("responder")
    @SerializedName("responder")
    RESPONDER
}
