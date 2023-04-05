package com.example.demo.connection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ConnectionAcceptance {
    @JsonProperty("auto")
    @SerializedName("auto")
    AUTO,

    @JsonProperty("manual")
    @SerializedName("manual")
    MANUAL
}
