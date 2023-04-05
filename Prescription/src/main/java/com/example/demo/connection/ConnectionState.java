package com.example.demo.connection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public enum ConnectionState {
    @JsonProperty("init")
    @SerializedName("init")
    INIT,

    @JsonProperty("invitation")
    @SerializedName("invitation")
    INVITATION,

    @JsonProperty("request")
    @SerializedName("request")
    REQUEST,

    @JsonProperty("response")
    @SerializedName("response")
    RESPONSE,

    @JsonProperty("active")
    @SerializedName("active")
    ACTIVE,

    @JsonProperty("error")
    @SerializedName("error")
    ERROR,

    @JsonProperty("completed")
    @SerializedName("completed")
    COMPLETED,

    @JsonProperty("abandoned")
    @SerializedName("abandoned")
    ABANDONED,

    @JsonProperty("start")
    @SerializedName("start")
    START,

    // not aries states

    @JsonProperty("ping_response")
    @SerializedName("ping_response")
    PING_RESPONSE,

    @JsonProperty("ping_no_response")
    @SerializedName("ping_no_response")
    PING_NO_RESPONSE

}
