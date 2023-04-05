package com.example.demo.issue_credential_v2;

import com.google.gson.annotations.SerializedName;

public class CredentialFormat {
    public static final String SERIALIZED_NAME_ATTACH_ID = "attach_id";
    @SerializedName(SERIALIZED_NAME_ATTACH_ID)
    private String attachId;
    public static final String SERIALIZED_NAME_FORMAT = "format";
    @SerializedName(SERIALIZED_NAME_FORMAT)
    private String format;
}
